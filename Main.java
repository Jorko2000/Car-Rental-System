import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarRentalService service = new CarRentalService();

        service.getCars().addAll(FileHandler.readCars("data/cars.csv"));

        while (true) {
            System.out.println("\n1. Add Car");
            System.out.println("2. List Cars");
            System.out.println("3. Rent Car");
            System.out.println("4. Return Car");
            System.out.println("5. Search");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("ID: ");
                        String id = scanner.nextLine();

                        System.out.print("Make: ");
                        String make = scanner.nextLine();

                        System.out.print("Model: ");
                        String model = scanner.nextLine();

                        System.out.print("Year: ");
                        int year = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Type: ");
                        String type = scanner.nextLine();

                        service.addCar(new Car(id, make, model, year, type, true));
                        break;

                    case 2:
                        service.listCars();
                        break;

                    case 3:
                        System.out.print("Car ID: ");
                        String carId = scanner.nextLine();

                        System.out.print("Customer Name: ");
                        String name = scanner.nextLine();

                        service.rentCar(carId, new Customer("C1", name));
                        break;

                    case 4:
                        System.out.print("Car ID: ");
                        service.returnCar(scanner.nextLine());
                        break;

                    case 5:
                        System.out.print("Model: ");
                        service.searchByModel(scanner.nextLine())
                               .forEach(System.out::println);
                        break;

                    case 6:
                        FileHandler.writeCars("data/cars.csv", service.getCars());
                        System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("Invalid input!");
            }
        }
    }
}
