void main() {
  final square = Square();
  square.side = 10.0;

  print(square);
  print(square.area);
}

class Square {
  double _side;

  void set side(double value) {
    if (value <= 0) {
      throw ('El valor no puede ser menor o igual a cero');
    }
    _side = value;
  }

  double get area => _side * _side;

  @override
  String toString() => 'Lado $_side';
}
