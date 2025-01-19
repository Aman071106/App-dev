import 'package:flutter/material.dart';
import 'package:cached_network_image/cached_network_image.dart';

class ImageWidget extends StatelessWidget {
  const ImageWidget({super.key});
  //Various image case uses in a ListView
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Image Widgets'),
      ),
      body: ListView(
        children: [
          Divider(
            color: Colors.white,
          ),
          //network image
          Center(
            child: Container(
              height: 200,
              width: 200,
              decoration: BoxDecoration(
                  color: Colors.red,
                  //no change to image but only to container
                  borderRadius: BorderRadius.circular(20)),
              child: Image.network(
                  fit: BoxFit.cover, //many customizations
                  "https://v3img.voot.com/resizeMedium,w_810,h_1080/v3Storage/assets/hp3x4-1687867620855-1716306193626-1716376773993.jpg"),
            ),
          ),
          Divider(
            color: Colors.white,
          ),
          Center(
            child: Container(
              height: 200,
              width: 200,
              decoration: BoxDecoration(
                  boxShadow: [
                    BoxShadow(
                        blurRadius: 20, color: Colors.white, spreadRadius: 5)
                  ],
                  color: Colors.red,
                  image: DecorationImage(
                      fit: BoxFit.cover,
                      image: NetworkImage(
                          "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQyynHpKb-pMRo9GYXF65g1FgQXqwfzdFhnEcSLHaA_sb8EfD8JP-KHgcKTc_db0jKtL34&usqp=CAU")),
                  //now change to image but only to container
                  borderRadius: BorderRadius.circular(20)),
            ),
          ),
          //assets image
          Divider(
            color: Colors.white,
          ),
          Center(
            child: Container(
              height: 200,
              width: 200,
              decoration: BoxDecoration(
                  color: Colors.red,
                  image: DecorationImage(
                      fit: BoxFit.cover,
                      image: AssetImage("assets/harry3.jpg")),
                  //now change to image but only to container
                  borderRadius: BorderRadius.circular(20)),
            ),
          )
          //cached image
          ,
          Divider(),
          Center(
            child: Container(
              height: 200,
              width: 200,
              // color: Colors.amber,
              child: CachedNetworkImage(
                  //in placeholder we provide a lamda fn to build a widget while image is being rendered
                  placeholder: (context, url) =>
                      Center(child: CircularProgressIndicator()),
                  errorWidget: (context, url, error) => Icon(Icons.error),
                  fit: BoxFit.fitWidth,
                  imageUrl:
                      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSwaDZAqazLOoxXtugtlmX4eXvG1JpMzI8qCRvrT9ZpxAdhvLr1UsnAqf449TosNWspsVE&usqp=CAU"),
            ),
          ),
          Divider(),
          Center(
            child: Container(
              height: 200,
              width: 200,
              // color: Colors.amber,
              child: CachedNetworkImage(
                  //in placeholder we provide a lamda fn to build a widget while image is being rendered
                  progressIndicatorBuilder: (context, url, downloadProgress) =>
                      CircularProgressIndicator(
                          value: downloadProgress.progress),
                  errorWidget: (context, url, error) => Icon(Icons.error),
                  fit: BoxFit.fitWidth,
                  imageUrl:
                      "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSwaDZAqazLOoxXtugtlmX4eXvG1JpMzI8qCRvrT9ZpxAdhvLr1UsnAqf449TosNWspsVE&usqp=CAU"),
            ),
          )
        ],
      ),
    );
  }
}

//Key Differences
// Aspect	Network Image	Cached Image
// Caching	No	Yes (stored locally in cache)
// Performance	Slower, re-downloads every time	Faster after initial download
// Data Usage	Higher (downloads every time)	Lower (reuses cached images)
// Offline Support	No	Yes
// Placeholders/Errors	No	Yes
