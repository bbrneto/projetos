import 'package:flutter/material.dart';

class CampoCheckBox extends StatefulWidget {
  @override
  _CampoCheckBoxState createState() => _CampoCheckBoxState();
}

class _CampoCheckBoxState extends State<CampoCheckBox> {

  bool _comidaBrasileira = false;

  bool _comidaMexicana = false;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("CheckBox")
      ),
      body: Container(
        child: Column(
          children: <Widget>[
            CheckboxListTile(
              title: Text("Comida Brasileira"),
              subtitle: Text("A melhor comida do mundo"),
              //secondary: Icon(Icons.add_location),
              value: _comidaBrasileira,
              onChanged: (bool valor) {
                setState(() {
                  _comidaBrasileira = valor;
                });
              }
            ),
            CheckboxListTile(
              title: Text("Comida Mexicana"),
              subtitle: Text("A comida mais apimentada do mundo"),
              value: _comidaMexicana,
              onChanged: (bool valor) {
                setState(() {
                  _comidaMexicana = valor;
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
                print("Comida Brasileira: " + _comidaBrasileira.toString());
                print("Comida Mexicana: " + _comidaMexicana.toString());
              }
            )
            /*
            Text("Comida Brasileira"),
            Checkbox(
              value: _estaSelecionado,// Estado inicial: true - Marcado; false - Desmarcado
              onChanged: (bool valor) {
                setState(() {
                  _estaSelecionado = valor;
                });                
              }
            )
            */
          ]
        )
      )
    );
  }
}