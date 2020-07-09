class TestPhoneNumbers {

    static void main(String[] args) {

        def phones = [
                '55-56683368 y 4775646800','8862970','9988923780','01998-2734280','01998-2734280','01998-2795891',
                '(01-33) 5000 0990','998-8871251, 998-8874901','998-8846860','998-8976324','(33) 3681-5593',
                '(55) 55616996','52-33-368-302-53','(818) 6255000','55 5082 5825- 40','998-8839647','8887770/8400582',
                '2717057','998 2677365','(744) 485 90 24','664 682 1711','8801297/8801299','(998) 8874490',
                '(33) 36-18-49-28','(55) 56 40 17 84','(998) 882 5099','984745749','01272 72 41 255',
                '998-2756314/998-2414839','998-8873350/998-8845573','55-53737934/55-53606711','571 92 20',
                '999 9829000','(818) 8389280','8729070','777-2430404','998-8844905','8914550','998-8847585',
                '(998) 887 12 22','2677215/8899818','998-2511608/2725010','(33) 3634-2043','998-2514628',
                '(998) 843-10-64','tel:983839750','fax: 983839749','01998-8845018','8494649 y 50','53 57 44 76',
                '998-8989209/998-2087370','(644) 414 15 23','8832443','01-998-886-90-02','664-684-82-81',
                '(998) 914-04-18','(81) 50001618','(558) 80 00 80 46','442 226 1709 ext 29','9841558193/9842061680',
                '9982062020/fax 9988807993','998-8400006 EXT. 1212','57-22-11-50','55675566',
                '998-8924828/fax: 998-8928248','01 (998) 209-30-00 ext.al 06','998 872 89 99   ext 16305 y 16308     Cel 998 181 07 01',
                '984 206 30 00','984 871 54 00   ext 4222                  984 871 54 24','987 872 31 32   987 103 55 35',
                'Dir.   8841377(hotel) 8842834 (asistente)','8840304  8927495 Cel. 9988421754',
                '1930100 tel dir. 1930108','Dir. 8812600   8812500   8831029 ext 3102','8843082, 8846494, 8840714',
                '8862201 AL 06 EXT. 111 y 190','881 18 00  EXT. 2101, 1101,  8811807','8 47 47 68  Cel. 9988455007',
                '01 984 871 51 00','8818300  8818301  8818302   8818303','88159 00','8844249 EXT 2',
                '8406587   EXT. 2002, 8406590   8831722,','2874760 AL 77','8846100  8846150 Ext.3101  Cel. 9981269550','2061775/78 ext. 103',
                '2061775/ext.103','9985246532/ext1231', '209-30-00 est 06', '8843082ext21, 8846494, 8840714'
        ]


        int i = 1;
        for (def phone : phones) {

            def telefono_completo = phone.toLowerCase().replaceAll("([0-9]/ext|[0-9]/ext|/ext|est|[0-9]e[0-9]|al[0-9]+|ex)", "ext").trim()

            telefono_completo = telefono_completo.replaceAll("-", "").replaceAll('\\(', "").replaceAll('\\)', "").replaceAll("\\.", "")

            def telefonos = telefono_completo.split("(cel|tel|hotel|asistente|dir|fax|/|y|,)").collect { it.trim().replaceAll(" ", "") }

            println("--"*90)
            println("#${i++}")

            def phones_ok = []

            for (def part : telefonos) {

                //Extraer Extension.
                def ext = "--"
                int indexExt = part.indexOf("ext")
                if (indexExt == 0) {
                    indexExt = part.indexOf("est")
                }

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
                    }
                    if (part_size > 8 && part_size % 8 == 0) {
                        part = part.substring(0, 8)
                    }
                    if (part_size > 10 && part_size % 10 == 0) {
                        part = part.substring(0, 10)
                    }
                    if (part_size > 12 && part_size % 12 == 0) {
                        part = part.substring(0, 12)
                    }

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
                println("-[${phones_ok.join(", ")}]")
            }
        }
    }

}
