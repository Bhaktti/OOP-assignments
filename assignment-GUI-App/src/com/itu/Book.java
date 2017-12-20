package com.itu;

/**
 * Created by bhakti on 12/9/17.
 */
public class Book {

    private int id;
    private String code;
    private String title;
    private double price;

    public Book(String code, String title, Double price) {
        this.code=code;
        this.price= price;
        this.title= title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
