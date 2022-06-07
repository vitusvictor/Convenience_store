package main.classes.comparators;

import main.classes.CustomerOrderSort;

import java.util.Comparator;

public class CustomerIDComparator implements Comparator<CustomerOrderSort> {
    @Override
    public int compare(CustomerOrderSort customer, CustomerOrderSort customer1) {
        if (customer.getID() > customer1.getID()) {
            return 1;
        } else if (customer.getID() < customer1.getID()) {
            return -1;
        }
        return 0; // for ascending id
    }
}
