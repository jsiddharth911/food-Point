package com.example.foodpoint;

public class modal2 {
        String image,name,rating,price,unique;

        modal2()
        {

        }

    public modal2(String image, String name, String rating, String price, String unique) {
        this.image = image;
        this.name =name;
        this.rating= rating;
        this.price = price;
        this.unique = unique;

    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUnique() {
        return unique;
    }

    public void setUnique(String unique) {
        this.unique = unique;
    }
}
