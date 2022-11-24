package VehiclesExtension;

public class Bus extends Vehicle{

    private final static double ADDITIONAL_FUEL_CONSUMPTION = 1.4;

    public Bus(double fuelQuantity, double fuelConsumption, int tankCapacity) {
        super(fuelQuantity, fuelConsumption,tankCapacity);
    }


}
