void main() {
  Dog dog = Dog(legs: 4, tails: 1);
  print(dog);
  dog.emitSound();

  Cat cat = Cat();
  cat.emitSound();
}

abstract class Animal {
  int legs;
  void emitSound();
}

class Dog implements Animal {
  int legs;
  int tails;
  void emitSound() => print('Dog says: Woof Woof');

  Dog({this.legs, this.tails});

  @override
  String toString() => '$legs and $tails';
}

class Cat implements Animal {
  int legs;
  void emitSound() => print('Cat says: Meau Meau');
  @override
  String toString() => '$legs';
}
