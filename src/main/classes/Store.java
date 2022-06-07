package main.classes;

import main.interfaces.IStore;

import java.util.ArrayList;
import java.util.List;

public class Store implements IStore {
    private final StoreOwner storeOwner;
    private final Manager manager = StoreOwner.getManager();
    private final Cashier cashier = Manager.getCashier();

    private static final List<Product> products = new ArrayList<>();

    public Store(StoreOwner storeOwner) {
        this.storeOwner = storeOwner;
    }

    @Override
    public void addProductToList(Product product) {
        products.add(product);
    }

    @Override
    public void showListOfAvailableProducts() {
        for (Product product : products){
            System.out.println("Product name: " + product.getName());
            System.out.println("Quantity available: " + product.getQty());
            System.out.println("Price: " + Double.parseDouble(product.getPrice()));
            System.out.println("Category: " + product.getCategory());
            System.out.println("_________________________________");
        }
    }

    @Override
    public StoreOwner getStoreOwner() {
        return storeOwner;
    }

    public static List<Product> getProducts() {
        return Store.products;
    }

    public static void addProduct(Product product) {
        products.add(product);
    }

}
