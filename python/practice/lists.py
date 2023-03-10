def list_operations():
    # Convertir una lista en tupla y viceversa.
    courses = ['Python', 'Django', 'FastAPI']
    levels = ('Basic', 'Advanced', 'Hacker')

    tuple_courses = tuple(courses)
    list_levels = list(levels)

    print(tuple_courses)
    print(type(tuple_courses))

    print(list_levels)
    print(type(list_levels))

    # Desempaquetando una tupla en variables.

    """
        Desempaquetar solo unos valores de una tupla
        option1, option2, *_ = numbers
        print(option1, option2)
    """
    numbers = (1, 2, 3, 4)
    one, two, three, four = numbers

    print(one, two, three, four)

    # Zip, generar una tupla a partir de lista

    items = [1, 2, 3, 4, 5]
    tuple_items = (10, 20, 30, 40, 50)
    zipped = zip(items, tuple_items)

    print(tuple(zipped))


if __name__ == "__main__":
    list_operations()
