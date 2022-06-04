package problem_1.processor;

public class ProcessorFactory {
    public static Processor getProcessor(String processorName) {
        if (processorName == null) {
            return null;
        }
        if (processorName.equalsIgnoreCase("atmega32")) {
            return new ATMega32();
        }
        if (processorName.equalsIgnoreCase("arduinomega")) {
            return new ArduinoMega();
        }
        if (processorName.equalsIgnoreCase("raspberrypi")) {
            return new RaspberryPi();
        }
        return null;
    }
}
