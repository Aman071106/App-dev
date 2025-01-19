import 'package:flutter/material.dart';

class MyTabBar extends StatefulWidget {
  const MyTabBar({super.key});
  @override
  createState() => _Tabar();
}

class _Tabar extends State<MyTabBar> {
  @override
  Widget build(BuildContext context) {
    return DefaultTabController(
      length: 6, //no of tabs
      child: Scaffold(
        appBar: AppBar(
          backgroundColor: Colors.blue,
          bottom: const TabBar(
            isScrollable: true,
            indicatorColor: Colors.amber,
            indicatorWeight: 5,
            tabs: [
              Tab(icon: Icon(Icons.directions_car)),
              Tab(icon: Icon(Icons.directions_transit)),
              Tab(icon: Icon(Icons.directions_bike)),
              Tab(icon: Icon(Icons.directions_car)),
              Tab(icon: Icon(Icons.directions_transit)),
              Tab(icon: Icon(Icons.directions_bike)),
            ],
          ),
        ),
        body: TabBarView(children: [
          Center(
            child: Container(
              color: Colors.amber,
              height: 40,
              width: 40,
            ),
          ),
          Center(
            child: Container(
              color: Colors.green,
              height: 40,
              width: 40,
            ),
          ),
          Center(
            child: Container(
              color: Colors.red,
              height: 40,
              width: 40,
            ),
          ),
          Center(
            child: Container(
              color: Colors.amber,
              height: 40,
              width: 40,
            ),
          ),
          Center(
            child: Container(
              color: Colors.green,
              height: 40,
              width: 40,
            ),
          ),
          Center(
            child: Container(
              color: Colors.red,
              height: 40,
              width: 40,
            ),
          )
        ]),
      ),
    );
  }
}
