public interface Rentable {
    void rentCar(String carId, Customer customer);
    void returnCar(String carId);
}
