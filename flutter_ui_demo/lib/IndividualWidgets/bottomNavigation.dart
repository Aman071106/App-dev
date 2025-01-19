import 'package:flutter/material.dart';
//pages
import 'Rows_cols_wrap.dart';
import 'alert.dart';
import 'container_sized.dart';

class Bottomnavigationbar extends StatefulWidget {
  const Bottomnavigationbar({super.key});

  @override
  createState() => _stateobj();
}

class _stateobj extends State<Bottomnavigationbar> {
  int current = 0;
  //sample
  // List<Widget> demo = [
  //   Text("home"),
  //   Text("alert"),
  //   Text("Row_Cols"),
  // ];

  //pagecontroller create
  final PageController _pg = PageController();
  //define
  void ontapsetindex(int index) {
    setState(() {
      //setstate will see the changes in widgets due to a variable
      current = index;
      _pg.jumpToPage(index);
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      // appBar: AppBar(                //not required since every page has its own
      //   title: Text("Nav Bar"),
      // ),
      // body: Center(child: demo.elementAt(current)),
      body: PageView(
        controller: _pg,
        physics: NeverScrollableScrollPhysics(),
        children: [MyBox1(), Alert_1(), RowsColsWrap()],
      ),
      bottomNavigationBar: BottomNavigationBar(
        items: const <BottomNavigationBarItem>[
          BottomNavigationBarItem(icon: Icon(Icons.home), label: "home"),
          BottomNavigationBarItem(icon: Icon(Icons.alarm), label: "alertpage"),
          BottomNavigationBarItem(
              icon: Icon(Icons.table_rows), label: "rows_cols"),
        ],
        currentIndex: current,
        backgroundColor: Colors.grey,
        selectedItemColor: Colors.blue,
        onTap: ontapsetindex,
      ),
    );
  }
}
