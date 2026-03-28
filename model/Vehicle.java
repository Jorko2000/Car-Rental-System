public abstract class Vehicle {
    protected String id;
    protected String make;
    protected String model;
    protected int year;
    protected boolean available;

    public Vehicle(String id, String make, String model, int year, boolean available) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.available = available;
    }

    public abstract String getType();

    // Getters & setters
}
