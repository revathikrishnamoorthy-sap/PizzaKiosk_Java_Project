package de.rkrish.rkpizzakiosk.model;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private int id;
    private String name;
    private double basePrice;
    private int qty;


    // Constructor
    public Pizza(int id, String name, int qty, double basePrice) {
        this.id = id;
        this.name = name;
        this.basePrice = basePrice;
        this.qty = qty;
    }


    //Getters
    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return basePrice;
    }

    public int getQty() {
        return qty;
    }

    @Override
    public String toString() {
        return  "\n" + id +"."
                + name + " - "
                +"\nPrice = "+ basePrice
                +"\nQty = "+ qty;
    }


}

