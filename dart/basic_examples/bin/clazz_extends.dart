void main() {
  final ironman = Heroe();
  ironman.power = 'Technological Armor';
  ironman.name = 'Tony Stark';
  ironman.bravery = 9;

  final joker = Villains();
  joker.power = 'Laught';
  joker.name = 'Joker';
  joker.evil = 10;

  print(ironman);
  print(joker);
}

abstract class Character {
  String power;
  String name;

  @override
  String toString() => '$name';
}

class Heroe extends Character {
  int bravery;
  @override
  String toString() => '${super.toString()} bravery:$bravery';
}

class Villains extends Character {
  int evil;
  @override
  String toString() => '${super.toString()} evil:$evil';
}
