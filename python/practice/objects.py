class User:
    # Atributos de la clase
    username = 'lgzarturo'
    email = 'arthurolg@gmail.com'


class Customer:
    def __init__(self, first_name: str, last_name: str) -> None:
        # Atributos de instancia
        self.first_name = first_name
        self.last_name = last_name


class Animal:
    def eat(self):
        print("eating")

    def sleep(self):
        print("sleeping zzzzzz...")

    def hunt(self):
        print("Hunting....")


class Pet:
    def eat(self):
        print("eating in the house")

    def collar(self):
        print("Have pretty collar")


class Dog(Pet):
    pass


class Cat(Pet, Animal):
    def hunt(self):
        print("Mouse Hunting....")
        super().hunt()


class Bird(Animal):
    def hunt(self):
        print("Bird don't hunting")


def actions():
    # Añadir atributos en tiempo de ejecución
    admin_user = User()
    print(admin_user)
    print(User.username)
    print(User.email)
    User.username = "usuario1"
    User.email = "usuario1@gmail.com"
    print(User.username)
    print(User.email)
    print(admin_user.__dict__)
    admin_user.username = 'arthurolg@me.com'
    print(admin_user.__dict__)
    print(admin_user.username)

    customer1 = Customer("john", "doe")
    customer2 = Customer("smith", "titor")
    print(customer1.__dict__)
    print(customer2.__dict__)

    print(">>> Dog")
    snoppy = Dog()
    snoppy.eat()
    snoppy.collar()

    print(">>> Cat")
    garfield = Cat()
    garfield.eat()
    garfield.sleep()
    garfield.hunt()

    print(">>> Bird")
    piolin = Bird()
    piolin.eat()
    piolin.sleep()
    piolin.hunt()


if __name__ == "__main__":
    actions()
