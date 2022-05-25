package org.example;

import org.example.action.*;
import org.example.model.Product;
import org.example.store.ProductTrackerImpl;
import org.example.store.Store;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static ClassPathXmlApplicationContext context;

    public static void main(String[] args) {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        List<UserAction> actions = List.of(
                context.getBean("create", CreateImpl.class),
                context.getBean("delete", DeleteImpl.class),
                context.getBean("replace", ReplaceImpl.class),
                context.getBean("findAllProduct", FindAllProduct.class),
                context.getBean("findById", FindByIdImpl.class),
                context.getBean("findByName", FindByNameImpl.class),
                context.getBean("exit", ExitImpl.class)
        );
        Store store = context.getBean("store", ProductTrackerImpl.class);
        store.add(context.getBean("apple", Product.class));
        store.add(context.getBean("orange", Product.class));
        store.add(context.getBean("burger", Product.class));
        store.add(context.getBean("banana", Product.class));
        store.add(context.getBean("shocolate", Product.class));

        init(actions, store);
    }

    private static void init(List<UserAction> actions, Store store) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter select: ");
            int select = scanner.nextInt();
            if (select == 7) {
                Store newStore = context.getBean("store", ProductTrackerImpl.class);
                init(actions, newStore);
                break;
            }
            UserAction action = actions.get(select);
            run = action.execute(store);

        }
    }

    private static void showMenu(List<UserAction> actions) {
        System.out.println("Menu.");
        for (int i = 0; i < actions.size(); i++) {
            System.out.printf("%d. %s%n", i, actions.get(i).name());
        }
        System.out.println("7. === Create a new product list ===");
    }

}
