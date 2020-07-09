package com

import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.xssf.usermodel.XSSFWorkbook


class ReadInvalidEmails {
    static void main(String[] args) {
        long start = System.nanoTime()
        def filename = "Contact"
        println("Inicio de la lectura")
        def dir = "xls/07092015"
        def file = new FileInputStream(new File("${dir}${filename}-ok.xlsx"))
        def workbook = new XSSFWorkbook(file)
        def sheet = workbook.getSheet("Atomic Verifier Online")

        //Extraer los correos verificados
        def rowIterator = sheet.iterator()
        def emails = []
        while (rowIterator.hasNext()) {
            def row = rowIterator.next()
            def cellIterator = row.cellIterator()
            while (cellIterator.hasNext()) {
                def cell = cellIterator.next()
                emails << cell.stringCellValue.trim()
            }
        }

        file.close()

        def file2 = new FileInputStream(new File("${dir}${filename}.xlsx"))
        //Leer el archivo de salesforce
        workbook = new XSSFWorkbook(file2)
        sheet = workbook.getSheet("DATOS")
        def headers = []
        def cellIterator = sheet.getRow(0).cellIterator()
        while (cellIterator.hasNext()) {
            def cell = cellIterator.next()
            headers << cell.stringCellValue.trim()
        }
        headers << "CorreoValido"

        def list_data = []
        rowIterator = sheet.iterator()

        while (rowIterator.hasNext()) {
            def row = rowIterator.next()
            if (row.rowNum > 0) {
                def map_data = [:]
                cellIterator = row.cellIterator()
                while (cellIterator.hasNext()) {
                    def cell = cellIterator.next()
                    if (cell.columnIndex == 2) {
                        def email = cell.stringCellValue.trim()
                        if (emails.contains(email)) {
                            map_data.put("CorreoValido", "1")
                            map_data.put("IsDeleted", "0")
                        } else {
                            map_data.put("CorreoValido", "0")
                            map_data.put("IsDeleted", "1")
                        }
                    }

                    switch (cell.cellType) {
                        case Cell.CELL_TYPE_STRING:
                            map_data.put(headers[cell.columnIndex], cell.stringCellValue.trim())
                            break
                        case Cell.CELL_TYPE_NUMERIC:
                            map_data.put(headers[cell.columnIndex], cell.numericCellValue.longValue().toString())
                            break
                        case Cell.CELL_TYPE_BLANK:
                            map_data.put(headers[cell.columnIndex], "")
                            break
                    }


                }
                if (!map_data.isEmpty()) {
                    list_data << map_data
                }
            }
        }

        println("- tamaño: ${list_data.size()}")
        file2.close()

        workbook = new XSSFWorkbook()

        headers = [
                'Id',
                'IsDeleted',
                'Email',
                'CorreoValido'
        ]

        println("Proceso de escritura y limpieza")

        if (list_data.size() > 0) {
            WriteFileExcel.generateSimpleSheet("DATOS", headers, list_data, workbook)
        }

        CreateFileXLSX.createFile(dir, "${filename}-validation-", workbook)

        println("Fin del proceso")
        println "${(System.nanoTime() - start) / 1000000} ms"
    }
}
