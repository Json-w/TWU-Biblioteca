package com.twu.biblioteca.option;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.entity.Item;

import java.util.ArrayList;
import java.util.List;

public abstract class CheckOutItemOption<T extends Item> extends Option{

    public CheckOutItemOption(int id, String name, BibliotecaApp bibliotecaApp) {
        super(id, name, bibliotecaApp);
    }

    @Override
    public void execute() {
        String checkoutItemName = console.getNextString();
        List<T> itemsAfterCheckout = new ArrayList<T>();
        List<T> beforeCheckout = getAvailableItems();
        for (T t : beforeCheckout) {
            if (!checkoutItemName.equals(t.getName())) {
                itemsAfterCheckout.add(t);
            } else {
                getCheckedoutItems().add(t);
            }
        }
        setItems(itemsAfterCheckout);
        if (beforeCheckout.size() > itemsAfterCheckout.size()) {
            printSuccessInfo();
        } else {
            printFailureInfo();
        }
    }

    public abstract void printFailureInfo();

    public abstract void printSuccessInfo();

    public abstract void setItems(List<T> itemAfterCheckout);

    public abstract List<T> getCheckedoutItems();


    public abstract List<T> getAvailableItems();
}
