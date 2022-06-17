package problem_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

public class FileAdapter implements DecimalAdder {

    @Override
    public void calculateSum(File inputFile) throws FileNotFoundException {

        String fileText;

        FileReader fileReader = new FileReader(inputFile);
        char[] chars = new char[(int)inputFile.length()];
        try {
            fileReader.read(chars);
            fileText = new String(chars);

            double[] doubleValues = Arrays.stream(fileText.split("~"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            System.out.println("Sum of the decimal numbers is: " + Arrays.stream(doubleValues).sum());

        } catch (Exception e) {
            System.out.println("File format not supported.");
            System.out.println(e);
        }
    }
}
