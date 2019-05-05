package de.quandoo.recruitment.registry;

import de.quandoo.recruitment.registry.api.CuisinesRegistry;
import de.quandoo.recruitment.registry.comparator.RelatedModelComparator;
import de.quandoo.recruitment.registry.model.AbstractModel;
import de.quandoo.recruitment.registry.model.Cuisine;
import de.quandoo.recruitment.registry.model.Customer;
import de.quandoo.recruitment.registry.model.RelatedModel;

import java.util.*;
import java.util.stream.Collectors;

public class InMemoryCuisinesRegistry implements CuisinesRegistry {

    private List<RelatedModel> customerToCuisines;
    private List<RelatedModel> cuisineToCustomers;

    public InMemoryCuisinesRegistry() {
        customerToCuisines = new ArrayList<>();
        cuisineToCustomers = new ArrayList<>();
    }

    @Override
    public void register(Customer customer, Cuisine cuisine) {

        RelatedModel relatedModel = binarySearch(customerToCuisines,customer);
        if (relatedModel ==null) {
            relatedModel = new RelatedModel(customer,cuisine);
            customerToCuisines.add(relatedModel);
        } else {
            relatedModel.addChild(cuisine);
        }

        relatedModel = binarySearch(cuisineToCustomers,cuisine);
        if(relatedModel ==null){
            relatedModel = new RelatedModel(cuisine,customer);
            cuisineToCustomers.add(relatedModel);
        }
        else{
            relatedModel.addChild(customer);
        }
    }

    @Override
    public List<Cuisine> customerCuisines(Customer customer) {

        RelatedModel relatedModel = binarySearch(customerToCuisines,customer);
        if(relatedModel ==null)
            return null;

        return (List<Cuisine>) relatedModel.getChildren();
    }

    @Override
    public List<Customer> cuisineCustomers(Cuisine cuisine) {

        RelatedModel relatedModel = binarySearch(cuisineToCustomers,cuisine);

        if(relatedModel ==null)
            return null;

        return (List<Customer>) relatedModel.getChildren();
    }

    @Override
    public List<Cuisine> topCuisines(int n) {
        if(cuisineToCustomers.size()==0)
            return null;

        Collections.sort(cuisineToCustomers, RelatedModelComparator::compareByChildCount);

        List<RelatedModel> relatedModels = cuisineToCustomers.stream().limit(n).collect(Collectors.toList());

        List<Cuisine> cuisines = new ArrayList<>();
        for(RelatedModel relatedModel : relatedModels){
            cuisines.add((Cuisine) relatedModel.getParent());
        }

        return cuisines;
    }

    private RelatedModel binarySearch(List<RelatedModel> list, AbstractModel abstractModel) {

        if(list.size()==0)
            return null;

        Collections.sort(list, RelatedModelComparator::compareByParentId);

        int start = 0;
        int end = list.size() - 1;

        while (start <= end) {

            int middle = (start + end) / 2;

            if (abstractModel.getId().compareTo(list.get(middle).getParent().getId()) < 0) {
                end = middle - 1;
            }

            if (abstractModel.getId().compareTo(list.get(middle).getParent().getId()) > 0) {
                start = middle + 1;
            }

            if (abstractModel.getId().compareTo(list.get(middle).getParent().getId()) == 0) {
                return list.get(middle);
            }
        }

        return null;
    }
}
