import 'package:flutter/material.dart';

class Drawer_custom extends StatelessWidget {
  const Drawer_custom({super.key});
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      //drawer is a part of scaffold
      drawer: Drawer(
        child: Container(
          color: Theme.of(context).primaryColor, //child has complete space
          child: ListView(children: [
            DrawerHeader(
                padding: EdgeInsets.all(
                    0), //to remove default padding of drawerheader
                child: Container(
                  padding: EdgeInsets.all(10),
                  // color: Colors.blue,
                  child: Row(
                    children: [
                      CircleAvatar(
                        radius: 40,
                        backgroundImage: NetworkImage(
                            "https://m.media-amazon.com/images/I/61qmaEn2uxL._AC_UF1000,1000_QL80_.jpg"),
                      ),
                      Container(
                        //more modifications are done by wrapping with container
                        // color: Colors.white,
                        padding: EdgeInsets.only(left: 10),
                        child: Column(
                          mainAxisAlignment: MainAxisAlignment.center,
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: [
                            Text(
                              'Aman Gupta',
                              style: TextStyle(
                                  fontWeight: FontWeight.w700,
                                  fontSize: 20,
                                  color: Colors.black),
                            ),
                            Text(
                              '@deadlyharbor',
                              style: TextStyle(
                                  fontWeight: FontWeight.normal,
                                  fontSize: 16,
                                  color: Colors.black),
                            )
                          ],
                        ),
                      )
                    ],
                  ),
                )),
            ListTile(
              leading: Icon(
                Icons.share,
                color: Colors.black,
              ),
              title: Text(
                'Share',
                style: TextStyle(color: Colors.blue),
              ),
            ),
            ListTile(
              leading: Icon(
                Icons.share,
                color: Colors.black,
              ),
              title: Text(
                'Share',
                style: TextStyle(color: Colors.blue),
              ),
            ),
            ListTile(
              leading: Icon(
                Icons.share,
                color: Colors.black,
              ),
              title: Text(
                'Share',
                style: TextStyle(color: Colors.blue),
              ),
            ),
            ListTile(
              leading: Icon(
                Icons.share,
                color: Colors.black,
              ),
              title: Text(
                'Share',
                style: TextStyle(color: Colors.blue),
              ),
            ),
            ListTile(
              leading: Icon(
                Icons.share,
                color: Colors.black,
              ),
              title: Text(
                'Share',
                style: TextStyle(color: Colors.blue),
              ),
            ),
            Divider(
              color: Colors.red,
            ),
            ListTile(
              leading: Icon(
                Icons.share,
                color: Colors.black,
              ),
              title: Text(
                'Share',
                style: TextStyle(color: Colors.blue),
              ),
            ),
            ListTile(
              leading: Icon(
                Icons.share,
                color: Colors.black,
              ),
              title: Text(
                'Share',
                style: TextStyle(color: Colors.blue),
              ),
            ),
            ListTile(
              leading: Icon(
                Icons.share,
                color: Colors.black,
              ),
              title: Text(
                'Share',
                style: TextStyle(color: Colors.blue),
              ),
            ),
            ListTile(
              leading: Icon(
                Icons.share,
                color: Colors.black,
              ),
              title: Text(
                'Share',
                style: TextStyle(color: Colors.blue),
              ),
            ),
            ListTile(
              leading: Icon(
                Icons.share,
                color: Colors.black,
              ),
              title: Text(
                'Share',
                style: TextStyle(color: Colors.blue),
              ),
            ),
            ListTile(
              leading: Icon(
                Icons.share,
                color: Colors.black,
              ),
              title: Text(
                'Share',
                style: TextStyle(color: Colors.blue),
              ),
            ),
            ListTile(
              leading: Icon(
                Icons.share,
                color: Colors.black,
              ),
              title: Text(
                'Share',
                style: TextStyle(color: Colors.blue),
              ),
            ),
          ] //how to acess theme parameters
              ),
        ),
      ),
      appBar: AppBar(
        title: Text("Drawer implementation"),
      ),
    );
  }
}
