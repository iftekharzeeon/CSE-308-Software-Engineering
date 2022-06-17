package problem_2.appetizers;

import problem_2.MealDecorator;
import problem_2.burgers.MealItem;

public class OnionRings extends MealDecorator {

    private final int price = 130;

    public OnionRings(MealItem newMealItem) {
        super(newMealItem);
    }

    @Override
    public String mealType() {
        return super.mealType() + "1 Onion Rings -> Price: 1x" + price + "\n";
    }

    @Override
    public double mealPrice() {
        return super.mealPrice() + price;
    }
}
