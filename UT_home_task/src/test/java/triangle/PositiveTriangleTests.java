package triangle;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PositiveTriangleTests {

    @DataProvider(name = "verifyDetectTrianglePositiveTests")
    public Object[][] createPositiveTestsForVerifyDetectTriangle() {
        return new Object[][]{
                {new ArrayList<>(Arrays.asList(1.0, 1.0, 1.0)), 1 + 2}, //equilateral and isosceles
                {new ArrayList<>(Arrays.asList(4.5, 3.5, 3.5)), 2}, //isosceles
                {new ArrayList<>(Arrays.asList(3.5, 4.5, 4.5)), 2}, //isosceles
                {new ArrayList<>(Arrays.asList(3.5, 3.5, 4.5)), 2}, //isosceles
                {new ArrayList<>(Arrays.asList(0.1 + 0.2, 0.3, 0.3)), 1 + 2},  //equilateral and isosceles
                {new ArrayList<>(Arrays.asList(0.3, 0.1 + 0.2, 0.3)), 1 + 2},  //equilateral and isosceles
                {new ArrayList<>(Arrays.asList(0.3, 0.3, 0.1 + 0.2)), 1 + 2},  //equilateral and isosceles
                {new ArrayList<>(Arrays.asList(55.0, 75.0, 100.0)), 4},  //ordinary
                {new ArrayList<>(Arrays.asList(75.0, 55.0, 100.0)), 4},  //ordinary
                {new ArrayList<>(Arrays.asList(100.0, 75.0, 55.0)), 4},  //ordinary
                {new ArrayList<>(Arrays.asList(55.0, 100.0, 75.0)), 4},  //ordinary
                {new ArrayList<>(Arrays.asList(3.0, 4.0, 5.0)), 8},  //rectangular
                {new ArrayList<>(Arrays.asList(3.0, 5.0, 4.0)), 8},  //rectangular
                {new ArrayList<>(Arrays.asList(5.0, 3.0, 4.0)), 8},  //rectangular
                {new ArrayList<>(Arrays.asList(4.0, 5.0, 3.0)), 8},  //rectangular
                {new ArrayList<>(Arrays.asList(2.8284271247461900976, 2.0, 2.0)), 8 + 2},  //rectangular and isosceles
                {new ArrayList<>(Arrays.asList(2.0, 2.8284271247461900976, 2.0)), 8 + 2},  //rectangular and isosceles
                {new ArrayList<>(Arrays.asList(2.0, 2.0, 2.8284271247461900976)), 8 + 2},  //rectangular and isosceles
                {new ArrayList<>(Arrays.asList(Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE)), 1 + 2},  //equilateral and isosceles
                {new ArrayList<>(Arrays.asList(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE)), 1 + 2},  //equilateral and isosceles
                {new ArrayList<>(Arrays.asList(Double.MAX_VALUE - Double.MIN_VALUE, Double.MAX_VALUE, Double.MAX_VALUE)), 2},  //isosceles
                {new ArrayList<>(Arrays.asList(Double.MAX_VALUE, Double.MAX_VALUE - Double.MIN_VALUE, Double.MAX_VALUE)), 2},  //isosceles
                {new ArrayList<>(Arrays.asList(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE - Double.MIN_VALUE)), 2},  //isosceles
        };
    }

    @DataProvider(name = "verifyCheckTrianglePositiveTests")
    public Object[][] createPositiveTestsForVerifyCheckTriangle() {
        return new Object[][]{
                {new ArrayList<>(Arrays.asList(1.0, 1.0, 1.0))},
                {new ArrayList<>(Arrays.asList(4.5, 3.5, 3.5))},
                {new ArrayList<>(Arrays.asList(3.5, 4.5, 4.5))},
                {new ArrayList<>(Arrays.asList(3.5, 3.5, 4.5))},
                {new ArrayList<>(Arrays.asList(55.0, 75.0, 100.0))},
                {new ArrayList<>(Arrays.asList(75.0, 55.0, 100.0))},
                {new ArrayList<>(Arrays.asList(100.0, 75.0, 55.0))},
                {new ArrayList<>(Arrays.asList(55.0, 100.0, 75.0))},
                {new ArrayList<>(Arrays.asList(Double.MAX_VALUE - Double.MIN_VALUE, Double.MAX_VALUE / 2, Double.MAX_VALUE / 2))},
                {new ArrayList<>(Arrays.asList(Double.MAX_VALUE / 2, Double.MAX_VALUE - Double.MIN_VALUE, Double.MAX_VALUE / 2))},
                {new ArrayList<>(Arrays.asList(Double.MAX_VALUE / 2, Double.MAX_VALUE / 2, Double.MAX_VALUE - Double.MIN_VALUE))},
                {new ArrayList<>(Arrays.asList(Double.MIN_VALUE, Double.MAX_VALUE, Double.MAX_VALUE))},
                {new ArrayList<>(Arrays.asList(Double.MAX_VALUE, Double.MIN_VALUE, Double.MAX_VALUE))},
                {new ArrayList<>(Arrays.asList(Double.MAX_VALUE, Double.MAX_VALUE, Double.MIN_VALUE))},
                {new ArrayList<>(Arrays.asList(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE))},
                {new ArrayList<>(Arrays.asList(Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE))},
        };
    }

    @DataProvider(name = "verifyGetSquarePositiveTests")
    public Object[][] createPositiveTestsForVerifyGetSquare() {
        return new Object[][]{
                {new ArrayList<>(Arrays.asList(1.0, 1.0, 1.0)), 0.43301270189221932338},
                {new ArrayList<>(Arrays.asList(3.0, 4.0, 5.0)), 6.0},
                {new ArrayList<>(Arrays.asList(3.0, 5.0, 4.0)), 6.0},
                {new ArrayList<>(Arrays.asList(5.0, 3.0, 4.0)), 6.0},
                {new ArrayList<>(Arrays.asList(4.0, 5.0, 3.0)), 6.0},
                {new ArrayList<>(Arrays.asList(8.0, 7.0, 7.0)), 22.9782505861521146},
                {new ArrayList<>(Arrays.asList(7.0, 8.0, 7.0)), 22.9782505861521146},
                {new ArrayList<>(Arrays.asList(7.0, 7.0, 8.0)), 22.9782505861521146},
        };
    }

    @Test(testName = "VerificationDetectTriangleReturnedValue", dataProvider = "verifyDetectTrianglePositiveTests")
    public void verifyDetectTriangleReturnedValue(ArrayList<Double> sides, int expectedFinalState) {
        Triangle triangle = new Triangle(sides.get(0), sides.get(1), sides.get(2));
        assertEquals(triangle.detectTriangle(), expectedFinalState, "method 'detectTriangle' returned wrong final state of triangle, sides: " + sides);
    }

    @Test(testName = "VerificationCheckTriangleReturnedBoolean", dataProvider = "verifyCheckTrianglePositiveTests")
    public void verifyCheckTriangleReturnedBoolean(ArrayList<Double> sides) {
        Triangle triangle = new Triangle(sides.get(0), sides.get(1), sides.get(2));
        assertTrue(triangle.checkTriangle(), "method 'checkTriangle' returned wrong boolean value, sides: " + sides);
    }


    /*
    String excpected = "", because all triangles with sides from the DataProvider("verifyCheckTrianglePositiveTests")
    can exist and 'getMessage' method must always return empty string after invoking 'checkTriangle' method
    */

    @Test(testName = "VerificationCheckTriangleReturnedMessage", dataProvider = "verifyCheckTrianglePositiveTests")
    public void verifyCheckTriangleReturnedMessage(ArrayList<Double> sides) {
        String excpected = "";
        Triangle triangle = new Triangle(sides.get(0), sides.get(1), sides.get(2));
        triangle.checkTriangle();
        assertEquals(triangle.getMessage(), excpected, "method 'checkTriangle' returned wrong string message, sides: " + sides);
    }

    @Test(testName = "VerificationGetSquareReturnedValue", dataProvider = "verifyGetSquarePositiveTests")
    public void verifyGetSquareReturnedValue(ArrayList<Double> sides, double expected) {
        Triangle triangle = new Triangle(sides.get(0), sides.get(1), sides.get(2));
        assertEquals(triangle.getSquare(), expected, "method 'getSquare' returned wrong result, sides: " + sides);
    }
}