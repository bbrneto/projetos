import 'dart:math';

import 'package:flutter/material.dart';

class Jogo extends StatefulWidget {
  @override
  _JogoState createState() => _JogoState();
}

class _JogoState extends State<Jogo> {

  static const int pedra = 0;
  static const int tesoura = 1;
  static const int papel = 2;

  var _imageApp = AssetImage("images/padrao.png");

  var _mensagem = "Escolha uma opção abaixo";

  var _images = [
    AssetImage("images/pedra.png"),
    AssetImage("images/tesoura.png"),
    AssetImage("images/papel.png")
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("JokenPo"),
      ),
      body: Column(
        crossAxisAlignment: CrossAxisAlignment.center,
        children: <Widget>[
          Padding(
            padding: EdgeInsets.only(top: 32, bottom: 16),
            child: Text(
              "Escolha do App:",
              textAlign: TextAlign.center,
              style: TextStyle(
                fontSize: 20,
                fontWeight: FontWeight.bold
              ),
            )
          ),
          Image(image: this._imageApp),
          Padding(
            padding: EdgeInsets.only(top: 32, bottom: 16),
            child: Text(
              this._mensagem,
              textAlign: TextAlign.center,
              style: TextStyle(
                fontSize: 20,
                fontWeight: FontWeight.bold
              ),
            )
          ),
          Row(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: <Widget>[
              GestureDetector(
                onTap: () => this._compara(pedra),
                child: Image.asset(
                  "images/pedra.png",
                  height: 100
                )
              ),
              GestureDetector(
                onTap: () => this._compara(tesoura),
                child: Image.asset(
                  "images/tesoura.png",
                  height: 100
                )
              ),
              GestureDetector(
                onTap: () => this._compara(papel),
                child: Image.asset(
                  "images/papel.png",
                  height: 100
                )
              )
            ],
          )
        ],
      )
    );
  }

  void _compara(int valor) {
    var indice = new Random().nextInt(3);

    setState(() {
      this._imageApp = this._images[indice];
      this._mensagem = this._getMensagem(indice, valor);
    });
  }

  String _getMensagem(int indice, int valor) {
    if (indice == valor) {
      return "Empate!";
    }

    var jogadas = [
      [pedra, tesoura],
      [tesoura, papel],
      [papel, pedra]
    ];

    for (var jogada in jogadas) {
      if (indice == jogada[0] && valor == jogada[1]) {
        return "Você perdeu!";
      }      
    }

    return "Você ganhou!";
  }

}