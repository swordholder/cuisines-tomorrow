package swordholder.model;

public class Customer extends AbstractModel {
    private final String uuid;

    public Customer(final String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public String getId(){
        return this.getUuid();
    }

    @Override
    public String toString() {
        return this.getId();
    }
}
