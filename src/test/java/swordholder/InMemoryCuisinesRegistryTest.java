package swordholder;

import swordholder.constants.Cuisines;
import swordholder.model.Cuisine;
import swordholder.model.Customer;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class InMemoryCuisinesRegistryTest {

    private InMemoryCuisinesRegistry cuisinesRegistry = new InMemoryCuisinesRegistry();

    @Test
    public void shouldWork1() {
        cuisinesRegistry.register(new Customer("1"), new Cuisine(Cuisines.FRENCH));
        cuisinesRegistry.register(new Customer("2"), new Cuisine(Cuisines.GERMAN));
        cuisinesRegistry.register(new Customer("3"), new Cuisine(Cuisines.ITALIAN));

        cuisinesRegistry.cuisineCustomers(new Cuisine(Cuisines.FRENCH));
    }

    @Test
    public void multiTest(){

        Cuisine frenchCuisine = new Cuisine(Cuisines.FRENCH);
        Cuisine italianCuisine = new Cuisine(Cuisines.ITALIAN);
        Cuisine germanCuisine = new Cuisine(Cuisines.GERMAN);

        Customer albert = new Customer("Albert");
        Customer robert = new Customer("Robert");
        Customer peter = new Customer("Peter");
        Customer whitney = new Customer("Whitney");

        cuisinesRegistry.register(albert,frenchCuisine);
        cuisinesRegistry.register(albert,germanCuisine);
        cuisinesRegistry.register(albert,italianCuisine);

        cuisinesRegistry.register(whitney,germanCuisine);

        cuisinesRegistry.register(robert,frenchCuisine);
        cuisinesRegistry.register(robert,germanCuisine);

        cuisinesRegistry.register(peter,frenchCuisine);
        cuisinesRegistry.register(peter,germanCuisine);
        cuisinesRegistry.register(peter,italianCuisine);

        List<Customer> customerList = cuisinesRegistry.cuisineCustomers(frenchCuisine);
        Assert.assertEquals(customerList.size(),3);

        customerList = cuisinesRegistry.cuisineCustomers(italianCuisine);
        Assert.assertEquals(customerList.size(),2);

        customerList = cuisinesRegistry.cuisineCustomers(germanCuisine);
        Assert.assertEquals(customerList.size(),4);

        List<Cuisine> topCuisines = cuisinesRegistry.topCuisines(2);
        Assert.assertEquals(topCuisines.size(),2);
        Assert.assertEquals(topCuisines.get(0).getId(),Cuisines.GERMAN);
        Assert.assertEquals(topCuisines.get(1).getId(),Cuisines.FRENCH);

        List<Cuisine> cuisines = cuisinesRegistry.customerCuisines(albert);
        Assert.assertEquals(cuisines.size(),3);

        cuisines = cuisinesRegistry.customerCuisines(robert);
        Assert.assertEquals(cuisines.size(),2);

        cuisines = cuisinesRegistry.customerCuisines(peter);
        Assert.assertEquals(cuisines.size(),3);

        cuisines = cuisinesRegistry.customerCuisines(whitney);
        Assert.assertEquals(cuisines.size(),1);
    }

    @Test
    public void shouldWork2() {
        cuisinesRegistry.cuisineCustomers(null);
    }

    @Test
    public void shouldWork3() {
        cuisinesRegistry.customerCuisines(null);
    }

    @Test()
    public void thisDoesntWorkYet() {
       cuisinesRegistry.topCuisines(1);
    }


}