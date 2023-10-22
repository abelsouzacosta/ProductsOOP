package domain.entities;

import java.util.Date;

public final class UsedProduct extends Product {
    private Date manufactureDate;

    private UsedProduct(String name, double price, Date manufactureDate) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    public static UsedProduct createUsedProduct(String name, double price, Date manufactureDate) {
        return new UsedProduct(name, price, manufactureDate);
    }

    private Date getManufactureDate() { return this.manufactureDate; }

    @Override
    public String toString() {
        return "Name: " + this.getName() + ", price: " + this.getPrice() + ", manufacture date: " + this.getManufactureDate();
    }
}
