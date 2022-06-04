package problem_1.system;

import problem_1.application.Application;
import problem_1.communicationsystem.CommunicationSystem;
import problem_1.components.Component;
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
        System.out.println("You have selected " + this + " system.");
        System.out.println("Total number of display units " + numberOfDisplayUnits);
        double displayUnitPrice = 0;
        double systemCost = 0;
        System.out.println("Your display unit consists of ");
        for (Component component : components) {
            if (component instanceof Processor) {
                System.out.println("Processor: " + component.name());
                displayUnitPrice += component.price();
            }
            if (component instanceof Display) {
                System.out.println("Display: " + component.name());
                displayUnitPrice += component.price();
            }
        }
        systemCost += displayUnitPrice;
        System.out.println("Your communication system consists of ");
        for (Component component : components) {
            if (component instanceof CommunicationSystem) {
                System.out.println(component.name());
                systemCost += component.price();
            }
        }
        System.out.println("Your application program consists of ");
        for (Component component : components) {
            if (component instanceof Application) {
                System.out.println(component.name());
                systemCost += component.price();
            }
        }
        System.out.println("Your control unit consists of ");
        for (Component component : components) {
            if (component instanceof ControlUnit) {
                System.out.println(component.name());
                systemCost += component.price();
            }
        }
        System.out.println("Total cost " + systemCost);

    }
}
