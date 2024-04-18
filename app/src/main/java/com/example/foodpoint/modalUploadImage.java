package com.example.foodpoint;

public class modalUploadImage {
    private String image,name,price,unique,email;
    public modalUploadImage()
    {

    }
    public modalUploadImage(String image,String email,String name,String price,String unique)
    {
        this.image=image;
        this.name=name;
        this.price=price;
        this.unique=unique;
        this.email=email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
