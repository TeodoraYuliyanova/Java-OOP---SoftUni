package CarShopExtended;


public class Seat extends CarImpl implements Sellable {

    private Double price;

    public Seat(String model, String color, Integer horsePower, String countryProduced, Double price) {
        super(model, color, horsePower, countryProduced);
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("This is %s produced in %s and have %d tires" , getModel(), countryProduced(), TIRES));
        sb.append(System.lineSeparator());
        sb.append(String.format("%s sells for %f", getModel(), getPrice()));

        return sb.toString().trim();
    }

}
