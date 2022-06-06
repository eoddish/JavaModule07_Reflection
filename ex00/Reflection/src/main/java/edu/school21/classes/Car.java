package edu.school21.classes;

import java.util.StringJoiner;

public class Car {
    private String name;
    private String brand;
    private int price;
    public Car() {
        this.name = "Default first name";
        this.brand = "Default last name";
        this.price = 0;
    }
    public Car(String name, String brand, int price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }
    public int changePrice(int priceChange) {
        this.price += priceChange;
        return price;
    }
    @Override
    public String toString() {
        return new StringJoiner(", ", Car.class . getSimpleName() + "[", "]")
                . add("name='" + name + "'")
                . add("brand='" + brand + "'")
                . add("price=" + price)
                . toString();
    }
}
