package problem_1;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File inputFile = new File("src/problem_1/input.txt");
        DecimalFileAdder fileAdder = new DecimalFileAdder();

        fileAdder.calculateSum(inputFile);
    }
}
