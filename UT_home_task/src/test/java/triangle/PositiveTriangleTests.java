package triangle;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.testng.Assert.*;

public class PositiveTriangleTests {

    @DataProvider(name = "for_verifyDetectTriangleReturnedValue")
    public Object[][] createDataForVerifyDetectTriangleReturnedValue() {
        return new Object[][]{
                {new ArrayList<>(Arrays.asList(1.0, 1.0, 1.0)), 1 + 2}, //равносторонный и равнобедренный
                {new ArrayList<>(Arrays.asList(3.5, 3.5, 4.5)), 2}, //равнобедренный
                {new ArrayList<>(Arrays.asList(4.5, 3.5, 3.5)), 2},  //равнобедренный
                {new ArrayList<>(Arrays.asList(3.5, 4.5, 4.5)), 2}, //равнобедренный
                {new ArrayList<>(Arrays.asList(0.1 + 0.2, 0.3, 0.3)), 1 + 2},  //равносторонный и равнобедренный
                {new ArrayList<>(Arrays.asList(0.3, 0.3, 0.1 + 0.2)), 1 + 2},  //равносторонный и равнобедренный
                {new ArrayList<>(Arrays.asList(0.3, 0.1 + 0.2, 0.3)), 1 + 2},  //равносторонный и равнобедренный
                {new ArrayList<>(Arrays.asList(55.0, 75.0, 100.0)), 4},  //обычный
                {new ArrayList<>(Arrays.asList(75.0, 55.0, 100.0)), 4},  //обычный
                {new ArrayList<>(Arrays.asList(100.0, 75.0, 55.0)), 4},  //обычный
                {new ArrayList<>(Arrays.asList(55.0, 100.0, 75.0)), 4},  //обычный
                {new ArrayList<>(Arrays.asList(Math.sqrt(3.99999999999999999998), Math.sqrt(4.000000000000000000001), Math.sqrt(3.99999999999999999999))), 4},   //обычный треунгольник с разными сторонами
                {new ArrayList<>(Arrays.asList(Math.sqrt(4.000000000000000000001), Math.sqrt(3.99999999999999999998), Math.sqrt(3.99999999999999999999))), 4},   //обычный треунгольник с разными сторонами
                {new ArrayList<>(Arrays.asList(Math.sqrt(3.99999999999999999998), Math.sqrt(3.99999999999999999999), Math.sqrt(4.000000000000000000001))), 4},   //обычный треунгольник с разными сторонами
                {new ArrayList<>(Arrays.asList(Math.sqrt(3.99999999999999999999), Math.sqrt(4.000000000000000000001), Math.sqrt(3.99999999999999999998))), 4},   //обычный треунгольник с разными сторонами
                {new ArrayList<>(Arrays.asList(3.0, 4.0, 5.0)), 8},  //прямоугольный
                {new ArrayList<>(Arrays.asList(3.0, 5.0, 4.0)), 8},  //прямоугольный
                {new ArrayList<>(Arrays.asList(5.0, 3.0, 4.0)), 8},  //прямоугольный
                {new ArrayList<>(Arrays.asList(4.0, 5.0, 3.0)), 8},  //прямоугольный
                {new ArrayList<>(Arrays.asList(Double.MAX_VALUE / 2, Double.MAX_VALUE / 2, (Double.MAX_VALUE / 2) - 1)), 2},  //равнобедренный
                {new ArrayList<>(Arrays.asList(Double.MAX_VALUE / 2, (Double.MAX_VALUE / 2) - 1, Double.MAX_VALUE / 2)), 2},  //равнобедренный
                {new ArrayList<>(Arrays.asList((Double.MAX_VALUE / 2) - 1, Double.MAX_VALUE / 2, Double.MAX_VALUE / 2)), 2},  //равнобедренный
                {new ArrayList<>(Arrays.asList(2.8284271247461900976, 2.0, 2.0)), 8 + 2},  //прямоугольный и равнобедренный
                {new ArrayList<>(Arrays.asList(2.0, 2.8284271247461900976, 2.0)), 8 + 2},  //прямоугольный и равнобедренный
                {new ArrayList<>(Arrays.asList(2.0, 2.0, 2.8284271247461900976)), 8 + 2},  //прямоугольный и равнобедренный
                {new ArrayList<>(Arrays.asList(Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE)), 1 + 2},  //равносторонний
                {new ArrayList<>(Arrays.asList(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE)), 1 + 2},  //равносторонний
                {new ArrayList<>(Arrays.asList(Double.MAX_VALUE - Double.MIN_VALUE, Double.MAX_VALUE, Double.MAX_VALUE)), 2},  //равнобедренный
                {new ArrayList<>(Arrays.asList(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE - Double.MIN_VALUE)), 2},  //равнобедренный
                {new ArrayList<>(Arrays.asList(Double.MAX_VALUE, Double.MAX_VALUE - Double.MIN_VALUE, Double.MAX_VALUE)), 2},  //равнобедренный
        };
    }

    @Test(dataProvider = "for_verifyDetectTriangleReturnedValue")
    public void verifyDetectTriangleReturnedValue(ArrayList<Double> parameters, int expected) {
        double side_a = parameters.get(0);
        double side_b = parameters.get(1);
        double side_c = parameters.get(2);
        Triangle triangle = new Triangle(side_a, side_b, side_c);
        int actual = triangle.detectTriangle();
        System.out.println("Sides: a - " + side_a + ", b - " + side_b + ", c - " + side_c);
        System.out.println("actual - " + actual + ", expected - " + expected);
        System.out.println("-----------------------------------------------");
        assertEquals(actual, expected);
    }

    @DataProvider(name = "for_checkTrianglePositiveGroup")
    public Object[][] createDataForCheckTrianglePositiveGroup() {
        return new Object[][]{
                {new ArrayList<>(Arrays.asList(1.0, 1.0, 1.0))},
                {new ArrayList<>(Arrays.asList(3.5, 3.5, 4.5))},
                {new ArrayList<>(Arrays.asList(4.5, 3.5, 3.5))},
                {new ArrayList<>(Arrays.asList(3.5, 4.5, 4.5))},
                {new ArrayList<>(Arrays.asList(55.0, 75.0, 100.0))},
                {new ArrayList<>(Arrays.asList(75.0, 55.0, 100.0))},
                {new ArrayList<>(Arrays.asList(100.0, 75.0, 55.0))},
                {new ArrayList<>(Arrays.asList(55.0, 100.0, 75.0))},
                {new ArrayList<>(Arrays.asList(0.1 + 0.2, 0.15000000000000002, 0.15000000000000002))},
                {new ArrayList<>(Arrays.asList(0.15000000000000002, 0.15000000000000002, 0.1 + 0.2))},
                {new ArrayList<>(Arrays.asList(0.15000000000000002, 0.1 + 0.2, 0.15000000000000002))},
                {new ArrayList<>(Arrays.asList(Double.MAX_VALUE / 2, Double.MAX_VALUE / 2, Double.MAX_VALUE - Double.MIN_VALUE))},
                {new ArrayList<>(Arrays.asList(Double.MAX_VALUE / 2, Double.MAX_VALUE - Double.MIN_VALUE, Double.MAX_VALUE / 2))},
                {new ArrayList<>(Arrays.asList(Double.MAX_VALUE - Double.MIN_VALUE, Double.MAX_VALUE / 2, Double.MAX_VALUE / 2))},
                {new ArrayList<>(Arrays.asList(Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE))},
                {new ArrayList<>(Arrays.asList(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE))},
                {new ArrayList<>(Arrays.asList(Double.MIN_VALUE, Double.MAX_VALUE, Double.MAX_VALUE))},
                {new ArrayList<>(Arrays.asList(Double.MAX_VALUE, Double.MAX_VALUE, Double.MIN_VALUE))},
                {new ArrayList<>(Arrays.asList(Double.MAX_VALUE, Double.MIN_VALUE, Double.MAX_VALUE))},
        };
    }

    @Test(dataProvider = "for_checkTrianglePositiveGroup", groups = "checkTrianglePositive")
    public void verifyCheckTriangleReturnedBoolean(ArrayList<Double> parameters) {
        Double side_a = parameters.get(0);
        Double side_b = parameters.get(1);
        Double side_c = parameters.get(2);
        Triangle triangle = new Triangle(side_a, side_b, side_c);
        boolean actual = triangle.checkTriangle();
        System.out.println(actual + " - actual, " + true + " - expected");
        System.out.println("----------------------------------------");
        assertTrue(actual);
    }

    @Test(dataProvider = "for_checkTrianglePositiveGroup", groups = "checkTrianglePositive")
    public void verifyCheckTriangleReturnedMessage(ArrayList<Double> parameters) {
        String expected = "";
        Double side_a = parameters.get(0);
        Double side_b = parameters.get(1);
        Double side_c = parameters.get(2);
        Triangle triangle = new Triangle(side_a, side_b, side_c);
        triangle.checkTriangle();
        String actual = triangle.getMessage();
        System.out.println(actual + " - actual, " + expected + " - expected");
        System.out.println("----------------------------------------");
        assertEquals(actual, expected);
    }

    @DataProvider(name = "for_checkGetSquareReturnValue")
    public Object[][] createDataForCheckGetSquareReturnValue() {
        return new Object[][]{
                {new ArrayList<>(Arrays.asList(1.0, 1.0, 1.0)), 0.43301270189221932338},
                {new ArrayList<>(Arrays.asList(3.5, 3.5, 4.5)), 6.032140478304529672},
                {new ArrayList<>(Arrays.asList(4.5, 3.5, 3.5)), 6.032140478304529672},
                {new ArrayList<>(Arrays.asList(3.5, 4.5, 3.5)), 6.032140478304529672},
                {new ArrayList<>(Arrays.asList(0.1 + 0.2, 0.3, 0.3)), 0.038971143170299739},
                {new ArrayList<>(Arrays.asList(0.3, 0.3, 0.1 + 0.2)), 0.038971143170299739},
                {new ArrayList<>(Arrays.asList(0.3, 0.1 + 0.2, 0.3)), 0.038971143170299739},
                {new ArrayList<>(Arrays.asList(55.0, 75.0, 100.0)), 2034.698994937580441719366},
                {new ArrayList<>(Arrays.asList(75.0, 55.0, 100.0)), 2034.698994937580441719366},
                {new ArrayList<>(Arrays.asList(100.0, 75.0, 55.0)), 2034.698994937580441719366},
                {new ArrayList<>(Arrays.asList(55.0, 100.0, 75.0)), 2034.698994937580441719366},
                {new ArrayList<>(Arrays.asList(3.0, 4.0, 5.0)), 6.0},
                {new ArrayList<>(Arrays.asList(3.0, 5.0, 4.0)), 6.0},
                {new ArrayList<>(Arrays.asList(5.0, 3.0, 4.0)), 6.0},
                {new ArrayList<>(Arrays.asList(4.0, 5.0, 3.0)), 6.0}

//            проверить шестнадцатиричную, востмеричную и двоичные записи

        };
    }


    @Test(dataProvider = "for_checkGetSquareReturnValue")
    public void checkGetSquareReturnValue(ArrayList<Double> parameters, double expected) {
        double side_a = parameters.get(0);
        double side_b = parameters.get(1);
        double side_c = parameters.get(2);
        Triangle triangle = new Triangle(side_a, side_b, side_c);
        double actual = triangle.getSquare();
        System.out.println(actual + " - actual, " + expected + " - expected");
        System.out.println("--------------------------------------");
        assertEquals(actual, expected);
    }

    @Test
    public void checkTriangleConstructor() {
        Triangle triangle = new Triangle(1.0, 1.0, 1.0);
        assertEquals(triangle.getMessage(), "");
        assertNotNull(triangle);
    }
}
