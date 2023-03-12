class Circle:
    pi = 3.141592

    @classmethod
    def area(cls, radio: int) -> float:
        return cls.pi * (radio ** 2)


def actions():
    radio = 14
    result = Circle.area(radio)
    print(f'El area del circulo con el radio de {radio} es: {result}')


if __name__ == "__main__":
    actions()
