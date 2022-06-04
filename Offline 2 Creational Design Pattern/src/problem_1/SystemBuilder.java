package problem_1;

import problem_1.application.Application;
import problem_1.communicationsystem.CommunicationSystem;
import problem_1.communicationsystem.CommunicationSystemFactory;
import problem_1.controlunit.ControlUnit;
import problem_1.system.QueueManagementSystem;
import problem_1.system.SystemFactory;

public class SystemBuilder {

    QueueManagementSystem system ;

    public QueueManagementSystem buildSystem(String systemName, String comChannel, int numberOfUnits) {

        system = SystemFactory.getSystem(systemName);

        CommunicationSystem communicationSystem = CommunicationSystemFactory.getCommunicationSystem(comChannel);
        Application application = new Application(systemName);
        ControlUnit controlUnit = new ControlUnit(systemName);

        system.addComponent(communicationSystem);
        system.addComponent(application);
        system.addComponent(controlUnit);

        system.setNumberOfDisplayUnits(numberOfUnits);
        return system;
    }
}
