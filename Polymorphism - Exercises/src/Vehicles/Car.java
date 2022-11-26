package Vehicles;

public class Car extends Vehicle {

    private final static double ADDITIONAL_FUEL_CONSUMPTION = 0.9;


    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
        this.fuelConsumption = fuelConsumption + ADDITIONAL_FUEL_CONSUMPTION;
    }

}
