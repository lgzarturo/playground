package com

import org.apache.poi.ss.usermodel.Cell

class WriteFileExcel {
    static void generateSheet(String name, def headers = [], def list_data = [], def lada_estados = [:], def estados = [], def ciudades = [:], def ciudades_formato = [:],  def workbook) {
        def sheet = workbook.createSheet(name)

        def row = sheet.createRow(0)
        int cellnum = 0

        for(String head : headers) {
            def cell = row.createCell(cellnum++, Cell.CELL_TYPE_STRING)
            cell.setCellValue(head)
        }

        //list_data = list_data.reverse()
        list_data.eachWithIndex { obj, idx ->
            if (obj instanceof Map<String, String>) {
                row = sheet.createRow(idx+1)
                cellnum = 0
                def estado_valor = ""
                def sector_valor = ""
                def telefono_valor = ""
                def extension_valor = ""
                def telefonos = []
                def correos = []
                for (String head: headers) {
                    def cell = row.createCell(cellnum++)
                    def value = ""
                    if (obj.containsKey(head)) {
                        value = obj.get(head).trim()

                        if ("CATALOGO".equals(head) || "CLIENTE DE".equals(head)) {

                            String validation = StringUtilies.removeAccents(value.toLowerCase())
                            if (validation.equalsIgnoreCase("salesforce")) {
                                value = "Sales Force"
                            } else if (validation.equals("ventas de alto impacto") || validation.equals("ventas de alto impacto i")) {
                                value = "Ventas de Alto Impacto 1"
                            } else if (validation.equals("ventas de alto impacto ii")) {
                                value = "Ventas de Alto Impacto 2"
                            } else if (validation.equals("expo hotel")) {
                                value = "Expo Hotel 2013"
                            } else if (validation.equals("exphotel 2014") || validation.equals("expohotel 2014")) {
                                value = "Expo Hotel 2014"
                            } else if (validation.equals("lic. cuitlahuac zurita")) {
                                value = "Cuitlahuac Zurita"
                            } else if (validation.equals("lic. angel perez")) {
                                value = "Angel Perez"
                            } else if (validation.equals("mtro. jorge molina")) {
                                value = "Jorge Molina"
                            } else if (validation.equals("inscritos mailchimp")) {
                                value = "Mailchimp"
                            } else if (validation.equals("ahcozumel")) {
                                value = "Ahc Cozumel"
                            }

                            value = StringUtilies.capitalize(value)
                        }

                        if ("TELEFONO".equals(head)) {
                            def original = value

                            telefono_valor = StringUtilies.cleanAllStringPhone(value)
                            telefonos = StringUtilies.extractPhones(original)

                            if (telefonos.size() > 0) {
                                value = telefonos.remove(0)
                                extension_valor = StringUtilies.getExtension(value)
                                value = StringUtilies.getPhone(value)
                            } else {
                                value = ""
                                extension_valor = ""
                            }
                            def size = value.length()

                            //LADA
                            def lada

                            if (size == 10) {
                                //Estrae la lada y la compara para saber si pertenece a df, monterrey o guadalajara
                                if (value.startsWith("55")||value.startsWith("81")||value.startsWith("33")) {
                                    lada = value.substring(0, 2)
                                } else {
                                    lada = value.substring(0, 3)
                                }
                                estado_valor = (lada_estados.get(lada)) ? lada_estados.get(lada) as String : ''
                            }

                            if (value.isEmpty()) {
                                value = ""
                            }

                        }

                        if("EMAIL".equals(head)) {
                            correos = StringUtilies.extractEmails(value)
                            if (correos.size() > 0) {
                                value = correos.remove(0)
                            } else {
                                value = ""
                            }

                        }

                        if("SITIO WEB".equals(head)) {
                            value = StringUtilies.removeAccents(value).toLowerCase()
                        }

                        if("GIRO".equals(head)) {
                            sector_valor = value
                        }

                        if("EMPRESA".equals(head)) {
                            if ("NA".equals(value) || "N/A".equals(value) || ".".equals(value) || "-".equals(value) || "....".equals(value) || ",".equals(value)) {
                                value = ""
                            }
                        }
                    }

                    if("CIUDAD".equals(head)) {
                        def criterio = StringUtilies.removeAccents(value).toLowerCase()
                        for (Map.Entry<String, String> entry : ciudades.entrySet()) {
                            if (criterio.contains(entry.key)) {
                                estado_valor = entry.value
                                value = ciudades_formato.get(entry.key)
                                break
                            }
                        }

                        value = (!value.isEmpty()) ? StringUtilies.capitalize(value.replaceAll("\\.", "")) : ""
                    }

                    if("NOMBRE".equals(head) || "APELLIDO".equals(head)) {
                        value = StringUtilies.capitalize(value).replaceAll("Ã±", "ñ")
                                .replaceAll("Ã¡", "á").replaceAll("Ã©", "e").replaceAll("Ã­", "i").replaceAll("Ã³", "ó").replaceAll("Ã­", "u")
                                .replaceAll("Ã", "Á").replaceAll("Ã“", "Ó").replaceAll("(_|\\?|\\*|:|'|)", "")
                    }

                    if("CARGO".equals(head)) {
                        value = StringUtilies.capitalize(value)
                    }

                    if("ESTADO".equals(head)) {
                        value = estado_valor.length() > 0 ? StringUtilies.capitalize(estado_valor) : ""
                    }

                    if("PAIS".equals(head)) {
                        value = (estados.contains(estado_valor)) ? "México" : ""
                    }

                    if("SECTOR".equals(head)) {
                        value = sector_valor.length() > 0 ? sector_valor : ""
                        value = StringUtilies.addSector(value)
                    }
                    if("EXTENSION".equals(head)) {
                        value = extension_valor
                    }

                    if("TELEFONO COMPLETO".equals(head)) {
                        value = telefono_valor.length() > 0 ? StringUtilies.capitalize(telefono_valor) : ""
                    }

                    cell.setCellValue(value.trim())
                }

                if (!telefonos.empty) {
                    int index = telefonos.size()
                    def rowHead = sheet.getRow(0)
                    for (int i = 0; i<index; i++) {
                        def cellHead = rowHead.createCell(cellnum+i)
                        cellHead.setCellValue("TELEFONO${i+1}")
                    }
                    //Agregar telefonos extra
                    for (String tel : telefonos) {
                        def cell = row.createCell(cellnum++)
                        def extension = StringUtilies.extractExtension(tel)
                        def telefono_extra = StringUtilies.getPhone(tel)
                        cell.setCellValue("${telefono_extra}${(extension.length()>0)?' Ext:'+extension:''}" )
                    }
                }

            }
        }
    }

    //"CONTACTOS", headers, list_data, workbook
    static void generateSimpleSheet(String name, def headers = [], def list_data = [], def workbook) {
        def sheet = workbook.createSheet(name)

        def row = sheet.createRow(0)
        int cellnum = 0

        for(String head : headers) {
            def cell = row.createCell(cellnum++, Cell.CELL_TYPE_STRING)
            cell.setCellValue(head)
        }

        //list_data = list_data.reverse()
        list_data.eachWithIndex { obj, idx ->
            if (obj instanceof Map<String, String>) {
                row = sheet.createRow(idx+1)
                cellnum = 0
                for (String head: headers) {
                    def cell = row.createCell(cellnum++)
                    def value = ""
                    if (obj.containsKey(head)) {
                        value = obj.get(head).trim()
                    }

                    cell.setCellValue(value.trim())
                }
            }
        }
    }
}
