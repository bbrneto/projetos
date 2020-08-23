import 'package:flutter/material.dart';

void main() {
  runApp(
    MyApp()
  );
}

class MyApp extends StatelessWidget {
  
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Livro sobre Flutter',// Título para a aplicação
      home: MyHomePage(),
    );
  }

}

class MyHomePage extends StatefulWidget {

  @override
  _MyHomePageState createState() => _MyHomePageState();

}

class _MyHomePageState extends State<MyHomePage> {

  int _counter = 0;

  void _incrementCounter() {
    setState(() {
      _counter++;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(
          "Nosso aplicativo"
        ),
        backgroundColor: Colors.brown,
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: <Widget>[
            Text(
              'Vezes em que o botão foi pressionado:',
            ),
            Text(
              '$_counter',
              style: Theme.of(context).textTheme.headline4,
            ),
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: _incrementCounter,
        tooltip: 'Increment',
        child: Icon(Icons.add),
        backgroundColor: Colors.red,
      ),
      bottomNavigationBar: BottomAppBar(
        color: Colors.brown,
        child: Container(
          height: 100,
          child: Padding(
            padding: EdgeInsets.all(16),
            child: Row(
              children: <Widget>[
                IconButton(
                  icon: Icon(
                    Icons.add_box,
                    color: Colors.white,
                  ), 
                  onPressed: () {
                    print('Adicionei uma caixa');
                  }
                ),
                IconButton(
                  icon: Icon(
                    Icons.add_a_photo,
                    color: Colors.white,
                  ), 
                  onPressed: () {
                    print('Adicionei uma foto');
                  }
                )
              ],
            ),
          ),
        ),
      ),
    );
  }

}
