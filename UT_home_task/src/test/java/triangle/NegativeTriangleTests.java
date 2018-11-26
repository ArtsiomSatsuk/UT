package triangle;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collector;

import static org.testng.Assert.*;

public class NegativeTriangleTests {

    @DataProvider(name = "NegativeValues")
    public Object[][] createNegativeValues() {
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

                {new ArrayList<>(Arrays.asList(1.0, Double.POSITIVE_INFINITY, 1.0)), "Infinity as a side"},
                {new ArrayList<>(Arrays.asList(1.0, 1.0, Double.POSITIVE_INFINITY)), "Infinity as a side"},
                {new ArrayList<>(Arrays.asList(Double.POSITIVE_INFINITY, 1.0, 1.0)), "Infinity as a side"},
                {new ArrayList<>(Arrays.asList(1.0, Double.NEGATIVE_INFINITY, 1.0)), "Infinity as a side"},
                {new ArrayList<>(Arrays.asList(1.0, 1.0, Double.NEGATIVE_INFINITY)), "Infinity as a side"},
                {new ArrayList<>(Arrays.asList(Double.NEGATIVE_INFINITY, 1.0, 1.0)), "Infinity as a side"},
                {new ArrayList<>(Arrays.asList(1.0, Math.sqrt(-8), 1.0)), "NaN as a side"},
                {new ArrayList<>(Arrays.asList(1.0, 1.0, Math.sqrt(-8))), "NaN as a side"},
                {new ArrayList<>(Arrays.asList(Math.sqrt(-8), 1.0, 1.0)), "NaN as a side"},
                {new ArrayList<>(Arrays.asList(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY)), "Infinity as a side"},
                {new ArrayList<>(Arrays.asList(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY)), "Infinity as a side"},
        };
    }
//
//    @Test(testName = "VerificationOfSides", dataProvider = "NegativeValues")
//    public void verifySide(ArrayList<Double> parameters, String expectedMessage) {
//        parameters.forEach(sideValue -> assertFalse(Double.isInfinite(sideValue), "illegal side value: " + sideValue));
//        parameters.forEach(sideValue -> assertFalse(Double.isNaN(sideValue), "illegal side value: " + sideValue));
//    }

    @Test(testName = "VerificationCheckTriangleReturnedMessage", dataProvider = "NegativeValues")
    public void verifyCheckTriangleReturnedMessage(ArrayList<Double> parameters, String expectedMessage) {
        Triangle triangle = new Triangle(parameters.get(0), parameters.get(1), parameters.get(2));
        triangle.checkTriangle();
        assertEquals(triangle.getMessage(), expectedMessage, "method 'checkTriangle' returned wrong string message with " + parameters + " as sides");
    }

    @Test(testName = "VerificationCheckTriangleReturnedBoolean", dataProvider = "NegativeValues")
    public void verifyCheckTriangleReturnedBoolean(ArrayList<Double> parameters, String expectedMessage) {
        Triangle triangle = new Triangle(parameters.get(0), parameters.get(1), parameters.get(2));
        assertFalse(triangle.checkTriangle(), "method 'checkTriangle' returned wrong boolean value with: " + parameters + " as sides;");
    }

    @Test(testName = "VerificationThrownExceptionInDetectTriangle", dataProvider = "NegativeValues",expectedExceptions = Exception.class)
    public void checkExceptionInDetectTriangleWithWrongSideValues(ArrayList<Double> parameters, String expectedMessage) {
        Triangle triangle = new Triangle(parameters.get(0), parameters.get(1), parameters.get(2));
        triangle.detectTriangle();
    }

    @Test(testName = "VerificationThrownExceptionInGetSquare",dataProvider = "NegativeValues",expectedExceptions = Exception.class)
    public void checkExceptionInGetSquareWithWrongSideValues(ArrayList<Double> parameters, String expectedMessage){
                Triangle triangle = new Triangle(parameters.get(0), parameters.get(1), parameters.get(2));
                triangle.getSquare();
    }
}

//expected = 0, because you cannot determine type of triangle with wrong parameters of sides

//    @Test(testName = "VerificationDetectTriangleReturnedValue", dataProvider = "NegativeValues")
//    public void checkDetectTriangleReturnedValue(ArrayList<Double> parameters, String expectedMessage) {
//        Triangle triangle = new Triangle(parameters.get(0), parameters.get(1), parameters.get(2));
//        assertEquals(triangle.detectTriangle(), 0, "you cannot determine type of triangle with " + parameters + " as sides");
//    }

//    @Test(testName = "TriangleWithIncorrectSidesVerification", dataProvider = "NegativeValues")
//    public void verifyNullTriangle(ArrayList<Double> parameters, String expectedMessage) {
//        Triangle triangle = new Triangle(parameters.get(0), parameters.get(1), parameters.get(2));
//        assertNull(triangle, "triangle cannot be created with such sides - " + parameters);
//    }


//@DataProvider(name = "ExtremeValues")
//    public Object[][] createExtremeValuesData() {
//        return new Object[][]{
//                {1.0, Double.POSITIVE_INFINITY, 1.0},
//                {1.0, 1.0, Double.POSITIVE_INFINITY},
//                {Double.POSITIVE_INFINITY, 1.0, 1.0},
//
//                {1.0, Double.NEGATIVE_INFINITY, 1.0},
//                {1.0, 1.0, Double.NEGATIVE_INFINITY},              подумать
//                {Double.NEGATIVE_INFINITY, 1.0, 1.0},
//
//                {1.0, Math.sqrt(-8), 1.0},
//                {1.0, 1.0, Math.sqrt(-8)},
//                {Math.sqrt(-8), 1.0, 1.0},
//        };
//    }
//
//    @Test(testName = "VerificationOfSides", dataProvider = "ExtremeValues")
//    public void verifySide(Double[] parameters) {
//        Arrays.stream(parameters).forEach(sideValue -> assertFalse(Double.isInfinite(sideValue), "illegal side value - " + sideValue));
//        Arrays.stream(parameters).forEach(sideValue -> assertFalse(Double.isNaN(sideValue), "illegal side value - " + sideValue));
//    }
//
//    @Test(testName = "TriangleWithIncorrectSidesVerification", dataProvider = "ExtremeValues")
//    public void verifyNullTriangle(Double[] parameters) {
//        Triangle triangle = new Triangle(parameters[0], parameters[1], parameters[2]);
//        assertNull(triangle, "triangle cannot be created with such sides - " + parameters[0] + " " + parameters[1] + " " + parameters[2]);
//    }