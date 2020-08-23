import 'package:flutter/material.dart';

void main() {
  runApp(
    FriendsApp()
  );
}

class FriendsApp extends StatelessWidget {
  
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Meus amigos',
      home: Scaffold(
        appBar: AppBar(
          title: Text("Meus amigos"),
        ),
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: <Widget>[
              MyFriend("Maria"),
              MyFriend("Gabriel"),
              MyFriend("Anderson"),
              MyFriend("Camila")
            ],
          )
        ),
      )
    );
  }

}

// Widget personalizado
class MyFriend extends StatelessWidget {

  // Cada objeto desta classe é único assim como uma String.
  final String _text;

  const MyFriend(this._text);// Stateless widget é imutável

  @override
  Widget build(BuildContext context) {
    return Padding(
        padding: EdgeInsets.all(16),
        child: DecoratedBox(
          decoration: BoxDecoration(
            color: Colors.lightBlueAccent
          ),
          child: Text(
            this._text,
            style: TextStyle(
              fontSize: 48
            ),
          ),
        ),
      );
  }

}
