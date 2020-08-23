import 'package:flutter/material.dart';
import 'package:qrscan/qrscan.dart' as scanner;

void main() {
  runApp(
    MyApp()
  );
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Leitor de QR Code',
      theme: ThemeData(
        primarySwatch: Colors.blue
      ),
      home: MyHomePage(
        title: 'Leitor de QR Code'
      ),
    );
  }
}

class MyHomePage extends StatefulWidget {

  final String title;

  MyHomePage({Key key, this.title}) : super(key: key);

  @override
  _MyHomePageState createState() => _MyHomePageState();

}

class _MyHomePageState extends State<MyHomePage> {

  void _captureQR() async {
    String qrText = await scanner.scan();

    _showDialog(qrText);
  }

  void _showDialog(String qrText) {
    showDialog(
      context: context,
      builder: (BuildContext context) {
        return AlertDialog(
          title: Text('Texto do QR Code'),
          content: Text(qrText),
          actions: <Widget>[
            FlatButton(
              child: Text('Fechar'),
              onPressed: () {
                Navigator.of(context).pop();
              }
            )
          ],
        );
      }
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(widget.title),
      ),
      body: Center(
        child: Column(
          children: <Widget>[
            RaisedButton(
              child: Text('Ler QR Code'),
              onPressed: () {
                _captureQR();
              }
            )
          ],
          mainAxisAlignment: MainAxisAlignment.center,
        ),
      ),
    );
  }

}
