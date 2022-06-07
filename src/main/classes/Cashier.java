package main.classes;

import main.enums.AcademicQualification;
import main.exceptions.EmptyCartException;
import main.exceptions.NotFoundException;
import main.exceptions.OutOfQtyException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Cashier extends Staff {
    private AcademicQualification academicQualification;

    public Cashier(String name, String phoneNumber, String emailAddress, String houseAddress, int age, AcademicQualification academicQualification) {
        super(name, phoneNumber, emailAddress, houseAddress, age);
        this.academicQualification = academicQualification;
    }

    public void getByCategory(String category){
        for (Product product : Store.getProducts()) {
            String name = product.getName();
            String cat = product.getCategory();

            if (Objects.equals(category, cat)) {
                System.out.println(name);

            }
        }
    }


    public static boolean itemizeAndCalculatePrice(CustomerOrderSort customer) throws OutOfQtyException, NotFoundException, EmptyCartException {
        HashMap<String, Double> itemizedList = new HashMap<>();
        double totalPrice = 0.0;

        // confirm that list is not empty.
        if (customer.getItemsToBuy().size() > 0) {
            boolean found = false;
            String name = customer.getProductName();
            int qty = customer.getQty();

                // confirm if all items are available in store at the required quantity
                for (Product product : Store.getProducts()) {

                    if (Objects.equals(name, product.getName())) {
                        found = true;
                        if (qty <= Integer.parseInt(product.getQty())) {
                            System.out.println(name + " added to cart.");

                            // updating the qty available in store
                            product.setQty(Integer.toString(Integer.parseInt(product.getQty()) - qty));

                            double amount = Double.parseDouble(product.getPrice()) * qty;
                            totalPrice += amount;
                            itemizedList.put(name, amount);
                        } else {
                            throw new OutOfQtyException("Out of stock. " + product.getQty() + " " + name.toUpperCase() + " available. " + qty + " demanded.");
                        }
                    }
                }

                if (!found) {
                    throw new NotFoundException(name.toUpperCase() + " not found!");
                }

//            }

            dispenseReceipt(customer.getCustomerName(), itemizedList, totalPrice);
        } else {
            throw new EmptyCartException("Please select items.");
        }

        return true; // means everything went fine
    }


    public static void dispenseReceipt(String name, HashMap<String, Double> cart, double totalPrice) {
        System.out.println("****** Printing Receipt ********");
        System.out.println("Customer name: " + name);

        for (Map.Entry<String, Double> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + " costs " + entry.getValue());
        }
        System.out.println("Total = " + totalPrice);
        System.out.println("============================");
    }
}
