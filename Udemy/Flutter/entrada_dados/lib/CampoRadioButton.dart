import 'package:flutter/material.dart';

class CampoRadioButton extends StatefulWidget {
  @override
  _CampoRadioButtonState createState() => _CampoRadioButtonState();
}

class _CampoRadioButtonState extends State<CampoRadioButton> {

  String _escolhaUsuario;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("RadioButton"),
      ),
      body: Container(
        child: Column(
          children: <Widget>[
            RadioListTile(
              title: Text(
                "Masculino"
              ),
              value: "m",
              groupValue: _escolhaUsuario,
              onChanged: (String value) {
                setState(() {
                  _escolhaUsuario = value;
                });
              }
            ),
            RaisedButton(
              child: Text(
                "Salvar",
                style: TextStyle(
                  fontSize: 20
                )
              ),
              onPressed: () {
                print(_escolhaUsuario);
              }
            )
          ],
        ),
      ),
    );
  }
}
