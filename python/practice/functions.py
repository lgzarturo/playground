from enum import Enum

# uso de variables globales
alien = 'gray'


def ufo():
    global alien
    alien = 'pleyadians'
    print(f'{id(alien)} - {alien} <- scope_function')


class TypeCalculation(Enum):
    ADD = 1


# Uso de clases como parámetros
class Operation:
    def __init__(self, number_one: int, number_two: int, operation: TypeCalculation | None = None) -> None:
        self.number_one = number_one
        self.number_two = number_two
        self.operation = operation
        self.result = None

    def __str__(self) -> str:
        if self.operation == TypeCalculation.ADD:
            return f'{self.add().result}'
        return f'{0 if self.result is None else self.result}'

    def add(self):
        self.result = self.number_one + self.number_two
        return self


# Parámetro en forma de tupla
def average(*args: int) -> float:
    print(type(args))
    return sum(args) / len(args)


# Parámetro en forma de diccionario
def users(**kwargs):
    print(kwargs)
    print(type(kwargs))


# Usar todo tipo de parámetros en Python
def say_hello(first_name: str, last_name: str, *args: str, age: int = 18, **kwargs):
    print(f'fullname: {first_name} {last_name}')
    print(f'age {age}')
    print(args)
    print(type(args))
    print(kwargs)
    print(type(kwargs))


class OperationException(Exception):
    def __init__(self):
        super().__init__('No se pudo procesar la operación')


class TypeOperation(Enum):
    DEPOSIT = 1
    WITHDRAWAL = 2
    OTHER = 3


# Funciones anidadas
def operation(quantity: int, balance: int, type_operation: TypeOperation=TypeOperation.DEPOSIT):
    def deposit(quantity, balance):
        return quantity + balance

    def withdrawal(quantity, balance):
        if quantity <= balance:
            return balance - quantity
        else:
            return 0

    if type_operation == TypeOperation.DEPOSIT:
        return deposit(quantity, balance)
    elif type_operation == TypeOperation.WITHDRAWAL:
        return withdrawal(quantity, balance)
    else:
        raise OperationException()



class TypeConversion(Enum):
    CELSIUS = 'celsius'
    FAHRENHEIT = 'fahrenheit'


# Funciones de primer orden
def celsius_to_fahrenheit(degrees: int) -> float:
    return degrees * 1.8 + 32


def fahrenheit_to_celsius(degrees: int) -> float:
    return (degrees - 32) / 1.8


def determine_conversion(degrees: int, type_conversion: TypeConversion) -> str:
    if type_conversion == TypeConversion.CELSIUS:
        conversor = fahrenheit_to_celsius
    elif type_conversion == TypeConversion.FAHRENHEIT:
        conversor = celsius_to_fahrenheit
    return f'{conversor(degrees)} {type_conversion.value}'


def basic_operations():
    print(Operation(400, 399).add())
    print('--> ADD %s' % Operation(1, 2, TypeCalculation.ADD))
    print(average(19, 20, 30, 0, 15, 1))
    users(john=[8, 9, 10], smith=[7,9,8])
    say_hello('john', 'doe', 'basic school', 'high school', items=[1,2,3,4,5], colors=['red', 'blue'], age=23)
    print(operation(100, 1000))
    print(operation(100, 1000, TypeOperation.WITHDRAWAL))
    try:
        print(operation(100, 1000, TypeOperation.OTHER))
    except OperationException as e:
        print(e)


if __name__ == "__main__":
    basic_operations()
    print(f'{id(alien)} - {alien} <- scope_global')
    ufo()
    print(f'{id(alien)} - {alien} <- scope_global')
    print(determine_conversion(0, TypeConversion.FAHRENHEIT))
    print(determine_conversion(32, TypeConversion.CELSIUS))
    print(determine_conversion(10, TypeConversion.FAHRENHEIT))
    print(determine_conversion(50, TypeConversion.CELSIUS))
    function_degrees = lambda degrees : degrees * 1.8 + 32
    print(f'lambda -> {function_degrees(100)}')
    lambda_zero = lambda : True
    lambda_one = lambda x=1, y=2, z=3: x + y + z
    lambda_two = lambda *args, **kwargs: len(args) + len(kwargs)
    print(f'lambda zero -> {lambda_zero()}')
    print(f'lambda one -> {lambda_one()}')
    print(f'lambda two -> {lambda_two(1,2,4,hola=[112,1212],mundo=True)}')
    lambda_average = lambda *args : sum(args) / len(args)
    lambda_score = lambda score : score >= 7
    def user_score(func_average, func_score, *args):
        average = func_average(*args)
        if (func_score(average)):
            print(f'Felicidades has aprobado con {average}')
        else:
            print(f'Lo siento has repobado, tu calificación con {average}')
    print(f'lambda_average -> {lambda_average(10, 10, 9, 8, 7)}')
    print(f'lambda_score -> {lambda_score(5)}')
    user_score(lambda_average, lambda_score, 10, 10, 10, 10, 10)
    user_score(lambda_average, lambda_score, 4, 5, 6, 10, 8)
    user_score(lambda_average, lambda_score, 9, 7, 9, 10, 8)
