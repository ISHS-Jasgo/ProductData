package com.github.jasgo.productdata;

public class Nutrient {
    private int carbohydrate;
    private int protein;
    private int fat;
    private int sodium;
    private int sugar;
    private int cholesterol;
    private int saturatedfat;
    private int transfat;

    public Nutrient(int carbohydrate, int protein, int fat, int sodium, int sugar, int cholesterol, int saturatedfat, int transfat) {
        this.carbohydrate = carbohydrate;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
        this.sugar = sugar;
        this.cholesterol = cholesterol;
        this.saturatedfat = saturatedfat;
        this.transfat = transfat;
    }

    public int getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
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

    public int getSodium() {
        return sodium;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public int getCholesterol() {
        return cholesterol;
    }

    public void setCholesterol(int cholesterol) {
        this.cholesterol = cholesterol;
    }

    public int getSaturatedfat() {
        return saturatedfat;
    }

    public void setSaturatedfat(int saturatedfat) {
        this.saturatedfat = saturatedfat;
    }

    public int getTransfat() {
        return transfat;
    }

    public void setTransfat(int transfat) {
        this.transfat = transfat;
    }
}
