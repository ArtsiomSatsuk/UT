package triangle;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.testng.Assert.*;

public class NegativeTriangleTests {

    @Test(expectedExceptions = ArithmeticException.class, groups = "ArithmeticException")
    public void tst1_ArithmeticExceptionInDetectTriangle() {
        Triangle triangle = new Triangle(2 / 0, 1.0, 1.0);
        triangle.detectTriangle();
    }

    @Test(expectedExceptions = ArithmeticException.class, groups = "ArithmeticException")
    public void tst2_ArithmeticExceptionMustInDetectTriangle() {
        Triangle triangle = new Triangle(1.0, 2 / 0, 1.0);
        triangle.detectTriangle();
    }

    @Test(expectedExceptions = ArithmeticException.class, groups = "ArithmeticException")
    public void tst3_ArithmeticExceptionInDetectTriangle() {
        Triangle triangle = new Triangle(1.0, 1.0, 2 / 0);
        triangle.detectTriangle();
    }

    @Test(expectedExceptions = ArithmeticException.class, groups = "ArithmeticException")
    public void test1_ArithmeticExceptionInCheckTriangle() {
        Triangle triangle = new Triangle(2 / 0, 1.0, 1.0);
        triangle.checkTriangle();
    }

    @Test(expectedExceptions = ArithmeticException.class, groups = "ArithmeticException")
    public void test2_ArithmeticExceptionInCheckTriangle() {
        Triangle triangle = new Triangle(1.0, 2 / 0, 1.0);
        triangle.checkTriangle();
    }

    @Test(expectedExceptions = ArithmeticException.class, groups = "ArithmeticException")
    public void test3_ArithmeticExceptionInCheckTriangle() {
        Triangle triangle = new Triangle(1.0, 1.0, 2 / 0);
        triangle.checkTriangle();
    }

    @Test(expectedExceptions = ArithmeticException.class, groups = "ArithmeticException")
    public void test1_ArithmeticExceptionInGetSquare() {
        Triangle triangle = new Triangle(2 / 0, 1.0, 1.0);
        triangle.getSquare();
    }

    @Test(expectedExceptions = ArithmeticException.class, groups = "ArithmeticException")
    public void test2_ArithmeticExceptionInGetSquare() {
        Triangle triangle = new Triangle(1.0, 2 / 0, 1.0);
        triangle.getSquare();
    }

    @Test(expectedExceptions = ArithmeticException.class, groups = "ArithmeticException")
    public void test3_ArithmeticExceptionInGetSquare() {
        Triangle triangle = new Triangle(1.0, 1.0, 2 / 0);
        triangle.getSquare();
    }

    @Test(expectedExceptions = ArithmeticException.class, groups = "ArithmeticException")
    public void test1_ArithmeticExceptionInGetMessage() {
        Triangle triangle = new Triangle(2 / 0, 1.0, 1.0);
        triangle.getMessage();
    }

    @Test(expectedExceptions = ArithmeticException.class, groups = "ArithmeticException")
    public void test2_ArithmeticExceptionInGetMessage() {
        Triangle triangle = new Triangle(1.0, 2 / 0, 1.0);
        triangle.getMessage();
    }

    @Test(expectedExceptions = ArithmeticException.class, groups = "ArithmeticException")
    public void test3_ArithmeticExceptionInGetMessage() {
        Triangle triangle = new Triangle(1.0, 1.0, 2 / 0);
        triangle.getMessage();
    }


    @DataProvider(name = "for_NegativeTests")
    public Object[][] createDataForNegativeTests() {
        return new Object[][]{
                {new ArrayList<>(Arrays.asList(1.0, -1.0, 1.0)), "b<=0"},
                {new ArrayList<>(Arrays.asList(2.0, 0.0, 2.0)), "b<=0"},
                {new ArrayList<>(Arrays.asList(1.0, 1.0, -1.0)), "c<=0"},
                {new ArrayList<>(Arrays.asList(2.0, 2.0, 0.0)), "c<=0"},
                {new ArrayList<>(Arrays.asList(-1.0, 1.0, 1.0)), "a<=0"},
                {new ArrayList<>(Arrays.asList(0.0, 2.0, 2.0)), "a<=0"},
                {new ArrayList<>(Arrays.asList(0.0, 0.0, 0.0)), "a<=0"},
                {new ArrayList<>(Arrays.asList(2.0, 9.0, 2.0)), "a+c<=b"},
                {new ArrayList<>(Arrays.asList(2.0, 2.0, 9.0)), "a+b<=c"},
                {new ArrayList<>(Arrays.asList(9.0, 2.0, 2.0)), "b+c<=a"},
                {new ArrayList<>(Arrays.asList(4.5, 9.0, 4.5)), "a+c<=b"},
                {new ArrayList<>(Arrays.asList(9.0, 4.5, 4.5)), "b+c<=a"},
                {new ArrayList<>(Arrays.asList(4.5, 4.5, 9.0)), "a+b<=c"},
                {new ArrayList<>(Arrays.asList(Double.MAX_VALUE / 2, Double.MAX_VALUE / 2, Double.MAX_VALUE + Double.MIN_VALUE)), "a+b<=c"},
                {new ArrayList<>(Arrays.asList(Double.MAX_VALUE / 2, Double.MAX_VALUE + Double.MIN_VALUE, Double.MAX_VALUE / 2)), "a+c<=b"},
                {new ArrayList<>(Arrays.asList(Double.MAX_VALUE + Double.MIN_VALUE, Double.MAX_VALUE / 2, Double.MAX_VALUE / 2)), "b+c<=a"},
                {new ArrayList<>(Arrays.asList(Double.MAX_VALUE / Double.NEGATIVE_INFINITY, 2.0, 3.5)), "a<=0"},    // -0.0
                {new ArrayList<>(Arrays.asList(2.0, Double.MAX_VALUE / Double.NEGATIVE_INFINITY, 3.5)), "b<=0"},    // -0.0
                {new ArrayList<>(Arrays.asList(3.5, 2.0, Double.MAX_VALUE / Double.NEGATIVE_INFINITY)), "c<=0"},    // -0.0
        };
    }

    @Test(dataProvider = "for_NegativeTests", groups = "checkTriangleNegative")
    public void verifyCheckTriangleReturnedMessage(ArrayList<Double> parameters, String expectedMessage) {
        Double side_a = parameters.get(0);
        Double side_b = parameters.get(1);
        Double side_c = parameters.get(2);
        Triangle triangle = new Triangle(side_a, side_b, side_c);
        triangle.checkTriangle();
        String actual = triangle.getMessage();

        System.out.println(parameters);
        System.out.println(actual + " - actual, " + expectedMessage + " - expected");
        System.out.println("----------------------------------------");
        assertEquals(actual, expectedMessage);
    }

    @Test(dataProvider = "for_NegativeTests", groups = "checkTriangleNegative")
    public void verifyCheckTriangleReturnedBoolean(ArrayList<Double> parameters, String expectedMessage) {
        Double side_a = parameters.get(0);
        Double side_b = parameters.get(1);
        Double side_c = parameters.get(2);
        Triangle triangle = new Triangle(side_a, side_b, side_c);
        boolean actual = triangle.checkTriangle();
        System.out.println(parameters);
        System.out.println(actual + " - actual, expected - " + false);
        System.out.println("----------------------------------------");
        assertFalse(actual);
    }


//expected = 0, because you cannot determine type of triangle with wrong parameters of sides

    @Test(dataProvider = "for_NegativeTests")
    public void checkDetectTriangleWithWrongParameters(ArrayList<Double> parameters, String expectedMessage) {
        Double side_a = parameters.get(0);
        Double side_b = parameters.get(1);
        Double side_c = parameters.get(2);
        Triangle triangle = new Triangle(side_a, side_b, side_c);
        int actual = triangle.detectTriangle();
        int expected = 0;
        System.out.println(parameters);
        System.out.println(actual + " - actual, expected - " + expected);
        System.out.println("----------------------------------------");
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "for_NegativeTests")
    public void checkConstructorWithWrongParameters(ArrayList<Double> parameters, String expectedMessage) {
        Double side_a = parameters.get(0);
        Double side_b = parameters.get(1);
        Double side_c = parameters.get(2);
        new Triangle(side_a, side_b, side_c);
        System.out.println(parameters);
        System.out.println("----------------------------------------");
        boolean actual = true;
        if ((side_a <= 0 || (side_b <= 0) || (side_c <= 0)) || (side_a + side_b <= side_c) || (side_a + side_c <= side_b) || (side_b + side_c <= side_a)) {
            actual = false;
        }
        assertTrue(actual);
    }

//    @Test(dataProvider = "for_NegativeTests")               переделать
//    public void checkGetSquareWithWrongParameters(ArrayList<Double> parameters, String expectedMessage) {
//        Double side_a = parameters.get(0);
//        Double side_b = parameters.get(1);
//        Double side_c = parameters.get(2);
//        new Triangle(side_a, side_b, side_c);
//        System.out.println(parameters);
//        System.out.println("----------------------------------------");
//        boolean actual = true;
//        if ((side_a <= 0 || (side_b <= 0) || (side_c <= 0)) || (side_a + side_b <= side_c) || (side_a + side_c <= side_b) || (side_b + side_c <= side_a)) {
//            actual = false;
//        }
//        assertTrue(actual);
//    }
}