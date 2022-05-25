package org.example.action;

import org.example.model.Product;
import org.example.store.Store;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ReplaceImpl implements UserAction {

    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Store store) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter id: ");
        int id = scanner.nextInt();
        System.out.print("Enter name product: ");
        String name = scanner.next();
        System.out.print("Enter name product: ");
        double price = scanner.nextDouble();
        if (store.replace(id, new Product(name, price))) {
            System.out.println("Item is successfully replaced!");
        } else {
            System.out.println("Wrong id!");
        }
        return true;
    }
}
