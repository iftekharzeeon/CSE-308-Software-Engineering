package problem_2;

public class Cheese extends MealDecorator{
    private final int price = 40;

    public Cheese(MealItem newMealItem) {
        super(newMealItem);
    }

    @Override
    public String mealType() {
        return super.mealType() + " with Cheese\n";
    }

    @Override
    public double mealPrice() {
        return super.mealPrice() + price;
    }
}
