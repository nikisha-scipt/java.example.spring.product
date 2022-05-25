package org.example.action;

import org.example.model.Product;
import org.example.store.Store;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindAllProduct implements UserAction {

    @Override
    public String name() {
        return "=== Find all products ====";
    }

    @Override
    public boolean execute(Store store) {
        List<Product> products = store.findAll();
        for (Product elem : products) {
            System.out.println(elem);
        }
        return true;
    }
}
