package VehiclesExtension;

import java.text.DecimalFormat;

public class Vehicle {

    protected double fuelQuantity;
    protected double fuelConsumption;
    protected int tankCapacity;

    public Vehicle(double fuelQuantity, double fuelConsumption, int tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.tankCapacity = tankCapacity;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {

        this.fuelQuantity = fuelQuantity;
    }


    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(int tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public String drive(double distance) {

        double fuelNeeded = fuelConsumption * distance;

        if (fuelNeeded > this.fuelQuantity) {
            return String.format("%s needs refueling", this.getClass().getSimpleName());
        }

        this.fuelQuantity = this.fuelQuantity - fuelNeeded;
        DecimalFormat df = new DecimalFormat("##.##");
        return String.format("%s travelled %s km", this.getClass().getSimpleName(), df.format(distance));

    }

    public void refuel(double liters) {
        if (liters <= 0) {
            System.out.println("Fuel must be a positive number");
            return;
        }
        if (liters > this.tankCapacity - liters) {
            System.out.println("Cannot fit fuel in tank");
        } else {
            this.fuelQuantity += liters;
        }
    }


    public String driveFull(Vehicle vehicle, double distance) {
        if (vehicle instanceof Bus) {
            this.fuelConsumption = fuelConsumption + 1.4;
        }
        return vehicle.drive(distance);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }
}
