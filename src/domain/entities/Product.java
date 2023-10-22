package domain.entities;

public class Product {
    private final String name;
    private double price;

    protected Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public static Product createProductInstance(String name, double price) {
        return new Product(name, price);
    }

    protected String getName() { return this.name; }

    protected double getPrice() { return this.price; }

    protected void setPrice(double price) { this.price = price; }
}
