package main.classes;

import main.classes.comparators.CustomerIDComparator;
import main.classes.comparators.CustomerQtyComparator;
import main.exceptions.EmptyCartException;
import main.exceptions.NotFoundException;
import main.exceptions.OutOfQtyException;

import java.util.*;

public class CustomerOrderSort{

    private final String customerName;
    private int qty;
    private String productName;
    private final int ID;

    private final List<List<String>> itemsToBuy;


    public CustomerOrderSort(Customer customer) {
        if (customer.getItemsToBuy().size() != 0) {
            this.productName = customer.getItemsToBuy().get(0).get(0);
            this.qty = Integer.parseInt(customer.getItemsToBuy().get(0).get(1));
        }

        this.customerName = customer.getName();
        this.ID = customer.getID();
        this.itemsToBuy = customer.getItemsToBuy();
    }

    public static boolean placeOrderByQtyOrID(ArrayList<Customer> customerList) throws OutOfQtyException, NotFoundException, EmptyCartException {
        // sort first based on id
        Queue<CustomerOrderSort> customerPriorityQueue = new PriorityQueue<>(new CustomerIDComparator());
        for (Customer customer : customerList) {
            CustomerOrderSort customerSO = new CustomerOrderSort(customer);
            customerPriorityQueue.add(customerSO);
        }

        List<CustomerOrderSort> customerPriorityArray = new ArrayList<>(customerPriorityQueue);

        for (Product product : Store.getProducts()) {
            String productName = product.getName();
            Queue<CustomerOrderSort> sameProductCustomers = new PriorityQueue<>(new CustomerQtyComparator());

            for (CustomerOrderSort customer : customerPriorityArray) { // list of all customers
                if (Objects.equals(customer.getProductName(), productName)) {
                    sameProductCustomers.add(customer);
                }
            }

            while (!sameProductCustomers.isEmpty()) {
                System.out.println(sameProductCustomers.peek());
                Cashier.itemizeAndCalculatePrice(Objects.requireNonNull(sameProductCustomers.poll()));
            }

        }

        return true; // everything went fine
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getProductName() {
        return productName;
    }

    public int getQty() {
        return qty;
    }

    public int getID() {
        return ID;
    }

    public List<List<String>> getItemsToBuy() {
        return itemsToBuy;
    }

    @Override
    public String toString() {
        return "CustomerOrderSort{" +
                "name='" + customerName + '\'' +
                ", qty=" + qty +
                ", productName='" + productName + '\'' +
                ", ID=" + ID +
                '}';
    }

}
