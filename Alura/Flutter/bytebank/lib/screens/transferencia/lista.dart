import 'package:bytebank/models/transferencia.dart';
import 'package:bytebank/screens/transferencia/formulario.dart';
import 'package:flutter/material.dart';

const _tituloAppBar = 'Transferências';

class ListaTransferencias extends StatefulWidget {

  final List<Transferencia> _transferencias = List();

  @override
  _ListaTransferenciasState createState() => _ListaTransferenciasState();

}

class _ListaTransferenciasState extends State<ListaTransferencias> {

  // Executado a cada mudanca de estado, ou seja, a cada atualizacao de tela.
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(
          _tituloAppBar,
        ),
      ),
      body: ListView.builder(
        itemCount: widget._transferencias.length,
        itemBuilder: (context, indice) {
          final transferencia = widget._transferencias[indice];

          return ItemTransferencia(transferencia);
        },
      ),
      floatingActionButton: FloatingActionButton(
        child: Icon(
          Icons.add,
        ),
        onPressed: () {
          Navigator.push(context, MaterialPageRoute(builder: (context) {
            return FormularioTransferencia();
          })).then((transferenciaRecebida) {
            _atualiza(transferenciaRecebida);
          });
        }
      ),
    );
  }

  void _atualiza(Transferencia transferenciaRecebida) {
    debugPrint('Chegou!!!');
    debugPrint('$transferenciaRecebida');
    
    if (transferenciaRecebida != null) {
      setState(() {// Executa novamente o metodo Widget build(BuildContext context)
        widget._transferencias.add(transferenciaRecebida);
      });
    }
  }

}

class ItemTransferencia extends StatelessWidget {
  
  final Transferencia _transferencia;

  ItemTransferencia(this._transferencia);

  @override
  Widget build(BuildContext context) {
    return Card(
      child: ListTile(
        leading: Icon(
          Icons.monetization_on
        ),
        title: Text(
          this._transferencia.valor.toString()
        ),
        subtitle: Text(
          this._transferencia.numeroConta.toString()
        ),
      ),
    );
  }
}
