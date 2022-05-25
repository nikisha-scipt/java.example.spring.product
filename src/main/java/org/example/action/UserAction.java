package org.example.action;

import org.example.store.Store;
import org.springframework.stereotype.Component;

@Component
public interface UserAction {

    String name();

    boolean execute(Store store);

}
