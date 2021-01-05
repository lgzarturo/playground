import 'dart:convert';

void main() {
  final spiderman = Heroe(
      name: 'Peter Parker',
      alias: 'Spiderman',
      mutantPower: 'Poder Aracnido',
      power: 90);
  print(spiderman);
  final wolverine = Heroe(
      name: 'Logan',
      alias: 'Wolverine',
      mutantPower: 'Regeneración',
      power: 88);
  print(wolverine);

  final lexLuthor = Villains('Lex Luthor', 'Luthor');
  print(lexLuthor);

  final jsonRaw = '{ "name": "Norman Osborn", "alias": "Green goblin" }';
  final parseJson = json.decode(jsonRaw);
  final norman = Villains.fromJson(parseJson);
  print(norman);
  print(Villains.fromRawJson('{ "name": "Eddie Brooke", "alias": "Venom" }'));
}

class Heroe {
  String name;
  String alias;
  String mutantPower;
  int power;

  Heroe({this.name, this.alias, this.mutantPower, this.power});

  @override
  String toString() => '$name $alias - $mutantPower ($power)';
}

class Villains {
  String name;
  String alias;

  Villains(this.name, this.alias);
  Villains.fromJson(parseJson) {
    name = parseJson['name'];
    alias = parseJson['alias'];
  }
  Villains.fromRawJson(String rawJson) {
    final parseJson = json.decode(rawJson);
    name = parseJson['name'];
    alias = parseJson['alias'];
  }

  @override
  String toString() => '$name - $alias';
}
