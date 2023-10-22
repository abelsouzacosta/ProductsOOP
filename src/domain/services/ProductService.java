package domain.services;

import domain.entities.ImportedProduct;
import domain.entities.Product;
import domain.entities.UsedProduct;
import domain.exceptions.ArrayListFullException;
import infra.repositories.ProductRepository;

import java.util.Date;
import java.util.List;

public class ProductService {
    private final ProductRepository repository;

    private ProductService(int max) {
        this.repository = ProductRepository.getInstance(max);
    }

    public static ProductService getInstance(int max) {
        return new ProductService(max);
    }

    public void create(String name, double price, double customsFee) throws ArrayListFullException {
        ImportedProduct product = ImportedProduct.createImportedProduct(name, price, customsFee);
        this.repository.insert(product);
    }

    public void create(String name, double price, Date manufactureDate) throws ArrayListFullException {
        UsedProduct product = UsedProduct.createUsedProduct(name, price, manufactureDate);
        this.repository.insert(product);
    }

    public void list() {
        List<Product> products = this.repository.list();

        for (Product product : products) {
            if (product != null) {
                System.out.println(product.toString());
            }
        }
    }

}
