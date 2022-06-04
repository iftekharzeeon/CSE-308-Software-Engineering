package problem_1.system;

import problem_1.application.Application;
import problem_1.communicationsystem.CommunicationSystem;
import problem_1.Component;
import problem_1.controlunit.ControlUnit;
import problem_1.display.Display;
import problem_1.processor.Processor;

import java.util.ArrayList;
import java.util.List;

public abstract class QueueManagementSystem {
    private List<Component> components = new ArrayList<>();
    private int numberOfDisplayUnits = 0;

    public void addComponent(Component component) {
        components.add(component);
    }

    public double getPrice() {
        double price = 0;
        for (Component component : components) {
            price += component.price();
        }
        return price;
    }

    public void setNumberOfDisplayUnits(int numberOfDisplayUnits) {
        this.numberOfDisplayUnits = numberOfDisplayUnits;
    }

    public void details() {
        System.out.println("\nYou have selected " + this + " system for you Queue Management System.");
        System.out.println("Total number of display units " + numberOfDisplayUnits);
        double displayUnitPrice = 0;
        double systemCost = 0;
        System.out.println("\nYour single display unit consists of-> ");
        for (Component component : components) {
            if (component instanceof Processor) {
                System.out.println("Processor: " + component.name() + "; Price: " + component.price());
                displayUnitPrice += component.price();
            }
            if (component instanceof Display) {
                System.out.println("Display: " + component.name() + "; Price: " + component.price());
                displayUnitPrice += component.price();
            }
        }
        double totalDisplayUnitPrice = displayUnitPrice * numberOfDisplayUnits;
        System.out.println("\nPer display unit cost: " + displayUnitPrice + "; Total display unit cost: " + totalDisplayUnitPrice);
        systemCost += totalDisplayUnitPrice;
        System.out.println("\nYour communication system consists of-> ");
        double yearlyCost = 0;
        for (Component component : components) {
            if (component instanceof CommunicationSystem) {
                yearlyCost += component.price() * 12;
                System.out.println(component.name() + "; Price: " + component.price() + "; Yearly communication cost: " + component.price() + "x12 = " + yearlyCost);
                systemCost += component.price();
            }
        }
        System.out.println("\nYour application program consists of-> ");
        for (Component component : components) {
            if (component instanceof Application) {
                System.out.println(component.name() + "; Price: " + component.price());
                systemCost += component.price();
            }
        }
        System.out.println("\nYour control unit consists of-> ");
        for (Component component : components) {
            if (component instanceof ControlUnit) {
                System.out.println(component.name() + " for controlling " + numberOfDisplayUnits + " Display Units; Price: " + component.price());
                systemCost += component.price();
            }
        }
        System.out.println("\nTotal cost of the system: " + systemCost);

    }
}
