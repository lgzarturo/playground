void main() {
  print('Ciclo de vida');
  httpGet('https://arthurolg.com').then((data) => print(data));
  print('Fin del programa');
}

Future<String> httpGet(String url) {
  return Future.delayed(Duration(seconds: 4), () {
    return 'Hola mundo';
  });
}
