package infra.repositories;

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

    public void insert(Product product) throws ArrayListFullException {
        if (this.list.size() >= this.getMax()) throw new ArrayListFullException("Cannot insert: array is full");
        this.list.add(product);
    }

    public void remove(Product product) throws ArrayListEmptyException {
        if (this.list.size() == 0) throw new ArrayListEmptyException("Cannot remove: array is empty");
        this.list.remove(product);
    }
}
