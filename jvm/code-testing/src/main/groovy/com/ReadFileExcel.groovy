package com

import com.models.Contact
import com.utils.StringUtilities
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.xssf.usermodel.XSSFWorkbook

class ReadFileExcel {
    static void main(String[] args) {
        long start = System.nanoTime()
        println("Inicio de la lectura")
        def headers = []
        def dir = "xls"
        def file = new FileInputStream(new File("${dir}concentrado-general-sin-formato.xlsx"))
        //def file = new FileInputStream(new File("${dir}concentrado-general-prueba.xlsx"))
        def workbook = new XSSFWorkbook(file)
        //Leer ladas y estados
        def sheet = workbook.getSheet("LADA")

        def cellIterator = sheet.getRow(0).cellIterator()
        while (cellIterator.hasNext()) {
            def cell = cellIterator.next()
            headers << cell.stringCellValue.trim()
        }

        def lada_estado = [:] //lada:estado
        def estados = [] //lista de estados de mexico

        def rowIterator = sheet.iterator()
        while (rowIterator.hasNext()) {
            def row = rowIterator.next()
            if (row.rowNum > 0) {
                cellIterator = row.cellIterator()
                def estado = ""
                while (cellIterator.hasNext()) {
                    def cell = cellIterator.next()
                    if (cell.columnIndex == 0) {
                        estado = cell.stringCellValue.trim()
                        if (!estados.contains(estado)) {
                            estados.add(estado)
                        }
                    }
                    if (cell.columnIndex == 1) {
                        def ladas = []
                        switch (cell.cellType) {
                            case Cell.CELL_TYPE_STRING:
                                ladas = cell.stringCellValue.trim().replaceAll(" ", "").split(",").collect { it.trim() }
                                break
                            case Cell.CELL_TYPE_NUMERIC:
                                ladas << cell.numericCellValue.intValue().toString()
                                break
                        }

                        for (String lada : ladas) {
                            if (lada.length() > 0) {
                                lada_estado.put(lada, estado)
                            }
                        }
                    }
                }
            }
        }

        //Leer ciudades y estados
        sheet = workbook.getSheet("CIUDADES")

        cellIterator = sheet.getRow(0).cellIterator()
        while (cellIterator.hasNext()) {
            def cell = cellIterator.next()
            headers << cell.stringCellValue.trim()
        }

        def ciudades = [:] //ciudad:estado
        def ciudades_formato = [:] //ciudad:ciudad

        rowIterator = sheet.iterator()
        while (rowIterator.hasNext()) {
            def row = rowIterator.next()
            if (row.rowNum > 0) {
                cellIterator = row.cellIterator()
                def ciudad = ""
                def ciudad_formato = ""
                def estado = ""
                while (cellIterator.hasNext()) {
                    def cell = cellIterator.next()
                    if (cell.columnIndex == 0) {
                        ciudad = StringUtilities.removeAccents(cell.stringCellValue.trim()).toLowerCase()
                        ciudad_formato = cell.stringCellValue.trim()
                    }
                    if (cell.columnIndex == 1) {
                        estado = cell.stringCellValue.trim()
                    }
                }
                ciudades_formato.put(ciudad, ciudad_formato)
                ciudades.put(ciudad, estado)
            }
        }

        //Leer la base de datos.
        sheet = workbook.getSheet("SINFORMATO")
        //sheet = workbook.getSheet("MUESTRA")
        headers = []
        cellIterator = sheet.getRow(0).cellIterator()
        while (cellIterator.hasNext()) {
            def cell = cellIterator.next()
            headers << cell.stringCellValue.trim()
        }

        def list_data = []
        int size_list = 0
        //def list_data2 = []
        def list_duplicados = []
        def list_contact = []
        def list_excluidos = []
        def list_sin_datos = []
        def list_alternativos = []
        def map_alternativos = [:]
        def emails = []

        rowIterator = sheet.iterator()

        while (rowIterator.hasNext()) {
            def row = rowIterator.next()
            if (row.rowNum > 0) {
                def map_data = [:]
                cellIterator = row.cellIterator()
                while (cellIterator.hasNext()) {
                    def cell = cellIterator.next()
                    switch (cell.cellType) {
                        case Cell.CELL_TYPE_STRING:
                            map_data.put(headers[cell.columnIndex], cell.stringCellValue.trim())
                            break
                        case Cell.CELL_TYPE_NUMERIC:
                            if (cell.columnIndex == 7) {
                                map_data.put(headers[cell.columnIndex], cell.numericCellValue.longValue().toString())
                            } else {
                                map_data.put(headers[cell.columnIndex], "${cell.numericCellValue.longValue()}")
                            }
                            break
                        case Cell.CELL_TYPE_BLANK:
                            map_data.put(headers[cell.columnIndex], "")
                            break
                    }
                }
                if (!map_data.isEmpty()) {
                    def contact = new Contact(map_data)
                    if (contact.telefono.isEmpty() && contact.email.isEmpty()) {
                        list_sin_datos.add(map_data)
                    } else {
                        if (!emails.contains(contact.email) && !list_contact.contains(contact)) {
                            list_contact.add(contact)
                            if (contact.catalogo == "contacto_sf" ||
                                    contact.catalogo == "startalent" ||
                                    contact.email == "s/n" ||
                                    contact.email == "sn") {

                                list_excluidos.add(map_data)

                            } else {
                                emails << contact.email
                                list_data.add(map_data)
                            }
                        } else {
                            list_duplicados.add(map_data)
                            map_alternativos.put(contact, map_data)
                        }
                    }
                    size_list ++
                }
            }
        }

        list_contact.clear()

        def map = [:]
        for (Contact contact : list_duplicados) {

            def items = []
            if (map.containsKey(contact.email)) {
                items.addAll(map.get(contact.email))
            }
            items.add(contact)
            map.put(contact.email, items)

        }

        for (Map.Entry<String, List<Contact>> entry : (map.entrySet() as List<Map.Entry<String, List<Contact>>>)) {
            if (entry.value.size() > 1) {
                for(Contact c : entry.value) {
                    boolean alternative = true
                    if (c.catalogo == "contacto_sf" || c.catalogo == "startalent") {
                        alternative = false
                    } else if (c.email == "s/n" || c.email == "sn") {
                        alternative = false
                    } else if (list_excluidos.contains(c) || list_sin_datos.contains(c)) {
                        alternative = false
                    }

                    if (alternative) {
                        list_alternativos.add(map_alternativos.get(c))
                    }
                }
            }
        }

        println("- tamaño: ${size_list}, unicos: ${list_data.size()}, duplicados: ${list_duplicados.size()}, erroneos: ${list_sin_datos.size()}, alternativos: ${list_alternativos.size()}")

        file.close()

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
                'ESTATUS'
        ]

        println("Proceso de escritura y limpieza")

        if (list_data.size() > 0) {
            WriteFileExcel.generateSheet("CONTACTOS", headers, list_data, lada_estado, estados, ciudades, ciudades_formato, workbook)
        }
        if (list_duplicados.size() > 0) {
            WriteFileExcel.generateSheet("DUPLICADOS", headers, list_duplicados, lada_estado, estados, ciudades, ciudades_formato, workbook)
        }
        if (list_excluidos.size() > 0) {
            WriteFileExcel.generateSheet("EXCLUIDOS", headers, list_excluidos, lada_estado, estados, ciudades, ciudades_formato, workbook)
        }
        if (list_sin_datos.size() > 0) {
            WriteFileExcel.generateSheet("SINDATOS", headers, list_sin_datos, lada_estado, estados, ciudades, ciudades_formato, workbook)
        }

        CreateFileXLSX.createFile(dir, "general-", workbook)

        println("Proceso de escritura de alternativos")

        workbook = new XSSFWorkbook()

        if (list_alternativos.size() > 0) {
            WriteFileExcel.generateSheet("ALTERNATIVOS", headers, list_alternativos, lada_estado, estados, ciudades, ciudades_formato, workbook)
        }

        CreateFileXLSX.createFile(dir, "aleternativos-", workbook)

        println("Fin del proceso")
        println "${(System.nanoTime() - start) / 1000000} ms"
    }
}
