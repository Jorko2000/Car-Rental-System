public class Car extends Vehicle {
    private String type;

    public Car(String id, String make, String model, int year, String type, boolean available) {
        super(id, make, model, year, available);
        this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return id + " | " + make + " | " + model + " | " + year + " | " + type + " | " + (available ? "Available" : "Rented");
    }
}
