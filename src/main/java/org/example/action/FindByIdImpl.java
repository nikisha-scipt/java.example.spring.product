package org.example.action;

import org.example.model.Product;
import org.example.store.Store;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class FindByIdImpl implements UserAction {

    @Override
    public String name() {
        return "=== Find item by Id ====";
    }

    @Override
    public boolean execute(Store store) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter id: ");
        int id = scanner.nextInt();
        Product product = store.findById(id);
        if (product != null) {
            System.out.println(product);
        } else {
            System.out.println("Wrong id!");
        }
        return true;
    }
}
