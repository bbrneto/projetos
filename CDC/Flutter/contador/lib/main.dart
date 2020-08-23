import 'package:flutter/material.dart';

void main() {
  runApp(
    CounterApp()
  );
}

class CounterApp extends StatelessWidget {

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Contador',
      home: Scaffold(
        appBar: AppBar(
          title: Text("Contador"),
        ),
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              ItemCounter("Leo")
            ],
          ),
        ),
      ),
    );
  }

}

class ItemCounter extends StatefulWidget {

  final String name;

  ItemCounter(this.name);

  @override
  _ItemCounterState createState() => _ItemCounterState();

}

// Classe privada responsável pelos aspectos mutável do widget.
class _ItemCounterState extends State<ItemCounter> {

  int count = 0;

  @override
  Widget build(BuildContext context) {
    return GestureDetector(
      onTap: () {
        setState(() {// Notifica uma mudança de estado.
          count++;
        });// Permite que o Flutter altere o widget na tela do aplicativo.
      },
      child: Text(
        '${widget.name}: $count',
        style: TextStyle(
          fontSize: 48
        )
      )
    );
  }

}
