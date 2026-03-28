import java.util.List;

public interface Searchable {
    List<Car> searchByModel(String model);
    Car searchById(String id);
    List<Car> searchByAvailability(boolean available);
}
