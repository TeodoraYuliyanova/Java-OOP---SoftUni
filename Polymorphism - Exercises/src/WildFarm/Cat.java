package WildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime {

    private String breed;

    public Cat(String animalType, String animalName, Double animalWeight, String livingRegion, String breed) {
        super(animalType, animalName, animalWeight, livingRegion);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
        super.eat(food);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#####.##");
        return String.format("%s[%s, %s, %s, %s, %d]", getAnimalType(), getAnimalName(), getBreed(), df.format(getAnimalWeight()), getLivingRegion(), getFoodEaten());
    }
}
