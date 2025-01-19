//for log
import 'dart:developer';
//for widgets
import 'package:flutter/material.dart';
//for url
import 'package:url_launcher/url_launcher.dart';

class Quicklinks extends StatelessWidget {
  // Function to launch the URL
  Future<void> _launchURL(String url) async {
    final Uri uri = Uri.parse(url.trim()); // Convert the string to a Uri object
    log("$uri");
    try {
      await launchUrl(uri);
      log('Launched successfully');
    } catch (e) {
      log('Error occurred while launching: $e');
      throw 'Could not launch $url';
    }
  }

  //Links[title,link]
  List<List<String>> iitMandiLinks = [
    ["Institute", "null"],
    ["IIT Mandi Website", "https://www.iitmandi.ac.in/"],
    ["Student Gymkhana", "https://iitmandi.co.in/"],
    ["Academic", "null"],
    ["UG Academic", "https://iitmandi.co.in/ug_acad.html"],
    ["PG Academic", "https://iitmandi.co.in/pg_acad.html"],
    ["Technical Society", "null"],
    ["Society Website", "https://iitmandi.co.in/technical.html"],
    ["Kamand Prompt", "https://pc.iitmandi.co.in/"],
    ["Robotronics", "https://robotronics.iitmandi.co.in/"],
    ["STAC", "https://stac.iitmandi.co.in/"],
    ["Yantrik", "https://yantrik.iitmandi.co.in/"],
    ["Nirman", "https://nirmaan.iitmandi.co.in/"],
    ["SAE", "https://clubsae.iitmandi.co.in/about-us"],
    ["E-cell", "https://ecell.iitmandi.co.in/"],
    ["KBG", "https://www.instagram.com/kbg_iitmandi/"],
    ['Other', 'null'],
    ["Cultural Society", "https://iitmandi.co.in/cultural.html"],
    ["Sports Society", "https://iitmandi.co.in/sports.html"],
    ["Literary Society", "https://iitmandi.co.in/literary.html"],
    ["Hostel Affairs", "https://iitmandi.co.in/hostel.html"],
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(), //**replace with new app bar
      body: ListView.builder(
          padding: EdgeInsets.only(left: 20, right: 20),
          itemCount: iitMandiLinks.length,
          itemBuilder: (context, idx) {
            if (idx == 0) {
              return Text(
                "\n${iitMandiLinks[idx][0]}",
                style: const TextStyle(
                    fontWeight: FontWeight.w700,
                    fontSize: 20,
                    color: Color(0xFF212121)),
              );
            }
            if (iitMandiLinks[idx][1] == "null") {
              return Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  const Text("\n"),
                  Container(
                    height: 1,
                    decoration: const BoxDecoration(color: Color(0xFF9A9A9A)),
                  ),
                  Text(
                    "\n${iitMandiLinks[idx][0]}",
                    style: const TextStyle(
                        fontWeight: FontWeight.w700,
                        fontSize: 20,
                        color: Color(0xFF212121)),
                  ),
                ],
              );
            }
            return GestureDetector(
                onTap: () {
                  log(iitMandiLinks[idx][1]);
                  _launchURL(iitMandiLinks[idx][1]);
                },
                child: Wrap(
                  children: [
                    Text(
                      "\n${iitMandiLinks[idx][0]}",
                      style: const TextStyle(
                          fontSize: 17,
                          fontWeight: FontWeight.normal,
                          color: Color(0xFF212121)),
                    )
                  ],
                ));
          }),
    );
  }
}
