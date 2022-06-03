package problem_1.communicationsystem;

public class WiFi extends CommunicationSystem {
    @Override
    protected String name() {
        return "WiFi Module";
    }

    @Override
    protected double price() {
        return 500;
    }
}
