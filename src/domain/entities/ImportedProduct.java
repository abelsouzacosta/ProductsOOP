package domain.entities;

public final class ImportedProduct extends Product {
    private final double customsFee;

    private ImportedProduct(String name, double price, double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    public static ImportedProduct createImportedProduct(String name, double price, double customsFee) {
        return new ImportedProduct(name, price, customsFee);
    }
}
