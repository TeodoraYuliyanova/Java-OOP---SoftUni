package VehiclesExtension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] carInfo = scanner.nextLine().split("\\s+");
        Vehicle car = createVehicle(carInfo);

        String[] truckInfo = scanner.nextLine().split("\\s+");
        Vehicle truck = createVehicle(truckInfo);

        String[] busInfo = scanner.nextLine().split("\\s+");
        Vehicle bus = createVehicle(busInfo);

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();
        vehicles.put("Car", car);
        vehicles.put("Truck", truck);
        vehicles.put("Bus", bus);


        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfCommands; i++) {
            String[] commandsToDo = scanner.nextLine().split("\\s+");

            String command = commandsToDo[0];
            String vehicleType = commandsToDo[1];

            switch (command) {

                case "Drive":
                    double distance = Double.parseDouble(commandsToDo[2]);

                    String driveMessage;
                    if (vehicleType.equals("Bus")) {
                        driveMessage = vehicles.get(vehicleType).driveFull(bus, distance);
                    } else {
                        driveMessage = vehicles.get(vehicleType).drive(distance);
                    }
                    System.out.println(driveMessage);

                    break;

                case "Refuel":
                    double litersPerKm = Double.parseDouble(commandsToDo[2]);
                    vehicles.get(vehicleType).refuel(litersPerKm);

                    break;

                case "DriveEmpty":
                    distance = Double.parseDouble(commandsToDo[2]);
                    driveMessage = vehicles.get(vehicleType).drive(distance);
                    System.out.println(driveMessage);

                    break;
            }
        }

        vehicles.values().forEach(System.out::println);

    }

    private static Vehicle createVehicle(String[] tokens) {

        double fuelQuantity = Double.parseDouble(tokens[1]);
        double litersPerKm = Double.parseDouble(tokens[2]);
        int tankCapacity = Integer.parseInt(tokens[3]);
        Vehicle vehicle = null;

        switch (tokens[0]) {

            case "Car":
                vehicle = new Car(fuelQuantity, litersPerKm, tankCapacity);
                break;

            case "Truck":
                vehicle = new Truck(fuelQuantity, litersPerKm, tankCapacity);
                break;

            case "Bus":
                vehicle = new Bus(fuelQuantity, litersPerKm, tankCapacity);

        }

        return vehicle;
    }

}
