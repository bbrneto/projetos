import 'dart:math';

import 'package:flutter/material.dart';

// Atencao: e necessario configura o arquivo pubspec.yaml para imagens.
// Stateless: widgets que nao podem ser alterados (constantes).
// Stateful: widgets que podem ser alterados (variaveis).

void main() {
  runApp(MaterialApp(
    debugShowCheckedModeBanner: false,
    home: Home()
  ));
}

class Home extends StatefulWidget {
  @override
  _HomeState createState() => _HomeState();
}

class _HomeState extends State<Home> {
  var _frases = [
    "Resultados ou desculpas, mas nunca os dois!",
    "É apanhando que se aprende...",
    "Na prática, a teoria é outra."
  ];

  var _fraseInicial = "Clique abaixo para gerar uma frase!";

  void _geraFrase() {
    var _indice = new Random().nextInt(_frases.length);//0, 1, 2
    
    setState(() {
      _fraseInicial = _frases[_indice];
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text("Frases do Dia"),
          backgroundColor: Colors.green
        ),
        body: Center(
          child: Container(
            padding: EdgeInsets.all(16),
            child: Column(
              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              crossAxisAlignment: CrossAxisAlignment.center,
              children: <Widget>[
                Image.asset("images/logo.png"),
                Text(_fraseInicial,
                  textAlign: TextAlign.justify,
                  style: TextStyle(
                    fontSize: 17,
                    fontStyle: FontStyle.italic,
                    color: Colors.black
                  ),
                ),
                RaisedButton(
                  onPressed: () {
                    _geraFrase();
                  },
                  child: Text("Nova frase",
                    style: TextStyle(
                      fontSize: 25,
                      color: Colors.white,
                      fontWeight: FontWeight.bold
                    ),
                  ),
                  color: Colors.green
                )
              ],
            ),
          )
        )
      );
  }
}
