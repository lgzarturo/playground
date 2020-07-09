package com.models

import com.utils.StringUtilities

class Contact {
    String catalogo
    String cliente
    String empresa
    String nombre
    String apellido
    String cargo
    String telefono
    String email

    Contact(Map map) {
        def catalogo = map.get("CATALOGO")?:''
        if (catalogo instanceof String) {
            catalogo = StringUtilities.simpleClean(catalogo, false).toLowerCase()
        }

        def cliente =  map.get("CLIENTE DE")?:''
        if (cliente instanceof String) {
            cliente = StringUtilities.simpleClean(cliente, false)
        }

        def empresa =  map.get("EMPRESA")?:''
        if (empresa instanceof String) {
            empresa = StringUtilities.simpleClean(empresa, false)
        }

        def nombre =  map.get("NOMBRE")?:''
        if (nombre instanceof String) {
            nombre = StringUtilities.simpleClean(nombre, false)
        }

        def apellido =  map.get("APELLIDO")?:''
        if (apellido instanceof String) {
            apellido = StringUtilities.simpleClean(apellido, false)
        }

        def cargo =  map.get("CARGO")?:''
        if (cargo instanceof String) {
            cargo = StringUtilities.simpleClean(cargo, false)
        }

        def telefono = map.get("TELEFONO")?:''
        if (telefono instanceof String) {
            telefono = StringUtilities.simpleClean(telefono, true)
            def telefonos = StringUtilities.extractPhones(telefono)
            if (telefonos.size() > 0) {
                telefono = telefonos.remove(0)
            }
        }

        def email =  map.get("EMAIL")?:''
        if (email instanceof String) {
            email = StringUtilities.simpleClean(email, false)
            def emails = StringUtilities.extractEmails(email)
            if (emails.size() > 0) {
                email = emails.remove(0)
            }
        }

        this.catalogo = catalogo
        this.cliente = cliente
        this.empresa = empresa
        this.nombre = nombre
        this.apellido = apellido
        this.cargo = cargo
        this.telefono = telefono
        this.email = email
    }

    @Override
    public boolean equals(Object object) {
        boolean sameSame = false;

        if (object != null && object instanceof Contact)
        {
            sameSame = (
                    (this.email == ((Contact) object).email) &&
                            (this.telefono == ((Contact) object).telefono) &&
                            (this.empresa == ((Contact) object).empresa) &&
                            (this.nombre == ((Contact) object).nombre) &&
                            (this.apellido == ((Contact) object).apellido)
            )
        }

        return sameSame;
    }

    @Override
    int hashCode(){
        return this.email.hashCode() +
                this.telefono.hashCode() +
                this.empresa.hashCode() +
                this.nombre.hashCode() +
                this.apellido.hashCode();
    }
}
