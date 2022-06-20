package problem_2;

public abstract class MealDecorator implements MealItem {
    private MealItem newMealItem;

    public MealDecorator (MealItem newMealItem) {
        this.newMealItem = newMealItem;
    }

    @Override
    public String mealType() {
        return newMealItem.mealType();
    }

    @Override
    public double mealPrice() {
        return newMealItem.mealPrice();
    }
}
