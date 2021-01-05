void main() async {
  print('Ciclo de vida');
  httpGet('https://arthurolg.com').then((data) => print(data));
  print('Fin del programa');

  print('Nuevo ciclo de vida');
  String data = await httpGetAwait('https://webdeveloperhints.com');
  print(data);
  print('Fin del programa');
}

Future<String> httpGet(String url) {
  return Future.delayed(Duration(seconds: 4), () {
    return 'Furute -> Hola mundo ';
  });
}

Future<String> httpGetAwait(String url) {
  return Future.delayed(Duration(seconds: 4), () {
    return 'Async Await -> Hola mundo Async';
  });
}
