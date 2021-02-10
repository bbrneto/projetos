import 'dart:math';

import 'package:flutter/material.dart';

// Atencao: e necessario configura o arquivo pubspec.yaml para imagens.
// Stateless: widgets que nao podem ser alterados (constantes).
// Stateful: widgets que podem ser alterados (variaveis).

void main() {
  runApp(MaterialApp(
    // debugShowCheckedModeBanner: false,
    title: 'Frases do dia',
    home: Container(// Ocupa todo o espaço da tela
      child: Column(
        children: <Widget>[
          Text(
            'T1',
          ),
          Text(
            'T2',
          ),
          Text(
            'T3',
          ),
        ],
      ),
      padding: EdgeInsets.fromLTRB(0, 0, 0, 0),// Espaçamento interno
      margin: EdgeInsets.all(0),// Espaçamento externo
      decoration: BoxDecoration(
        border: Border.all(
          width: 3, 
          color: Colors.white,
        ),
      ),
    ),

    // home: Container(
    //   color: Colors.green,
    // ),

    // home: Column(
    //   children: <Widget>[
    //     Text(
    //       'Texto 01',
    //     ),
    //     Text(
    //       'Texto 02',
    //     ),
    //     Text(
    //       'Texto 03',
    //     ),
    //   ],
    // ),

    // home: Row(
    //   children: <Widget>[
    //     Text(
    //       'T1',
    //     ),
    //     Text(
    //       'T2',
    //     ),
    //     Text(
    //       'T3',
    //     ),
    //   ],
    // ),

    // home: Container(
    //   child: Column(
    //     children: <Widget>[
    //       Text(
    //         'Lorem Ipsum is simply dummy text of the printing and typesetting industry.',
    //         style: TextStyle(
    //           fontSize: 35,
    //           fontStyle: FontStyle.italic,
    //           fontWeight: FontWeight.bold,
    //           letterSpacing: 10,
    //           wordSpacing: 20,
    //           decoration: TextDecoration.lineThrough,
    //           decorationColor: Colors.green,
    //           decorationStyle: TextDecorationStyle.solid,
    //           color: Colors.black,
    //         ),
    //       ),
    //     ],
    //   ),
    //   color: Colors.white,
    // ),

    // home: Container(
    //   child: Column(
    //     children: <Widget>[
    //       FlatButton(
    //         onPressed: () {
    //           print('Botão pressionado!');
    //         }, 
    //         child: Text(
    //           'Clique aqui',
    //           style: TextStyle(
    //             fontSize: 20,
    //             color: Colors.black,
    //             decoration: TextDecoration.none,
    //           ),
    //         ),
    //       ),
    //     ],
    //   ),
    //   color: Colors.white,
    // ),
  ));
}

/*
void main() {
  runApp(MaterialApp(
    debugShowCheckedModeBanner: false,
    home: Home()
  ));
}
*/

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
    var _indice = new Random().nextInt(_frases.length); //0, 1, 2

    setState(() {
      _fraseInicial = _frases[_indice];
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar:
            AppBar(title: Text("Frases do Dia"), backgroundColor: Colors.green),
        body: Center(
            child: Container(
          padding: EdgeInsets.all(16),
          child: Column(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: <Widget>[
              Image.asset("images/logo.png"),
              Text(
                _fraseInicial,
                textAlign: TextAlign.justify,
                style: TextStyle(
                    fontSize: 17,
                    fontStyle: FontStyle.italic,
                    color: Colors.black),
              ),
              RaisedButton(
                  onPressed: () {
                    _geraFrase();
                  },
                  child: Text(
                    "Nova frase",
                    style: TextStyle(
                        fontSize: 25,
                        color: Colors.white,
                        fontWeight: FontWeight.bold),
                  ),
                  color: Colors.green)
            ],
          ),
        )));
  }
}
