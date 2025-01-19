import 'dart:developer';

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class Clone2 extends StatefulWidget {
  const Clone2({super.key});

  @override
  createState() => _Clone2State();
}

class _Clone2State extends State<Clone2> {
  @override
  Widget build(BuildContext context) {
    double h = MediaQuery.of(context).size.height;
    double w = MediaQuery.of(context).size.width;

    return DefaultTabController(
      length: 4,
      child: Scaffold(
        bottomNavigationBar: BottomAppBar(
          color: Colors.white,
          child: Row(
            mainAxisAlignment: MainAxisAlignment.spaceBetween,
            mainAxisSize: MainAxisSize.max,
            children: [
              CircleAvatar(
                radius: 20,
                backgroundColor: Colors.transparent,
                child: Icon(
                  Icons.home_outlined,
                  size: 30,
                ),
              ),
              CircleAvatar(
                backgroundColor: Colors.transparent,
                radius: 20,
                child: Icon(
                  Icons.location_on_outlined,
                  size: 30,
                ),
              ),
              CircleAvatar(
                radius: 20,
                backgroundColor: Colors.redAccent,
                child: Icon(
                  Icons.add,
                  size: 30,
                  color: Colors.white,
                ),
              ),
              Column(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  CircleAvatar(
                    backgroundColor: Colors.transparent,
                    radius: 20,
                    child: Icon(
                      Icons.favorite_outline,
                      size: 30,
                    ),
                  ),
                  CircleAvatar(
                    radius: 2,
                    backgroundColor: Colors.red,
                  )
                ],
              ),
              CircleAvatar(
                backgroundColor: Colors.transparent,
                radius: 20,
                child: Icon(
                  Icons.person_2_outlined,
                  size: 30,
                ),
              ),
            ],
          ),
        ),
        appBar: AppBar(
          title: Container(
            padding: EdgeInsets.only(left: 10),
            child: Row(
              children: [
                GestureDetector(
                  child: Icon(
                    Icons.arrow_back_ios,
                    color: Colors.blueGrey,
                  ),
                  onTap: () {
                    log("arrOW TAPPED");
                  },
                ),
                Text(
                  "wanda.s",
                  style: TextStyle(fontWeight: FontWeight.bold, fontSize: 24),
                ),
              ],
            ),
          ),
          backgroundColor: Colors.white,
        ),
        body: Container(
          height: h,
          width: w,
          color: Colors.white, //maxsize
          padding: EdgeInsets.all(10),
          child: Column(
            children: [
              //profile section

              Container(
                width: w,
                padding: EdgeInsets.only(left: 10),
                alignment: Alignment.topCenter,
                child: Row(
                  children: [
                    Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      children: [
                        CircleAvatar(
                          radius: 40,
                          backgroundColor: Colors.amber,
                        ),
                        Text(
                          "Wanda.S",
                          style: TextStyle(
                            fontWeight: FontWeight.w800,
                          ),
                        ),
                        Text(
                          "http://xyz.com",
                          style: TextStyle(
                              fontWeight: FontWeight.w500, color: Colors.red),
                        )
                      ],
                    ),
                    SizedBox(
                      width: 40,
                    ),
                    Column(
                      mainAxisSize: MainAxisSize.min,
                      crossAxisAlignment: CrossAxisAlignment.center,
                      children: [
                        Row(
                          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                          mainAxisSize: MainAxisSize.max,
                          children: [
                            Column(
                              crossAxisAlignment: CrossAxisAlignment.start,
                              children: [
                                Text(
                                  "150",
                                  style: TextStyle(
                                      fontSize: 16,
                                      fontWeight: FontWeight.w800),
                                ),
                                Text(
                                  "Posts",
                                  style: TextStyle(
                                      fontSize: 12,
                                      color: Colors.red,
                                      fontWeight: FontWeight.w700),
                                )
                              ],
                            ),
                            SizedBox(
                              width: 20,
                            ),
                            Column(
                              crossAxisAlignment: CrossAxisAlignment.start,
                              children: [
                                Text(
                                  "5k",
                                  style: TextStyle(
                                      fontSize: 16,
                                      fontWeight: FontWeight.w800),
                                ),
                                Text(
                                  "Followers",
                                  style: TextStyle(
                                      fontSize: 12,
                                      color: Colors.red,
                                      fontWeight: FontWeight.w700),
                                )
                              ],
                            ),
                            SizedBox(
                              width: 20,
                            ),
                            Column(
                              crossAxisAlignment: CrossAxisAlignment.start,
                              children: [
                                Text(
                                  "100",
                                  style: TextStyle(
                                      fontSize: 16,
                                      fontWeight: FontWeight.w800),
                                ),
                                Text(
                                  "Following",
                                  style: TextStyle(
                                      fontSize: 12,
                                      color: Colors.red,
                                      fontWeight: FontWeight.w700),
                                )
                              ],
                            )
                          ],
                        ),
                        Row(
                          mainAxisAlignment: MainAxisAlignment.center,
                          children: [
                            ElevatedButton(
                              onPressed: () {},
                              style: ButtonStyle(
                                  backgroundColor: WidgetStatePropertyAll(
                                      Colors.blueAccent.shade200)),
                              child: Container(
                                  alignment: Alignment.center,
                                  width: 70,
                                  child: Text(
                                    "Follow",
                                    style: TextStyle(color: Colors.white),
                                  )),
                            ),
                            SizedBox(
                              width: 10,
                            ),
                            CircleAvatar(
                              radius: 18,
                              backgroundColor: Colors.blue.shade200,
                              child: CircleAvatar(
                                radius: 16,
                                backgroundColor: Colors.white,
                                child: Transform.rotate(
                                    angle: -90 * (3.14159265359 / 180),
                                    child: Icon(
                                      Icons.arrow_back_ios_new_sharp,
                                    )),
                              ),
                            )
                          ],
                        )
                      ],
                    )
                  ],
                ),
              )

              //favourites
              ,
              Divider(
                height: 25,
                color: Colors.transparent,
              ),
              Row(
                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                children: [
                  Column(
                    children: [
                      CircleAvatar(
                        radius: 25,
                        backgroundColor: Colors.red,
                        child: Icon(
                          Icons.add,
                          color: Colors.white,
                        ),
                      ),
                      Text(
                        "New",
                        style: TextStyle(
                            fontWeight: FontWeight.bold, fontSize: 12),
                      ),
                    ],
                  ),
                  Column(
                    children: [
                      CircleAvatar(
                          radius: 26,
                          backgroundColor: Colors.black,
                          child: CircleAvatar(
                            radius: 24,
                            child: ClipOval(
                              child: Image.network(
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTpr2bAzhbBDaKlMeiRNcErzW1hEcV2waabqw&s",
                                fit: BoxFit.cover,
                                height: 46,
                                width: 46,
                              ),
                            ),
                          )),
                      Text(
                        "Ny",
                        style: TextStyle(
                            fontWeight: FontWeight.bold, fontSize: 12),
                      ),
                    ],
                  ),
                  Column(
                    children: [
                      CircleAvatar(
                          radius: 26,
                          backgroundColor: Colors.black,
                          child: CircleAvatar(
                            radius: 24,
                            child: ClipOval(
                              child: Image.network(
                                "https://media2.thrillophilia.com/images/photos/000/178/906/original/1573727812_shutterstock_1283691793.jpg?width=975&height=600",
                                fit: BoxFit.cover,
                                height: 46,
                                width: 46,
                              ),
                            ),
                          )),
                      Text(
                        "Brazil",
                        style: TextStyle(
                            fontWeight: FontWeight.bold, fontSize: 12),
                      ),
                    ],
                  ),
                  Column(
                    children: [
                      CircleAvatar(
                          radius: 26,
                          backgroundColor: Colors.black,
                          child: CircleAvatar(
                            radius: 24,
                            child: ClipOval(
                              child: Image.network(
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ8JNxo4FtRwcksJbfParG_-eldV7hGXMcmTw&s",
                                fit: BoxFit.cover,
                                height: 46,
                                width: 46,
                              ),
                            ),
                          )),
                      Text(
                        "Paris",
                        style: TextStyle(
                            fontWeight: FontWeight.bold, fontSize: 12),
                      ),
                    ],
                  ),
                  Column(
                    children: [
                      CircleAvatar(
                          radius: 26,
                          backgroundColor: Colors.black,
                          child: CircleAvatar(
                            radius: 24,
                            child: ClipOval(
                              child: Image.network(
                                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcST5HPEc0TkWuGRYwNNW8jHlVekaZW47Jdzfw&s",
                                fit: BoxFit.cover,
                                height: 46,
                                width: 46,
                              ),
                            ),
                          )),
                      Text(
                        "London",
                        style: TextStyle(
                            fontWeight: FontWeight.bold, fontSize: 12),
                      ),
                    ],
                  ),
                ],
              )

              //links

              ,
              Divider(
                height: 20,
              ),

              Row(
                crossAxisAlignment: CrossAxisAlignment.center,
                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                children: [
                  Text(
                    "Email",
                    style: TextStyle(
                        color: Colors.blue,
                        fontSize: 18,
                        fontWeight: FontWeight.w500),
                  ),
                  Container(
                    width: 2,
                    height: 40,
                    color: Colors.grey.shade400,
                  ),
                  Text(
                    "Site",
                    style: TextStyle(
                        color: Colors.blue,
                        fontSize: 18,
                        fontWeight: FontWeight.w500),
                  ),
                  Container(
                    width: 2,
                    height: 40,
                    color: Colors.grey.shade400,
                  ),
                  Text(
                    "Phone",
                    style: TextStyle(
                        color: Colors.blue,
                        fontSize: 18,
                        fontWeight: FontWeight.w500),
                  ),
                ],
              ),
              Divider(
                height: 20,
              ),
              const TabBar(
                  indicatorColor: Colors.white,
                  indicatorWeight: 1,
                  dividerColor: Colors.white,
                  labelColor: Colors.blueAccent,
                  tabs: [
                    Tab(
                        icon: Icon(
                      Icons.grid_4x4_outlined,
                    )),
                    Tab(
                        icon: Icon(
                      Icons.person_2_outlined,
                    )),
                    Tab(
                        icon: Icon(
                      Icons.favorite_outline,
                    )),
                    Tab(
                        icon: Icon(
                      Icons.analytics_outlined,
                    ))
                  ]),
              Expanded(
                  child: TabBarView(children: [
                GridView.builder(
                  gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
                      crossAxisCount: 4),
                  itemCount: 20,
                  itemBuilder: (context, index) {
                    return Card(
                      // height: 40,
                      // width: 40,
                      // padding: EdgeInsets.all(2),
                      color: Colors.green,
                    );
                  },
                ),GridView.builder(
                  gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
                      crossAxisCount: 4),
                  itemCount: 20,
                  itemBuilder: (context, index) {
                    return Card(
                      // height: 40,
                      // width: 40,
                      // padding: EdgeInsets.all(2),
                      color: Colors.amber,
                    );
                  },
                ),GridView.builder(
                  gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
                      crossAxisCount: 4),
                  itemCount: 20,
                  itemBuilder: (context, index) {
                    return Card(
                      // height: 40,
                      // width: 40,
                      // padding: EdgeInsets.all(2),
                      color: Colors.blue,
                    );
                  },
                ),GridView.builder(
                  gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
                      crossAxisCount: 4),
                  itemCount: 20,
                  itemBuilder: (context, index) {
                    return Card(
                      // height: 40,
                      // width: 40,
                      // padding: EdgeInsets.all(2),
                      color: Colors.red,
                    );
                  },
                )
              ]))
              //tabbarview
            ],
          ),
        ),
      ),
    );
  }
}



//Trasform widget
//clipoval widget