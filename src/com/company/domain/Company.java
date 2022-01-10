package com.company.domain;

import java.util.List;

public class Company {

    private Long id;
    private String name;
    private int price;
    private int procent;
    private String address;
    private String place;


    public Company(Long id, String name, int price, int procent, String address, String place) {
        this.id = id;
        this.name = name;
        this.price= price;
        this.procent = procent;
        this.address = address;
        this.place = place;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getProcent() {
        return procent;
    }

    public void setProcent(int procent) {
        this.procent = procent;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        place = place;
    }
}
