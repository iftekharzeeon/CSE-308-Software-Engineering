import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class GradeCalculatorTest {

    private static GradeCalculator gradeCalculator;

    @BeforeAll
    static void setUp() {
        gradeCalculator = new GradeCalculator();
        System.out.println("GradeCalculator testing started");
    }

    @DisplayName("3 Credit Course Non Number input test")
    @Test
    void threeCreditCourse_nonNumberTest() {
        NumberFormatException exception = Assertions.assertThrows(NumberFormatException.class, ()-> gradeCalculator.threeCreditCourse("twoFifty"), "Number format exception was expected");
        assertEquals("For input string: \"twoFifty\"",exception.getMessage());
    }

    @DisplayName("4 Credit Course Non Number input test")
    @Test
    void fourCreditCourse_nonNumberTest() {
        NumberFormatException exception = Assertions.assertThrows(NumberFormatException.class, ()-> gradeCalculator.fourCreditCourse("four Fifty"), "Number format exception was expected");
        assertEquals("For input string: \"four Fifty\"",exception.getMessage());
    }

    @DisplayName("3 Credit Course lower bound exceed test")
    @Test
    void threeCreditCourse_lowerBoundExceedTest() {
        assertEquals("Invalid Number: Negative", gradeCalculator.threeCreditCourse("-0.5"));
    }

    @DisplayName("4 Credit Course lower bound exceed test")
    @Test
    void fourCreditCourse_lowerBoundExceedTest() {
        assertEquals("Invalid Number: Negative", gradeCalculator.fourCreditCourse("-0.5"));
    }

    @DisplayName("3 Credit Course upper bound exceed test")
    @Test
    void threeCreditCourse_upperBoundExceedTest() {
        assertEquals("Invalid Number: Exceeding Upper Bound", gradeCalculator.threeCreditCourse("300.5"));
    }

    @DisplayName("4 Credit Course upper bound exceed test")
    @Test
    void fourCreditCourse_upperBoundExceedTest() {
        assertEquals("Invalid Number: Exceeding Upper Bound", gradeCalculator.fourCreditCourse("400.5"));
    }

    @DisplayName("Grade A Upper Boundary test for 3 Credit course with 299.5")
    @Test
    void threeCreditCourse_299dot5_shouldReturn_A() {
        assertEquals("A", gradeCalculator.threeCreditCourse("299.5"));
    }

    @DisplayName("Grade A Lower Boundary test for 3 Credit course with 239.5")
    @Test
    void threeCreditCourse_239dot5_shouldReturn_A() {
        assertEquals("A", gradeCalculator.threeCreditCourse("239.5"));
    }

    @DisplayName("Grade A test for 3 Credit course with 250")
    @Test
    void threeCreditCourse_250_shouldReturn_A() {
        assertEquals("A", gradeCalculator.threeCreditCourse("250"));
    }

    @DisplayName("Grade B Upper Boundary test for 3 Credit course with 238.5")
    @Test
    void threeCreditCourse_238dot5_shouldReturn_B() {
        assertEquals("B", gradeCalculator.threeCreditCourse("238.5"));
    }

    @DisplayName("Grade B Lower Boundary test for 3 Credit course with 209.5")
    @Test
    void threeCreditCourse_209dot5_shouldReturn_B() {
        assertEquals("B", gradeCalculator.threeCreditCourse("209.5"));
    }

    @DisplayName("Grade B test for 3 Credit course with 220")
    @Test
    void threeCreditCourse_220_shouldReturn_B() {
        assertEquals("B", gradeCalculator.threeCreditCourse("220") );
    }

    @DisplayName("Grade C Upper Boundary test for 3 Credit course with 208.5")
    @Test
    void threeCreditCourse_208dot5_shouldReturn_C() {
        assertEquals("C", gradeCalculator.threeCreditCourse("208.5"));
    }

    @DisplayName("Grade C Lower Boundary test for 3 Credit course with 179.5")
    @Test
    void threeCreditCourse_179dot5_shouldReturn_C() {
        assertEquals("C", gradeCalculator.threeCreditCourse("179.5"));
    }

    @DisplayName("Grade C test for 3 Credit course with 190")
    @Test
    void threeCreditCourse_190_shouldReturn_C() {
        assertEquals("C", gradeCalculator.threeCreditCourse("190") );
    }

    @DisplayName("Grade F Upper Boundary test for 3 Credit course with 178.5")
    @Test
    void threeCreditCourse_178dot5_shouldReturn_F() {
        assertEquals("F", gradeCalculator.threeCreditCourse("178.5"));
    }

    @DisplayName("Grade F Lower Boundary test for 3 Credit course with 0")
    @Test
    void threeCreditCourse_0_shouldReturn_F() {
        assertEquals("F", gradeCalculator.threeCreditCourse("0"));
    }

    @DisplayName("Grade F test for 3 Credit course with 150")
    @Test
    void threeCreditCourse_150_shouldReturn_F() {
        assertEquals("F", gradeCalculator.threeCreditCourse("150") );
    }

    @DisplayName("Grade A Upper Boundary test for 4 Credit course with 399.5")
    @Test
    void fourCreditCourse_399dot5_shouldReturn_A() {
        assertEquals("A", gradeCalculator.fourCreditCourse("399.5"));
    }

    @DisplayName("Grade A Lower Boundary test for 4 Credit course with 319.5")
    @Test
    void fourCreditCourse_319dot5_shouldReturn_A() {
        assertEquals("A", gradeCalculator.fourCreditCourse("319.5"));
    }

    @DisplayName("Grade A test for 4 Credit course with 350")
    @Test
    void fourCreditCourse_350_shouldReturn_A() {
        assertEquals("A", gradeCalculator.fourCreditCourse("350") );
    }

    @DisplayName("Grade B Upper Boundary test for 4 Credit course with 318.5")
    @Test
    void fourCreditCourse_318dot5_shouldReturn_B() {
        assertEquals("B", gradeCalculator.fourCreditCourse("318.5"));
    }

    @DisplayName("Grade B Lower Boundary test for 4 Credit course with 279.5")
    @Test
    void fourCreditCourse_279dot5_shouldReturn_B() {
        assertEquals("B", gradeCalculator.fourCreditCourse("279.5"));
    }

    @DisplayName("Grade B test for 4 Credit course with 300")
    @Test
    void fourCreditCourse_300_shouldReturn_B() {
        assertEquals("B", gradeCalculator.fourCreditCourse("300") );
    }

    @DisplayName("Grade C Upper Boundary test for 4 Credit course with 278.5")
    @Test
    void fourCreditCourse_278dot5_shouldReturn_C() {
        assertEquals("C", gradeCalculator.fourCreditCourse("278.5"));
    }

    @DisplayName("Grade C Lower Boundary test for 4 Credit course with 239.5")
    @Test
    void fourCreditCourse_239dot5_shouldReturn_C() {
        assertEquals("C", gradeCalculator.fourCreditCourse("239.5"));
    }

    @DisplayName("Grade C test for 4 Credit course with 250")
    @Test
    void fourCreditCourse_250_shouldReturn_C() {
        assertEquals("C", gradeCalculator.fourCreditCourse("250") );
    }

    @DisplayName("Grade F Upper Boundary test for 3 Credit course with 238.5")
    @Test
    void fourCreditCourse_238dot5_shouldReturn_F() {
        assertEquals("F", gradeCalculator.fourCreditCourse("238.5"));
    }

    @DisplayName("Grade F Lower Boundary test for 4 Credit course with 0")
    @Test
    void fourCreditCourse_0_shouldReturn_F() {
        assertEquals("F", gradeCalculator.fourCreditCourse("0"));
    }

    @DisplayName("Grade F test for 4 Credit course with 200")
    @Test
    void fourCreditCourse_200_shouldReturn_F() {
        assertEquals("F", gradeCalculator.fourCreditCourse("200") );
    }

    @AfterAll
    static void tearDown() {
        gradeCalculator = null;
        System.out.println("GradeCalculator testing done");
    }
}