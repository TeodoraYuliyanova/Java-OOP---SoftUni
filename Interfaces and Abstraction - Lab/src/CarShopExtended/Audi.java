package CarShopExtended;

public class Audi extends CarImpl implements Rentable {

    private Integer minRentDay;
    private Double pricePerDay;

    public Audi(String model, String color, Integer horsePower, String countryProduced, Integer minRentDay, Double pricePerDay) {
        super(model, color, horsePower, countryProduced);
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public Integer getMinRentDay() {
        return this.minRentDay;
    }

    @Override
    public Double getPricePerDay() {
        return this.pricePerDay;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("This is %s produced in %s and have %d tires" , getModel(), countryProduced(), TIRES));
        sb.append(System.lineSeparator());
       sb.append(String.format("Minimum rental period of %d days. Price per day %f", getMinRentDay(), getPricePerDay()));

       return sb.toString().trim();
    }
}
