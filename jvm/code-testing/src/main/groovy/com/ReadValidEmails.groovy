package com

import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.xssf.usermodel.XSSFWorkbook

class ReadValidEmails {
    static void main(String[] args) {
        long start = System.nanoTime()
        println("Inicio de la lectura")
        def dir = "xls"
        def file = new FileInputStream(new File("${dir}emails_ok.xlsx"))
        def workbook = new XSSFWorkbook(file)
        def sheet = workbook.getSheet("Atomic Verifier Online")

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

        def file2 = new FileInputStream(new File("${dir}general-1416948914948.xlsx"))
        //Leer el archivo general
        workbook = new XSSFWorkbook(file2)
        sheet = workbook.getSheet("DUPLICADOS")
        def headers = []
        def cellIterator = sheet.getRow(0).cellIterator()
        while (cellIterator.hasNext()) {
            def cell = cellIterator.next()
            headers << cell.stringCellValue.trim()
        }
        headers << "VALIDO"

        def list_data = []
        rowIterator = sheet.iterator()

        while (rowIterator.hasNext()) {
            def row = rowIterator.next()
            if (row.rowNum > 0) {
                def map_data = [:]
                cellIterator = row.cellIterator()
                while (cellIterator.hasNext()) {
                    def cell = cellIterator.next()
                    if (cell.columnIndex == 9) {
                        def email = cell.stringCellValue.trim()
                        if (emails.contains(email)) {
                            map_data.put("VALIDO", "1")
                            map_data.put("ORIGINAL_EMAIL", " ")
                        } else {
                            map_data.put("VALIDO", "0")
                            map_data.put("ORIGINAL_EMAIL", email)
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
                'CATALOGO',
                'CLIENTE DE',
                'EMPRESA',
                'GIRO',
                'SECTOR',
                'SALUDO',
                'NOMBRE',
                'APELLIDO',
                'CARGO',
                'EMAIL',
                'ORIGINAL_EMAIL',
                'TELEFONO',
                'EXTENSION',
                'CIUDAD',
                'ESTADO',
                'PAIS',
                'CODIGO POSTAL',
                'COMENTARIOS',
                'DESCRIPCION',
                'SITIO WEB',
                'ORIGEN',
                'VALORACION',
                'ESTATUS',
                'VALIDO',
                'TELEFONO1',
                'TELEFONO2',
                'TELEFONO3',
                'TELEFONO4',
                'TELEFONO5'

        ]

        println("Proceso de escritura y limpieza")

        if (list_data.size() > 0) {
            WriteFileExcel.generateSimpleSheet("DUPLICADOS", headers, list_data, workbook)
        }

        CreateFileXLSX.createFile(dir, "valid_emails-", workbook)

        println("Fin del proceso")
        println "${(System.nanoTime() - start) / 1000000} ms"
    }
}
