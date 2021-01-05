void main() {
  hello();
  String response = message();
  print(response);
  print(parameters('Hola mundo', 42));
  print(greetings(name: 'Arturo', text: 'Saludos de nuevo'));
  print(lamdaFunction('Juan', 'come pizza'));
}

void hello() {
  print('Hola, desde una función');
}

String message() {
  return 'Mensaje de respuesta';
}

String parameters(String text, int size) {
  return '$text -> $size';
}

String greetings({String text, String name}) {
  return '$text $name!!!';
}

String lamdaFunction(String text, String name) => '$text, $name';
