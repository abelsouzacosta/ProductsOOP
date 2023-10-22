package infra.repositories;

import domain.entities.ImportedProduct;
import domain.entities.Product;
import domain.exceptions.ArrayListEmptyException;
import domain.exceptions.ArrayListFullException;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private List<Product> list;
    private final int max;

    private ProductRepository(int MAX) {
        this.list = new ArrayList<>(MAX);
        this.max = MAX;
    }

    public static ProductRepository getInstance(int max) {
        return new ProductRepository(max);
    }

    private int getMax() { return this.max; }

    public List<Product> list() {
        return this.list;
    }

    public void insert(Product product) throws ArrayListFullException {
        if (this.list.size() >= this.getMax()) throw new ArrayListFullException("Cannot insert: array is full");
        this.list.add(product);
    }
}
