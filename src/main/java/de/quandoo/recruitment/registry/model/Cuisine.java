package de.quandoo.recruitment.registry.model;

public class Cuisine extends AbstractModel {

    private final String name;

    public Cuisine(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getId(){
        return this.getName();
    }

    @Override
    public String toString() {
        return this.getId();
    }
}
