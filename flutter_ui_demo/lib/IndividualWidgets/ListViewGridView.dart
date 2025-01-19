import 'package:flutter/material.dart';

class Listviewgridview extends StatefulWidget {
  const Listviewgridview({super.key});

  //must override this for a stateful widget
  @override
  State<StatefulWidget> createState() {
    return Stateobj();
  }

  //build the list
}

//for a stful widget implement a object (by class) that extends State<Stateful Widget>-bbuild the widget here
class Stateobj extends State<Listviewgridview> {
  //listview.builders list , maps etc create
  static List<List<String>>? cards; //nullable because list can also be empty
  static void buildlist() {
    cards ??=
        []; //intitalize cards if it is null with an empty list, null!=empty list
    for (int i = 0; i < 10; i++) {
      cards!.add([
        "Card ${i * i}",
        "$i"
      ]); //null check for list cards    ! means we are asserting the add method that list will not be null else write ? in place of ! that only if list is not null we invoke add
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text("Lists and Grids"),
          elevation: 8, //one more parameter of appbaar for decoration
        ),
        body: GridView.builder(
            gridDelegate:
                SliverGridDelegateWithFixedCrossAxisCount(crossAxisCount: 3),
            itemCount: Stateobj.cards!.length,
            itemBuilder: (context, idx) {
              return Card(
                  child: ListTile(
                title: Text(Stateobj.cards![idx][0]),
                subtitle: Text(Stateobj.cards![idx][1]),
              ));
            }));
  }
}



 
 
 
 //bydefault scrollable
        //if we use coloumn it will show error because of constrained and space
        //Card is a already decorated container

//1-//manually write the children in ListView widget inside bidy
// children: [
//           Card(
//             child: ListTile(
//               title: Text("Orange"),
//               subtitle: Text("Aman"),
//             ),
//           ),
//           Card(
//             child: ListTile(
//               title: Text("Orange"),
//               subtitle: Text("Aman"),
//             ),
//           ),
//           Card(
//             child: ListTile(
//               title: Text("Orange"),
//               subtitle: Text("Aman"),
//             ),
//           ),
//           Card(
//             child: ListTile(
//               title: Text("Orange"),
//               subtitle: Text("Aman"),
//             ),
//           ),
//           Card(
//             child: ListTile(
//               title: Text("Orange"),
//               subtitle: Text("Aman"),
//             ),
//           ) //child can be any widget
//           ,
//           Card(
//             child: ListTile(
//               title: Text("Orange"),
//               subtitle: Text("Aman"),
//             ),
//           ),
//           Card(
//             child: ListTile(
//               title: Text("Orange"),
//               subtitle: Text("Aman"),
//             ),
//           ),
//           Card(
//             child: ListTile(
//               title: Text("Orange"),
//               subtitle: Text("Aman"),
//             ),
//           ),
//           Card(
//             child: ListTile(
//               title: Text("Orange"),
//               subtitle: Text("Aman"),
//             ),
//           ),
//           Card(
//             child: ListTile(
//               title: Text("Orange"),
//               subtitle: Text("Aman"),
//             ),
//           ),
//           Card(
//             child: ListTile(
//               title: Text("Orange"),
//               subtitle: Text("Aman"),
//             ),
//           )
//         ]

//2-//if list is dynamic-variable length-there are deletions ,insertions overtime, we can use listview.builder widget inside body
// ListView.builder(
//             itemCount: Stateobj.cards!
//                 .length, //i am asserting which will cause error if list  is   null-but i have called to build the list in main fn
//             itemBuilder: (context, idx) {
//               if (idx % 2 == 0) {
//                 return Container(
//                     child: ListTile(
//                   leading: Icon(Icons.person_2_rounded),
//                   title: Text(Stateobj.cards![idx][0]),
//                   subtitle: Text(Stateobj.cards![idx][1]),
//                 ));
//               }
//               return Card(
//                   child: ListTile(
//                 //can also use onclick
//                 leading: Icon(Icons.person),
//                 title: Text(Stateobj.cards![idx][0]),
//                 subtitle: Text(Stateobj.cards![idx][1]),
//               ));
//             })


//3-//
// GridView(
//           gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
//               crossAxisCount: 2, //vertical
//               mainAxisSpacing: 10, //horizontal
//               crossAxisSpacing: 5,
//               childAspectRatio: 1 / 1),
//           children: [
//             Card(
//               child: ListTile(
//                 title: Text("Orange"),
//                 subtitle: Text("Aman"),
//               ),
//             ),
//             Card(
//               child: ListTile(
//                 title: Text("Orange"),
//                 subtitle: Text("Aman"),
//               ),
//             ),
//             Card(
//               child: ListTile(
//                 title: Text("Orange"),
//                 subtitle: Text("Aman"),
//               ),
//             ),
//             Card(
//               child: ListTile(
//                 title: Text("Orange"),
//                 subtitle: Text("Aman"),
//               ),
//             ),
//             Card(
//               child: ListTile(
//                 title: Text("Orange"),
//                 subtitle: Text("Aman"),
//               ),
//             ) //child can be any widget
//             ,
//             Card(
//               child: ListTile(
//                 title: Text("Orange"),
//                 subtitle: Text("Aman"),
//               ),
//             ),
//             Card(
//               child: ListTile(
//                 title: Text("Orange"),
//                 subtitle: Text("Aman"),
//               ),
//             ),
//             Card(
//               child: ListTile(
//                 title: Text("Orange"),
//                 subtitle: Text("Aman"),
//               ),
//             ),
//             Card(
//               child: ListTile(
//                 title: Text("Orange"),
//                 subtitle: Text("Aman"),
//               ),
//             ),
//             Card(
//               child: ListTile(
//                 title: Text("Orange"),
//                 subtitle: Text("Aman"),
//               ),
//             ),
//             Card(
//               child: ListTile(
//                 title: Text("Orange"),
//                 subtitle: Text("Aman"),
//               ),
//             )
//           ],
//         )