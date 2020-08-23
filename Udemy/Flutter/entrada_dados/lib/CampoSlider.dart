import 'package:flutter/material.dart';

class CampoSlider extends StatefulWidget {
  @override
  _CampoSliderState createState() => _CampoSliderState();
}

class _CampoSliderState extends State<CampoSlider> {

  double _valor = 5;

  String _label = "5";

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Slider"),
      ),
      body: Container(
        padding: EdgeInsets.all(32),
        child: Column(
          children: <Widget>[
            Slider(
              value: _valor,
              min: 0,
              max: 10,
              label: _label,
              divisions: 5,
              onChanged: (double value) {
                setState(() {
                  _valor = value;
                  _label = value.toString();
                });
              }
            ),
            RaisedButton(
              child: Text("Clique aqui"),
              onPressed: () {
                print("Valor selecionado: " + _valor.toString());
              }
            )
          ],
        ),
      ),
    );
  }
}