import 'package:flutter/material.dart';

class Clone1 extends StatelessWidget {
  const Clone1({super.key});
  @override
  Widget build(BuildContext context) {
    double h = MediaQuery.of(context).size.height;
    double w = MediaQuery.of(context).size.width;

    return Scaffold(
      body: SizedBox(
        // color: Colors.amber,
        height: h,
        width: w,
        child: Stack(
          children: [
            Container(
              height: h / 2,
              width: w,
              // color: Colors.amber,
              padding: EdgeInsets.all(0),
              child: Image.network(
                "https://cdn.pixabay.com/photo/2017/09/03/01/51/spain-2709122_640.jpg",
                fit: BoxFit.fill,
              ),
            ),
            Positioned(
              top: h / 2,
              child: Container(
                height: h / 2,
                width: w,
                color: Colors.white.withValues(alpha: 0.94),
                padding: EdgeInsets.all(20),
                child: Column(
                  // mainAxisAlignment: MainAxisAlignment.start,
                  // mainAxisSize: MainAxisSize.min,
                  children: [
                    Row(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      spacing: 60,
                      children: [
                        Text(
                          "Madrid city tour\nfor designers",
                          style: TextStyle(
                            fontSize: 40,
                            fontWeight: FontWeight.bold,
                            color: Colors.black,
                          ),
                        ),
                        Container(
                          padding: EdgeInsets.only(top: 10),
                          child: Icon(
                            Icons.plus_one,
                            color: Colors.black,
                            size: 45,
                          ),
                        )
                      ],
                    ),
                    SizedBox(
                      height: 10,
                    ),
                    Row(children: [
                      Text(
                        "city.madrid.post.designers.xyz",
                        style: TextStyle(
                            color: Colors.black.withValues(alpha: 0.8),
                            fontStyle: FontStyle.italic,
                            fontSize: 20),
                      )
                    ]),
                    Row(
                      mainAxisAlignment: MainAxisAlignment.spaceBetween,
                      children: [
                        Card(
                          color: Colors.grey.shade200,
                          child: Container(
                            padding: EdgeInsets.all(4),
                            height: 60,
                            width: 100,
                            child: Row(
                              mainAxisAlignment: MainAxisAlignment.spaceBetween,
                              children: [
                                Text("20",
                                    style: TextStyle(
                                        fontSize: 35, color: Colors.black)),
                                Icon(
                                  Icons.heart_broken_outlined,
                                  color: Colors.black,
                                  size: 35,
                                ),
                              ],
                            ),
                          ),
                        ),
                        Card(
                          color: Colors.grey.shade200,
                          child: Container(
                            padding: EdgeInsets.all(4),
                            height: 60,
                            width: 100,
                            child: Row(
                              mainAxisAlignment: MainAxisAlignment.spaceBetween,
                              children: [
                                Text("34",
                                    style: TextStyle(
                                        fontSize: 35, color: Colors.black)),
                                Icon(
                                  Icons.ac_unit_sharp,
                                  color: Colors.black,
                                  size: 35,
                                ),
                              ],
                            ),
                          ),
                        ),
                        Card(
                          color: Colors.grey.shade200,
                          child: Container(
                            padding: EdgeInsets.all(4),
                            height: 60,
                            width: 100,
                            child: Row(
                              mainAxisAlignment: MainAxisAlignment.spaceBetween,
                              children: [
                                Text("40",
                                    style: TextStyle(
                                        fontSize: 35, color: Colors.black)),
                                Icon(
                                  Icons.access_time,
                                  color: Colors.black,
                                  size: 35,
                                ),
                              ],
                            ),
                          ),
                        ),
                        Card(
                          color: Colors.grey.shade200,
                          child: Container(
                            padding: EdgeInsets.all(4),
                            height: 60,
                            width: 100,
                            child: Row(
                              mainAxisAlignment: MainAxisAlignment.spaceBetween,
                              children: [
                                Text("17",
                                    style: TextStyle(
                                        fontSize: 35, color: Colors.black)),
                                Icon(
                                  Icons.linked_camera,
                                  color: Colors.black,
                                  size: 35,
                                ),
                              ],
                            ),
                          ),
                        ),
                      ],
                    ),
                    Divider(
                      height: 10,
                      color: Colors.transparent,
                    ),
                    Divider(
                      height: 10,
                      color: Colors.grey,
                    ),
                    Container(
                      padding: EdgeInsets.only(top: 20),
                      child: SingleChildScrollView(
                        child: Text(
                          "Madrid, the capital of Spain, is a vibrant city known for its rich history, stunning architecture, and lively culture. Home to iconic landmarks like the Royal Palace, Puerta del Sol, and Plaza Mayor, Madrid blends old-world charm with modern sophistication. The city is renowned for its world-class museums, including the Prado Museum and Reina Sofía, housing masterpieces by artists like Velázquez.  ",
                          style: TextStyle(fontSize: 20, color: Colors.black),
                        ),
                      ),
                    )
                  ],
                ),
              ),
            ),
            Positioned(
                right: w / 20,
                top: h / 2.25,
                child: CircleAvatar(
                  radius: h / 20,
                  backgroundColor: Colors.blueGrey,
                  child: Icon(
                    size: 60,
                    Icons.man,
                    color: Colors.black,
                  ),
                )),
          ],
        ),
      ),
    );
  }
}
