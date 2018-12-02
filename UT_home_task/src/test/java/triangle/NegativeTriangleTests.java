package triangle;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class NegativeTriangleTests {

    @DataProvider(name = "NegativeTests")
    public Object[][] createNegativeTests() {
        return new Object[][]{
                {new ArrayList<>(Arrays.asList(-1.0, 1.0, 1.0)), "a<=0"},
                {new ArrayList<>(Arrays.asList(1.0, -1.0, 1.0)), "b<=0"},
                {new ArrayList<>(Arrays.asList(1.0, 1.0, -1.0)), "c<=0"},
                {new ArrayList<>(Arrays.asList(0.0, 2.0, 2.0)), "a<=0"},
                {new ArrayList<>(Arrays.asList(2.0, 0.0, 2.0)), "b<=0"},
                {new ArrayList<>(Arrays.asList(2.0, 2.0, 0.0)), "c<=0"},
                {new ArrayList<>(Arrays.asList(0.0, 0.0, 0.0)), "a<=0"},
                {new ArrayList<>(Arrays.asList(9.0, 2.0, 2.0)), "b+c<=a"},
                {new ArrayList<>(Arrays.asList(2.0, 9.0, 2.0)), "a+c<=b"},
                {new ArrayList<>(Arrays.asList(2.0, 2.0, 9.0)), "a+b<=c"},
                {new ArrayList<>(Arrays.asList(9.0, 4.5, 4.5)), "b+c<=a"},
                {new ArrayList<>(Arrays.asList(4.5, 9.0, 4.5)), "a+c<=b"},
                {new ArrayList<>(Arrays.asList(4.5, 4.5, 9.0)), "a+b<=c"},
                {new ArrayList<>(Arrays.asList(-0.0, 2.0, 3.5)), "a<=0"},
                {new ArrayList<>(Arrays.asList(2.0, -0.0, 3.5)), "b<=0"},
                {new ArrayList<>(Arrays.asList(3.5, 2.0, -0.0)), "c<=0"},
                {new ArrayList<>(Arrays.asList(0.75e+99, 0.75e+99, 1.5e+99 + Double.MIN_VALUE)), "a+b<=c"},
                {new ArrayList<>(Arrays.asList(0.75e+99, 1.5e+99 + Double.MIN_VALUE, 0.75e+99)), "a+c<=b"},
                {new ArrayList<>(Arrays.asList(1.5e+99 + Double.MIN_VALUE, 0.75e+99, 0.75e+99)), "b+c<=a"},
                {new ArrayList<>(Arrays.asList(Double.POSITIVE_INFINITY, 1.0, 1.0)), "a=Infinity"},
                {new ArrayList<>(Arrays.asList(1.0, Double.POSITIVE_INFINITY, 1.0)), "b=Infinity"},
                {new ArrayList<>(Arrays.asList(1.0, 1.0, Double.POSITIVE_INFINITY)), "c=Infinity"},
                {new ArrayList<>(Arrays.asList(Double.NEGATIVE_INFINITY, 1.0, 1.0)), "a=-Infinity"},
                {new ArrayList<>(Arrays.asList(1.0, Double.NEGATIVE_INFINITY, 1.0)), "b=-Infinity"},
                {new ArrayList<>(Arrays.asList(1.0, 1.0, Double.NEGATIVE_INFINITY)), "c=-Infinity"},
                {new ArrayList<>(Arrays.asList(Double.NaN, 1.0, 1.0)), "a=NaN"},
                {new ArrayList<>(Arrays.asList(1.0, Double.NaN, 1.0)), "b=NaN"},
                {new ArrayList<>(Arrays.asList(1.0, 1.0, Double.NaN)), "c=NaN"},
                {new ArrayList<>(Arrays.asList(Double.NaN, Double.NaN, Double.NaN)), "a=NaN"},
                {new ArrayList<>(Arrays.asList(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY)), "a=Infinity"},
                {new ArrayList<>(Arrays.asList(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY)), "a=-Infinity"},
        };
    }

    @Test(testName = "VerificationCheckTriangleReturnedMessage", dataProvider = "NegativeTests")
    public void verifyCheckTriangleReturnedMessage(ArrayList<Double> sides, String expectedMessage) {
        Triangle triangle = new Triangle(sides.get(0), sides.get(1), sides.get(2));
        triangle.checkTriangle();
        assertEquals(triangle.getMessage(), expectedMessage, "method 'checkTriangle' returned wrong string message, sides: " + sides);
    }

    @Test(testName = "VerificationCheckTriangleReturnedBoolean", dataProvider = "NegativeTests")
    public void verifyCheckTriangleReturnedBoolean(ArrayList<Double> sides, String expectedMessage) {
        Triangle triangle = new Triangle(sides.get(0), sides.get(1), sides.get(2));
        assertFalse(triangle.checkTriangle(), "method 'checkTriangle' returned wrong boolean value, sides: " + sides);
    }

    @Test(testName = "VerificationThrownExceptionInDetectTriangle", dataProvider = "NegativeTests", expectedExceptions = Exception.class)
    public void verifyIfExceptionWillBeThrownInDetectTriangleWithIncorrectValues(ArrayList<Double> sides, String expectedMessage) {
        Triangle triangle = new Triangle(sides.get(0), sides.get(1), sides.get(2));
        System.out.println(sides);
        triangle.detectTriangle();
    }

    @Test(testName = "VerificationThrownExceptionInGetSquare", dataProvider = "NegativeTests", expectedExceptions = Exception.class)
    public void verifyIfExceptionWillBeThrownInGetSquareWithIncorrectValues(ArrayList<Double> sides, String expectedMessage) {
        Triangle triangle = new Triangle(sides.get(0), sides.get(1), sides.get(2));
        System.out.println(sides);
        triangle.getSquare();
    }
}