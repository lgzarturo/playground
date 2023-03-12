# Decorator
def function_a(function_b):
    def function_c(*args, **kwargs):
        print('>>> Antes del llamado')
        result = function_b(*args, **kwargs)
        print('Estoy en la función C')
        print('>>> Después del llamado')
        return result
    return function_c


@function_a
def greetings():
    print('Hola, nos encontramos en una función')


@function_a
def add(number_one: int, number_two: int) -> int:
    return number_one + number_two


# __doc__ se puede aplicar a Módulos, Clases, Métodos y Funciones
def say_hello(name: str, age: int = 0) -> str:
    """La función saluda dependiendo la edad registrada

    Args:
        name (str): Representa el nombre de la persona que vamos a saludar
        age (int, optional): Se especifica la edad de la persona. Defaults to 0.

    Returns:
        str: El saludo a la persona

    TODO:
        * Se requiere refactorizar la función para que haga una sola cosa
        * Es necesario considerar lanzar una excepción para las edades cuando son mayores de 100 y menores de 0

    >>> say_hello('Arturo', 20)
    'Hola señor Arturo'
    >>> say_hello('Arturo', 0)
    'Hola aun no nacido Arturo'
    >>> say_hello('Arturo', 16)
    'Hola joven Arturo'
    """
    if age == 0:
        return f'Hola aun no nacido {name}'
    elif (age >= 18):
        return f'Hola señor {name}'
    else:
        return f'Hola joven {name}'


# Estructura básica del closure
def closures(username: str):
    message = f'Hola {username}'

    def show_message():
        print(message)

    return show_message


# Generadores
def pairs():
    for number in range(0, 100, 2):
        yield number
        print('Continuar')


if __name__ == "__main__":
    username = 'lgzarturo'
    response = closures(username)
    print(type(response))
    response()
    greetings()
    print('*'*80)
    result = add(10, 20)
    print(result)
    for pair in pairs():
        print(pair)
    print('*'*80)
    generator = pairs()
    print(next(generator))
    print(next(generator))
    print(next(generator))
    print('*'*80)
    while True:
        try:
            par = next(generator)
            print(par)
        except StopIteration:
            print('El generador finalizo')
            break
    print('*'*80)
    print(say_hello.__doc__)
    # help(say_hello)

