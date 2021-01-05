void main() {
  String property = 'age';
  Map<String, dynamic> people = {
    'name': 'Arturo',
    'age': 38,
    'single': false,
    'male': true,
  };

  print(people['name']);
  print(people[property]);

  Map<int, dynamic> items = {1: 'Juan', 2: 'Peter', 3: 'Tony'};

  items.addAll({4: 'Dr. Strange'});
  print(items[2]);
}
