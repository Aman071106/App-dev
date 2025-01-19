import 'package:flutter/material.dart';

class Dropdown1 extends StatefulWidget {
  const Dropdown1({super.key});
  @override
  _stobj createState() => _stobj();
}

class _stobj extends State<Dropdown1> {
  //in case nothing is selcted then we want null type
  String? Selected = "Select one";

  final List<String> _Roles = [
    "Developer",
    "Doctor",
    "Project Manager",
    "Coordinator"
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Button"),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Container(
                margin: EdgeInsets.all(20),
                height: 70,
                width: MediaQuery.of(context).size.width,
                // color: Colors.redAccent,
                child: DropdownButton<String>(
                    iconEnabledColor: Colors.amber,
                    icon: Icon(
                      Icons.arrow_drop_down_circle,
                      size: 30,
                    ),
                    isExpanded: true,
                    //setted value
                    value: Selected,

                    //to reduce writing big code we use map method

                    items: _Roles.map<DropdownMenuItem<String>>((String vl) {
                      return DropdownMenuItem<String>(
                          value: vl, child: Text(vl));
                    }).toList(),

                    //onchange
                    onChanged: (String? selected) {
                      setState(() {
                        if (selected != null) {
                          Selected = selected;
                        } else {
                          Selected = "Select one";
                        }
                      });
                    }))
          ],
        ),
      ),
    );
  }
}
