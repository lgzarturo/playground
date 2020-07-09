package com

import org.apache.commons.validator.routines.EmailValidator
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.xssf.usermodel.XSSFWorkbook

class SalesforceContacts {
    static void main(String[] args) {
        long start = System.nanoTime()
        println("Inicio de la lectura")
        def dir = "xls";
        def source_file = "${dir}linkedin-contacts.xlsx"
        def contacts_file = "${dir}salesforce-contact.xlsx"
        def leads_file = "${dir}salesforce-lead.xlsx"
        def sheet_name = "CONTACTOS"
        def base_list_rows = []
        def compare_leads = []
        def compare_contacts = []
        //def criteria_comparations = ['Email', 'FirstName', 'LastName']
        def criteria_comparations = ['Email']

        def headers = extractHeaders(source_file, sheet_name)
        if (headers) {
            base_list_rows = extractRowsWithEmailValid(source_file, 3, headers, sheet_name)
            //Extraer la informacion de contactos
            compare_contacts = extractRowsWithEmailValid(contacts_file, 28, extractHeaders(contacts_file, sheet_name), sheet_name)
            //Extraer la informacion de candidatos
            compare_leads = extractRowsWithEmailValid(leads_file, 18, extractHeaders(leads_file, sheet_name), sheet_name)
        }

        //Buscar contactos en la base de contactos salesforce
        extractRows(base_list_rows, compare_contacts, criteria_comparations)
        //Buscar contactos en la base de candidatos salesforce
        extractRows(base_list_rows, compare_leads, criteria_comparations)

        println("- numero de filas de ${source_file}: ${base_list_rows.size()}")
        println("- numero de filas de ${leads_file}: ${compare_leads.size()}")
        println("- numero de filas de ${contacts_file}: ${compare_contacts.size()}")

        // Escribir el archivo de excel
        def workbook = new XSSFWorkbook()
        WriteFileExcel.generateSimpleSheet(sheet_name, headers.values().collect(), base_list_rows, workbook)
        CreateFileXLSX.createFile(dir, "linkedin_valid_contacts-", workbook)

        println("Fin del proceso")
        println "${(System.nanoTime() - start) / 1000000} ms"
    }

    def static extractRows(def source = [], def compareTo = [], def criteriaFields = []) {
        def size = 0
        if (criteriaFields) {
            size = criteriaFields.size()
        }

        def unique_items = []

        for (final map: source) {
            //map row map
            def unique = true
            for (final compare: compareTo) {
                //compare row map
                def criteria_comparations = 0
                for (final field: criteriaFields) {

                    if (map.containsKey(field) && compare.containsKey(field)) {
                        def fieldStr = map.get(field)
                        def fieldCompareStr = compare.get(field)

                        if (fieldStr instanceof String && fieldCompareStr instanceof String) {

                            fieldStr = fieldStr.trim().toLowerCase()
                            fieldCompareStr = fieldCompareStr.trim().toLowerCase()

                            if (fieldStr.equals(fieldCompareStr)) {
                                criteria_comparations ++
                            }
                        }

                    }
                }

                if (criteria_comparations == size) {
                    compareTo.remove(compare)
                    unique = false
                    break;
                }
            }

            if (unique) {
                unique_items << map
            }
        }

        if (unique_items) {
            source.clear()
            source.addAll(unique_items)
        }
    }

    def static extractHeaders(String filePath, String sheetName)  {
        def source_file = null
        def headers = [:]
        try {
            source_file = new FileInputStream(new File(filePath))
            def workbook = new XSSFWorkbook(source_file)
            def sheet = workbook.getSheet(sheetName)

            def cellIterator = sheet.getRow(0).cellIterator()
            while (cellIterator.hasNext()) {
                def cell = cellIterator.next()
                headers.put(cell.columnIndex, cell.stringCellValue.trim())
            }
        } finally {
            if (source_file != null) {
                source_file.close()
            }
        }

        return headers
    }
    def static extractRowsWithEmailValid(String filePath, Integer emailColumnIndex, def headers = [:], String sheetName) {
        def source_file = null

        def list_rows = []
        try {
            source_file = new FileInputStream(new File(filePath))
            def workbook = new XSSFWorkbook(source_file)
            def sheet = workbook.getSheet(sheetName)

            def rowIterator = sheet.iterator()
            while (rowIterator.hasNext()) {
                def row = rowIterator.next()
                if (row.rowNum > 0) {
                    def map_row = [:]
                    def cellIterator = row.cellIterator()
                    def is_valid_row = false
                    while (cellIterator.hasNext()) {
                        def cell = cellIterator.next()

                        switch (cell.cellType) {
                            case Cell.CELL_TYPE_STRING:
                                map_row.put(headers.get(cell.columnIndex), cell.stringCellValue.trim())
                                break
                            case Cell.CELL_TYPE_NUMERIC:
                                map_row.put(headers.get(cell.columnIndex), cell.numericCellValue.longValue().toString())
                                break
                            case Cell.CELL_TYPE_BLANK:
                                map_row.put(headers.get(cell.columnIndex), "")
                                break
                        }

                        if (cell.columnIndex == emailColumnIndex) {
                            def email = cell.stringCellValue.trim().toLowerCase()
                            if (EmailValidator.getInstance(true).isValid(email)) {
                                map_row.put("Email", email)
                                is_valid_row = true
                            }
                        }
                    }

                    if (is_valid_row) {
                        list_rows << map_row
                    }
                }
            }
        } finally {
            if (source_file != null) {
                source_file.close()
            }
        }

        return list_rows
    }
}
