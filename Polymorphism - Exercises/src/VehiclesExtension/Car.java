package VehiclesExtension;

public class Car extends Vehicle {

    private final static double ADDITIONAL_FUEL_CONSUMPTION = 0.9;


    public Car(double fuelQuantity, double fuelConsumption, int tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        this.fuelConsumption = fuelConsumption + ADDITIONAL_FUEL_CONSUMPTION;
    }

}
