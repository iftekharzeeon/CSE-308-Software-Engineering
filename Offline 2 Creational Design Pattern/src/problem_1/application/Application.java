package problem_1.application;

import problem_1.Component;

public class Application implements Component {
    private String systemName;

    public Application(String systemName) {
        this.systemName = systemName;
    }

    @Override
    public String name() {
        return  systemName + " Application Program";
    }

    @Override
    public double price() {
        return 1000;
    }
}