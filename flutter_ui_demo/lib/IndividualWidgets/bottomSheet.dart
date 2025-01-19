import 'package:flutter/material.dart';

class BottomsheetW extends StatelessWidget {
  const BottomsheetW({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Bottom sheet"),
      ),
      body: Center(
        child: ElevatedButton(
          onPressed: () {
            showModalBottomSheet(
                barrierColor: Colors.amber,
                backgroundColor: Theme.of(context).primaryColor,
                isDismissible: true,
                enableDrag: false,
                shape: RoundedRectangleBorder(
                    borderRadius: BorderRadius.only(
                        topLeft: Radius.circular(30),
                        topRight: Radius.circular(0))),
                context: context,
                builder: (context) {
                  return ListView(
                    shrinkWrap: true,
                    // physics: PageScrollPhysics(),
                    children: [
                      Card(
                        child: ListTile(
                          title: Text('Aman Gupta'),
                          subtitle: Text('Software developer'),
                        ),
                      ),
                      Card(
                        child: ListTile(
                          title: Text('Aman Gupta'),
                          subtitle: Text('Software developer'),
                        ),
                      ),
                      Card(
                        child: ListTile(
                          title: Text('Aman Gupta'),
                          subtitle: Text('Software developer'),
                        ),
                      ),
                      Card(
                        child: ListTile(
                          title: Text('Aman Gupta'),
                          subtitle: Text('Software developer'),
                        ),
                      ),
                      Card(
                        child: ListTile(
                          title: Text('Aman Gupta'),
                          subtitle: Text('Software developer'),
                        ),
                      ),
                      Card(
                        child: ListTile(
                          title: Text('Aman Gupta'),
                          subtitle: Text('Software developer'),
                        ),
                      ),
                      Card(
                        child: ListTile(
                          title: Text('Aman Gupta'),
                          subtitle: Text('Software developer'),
                        ),
                      ),
                      Card(
                        child: ListTile(
                          title: Text('Aman Gupta'),
                          subtitle: Text('Software developer'),
                        ),
                      ),
                      Card(
                        child: ListTile(
                          title: Text('Aman Gupta'),
                          subtitle: Text('Software developer'),
                        ),
                      ),
                      Card(
                        child: ListTile(
                          title: Text('Aman Gupta'),
                          subtitle: Text('Software developer'),
                        ),
                      ),
                      Card(
                        child: ListTile(
                          title: Text('Aman Gupta'),
                          subtitle: Text('Software developer'),
                        ),
                      ),
                    ],
                  );
                });
          },
          child: Text('Show bottom sheet'),
        ),
      ),
    );
  }
}
