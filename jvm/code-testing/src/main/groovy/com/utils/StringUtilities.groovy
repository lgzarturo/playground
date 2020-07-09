package com.utils

import java.text.Normalizer

class StringUtilities {
    static String capitalize(String str) {
        return str.toLowerCase().tokenize().collect {it.capitalize()}.join(" ")
    }

    static String deleteBlankSpaces(def str = "") {
        return replaceLetter(str, " ", "")
    }

    static String deleteNTilde(def str = "") {
        return replaceLetter(replaceLetter(str, "Ñ", "N"), "ñ", "n")
    }

    static String deleteSlash(def str = "") {
        return replaceLetter(replaceLetter(str, "_", ""), "-", "")
    }

    static String replaceLetter(def str = "", def letterFrom = " ", letterTo = "") {
        if (str instanceof String) {
            str = str.replaceAll(letterFrom, letterTo)
        }
        return str
    }

    static String removeAccents(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll(/\p{InCombiningDiacriticalMarks}+/, '')
    }

    static String getPhone(String str) {
        int index = str.indexOf(":")
        if (index > 0) {
            str = str.substring(0, index).replaceAll("[^0-9]+", "")
        }

        return simpleCleanPhoneNumber(str)
    }

    static String getExtension(String str) {
        int index = str.indexOf(":")
        def ext = ""
        if (index > 0) {
            ext = str.substring(index, str.length()).replaceAll("[^0-9]+", "")
        }
        return ext
    }

    static String extractExtension(String str) {
        if (str.toLowerCase().contains("ext")) {
            int index = str.indexOf("ext")

            if (index > 0) {
                str = cleanPhoneNumber(str.substring(index, str.length()).replaceAll("[^0-9]+", ""))
            } else {
                str = cleanPhoneNumber(str.replaceAll("[^0-9]+", ""))
            }

        } else {
            str = ""
        }
        return str
    }

    static String cleanPhoneNumber(String str) {
        if (!str.matches("[0-9]+")) {
            str = deleteBlankSpaces(str)
            if (str.startsWith("/")) {
                str = str.substring(1, str.length())
            }

            str = splitPhone(str)
            str = str.replaceAll("[^0-9]+", "")

            if (str.startsWith("1") && str.length() == 11) {
                //1
                str = str.substring(1, str.length())
            } else if (str.startsWith("01") && str.length() == 12) {
                //01
                str = str.substring(2, str.length())
            }
        }
        return str
    }

    static String simpleClean(String str, boolean onlyNumbers) {
        str = str?:""
        if (onlyNumbers) {
            str = str.replaceAll("[^0-9]+", "")
                    .replaceAll("[^0-9,A-Z,a-z,:,/,\\(,\\)]+", "")

        }
        return str.replaceAll(" ","").trim()
    }

    static String simpleCleanPhoneNumber(String str) {
        str = deleteBlankSpaces(str)
                .replaceAll("[^0-9]+", "")
                .replaceAll("[^0-9,A-Z,a-z,:,/,\\(,\\)]+", "")
                .replaceAll(" ","").trim()

        int size = str.length()
        if (str.startsWith("1") && size == 11) {
            //1
            str = str.substring(1, size)
        } else if (str.startsWith("01") && size == 12) {
            //01
            str = str.substring(2, size)
        }

        return str
    }

    static String cleanEmail(String str) {
        return removeAccents(deleteBlankSpaces(deleteNTilde(str))).toLowerCase()
    }

    static String splitPhone(String str) {
        def numbers = []
        numbers.addAll(splitPhones(str))
        return (numbers.isEmpty()) ? str : numbers.unique().get(0).toString().trim()
    }

    static String cleanAllStringPhone(String str) {
        str = deleteBlankSpaces(str.replaceAll("[^0-9,A-Z,a-z,:,/]+", "")).toUpperCase()
        if (str.startsWith("/")) {
            str = str.substring(1, str.length())
        }
        return str
    }

    static ArrayList<String> splitPhones(String str) {
        def phones = str.toLowerCase().trim()
        if (phones.contains("ext") &&  phones.indexOf("ext") > 0) {
            phones = phones.substring(0, phones.indexOf("ext"))
        }
        if (str.contains("fax") &&  phones.indexOf("fax") > 0) {
            phones = phones.substring(0, phones.indexOf("fax"))
        }
        if (str.contains("al") &&  phones.indexOf("al") > 0) {
            phones = phones.substring(0, phones.indexOf("al"))
        }

        def numbers = []
        if (str.contains("/")) {
            phones = phones.split("/").join(",")
        }

        if (str.contains("y")) {
            phones = phones.split("y").join(",")
        }

        if (str.contains("cel")) {
            phones = phones.split("cel").join(",")
        }

        if (str.contains("hotel")) {
            phones = phones.split("hotel").join(",")
        }

        if (str.contains("nextel")) {
            phones = phones.split("nextel").join(",")
        }

        def array_phones = phones.split(",")
        for (String phone : array_phones) {
            phone = simpleCleanPhoneNumber(phone)
            if (!numbers.contains(phone)) {
                numbers << phone
            }
        }

        return numbers
    }

    static ArrayList<String> removePrincipal(List<String> phones, String item) {
        phones.remove(item)
        return phones
    }

    static ArrayList<String> extractEmails(String emails) {
        emails = emails.replaceAll(",com", ".com").replaceAll(",mx", ".mx").replaceAll(",net", ".net")
        return  emails.toLowerCase().replaceAll(" ", "").trim().split(",").collect {cleanEmail(it.trim())}
    }

    static ArrayList<String> extractPhones(String telefono_completo) {
        telefono_completo = telefono_completo.toLowerCase().replaceAll(" ", "").replaceAll("([0-9]/ext|[0-9]/ext|/ext|/ ext|est|[0-9]e[0-9]|al[0-9]+|ex)", "ext").trim()

        telefono_completo = telefono_completo.replaceAll("-", "").replaceAll('\\(', "").replaceAll('\\)', "").replaceAll("\\.", "")

        def telefonos = telefono_completo.split("(cel|tel|hotel|asistente|dir|fax|/|y|,)").collect { it.trim() }

        def phones_ok = []

        for (def part : telefonos) {

            //Extraer Extension.
            def ext = ""
            int indexExt = part.indexOf("ext")
            if (indexExt > 0) {
                ext = part.substring(indexExt, part.length()).replaceAll("[^0-9]+","")
                if (ext.length() > 4) {
                    ext = ext.substring(0, 4)
                }
                part = part.substring(0, indexExt)
            }
            part = part.replaceAll("[^0-9]+", "")
            Integer part_size = part.length()
            if (part_size > 0) {
                if (part_size > 7 && part_size % 7 == 0) {
                    part = part.substring(0, 7)
                } else if (part_size > 8 && part_size % 8 == 0) {
                    part = part.substring(0, 8)
                } else if (part_size > 10 && part_size % 10 == 0) {
                    part = part.substring(0, 10)
                } else if (part_size > 12 && part_size % 12 == 0) {
                    part = part.substring(0, 12)
                }
                part_size = part.length()
                if (part.startsWith("1") && part_size == 11) {
                    //1
                    part = part.substring(1, part_size)
                } else if (part.startsWith("01") && part_size == 12) {
                    //01
                    part = part.substring(2, part_size)
                }
            }


            if (part.length() > 5) {
                if (ext.length() > 0) {
                    phones_ok <<  "${part}:${ext}"
                } else {
                    phones_ok << part
                }
            }

        }
        return phones_ok
    }

    static String addSector(String giro) {
        giro = removeAccents(giro.toLowerCase())
        def sector_seleccionado = ""
        def sector = [
                'Agropecuario':['agropecuario', 'agricultura', 'ganaderia', 'silvicultura', 'caza', 'pesca', 'marina', 'mar', 'maiz', 'trigo', 'marinos'],
                'Servicios':['servicios', 'admnistracion', 'abogados', 'agencia', 'aduana', 'carga', 'importacion', 'asesoramiento', 'asesores', 'consultoria', 'consultores', 'asesoria', 'camara', 'gobierno', 'talento', 'golf', 'capacitacion', 'entrenamiento', 'oficina', 'estetica', 'monitoreo', 'club', 'turismo', 'hoteleria', 'reclutamiento', 'contabilidad', 'auditoria', 'contadores', 'contratista', 'control risk', 'juridico', 'educacion', 'reclutamiento', 'turistica' , 'fiscal', 'laboral', 'enseñanza', 'escuelas', 'medicion', 'especialistas', 'estudios', 'fotografia', 'servicios medicos', 'hotel', 'impresion', 'sistemas', 'soluciones', 'logistica', 'travel', 'organizacion', 'organizar', 'outsourcing', 'internet', 'recreacion', 'recursos humanos', 'renta', 'seguridad privada', 'software', 'soluciones', 'spa', 'tecnologia', 'traduccion', 'universidades', 'inteligencia', 'administracion', 'del idioma ingles'],
                'Industrial':['industria', 'infraestructura', 'industrial', 'manufactura', 'blindaje', 'cereales', 'desarrollo', 'dupont', 'inventor', 'elaboracion', 'biotecnologia', 'electronica', 'empaque', 'tabaco', 'embolsadora', 'embotellador', 'manufacturera', 'ensamble', 'fabricacion', 'fabrica', 'farmaceutica', 'herramientas', 'ergonomicas', 'investigacion', 'laboratorio', 'mantenimiento', 'maquila', 'medicion', 'motores', 'perforacion', 'textil', 'transformacion', 'troquelados', 'farmaceuticos.'],
                'Transporte':['aereolineas','aeronautica', 'viajes', 'navieros', 'automotriz', 'autotransporte', 'transporte', 'mensajeria', 'mudanzas', 'automotor', 'transportacion', 'transportadora', 'traslado', 'aerolineas', 'linea aerea', 'aerea'],
                'Comercio':['comercial', 'comercializadora', 'comecializadora', 'comericalizadora', 'comercializador', 'alimentos', 'bebidas', 'alimentacion', 'comerciantes', 'vinos', 'botanas', 'comercio', 'compra/venta', "compra", 'venta', 'cosmetica', 'distribucion', 'distribuidor', 'equipos', 'exportacion', 'comerciales', 'importacion', 'exportacion', 'importadores', 'exportadores', 'mercadeo', 'perecederos', 'produccion', 'productoras', 'productos', 'proveedor', 'restaurantes', 'bares', 'departamental', 'tiendas'],
                'Financiero':['seguro','financiero', 'bienes raices', 'inmobiliarias', 'inmuebles', 'arrendamiento', 'aseguradora', 'seguros', 'aseguramiento', 'financiamiento', 'banca', 'banco', 'empeño', 'impuestos', 'vales', 'credito', 'pensiones', 'financiera', 'finanzas', 'bancaria', 'transacciones', 'inversiones', 'recursos naturales', 'pago', 'bancaria', 'riesgo', 'casas de empe'],
                'Construcción':['construccion', 'constructoras', 'arquitectonico', 'arquitectos', 'ingenieros','materiales', 'carga', 'ferrocarril', 'ingenieria', 'maquinaria', 'material'],
                'Minero y Energético':['energetico', 'minero', 'energia', 'petroleo', 'extraccion', 'gas', 'joyeria', 'metalurgia', 'petroquimica', 'mineria'],
                'Solidario':['solidario', 'cooperativa', 'fundacion', 'asociacion', 'organizacion', 'sin fines de lucro', 'salud', 'beneficencia', 'propiedad intelectual', 'sindicato', 'beneficiencia'],
                'Comunicación':['publicidad','medios','television','hollywood','conferencias','telecomunicaciones', 'comunicacion', 'telemarketing', 'marketing', 'mercadotecnia', 'diseño', 'informacion', 'celular', 'telefonia', 'representacion', 'promocion', 'publicidad', 'espectaculos', 'eventos', 'revistas', 'tv', 'entretenimiento'],
        ]

        sector.each {
            for(String token:it.value) {
                if (giro.contains(token)) {
                    sector_seleccionado = it.key
                    break
                }
            }
        }
        return sector_seleccionado
    }
}
