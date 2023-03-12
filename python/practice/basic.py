def basic_operations():
    title = 'Ejemplo de desarrollo de código en python'
    text = 'código'
    print(text in title)
    counter = title.count(text)
    is_present = 'ausente' if counter == 0 else ''
    if is_present == '':
        is_present = f'{counter} veces' if counter > 1 else f'{counter} vez'
    print(f'El texto "{text}" código esta {is_present} en el título "{title}"')

    # Range
    iterable_range = range(1, 11)
    for value in iterable_range:
        print(value)

    # Enumerate
    items = [1,2,3,4,5,6,7,8,9]
    for index, number in enumerate(items, 1):
        print(f'index: {index}, value: {number}')


if __name__ == "__main__":
    basic_operations()
