import 'package:flutter/material.dart';

class CampoSwitch extends StatefulWidget {
  @override
  _CampoSwitchState createState() => _CampoSwitchState();
}

class _CampoSwitchState extends State<CampoSwitch> {

  bool _escolhaUsuario = false;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Switch"),
      ),
      body: Container(
        child: Column(
          children: <Widget>[
            SwitchListTile(
              title: Text("Receber notificações?"),
              value: _escolhaUsuario,
              onChanged: (bool value) {
                setState(() {
                  this._escolhaUsuario = value;
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
          ]
        )
      ),
    );
  }
}