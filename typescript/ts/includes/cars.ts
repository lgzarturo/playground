function hello(constructor:Function) {
    constructor()
}

function method_editable(isWritable: boolean) {
    return function(target: any, property: string, descriptor: PropertyDescriptor):any {
        descriptor.writable = isWritable
    }
}

function editable(isWritable: boolean) {
    return function(target: any, property: string):any {
        let descriptor:PropertyDescriptor = {
            writable: isWritable
        }
        return descriptor
    }
}

function execute_constructor(isExecutable: boolean):any {
    if (isExecutable) {
        return hello
    } else {
        return null
    }
}

@execute_constructor(false)
export class Automovile {
    constructor() {
        console.log(`Hola estas en carro`)
    }
}

export class Bus {
    @editable(true)
    plate: number = 123;

    @method_editable(true)
    doors() {
        console.log("Numero de puertas")
    }

    constructor() {
    }
}
