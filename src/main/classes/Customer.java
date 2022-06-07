package main.classes;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String name;

    private List<List<String>> itemsToBuy = new ArrayList<>();

    private int qty;
    private final int ID;

    public Customer(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }

    public int getQty() {
        return qty;
    }

    public int getID() {
        return this.ID;
    }

    public void buyAProduct(String productName, String quantity) {
        List<String> product = new ArrayList<>();
        product.add(productName);
        product.add(quantity);

        this.itemsToBuy.add(product);
    }

    public String getName() {
        return name;
    }

    public List<List<String>> getItemsToBuy() {
        return itemsToBuy;
    }

    public void setItemsToBuy(List<List<String>> list) {
        itemsToBuy = list;
    }

}
