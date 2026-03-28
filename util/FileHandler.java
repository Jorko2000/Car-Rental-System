import java.io.*;
import java.util.*;

public class FileHandler {

    public static List<Car> readCars(String fileName) {
        List<Car> cars = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                Car car = new Car(
                        data[0],
                        data[1],
                        data[2],
                        Integer.parseInt(data[3]),
                        data[4],
                        Boolean.parseBoolean(data[5])
                );

                cars.add(car);
            }

        } catch (IOException e) {
            System.out.println("Error reading file!");
        }
        return cars;
    }

    public static void writeCars(String fileName, List<Car> cars) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Car c : cars) {
                bw.write(c.getId() + "," + c.getMake() + "," + c.getModel() + "," +
                        c.getYear() + "," + c.getType() + "," + c.isAvailable());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing file!");
        }
    }
}
