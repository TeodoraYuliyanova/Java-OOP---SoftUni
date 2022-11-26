package Vehicles;

public class Truck extends Vehicle{

    private final static double ADDITIONAL_FUEL_CONSUMPTION = 1.6;
    private final static double FUEL_LEAK_CORRECTION_PERCENTAGE = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
        this.fuelConsumption = fuelConsumption + ADDITIONAL_FUEL_CONSUMPTION;
    }

    @Override
    public void refuel(double liters) {
        liters = liters * FUEL_LEAK_CORRECTION_PERCENTAGE;

        super.refuel(liters);
    }
}
