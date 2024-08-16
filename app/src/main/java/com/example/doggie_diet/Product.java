//package com.example.doggie_diet;
//
//public class Product {
//    private String name;
//    private String imageUrl;
//
//    public Product(String name, String imageUrl) {
//        this.name = name;
//        this.imageUrl = imageUrl;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getImageUrl() {
//        return imageUrl;
//    }
//}
//

package com.example.doggie_diet;

public class Product {
    private String name;
    private int imageResId;

    public Product(String name, int imageResId) {
        this.name = name;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }
}
