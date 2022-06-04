package problem_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputFileName = scanner.nextLine();

        String fileExtension = inputFileName.split("\\.")[inputFileName.split("\\.").length - 1];
        System.out.println(fileExtension);
    }
}
