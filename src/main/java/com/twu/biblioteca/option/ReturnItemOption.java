package com.twu.biblioteca.option;

import com.twu.biblioteca.BibliotecaApp;
import com.twu.biblioteca.entity.Item;

import java.util.List;

public abstract class ReturnItemOption<T extends Item> extends Option{
    public ReturnItemOption(int id, String name, BibliotecaApp bibliotecaApp) {
        super(id, name, bibliotecaApp);
    }

    @Override
    public void execute() {
        String readyReturnItemName = console.getNextString();
        if (validateItemAndDeleteItOnCheckedOutItems(readyReturnItemName)) {
            printSuccessInfo();
        } else {
            printFailureInfo();
        }
    }

    public abstract void printSuccessInfo();

    public abstract void printFailureInfo();

    private boolean validateItemAndDeleteItOnCheckedOutItems(String readyReturnBookName) {
        List<T> checkedOutItems = getCheckedOutItems();
        for (T t: checkedOutItems) {
            if (t.getName().equals(readyReturnBookName)) {
                checkedOutItems.remove(t);
                getAvailableItem().add(t);
                setCheckedOutItems(checkedOutItems);
                return true;
            }
        }
        return false;
    }

    public abstract void setCheckedOutItems(List<T> checkedOutItems);

    public abstract List<T> getAvailableItem();

    public abstract List<T> getCheckedOutItems();
}
