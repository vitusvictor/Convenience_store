package main;

import main.classes.*;
import main.classes.fileReader.ReadProductFile;
import main.enums.AcademicQualification;
import main.exceptions.EmptyCartException;
import main.exceptions.NotFoundException;
import main.exceptions.OutOfQtyException;

import java.util.*;


public class Main {
    public static void main(String[] args) throws OutOfQtyException, NotFoundException, EmptyCartException {
        // read product file
        ReadProductFile.readFile();

        // create a store owner
        StoreOwner storeOwner = new StoreOwner("Somto", "07038317841", "vitusvictor41@gmailcom", "Onitsha, Anambra state", 50);

        // create a manager
        Manager manager = new Manager("Ebuka", "09043189422", "ebuka@gmail.com", "Mgbuka, Anambra state", 30, AcademicQualification.MASTERS);

        // create cashier
        Cashier cashier = new Cashier("Ude", "08028492319", "ada@gmail.com", "Fegge, Onitsha", 28, AcademicQualification.FIRST_DEGREE);

        // hire manager and cashier
        storeOwner.setManager(manager);

        manager.setCashier(cashier);


        Customer customer7 = new Customer("customer7", 7);
        customer7.buyAProduct("Brush", "3");

        Customer customer1 = new Customer("customer1", 1);
        customer1.buyAProduct("Brush", "3");

        Customer customer4 = new Customer("customer4", 4);
        customer4.buyAProduct("Brush", "3");

        Customer customer3 = new Customer("customer3", 3);
        customer3.buyAProduct("Shoes", "2");

        Customer customer2 = new Customer("customer2", 2);
        customer2.buyAProduct("Shoes", "1");

        Customer customer5 = new Customer("customer5", 5);
        customer5.buyAProduct("Shoes", "10");

        Customer customer6 = new Customer("customer6", 6);
        customer6.buyAProduct("Pen", "10");


        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(customer1); customers.add(customer2); customers.add(customer4); customers.add(customer3);
        customers.add(customer5); customers.add(customer6); customers.add(customer7);


        CustomerOrderSort.placeOrderByQtyOrID(customers);

    }

}
