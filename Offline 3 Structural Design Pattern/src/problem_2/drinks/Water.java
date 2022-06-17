package problem_2.drinks;

import problem_2.MealDecorator;
import problem_2.burgers.MealItem;

public class Water extends MealDecorator {
    private int numberOfWater;
    private final int price = 15;

    public Water(MealItem newMealItem, int numberOfWater) {
        super(newMealItem);
        this.numberOfWater = numberOfWater;
    }

    @Override
    public String mealType() {
        return super.mealType() + numberOfWater + " Water -> Price: " + numberOfWater + "x" + price + "\n";
    }

    @Override
    public double mealPrice() {
        return super.mealPrice() + numberOfWater*price;
    }
}
