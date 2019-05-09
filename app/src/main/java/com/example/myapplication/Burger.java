package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Burger {


    private String name;
    private String company;
    private String location;
    private String category;
    private int size;
    private int cost;

    public Burger(String inName, String inCompany, String inLocation, String inCategory, int inSize, int inCost) {
        name = inName;
        company = inCompany;
        location = inLocation;
        category = inCategory;
        size = inSize;
        cost = inCost;

    }

    public Burger(String inName) {
        name = inName;
        company = "";
        location = "";
        category = "";
        size = -1;
        cost = -1;
    }

    @Override
    public String toString() {
        return name;
    }

    public String info() {
        String str = name;
        str+=" is located in ";
        str+=location;
        str+=" and has a height of ";
        str+=Integer.toString(size);
        str+="m.";
        return str;

    }

    public void setSize(int newSize) {
        size = newSize;
    }
    public String getSize(){
        String newSize=""+size;
        return newSize;
    }

}
