package com.example.btandroid7;

public class Food {
    String url;
    String name;
    String price;

    public Food(String url, String name, String price) {
        this.url = url;
        this.name = name;
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
}
