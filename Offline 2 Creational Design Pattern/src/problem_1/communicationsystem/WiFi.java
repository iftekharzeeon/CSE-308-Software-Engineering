package problem_1.communicationsystem;

public class WiFi extends CommunicationSystem {
    @Override
    public String name() {
        return "WiFi Module";
    }

    @Override
    public double price() {
        return 500;
    }
}
