package problem_1.communicationsystem;

public class GrameenPhone extends MobileNetwork{
    @Override
    public String name() {
        return "Grameen Phone SIM";
    }

    @Override
    public double price() {
        return 200;
    }
}
