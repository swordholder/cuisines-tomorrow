package swordholder.api;

import swordholder.model.Cuisine;
import swordholder.model.Customer;

import java.util.List;

public interface CuisinesRegistry {

    void register(Customer customer, Cuisine cuisine);

    List<Cuisine> customerCuisines(Customer customer);

    List<Cuisine> topCuisines(int n);

    List<Customer> cuisineCustomers(Cuisine cuisine);
}
