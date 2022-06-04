package problem_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the file name (with extension) name to open");
        String inputFileName = scanner.nextLine();
        CodeEditor.open(inputFileName);
    }
}
