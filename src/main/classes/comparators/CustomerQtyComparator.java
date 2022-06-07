package main.classes.comparators;

import main.classes.CustomerOrderSort;

import java.util.Comparator;

public class CustomerQtyComparator implements Comparator<CustomerOrderSort> {

    @Override
    public int compare(CustomerOrderSort customer, CustomerOrderSort customer1) {
        // when quantities are same, sort by id
        if (customer.getQty() == customer1.getQty()) {
            CustomerIDComparator sortID = new CustomerIDComparator();

            return sortID.compare(customer, customer1);
        }

        // for different quantities
        if (customer.getQty() > customer1.getQty()) {
            return -1;
        } else if (customer.getQty() < customer1.getQty()) {
            return 1;
        }
        return 0;
    }
}
