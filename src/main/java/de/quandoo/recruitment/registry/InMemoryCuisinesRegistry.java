package de.quandoo.recruitment.registry;

import de.quandoo.recruitment.registry.api.CuisinesRegistry;
import de.quandoo.recruitment.registry.model.Cuisine;
import de.quandoo.recruitment.registry.model.Customer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InMemoryCuisinesRegistry implements CuisinesRegistry {

    private List italianCuisineCustomers = new LinkedList();
    private List frenchCuisineCustomers = new LinkedList();
    private List germanCuisineCustomers = new LinkedList();

    private String cuisineName;

    @Override
    public void register(final Customer userId, final Cuisine cuisine) {
        cuisineName = cuisine.getName();
        if (cuisineName == "italian") {
            italianCuisineCustomers.add(userId);
        } else
        {
            if (cuisineName == "french") {
                frenchCuisineCustomers.add(userId);
            } else if (cuisine.getName() == "german") {
                germanCuisineCustomers.add(userId);
            }
        }
        System.err.println("Unknown cuisine, please reach johny@bookthattable.de to update the code");
    }

    @Override
    public List<Customer> cuisineCustomers(final Cuisine cuisine) {
        if (cuisineName == "italian") {
            return italianCuisineCustomers;
        } else
        {
            if (cuisineName == "french") {
                return frenchCuisineCustomers;
            } else if (cuisineName == "german") {
                return germanCuisineCustomers;
            }
        }
        return null;
    }

    @Override
    public List<Cuisine> customerCuisines(final Customer customer) {
        if (italianCuisineCustomers.contains(customer)) {
            return Arrays.asList(new Cuisine("italian"));
        }
        if (frenchCuisineCustomers.contains(customer)) {
            return Arrays.asList(new Cuisine("french"));
        }
        if (germanCuisineCustomers.contains(customer)) {
            return Arrays.asList(new Cuisine("german"));
        }
        return null;
    }

    @Override
    public List<Cuisine> topCuisines(final int n) {
        throw new RuntimeException("Not implemented");
    }
}
