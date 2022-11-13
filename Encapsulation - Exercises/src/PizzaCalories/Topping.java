package PizzaCalories;

public class Topping {

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    private void setToppingType(String toppingType) {

        if (toppingType.equals("Meat")){
            this.toppingType = toppingType;
        }else if (toppingType.equals("Veggies")){
            this.toppingType = toppingType;
        }else if (toppingType.equals("Cheese")){
            this.toppingType = toppingType;
        }else if ( toppingType.equals("Sauce")){
            this.toppingType = toppingType;
        }else {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }

    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(this.toppingType + " weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    private double getToppingModifier() {
        if (this.toppingType.equals("Meat")) {
            return 1.2;
        } else if (this.toppingType.equals("Veggies")) {
            return 0.8;
        } else if (this.toppingType.equals("Cheese")) {
            return 1.1;
        } else if (this.toppingType.equals("Sauce")) {
            return 0.9;
        }
        return 0;
    }

    public double calculateCalories() {
        return 2 * weight * getToppingModifier();
    }
}
