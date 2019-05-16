package com.example.myapplication;

public class Burger {


    private String name;
    private String company;
    private String location;
    private String category;
    private int size;
    private int cost;
    private int cals;
    private int fats;
    private int carbs;
    private int prots;
    private float fibs;
    private float salts;


    public Burger(String inName, String inCompany, String inLocation, String inCategory, int inSize, int inCost, int inCals, int inFats, int inCarbs, int inProts, float inFibs, float inSalts) {
        name = inName;
        company = inCompany;
        location = inLocation;
        category = inCategory;
        size = inSize;
        cost = inCost;
        cals = inCals;
        fats = inFats;
        carbs = inCarbs;
        prots = inProts;
        fibs = inFibs;
        salts = inSalts;
    }



    public Burger(String burgerName, String burgerCompany, String burgerLocation, String inName, int size, int cost, int cals, int burgerSize, int burgerCost, int burgerCals, float burgerFibs, int burgerFats) {
        name = inName;
        company = "";
        location = "";
        category = "";
        this.size = -1;
        this.cost = -1;
        this.cals = -1;
        fats = -1;
        carbs = -1;
        prots = -1;
        fibs = -1;
        salts = -1;

    }

    @Override
    public String toString() {
        return name;
    }

    public String info() {
        String str = name;
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

    public void setCarbs(int newCarbs) {
        carbs = newCarbs;
    }
    public int getCarbs(){
        return carbs;
    }

    public void setCals(int newCals) {
        cals = newCals;
    }
    public int getCals(){
        return cals;
    }

    public void setFats(int newfats) {
        fats = newfats;
    }
    public int getFats(){
        return fats;
    }

    public void setProts(int newProts) {
        prots = newProts;
    }
    public int getProts(){
        return prots;
    }

    public void setFibs(float newFibs) {
        fibs = newFibs;
    }
    public float getFibs(){
        return fibs;
    }

    public void setSalts(int newSalts) {
        salts = newSalts;
    }
    public float getSalts(){
        return salts;
    }





}
