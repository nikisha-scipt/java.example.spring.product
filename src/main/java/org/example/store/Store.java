package org.example.store;

import org.example.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface Store {

    Product add(Product product);

    boolean replace(int id, Product product);

    boolean delete(int id);

    List<Product> findAll();

    List<Product> findByName(String name);

    Product findById(int id);

}
