package org.example.action;

import org.example.model.Product;
import org.example.store.Store;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class FindByNameImpl implements UserAction {

    @Override
    public String name() {
        return "=== Find items by name ====";
    }

    @Override
    public boolean execute(Store store) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        List<Product> products = store.findByName(name);
        for (Product elem : products) {
            System.out.println(elem);
        }
        return true;
    }
}
