import 'package:flutter/material.dart';

void main() {
  runApp(// Pega o Widget fornecido e faz dele a raiz da árvore de Widgets.
    Center(// Raiz da árvore de Widgets.
      child: Text(
        "Hello World!",
        textDirection: TextDirection.ltr,
        style: TextStyle(
          fontSize: 30
        ),
      ),
    )
  );
}
