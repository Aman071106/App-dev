import 'package:flutter/material.dart';

class Dissmisible extends StatefulWidget {
  //inbuilt spell: Dismissible
  const Dissmisible({super.key});

  @override
  State<StatefulWidget> createState() {
    //_stateofdismissible=State<Stateful Widget>=nothing ,because we are overriding
    return _Stateofdismissible();
  }
}

class _Stateofdismissible extends State<Dissmisible> {
  List<int> l = [for (int i = 0; i < 10; i++) i];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Dissmisible'),
      ),
      body: ListView.builder(
        itemCount: l.length,
        itemBuilder: (context, idx) {
          return Dismissible(
              //background based on dismiss
              background: Container(
                color: Colors.blueGrey,
              ),
              secondaryBackground: Icon(Icons.access_time),
              onDismissed: (dir) {
                //dir is var name foor direction im using
                //other than dismiss there are resize etc
                if (dir == DismissDirection.startToEnd) {
                  //there are many directions
                  ScaffoldMessenger.of(context).showSnackBar(SnackBar(
                      backgroundColor: Colors.red,
                      content: Text(
                          'The square of number you delted is ${l[idx] * l[idx]}')));
                } else {
                  //rest directions-end to start
                  ScaffoldMessenger.of(context).showSnackBar(SnackBar(
                      backgroundColor: Colors.amber,
                      content: Text('The  number you delted is ${l[idx]}')));
                }
              },
              key: Key("${l[idx]}"), //key should be unique
              child: Card(
                child: Text(l[idx].toString()),
              ));
        },
      ),
    );
  }
}
