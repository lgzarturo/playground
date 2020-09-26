#!/usr/bin/env python

def greeting(name='Mundo'):
  print(f'Hola {name}')


def custom_greeting(name, age):
  print(f'Hola {name} tienes {age} años')
  if age > 18:
    print('Eres mayor de edad, ya tiene tu INE?')
  else:
    print('Eres menor de edad, no puedes entrar a las Discotecas')


class Man(object):
  def __init__(self, radius):
    self.radius = radius

  @classmethod
  def greeting(cls, name):
    print(f'Hola super {name}')

  @staticmethod
  def static_greeting():
    print("Welcome")

  @property
  def area(self):
    return 3.1416 * (self.radius**2)


class Car(object):
  def __init__(self, m):
    self.wheels = 4
    self.color = 'Azul'
    self.brand = 'Ford'
    self.model = 'Figo'
    self.doors = '4'
    self.m = m

  def traffic(self):
    return "Acelerar" if self.m else "Frenar"


def add(value1, value2):
  print(f'La suma de {value1} + {value2} = {value1 + value2}')


def subtract(value1, value2):
  print(f'La resta de {value1} - {value2} = {value1 - value2}')


def divide(value1, value2):
  print(f'La división de {value1} / {value2} = {value1 / value2}')


def multiply(value1, value2):
  print(f'La multiplicación de {value1} * {value2} = {value1 * value2}')


def main():
  man = Man()
  man.static_greeting()
  print(man.area(5))
  Man.greeting("Gustavo")
  greeting()
  greeting('Arturo')
  while True:
    print('=' * 32)
    print('Recorrido del carro')
    print('=' * 32)
    print('1. Acelerar')
    print('2. Frenar')
    print('3. Detener')
    option = int(input("Opción => "))

    if option == 3:
      break

    if option == 0 or option > 3:
      print(f'La opción {option} no esta soportada')
      continue

    if option == 1:
      car = Car(m=True)
    else:
      car = Car(m=False)

    message = f"""{car.traffic()} =>
      El carro {car.brand} {car.model}, tiene {car.doors} puertas
      y tiene {car.wheels} llantas y es de color {car.color}
    """
    print(message)

  print("*"*64)
  name = input('Cual es tu nombre? => ')
  age = int(input('Cual es tu edad? => '))
  custom_greeting(name, age)
  while True:
    print('=' * 32)
    print('Calculadora')
    print('=' * 32)
    print('1. Suma dos números')
    print('2. Resta dos números')
    print('3. Divide dos números')
    print('4. Multiplica dos números')
    print('5. Salir\n')
    option = int(input("Opción => "))

    if option == 5:
      break

    if option == 0 or option > 5:
      print(f'La opción {option} no esta soportada')
      continue

    value1 = int(input('Valor1 => '))
    value2 = int(input('Valor2 => '))

    if option == 1:
      add(value1, value2)
    elif option == 2:
      subtract(value1, value2)
    elif option == 3:
      divide(value1, value2)
    elif option == 4:
      multiply(value1, value2)


if __name__ == '__main__':
  main()
