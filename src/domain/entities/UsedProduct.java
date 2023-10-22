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
}
