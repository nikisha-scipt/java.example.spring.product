package org.example.action;

import org.example.model.Product;
import org.example.store.Store;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CreateImpl implements UserAction {


    @Override
    public String name() {
        return "=== Create a new Product ====";
    }

    @Override
    public boolean execute(Store store) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name product: ");
        String name =  scanner.nextLine();
        System.out.print("Enter price product: ");
        double price =  scanner.nextDouble();
        Product product = new Product(name, price);
        store.add(product);
        System.out.println("Product successfully added!");
        return true;
    }
}
