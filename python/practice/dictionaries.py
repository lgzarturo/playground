import pprint


def basic_operations():
    dictionary = {'a':1, 'b':2, 'c':3, 'd':4}
    print('z' in dictionary)
    value = dictionary.get('d')
    print(value)
    print(dictionary.get('z'))
    # Al no existir la llave en el diccionario y método retorna un valor por 'default'
    print(dictionary.get('y', 'No existe Y'))
    # Será agregado el valor del segundo argumento, siempre y cuando no se encuentre la llave en el diccionario
    new_item = dictionary.setdefault('w', 5)
    print(new_item)
    pprint.pprint(dictionary)

    keys = tuple(dictionary.keys())
    print(keys)
    values = tuple(dictionary.values())
    print(values)
    items = tuple(dictionary.items())
    print(items)
    print(len(dictionary))
    del dictionary['w']
    print(len(dictionary))
    one_item = dictionary.pop('a')
    print(one_item)
    print(len(dictionary))
    dictionary.clear()
    print(len(dictionary))
    print(dictionary)


if __name__ == "__main__":
    basic_operations()
