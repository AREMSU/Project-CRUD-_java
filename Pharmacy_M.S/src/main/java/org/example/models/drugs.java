package org.example.models;

public class drugs {
    private String name;
    private String manufacturer;
    private int quantity;
    private double price;

    public drugs(String name, String manufacturer,int quantity, double price) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.quantity =quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public String toString() {
        return "Name: " + name + ", Manufacturer: " + manufacturer + ",Quantity: " + quantity + ", Price: $" + price;
    }
}


