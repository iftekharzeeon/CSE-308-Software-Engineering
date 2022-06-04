package problem_1;

import problem_1.system.QueueManagementSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SystemBuilder systemBuilder = new SystemBuilder();
        QueueManagementSystem orderedSystem;

        String nameOfSystem;
        String nameOfNetwork;
        String nameOfSimCard = "";

        String inputOption;

        System.out.println("Choose an option for the type of the system you want to get.");
        System.out.println("      1. Deluxe: LCD Panel with Raspberry Pi");
        System.out.println("      2. Optimal: Arduino Mega with LED Matrix");
        System.out.println("      3. Poor: ATMega32 with LED Matrix");


        while (true) {
            inputOption = scanner.nextLine();

            if (inputOption.equals("1")) {
                nameOfSystem = "deluxe";
                break;
            } else if (inputOption.equals("2")) {
                nameOfSystem = "optimal";
                break;
            } else if (inputOption.equals("3")) {
                nameOfSystem = "poor";
                break;
            } else {
                System.out.println("Invalid input. Try again");
            }
        }

        System.out.println("Choose an option for the type of communication channel you want.");
        System.out.println("      1. WiFi");
        System.out.println("      2. Mobile Network");

        while (true) {
            inputOption = scanner.nextLine();

            if (inputOption.equals("1")) {
                nameOfNetwork = "wifi";
                break;
            } else if (inputOption.equals("2")) {
                nameOfNetwork = "mobile";
                break;
            } else {
                System.out.println("Invalid input. Try again");
            }
        }

        if (nameOfNetwork.equalsIgnoreCase("mobile")) {
            System.out.println("Choose an option for your SIM Card.");
            System.out.println("      1. Grameen Phone");
            System.out.println("      2. Banglalink");
            System.out.println("      3. Robi");
            System.out.println("      4. Teletalk");

            while (true) {
                inputOption = scanner.nextLine();

                if (inputOption.equals("1")) {
                    nameOfSimCard = "grameenphone";
                    break;
                } else if (inputOption.equals("2")) {
                    nameOfSimCard = "banglalink";
                    break;
                } else if (inputOption.equals("3")) {
                    nameOfSimCard = "robi";
                    break;
                } else if (inputOption.equals("4")) {
                    nameOfSimCard = "teletalk";
                    break;
                } else {
                    System.out.println("Invalid input. Try again");
                }
            }
        }

        String communicationType = nameOfNetwork + "#" + nameOfSimCard;

        System.out.println("Enter the number of display units.");
        int numberOfDisplayUnits = Integer.parseInt(scanner.nextLine());

        orderedSystem = systemBuilder.buildSystem(nameOfSystem, communicationType, numberOfDisplayUnits);

        orderedSystem.details();
    }
}
