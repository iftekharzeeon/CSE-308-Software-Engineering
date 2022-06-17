package problem_2;

import problem_2.appetizers.FrenchFries;
import problem_2.appetizers.OnionRings;
import problem_2.burgers.BeefBurger;
import problem_2.burgers.MealItem;
import problem_2.burgers.VeggiBurger;
import problem_2.drinks.Coffee;
import problem_2.drinks.Coke;
import problem_2.drinks.Water;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Special Burger Shop");

        MealItem mealItem = null;

        int numberOfWater = 0;
        int numberOfCoke = 0;
        int numberOfCoffee = 0;

        boolean showMenu = true;

        while (showMenu) {
            menu();
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    mealItem = new BeefBurger();
                    mealItem = new FrenchFries(mealItem);
                    showMenu = false;
                    break;
                case "2":
                    System.out.println("Enter the number of Water you want: ");
                    numberOfWater = Integer.parseInt(scanner.nextLine());
                    mealItem = new VeggiBurger();
                    mealItem = new OnionRings(mealItem);
                    mealItem = new Water(mealItem, numberOfWater);
                    showMenu = false;
                    break;
                case "3":
                    System.out.println("Enter the number of Coke you want: ");
                    numberOfCoke = Integer.parseInt(scanner.nextLine());
                    mealItem = new VeggiBurger();
                    mealItem = new OnionRings(mealItem);
                    mealItem = new FrenchFries(mealItem);
                    mealItem = new Coke(mealItem, numberOfCoke);
                    showMenu = false;
                    break;
                case "4":
                    System.out.println("Enter the number of Coffee you want: ");
                    numberOfCoffee = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter the number of Water you want: ");
                    numberOfWater = Integer.parseInt(scanner.nextLine());

                    mealItem = new VeggiBurger();
                    mealItem = new OnionRings(mealItem);
                    mealItem = new Coffee(mealItem, numberOfCoffee);
                    mealItem = new Water(mealItem, numberOfWater);
                    showMenu = false;
                    break;
                case "5":
                    mealItem = new BeefBurger();
                    showMenu = false;
                    break;
                default:
                    System.out.println("Sorry, we are only selling the following meals for now");
            }
        }

        System.out.println("Your meal consists of\n" + mealItem.mealType());
        System.out.println("Total Bill => " + mealItem.mealPrice());

    }

    static void menu(){
        System.out.println("Select a meal from the following options: ");
        System.out.println("1. Beef burger with French fry and cheese");
        System.out.println("2. Veggi burger with onion rings and Bottle of Water");
        System.out.println("3. A combo meal with Veggi burger, French Fry and Coke");
        System.out.println("4. A combo meal with Veggi burger, Onion Rings, Coffee and Water");
        System.out.println("5. A Beef burger only");
    }
}
