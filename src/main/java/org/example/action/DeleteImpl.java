package org.example.action;

import org.example.store.Store;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class DeleteImpl implements UserAction {

    @Override
    public String name() {
        return "=== Delete product ====";
    }

    @Override
    public boolean execute(Store store) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter id: ");
        int id = scanner.nextInt();
        if (store.delete(id)) {
            System.out.println("Product is successfully deleted!");
        } else {
            System.out.println("Wrong id!");
        }
        return true;
    }

}
