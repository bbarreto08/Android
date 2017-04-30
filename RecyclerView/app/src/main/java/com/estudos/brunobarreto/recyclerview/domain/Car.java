package com.estudos.brunobarreto.recyclerview.domain;

/**
 * Created by bruno.barreto on 28/04/2017.
 */

public class Car {
    public String models;
    public String brands;
    public int photo;

    public Car(String models, String brands, int photo) {
        this.models = models;
        this.brands = brands;
        this.photo = photo;
    }

    public int getPhoto() {
        return photo;
    }


    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public void setModels(String models) {
        this.models = models;
    }

    public void setBrands(String brands) {
        this.brands = brands;
    }

    public String getModels() {

        return models;
    }

    public String getBrands() {
        return brands;
    }
}
