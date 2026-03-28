import java.time.LocalDate;

public class Rental {
    private Car car;
    private Customer customer;
    private LocalDate startDate;
    private LocalDate returnDate;

    public Rental(Car car, Customer customer, LocalDate startDate, LocalDate returnDate) {
        this.car = car;
        this.customer = customer;
        this.startDate = startDate;
        this.returnDate = returnDate;
    }

    // Getters & setters
}
