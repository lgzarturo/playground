void main() {
  final duck = Duck();
  duck.swim();
  duck.walk();
  duck.fly();
}

abstract class Animal {}

abstract class Mammal extends Animal {}

abstract class Bird extends Animal {}

abstract class Fish extends Animal {}

abstract class Flying {
  void fly() => print('Estoy volando!!');
}

abstract class Walking {
  factory Walking._() => null;
  void walk() => print('Estoy caminando!!');
}

abstract class Swiming {
  void swim() => print('Estoy nadando!!');
}

class Dolphin extends Mammal with Swiming {}

class Bat extends Mammal with Flying, Walking {}

class Cat extends Mammal with Walking {}

class Pigeon extends Bird with Flying, Walking {}

class Duck extends Bird with Flying, Walking, Swiming {}

class Shark extends Fish with Swiming {}

class FlyingFish extends Fish with Swiming, Flying {}
