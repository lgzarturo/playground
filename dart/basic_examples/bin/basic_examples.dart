import 'package:basic_examples/basic_examples.dart' as basic_examples;
import 'package:test/test.dart';

void main(List<String> arguments) {
  String name = 'Arturo López';
  int interval = 10;
  double pi = 3.141592;
  print('Hello $name - ${interval * pi}: ${basic_examples.calculate()}!');

  String message = 'Comillas simples';

  print(message[0]);
  print(message[message.length - 1]);

  bool isActive = true;
  if (isActive) {
    print('La opción esta activada');
  }

  isActive = !isActive;

  if (!isActive) {
    print('Esta desactivado');
  }

  List<int> numbers = [1, 2, 3, 4, 5];
  print(numbers);

  numbers.add(6);
  print(numbers);
  List otherNumber = List(10);
  print(otherNumber);
  otherNumber.add(10);
}
