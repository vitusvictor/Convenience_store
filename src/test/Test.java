package test;

import main.classes.*;
import main.classes.fileReader.ReadProductFile;
import main.enums.AcademicQualification;
import main.exceptions.EmptyCartException;
import main.exceptions.NotFoundException;
import main.exceptions.OutOfQtyException;
import org.junit.jupiter.api.BeforeAll;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Test {
    List<Product> products = Store.getProducts();
    static StoreOwner storeOwner;
    static Manager manager;
    static Cashier cashier;
    static Customer customer1, customer2, customer3, customer4, customer5, customer6, customer7;
    static ArrayList<Customer> customers;


    @BeforeAll
    @org.junit.jupiter.api.Test
    static void beforeAll() throws OutOfQtyException, NotFoundException {
        System.out.println("Initializing test... ");

        // read product file
        ReadProductFile.readFile();

        // create a store owner
        storeOwner = new StoreOwner("Somto", "07038317841", "vitusvictor41@gmailcom", "Onitsha, Anambra state", 50);

        // create a manager
        manager = new Manager("Ebuka", "09043189422", "ebuka@gmail.com", "Mgbuka, Anambra state", 30, AcademicQualification.MASTERS);

        // create cashier
        cashier = new Cashier("Ude", "08028492319", "ada@gmail.com", "Fegge, Onitsha", 28, AcademicQualification.FIRST_DEGREE);

        // hire manager and cashier
        storeOwner.setManager(manager);

        manager.setCashier(cashier);


        customer7 = new Customer("customer7", 7);
        customer7.buyAProduct("Brush", "3");

        customer1 = new Customer("customer1", 1);
        customer1.buyAProduct("Brush", "3");

        customer4 = new Customer("customer4", 4);
        customer4.buyAProduct("Brush", "3");

        customer3 = new Customer("customer3", 3);
        customer3.buyAProduct("Shoes", "2");

        customer2 = new Customer("customer2", 2);
        customer2.buyAProduct("Shoes", "1");

        customer5 = new Customer("customer5", 5);
        customer5.buyAProduct("Shoes", "10");

        customer6 = new Customer("customer6", 6);
        customer6.buyAProduct("Pen", "10");


        customers = new ArrayList<>();
        customers.add(customer1); customers.add(customer2); customers.add(customer4); customers.add(customer3);
        customers.add(customer5); customers.add(customer6); customers.add(customer7);

    }


    // determine size of products in store
    @org.junit.jupiter.api.Test
    void getProducts() {
        assertEquals(10, products.size());
    }

    // determine size of products in store
    @org.junit.jupiter.api.Test
    void placeOrderForCustomers() throws OutOfQtyException, NotFoundException, EmptyCartException {
        assertTrue(CustomerOrderSort.placeOrderByQtyOrID(customers));
    }

    @org.junit.jupiter.api.Test
    void placeOrderThrowsException() throws OutOfQtyException, NotFoundException {
        Customer customer8 = new Customer("customer6", 8);
        customer8.buyAProduct("Calculator", "100");
        CustomerOrderSort cOS = new CustomerOrderSort(customer8);

        //should throw exception since 106 is hire than quantity in store (105)
        assertThrows(OutOfQtyException.class, () -> Cashier.itemizeAndCalculatePrice(cOS));
    }

    @org.junit.jupiter.api.Test
    void emptyCartException() {
        Customer customer9 = new Customer("customer6", 8);
        CustomerOrderSort cOS = new CustomerOrderSort(customer9);

        //should throw exception since 106 is hire than quantity in store (105)
        assertThrows(EmptyCartException.class, () -> Cashier.itemizeAndCalculatePrice(cOS));
    }

    // storeOwner hire manager
    @org.junit.jupiter.api.Test
    void storeOwnerHire() {
        boolean value = storeOwner.determineInterviewStatus(34, 5, AcademicQualification.FIRST_DEGREE, "09089239841", "emeka@gmail.com");
        assertTrue(value);
    }

    // manager hire cashier
    @org.junit.jupiter.api.Test
    void managerHire() {
        boolean value = manager.determineInterviewStatus(25, 2, AcademicQualification.SSCE, "08028741294", "adaobi@gmail.com");
        assertFalse(value); // should fail since years of experience is not up to 3
    }

    // compare manager
    @org.junit.jupiter.api.Test
    void getManager() {
        assertEquals(manager, StoreOwner.getManager());
    }

    // compare cashiers
    @org.junit.jupiter.api.Test
    void getCashier() {
        assertEquals(cashier, Manager.getCashier());
    }
}