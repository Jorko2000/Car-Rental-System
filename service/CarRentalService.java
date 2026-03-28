import java.util.*;

public class CarRentalService implements Rentable, Searchable {
    private List<Car> cars = new ArrayList<>();
    private Map<String, Rental> rentals = new HashMap<>();

    // Add Car
    public void addCar(Car car) {
        cars.add(car);
    }

    // Edit Car
    public void editCar(String id, String newModel) {
        Car car = searchById(id);
        if (car != null) {
            car.setModel(newModel);
        }
    }

    // Remove Car
    public void removeCar(String id) {
        cars.removeIf(car -> car.getId().equals(id));
    }

    // List Cars
    public void listCars() {
        cars.forEach(System.out::println);
    }

    // Rent
    @Override
    public void rentCar(String carId, Customer customer) {
        Car car = searchById(carId);
        if (car != null && car.isAvailable()) {
            car.setAvailable(false);
            Rental rental = new Rental(car, customer, java.time.LocalDate.now(), null);
            rentals.put(carId, rental);
        } else {
            System.out.println("Car not available!");
        }
    }

    // Return
    @Override
    public void returnCar(String carId) {
        Rental rental = rentals.get(carId);
        if (rental != null) {
            rental.getCar().setAvailable(true);
            rentals.remove(carId);
        }
    }

    // Search
    @Override
    public List<Car> searchByModel(String model) {
        List<Car> result = new ArrayList<>();
        for (Car c : cars) {
            if (c.getModel().equalsIgnoreCase(model)) {
                result.add(c);
            }
        }
        return result;
    }

    @Override
    public Car searchById(String id) {
        for (Car c : cars) {
            if (c.getId().equals(id)) return c;
        }
        return null;
    }

    @Override
    public List<Car> searchByAvailability(boolean available) {
        List<Car> result = new ArrayList<>();
        for (Car c : cars) {
            if (c.isAvailable() == available) result.add(c);
        }
        return result;
    }

    public List<Car> getCars() {
        return cars;
    }
}
