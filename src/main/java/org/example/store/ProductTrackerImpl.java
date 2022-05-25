package org.example.store;

import org.example.model.Product;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class ProductTrackerImpl implements Store {

    private final List<Product> products = new ArrayList<>();
    private int id = 0;

    @Override
    public Product add(Product product) {
        product.setId(++id);
        products.add(product);
        return product;
    }

    @Override
    public boolean replace(int id, Product product) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        product.setId(id);
        products.set(index, product);
        return true;
    }

    private int indexOf(int id) {
        int res = -1;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                res = i;
                break;
            }
        }
        return res;
    }

    @Override
    public boolean delete(int id) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        products.remove(index);
        return true;
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> res = new ArrayList<>();
        for (Product elem : products) {
            if (name.equals(elem.getName())) {
                res.add(elem);
            }
        }
        return res;
    }

    @Override
    public Product findById(int id) {
        int index = indexOf(id);
        return index == -1 ? null : products.get(index);
    }

}
