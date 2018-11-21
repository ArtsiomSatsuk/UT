package triangle;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.testng.Assert.*;

public class PositiveTriangleTests {

    @DataProvider(name = "PositiveValues")
    public Object[][] createPositiveData() {
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

    @Test(dataProvider = "PositiveValues")
    public void verifyDetectTriangleReturnedValue(ArrayList<Double> parameters, int expected) {
        Triangle triangle = new Triangle(parameters.get(0), parameters.get(1), parameters.get(2));
        assertEquals(triangle.detectTriangle(), expected, "method 'detectTriangle' returned wrong final state of triangle with: " + parameters + " as sides;");
    }

    @DataProvider(name = "checkTrianglePositiveGroup")
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

    @Test(dataProvider = "checkTrianglePositiveGroup", groups = "checkTrianglePositive")
    public void verifyCheckTriangleReturnedBoolean(ArrayList<Double> parameters) {
        Triangle triangle = new Triangle(parameters.get(0), parameters.get(1), parameters.get(2));
        assertTrue(triangle.checkTriangle(), "method 'checkTriangle' returned wrong boolean value with " + parameters + " as sides;");
    }

    @Test(dataProvider = "checkTrianglePositiveGroup", groups = "checkTrianglePositive")
    public void verifyCheckTriangleReturnedMessage(ArrayList<Double> parameters) {
        Triangle triangle = new Triangle(parameters.get(0), parameters.get(1), parameters.get(2));
        triangle.checkTriangle();
        assertEquals(triangle.getMessage(), "", "method 'checkTriangle' returned wrong string message with " + parameters + " as sides;");
    }

    @DataProvider(name = "for_checkGetSquareReturnValue")
    public Object[][] createDataForCheckGetSquareReturnValue() {
        return new Object[][]{
                {new ArrayList<>(Arrays.asList(1.0, 1.0, 1.0)), 0.43301270189221932338},
//                {new ArrayList<>(Arrays.asList(3.5, 3.5, 4.5)), 6.032140478304529672},
//                {new ArrayList<>(Arrays.asList(4.5, 3.5, 3.5)), 6.032140478304529672},
//                {new ArrayList<>(Arrays.asList(3.5, 4.5, 3.5)), 6.032140478304529672},
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
        Triangle triangle = new Triangle(parameters.get(0), parameters.get(1), parameters.get(2));
        assertEquals(triangle.getSquare(), expected, "method \'getSquare\' returned wrong result with " + parameters + " as sides;");
    }
}
