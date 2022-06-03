package problem_1.components;

import problem_1.application.Application;
import problem_1.communicationsystem.CommunicationSystem;
import problem_1.communicationsystem.MobileNetwork;
import problem_1.communicationsystem.WiFi;
import problem_1.controlunit.ControlUnit;
import problem_1.display.Display;
import problem_1.display.LCD;
import problem_1.display.LED;
import problem_1.processor.ATMega32;
import problem_1.processor.ArduinoMega;
import problem_1.processor.Processor;
import problem_1.processor.RaspberryPi;

public abstract class Component {
    public String componentName;
    public double price;

    private Display display;
    private Processor processor;
    private CommunicationSystem communicationSystem;
    private Application application;
    private ControlUnit controlUnit;

    public Component(String componentType, String communicationSystem) {
        if (componentType.equalsIgnoreCase("deluxe")) {
            processor = new RaspberryPi();
            display = new LCD();
        } else if (componentType.equalsIgnoreCase("optimal")) {
            processor = new ArduinoMega();
            display = new LED();
        } else if (componentType.equalsIgnoreCase("poor")) {
            processor = new ATMega32();
            display = new LED();
        }

        if (communicationSystem.equalsIgnoreCase("wifi")) {
            this.communicationSystem = new WiFi();
        } else if (communicationSystem.equalsIgnoreCase("mobile")) {
            this.communicationSystem = new MobileNetwork();
        }
    }
}
