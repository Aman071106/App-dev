import 'dart:developer';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class Forms extends StatefulWidget {
  const Forms({super.key});

  @override
  createState() => _FormState();
}

class _FormState extends State<Forms> {
  //key for form?
  final _formkey = GlobalKey<FormState>();

  //Textformfields -these are different from normal text fields
  String _name = "", _email = "";
  String _PassW = "";

  //although it should first authenticate with a future function which will be seen while working with firebase
  _trySubmit() {
    bool isvalid =
        _formkey.currentState!.validate(); //according to individual validators
    if (isvalid) {
      //check for authentication later
      _submit();
    } else {
      log("error");
    }
  }

  _submit() {
    _formkey.currentState!.save();
    log(_name);
    log(_PassW);
    log(_email);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("FORMS"),
      ),
      body: Center(
        child: Form(
            key: _formkey,
            child: Column(
              children: [
                TextFormField(
                  key: ValueKey("name"), //what is a value key
                  validator: (value) {
                    if (value.toString() == "") {
                      return "Hey there!, Enter your name";
                    }
                    return null;
                  },
                  onSaved: (value) {
                    _name = value.toString();
                  },
                  decoration: InputDecoration(hintText: "Enter your name"),
                ),
                TextFormField(
                  key: ValueKey("email"), //what is a value key
                  validator: (value) {
                    if (value.toString() == "" ||
                        !value.toString().contains('@')) {
                      return "Hey there!, Enter your email with @sign";
                    }
                    return null;
                  },
                  onSaved: (value) {
                    _email = value.toString();
                  },
                  decoration: InputDecoration(hintText: "Enter your email"),
                ),
                TextFormField(
                  //only number input
                  keyboardType: TextInputType.number,
                  inputFormatters: [FilteringTextInputFormatter.digitsOnly],
                  key: ValueKey("password"), //what is a value key
                  validator: (value) {
                    if (value.toString().length < 8) {
                      return "Minimum length is 8";
                    }
                    return null;
                  },
                  onSaved: (value) {
                    _PassW = value.toString();
                  },
                  obscureText: true,
                  decoration: InputDecoration(
                    hintText: "Enter password",
                  ),
                ),
                ElevatedButton(
                    onPressed: () {
                      _trySubmit();
                    },
                    child: Text("Submit"))
              ],
            )),
      ),
    );
  }
}
