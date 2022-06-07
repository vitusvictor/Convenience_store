package main.interfaces;

import main.classes.Product;
import main.classes.StoreOwner;

public interface IStore {
    void addProductToList(Product product);

    void showListOfAvailableProducts();

    StoreOwner getStoreOwner();

}
