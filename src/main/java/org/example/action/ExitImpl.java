package org.example.action;

import org.example.store.Store;
import org.springframework.stereotype.Component;

@Component
public class ExitImpl implements UserAction {
    @Override
    public String name() {
        return "=== Exit ====";
    }

    @Override
    public boolean execute(Store store) {
        return false;
    }
}
