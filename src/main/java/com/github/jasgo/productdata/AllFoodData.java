package com.github.jasgo.productdata;

public class AllFoodData {
    private String name;
    private int kcal;
    private int protein;
    private int fat;
    private int carbo;
    private int allsugars;
    private int na;
    private int coles;
    private int allsatur;
    private int alltrans;


    public AllFoodData(String name, int kcal, int protein, int fat, int carbo, int allsugars, int na, int coles, int allsatur, int alltrans){
        this.name = name;
        this.kcal = kcal;
        this.protein = protein;
        this.fat = fat;
        this.carbo = carbo;
        this.allsugars = allsugars;
        this.na = na;
        this.coles = coles;
        this.allsatur = allsatur;
        this.alltrans = alltrans;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getCarbo() {
        return carbo;
    }

    public void setCarbo(int carbo) {
        this.carbo = carbo;
    }

    public int getAllsugars() {
        return allsugars;
    }

    public void setAllsugars(int allsugars) {
        this.allsugars = allsugars;
    }

    public int getNa() {
        return na;
    }

    public void setNa(int na) {
        this.na = na;
    }

    public int getColes() {
        return coles;
    }

    public void setColes(int coles) {
        this.coles = coles;
    }

    public int getAllsatur() {
        return allsatur;
    }

    public void setAllsatur(int allsatur) {
        this.allsatur = allsatur;
    }
}
