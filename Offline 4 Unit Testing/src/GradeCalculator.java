public class GradeCalculator {

    public String threeCreditCourse(String totalMarksString) throws NumberFormatException {

        double totalMarks = Double.parseDouble(totalMarksString);

        if (totalMarks < 0) {
            return "Invalid Number: Negative";
        }

        totalMarks = Math.ceil(totalMarks);

        if (totalMarks > 300) {
            return "Invalid Number: Exceeding Upper Bound";
        }

        if (totalMarks >= 240) {
            return "A";
        } else if (totalMarks >= 210 && totalMarks <= 239) {
            return "B";
        } else if (totalMarks >= 180 && totalMarks <= 209) {
            return "C";
        } else {
            return "F";
        }
    }

    public String fourCreditCourse(String totalMarksString) throws NumberFormatException {

        double totalMarks = Double.parseDouble(totalMarksString);

        if (totalMarks < 0) {
            return "Invalid Number: Negative";
        }

        totalMarks = Math.ceil(totalMarks);

        if (totalMarks > 400) {
            return "Invalid Number: Exceeding Upper Bound";
        }

        if (totalMarks >= 320) {
            return "A";
        } else if (totalMarks >= 280 && totalMarks <= 319) {
            return "B";
        } else if (totalMarks >= 240 && totalMarks <= 279) {
            return "C";
        } else {
            return "F";
        }
    }
}
