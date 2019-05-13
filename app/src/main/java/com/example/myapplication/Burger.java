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



    public void setCompany(String newCompany) {
        company = newCompany;
    }
    public String getCompany(){
        String newCompany=company;
        return newCompany;
    }

    public void setLocation(String newLocation) {
        location = newLocation;
    }
    public String getLocation(){
        String newLocation=location;
        return newLocation;
    }

    public void setCategory(String newCategory) {
        category = newCategory;
    }
    public String getCategory(){
        String newCategory=category;
        return newCategory;
    }

    public void setSize(int newSize) {
        size = newSize;
    }
    public String getSize(){
        String newSize=""+size;
        return newSize;
    }

    public void setCost(int newCost) {
        cost = newCost;
    }
    public String getCost(){
        String newCost=""+cost;
        return newCost;
    }



}
