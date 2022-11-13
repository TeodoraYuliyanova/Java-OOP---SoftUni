package PizzaCalories;

public class Dough {

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if (!checksIfRightFlour(flourType)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!checksIfRightTechnique(bakingTechnique)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    private boolean checksIfRightFlour(String flourType) {
        if (flourType.equals("White") || flourType.equals("Wholegrain")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checksIfRightTechnique(String bakingTechnique) {
        if (bakingTechnique.equals("Crispy") || bakingTechnique.equals("Chewy") || bakingTechnique.equals("Homemade")) {
            return true;
        }
        return false;
    }

    private double getFlourModifier() {
        if (this.flourType.equals("White")) {
            return 1.5;
        } else if (this.flourType.equals("Wholegrain")) {
            return 1.0;
        }
        return 0;
    }

    private double getTechniqueModifier() {
        if (this.bakingTechnique.equals("Crispy")) {
            return 0.9;
        } else if (this.bakingTechnique.equals("Chewy")) {
            return 1.1;
        } else if (this.bakingTechnique.equals("Homemade")) {
            return 1.0;
        }
        return 0;
    }

    public double calculateCalories() {
        return 2 * weight  * getFlourModifier() * getTechniqueModifier();
    }
}
