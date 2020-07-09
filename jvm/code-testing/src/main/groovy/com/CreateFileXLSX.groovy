package com

import org.joda.time.DateTime

class CreateFileXLSX {
    static void createFile(def dir, def name, def workbook) {
        try {
            def filename = "${dir}${name}${new DateTime().millis}.xlsx"
            println("Guardando el archivo ${filename}")
            File outFile = new File(filename);
            FileOutputStream out = new FileOutputStream(outFile)
            workbook.write(out)
            out.close()
        } catch (FileNotFoundException e) {
            e.printStackTrace()
        } catch (IOException e) {
            e.printStackTrace()
        }
    }
}
