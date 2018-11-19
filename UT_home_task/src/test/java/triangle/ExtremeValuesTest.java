package triangle;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.testng.Assert.assertFalse;

public class ExtremeValuesTest {


    @DataProvider(name = "for_checkInfinity_AsTriangleSide")
    public Object[][] createDataForСheckInfinity_AsTriangleSide() {
        return new Object[][]{
                {new ArrayList<>(Arrays.asList(1.0, Double.POSITIVE_INFINITY, 1.0))},
                {new ArrayList<>(Arrays.asList(1.0, 1.0, Double.POSITIVE_INFINITY))},
                {new ArrayList<>(Arrays.asList(Double.POSITIVE_INFINITY, 1.0, 1.0))},

                {new ArrayList<>(Arrays.asList(1.0, Double.NEGATIVE_INFINITY, 1.0))},
                {new ArrayList<>(Arrays.asList(1.0, 1.0, Double.NEGATIVE_INFINITY))},
                {new ArrayList<>(Arrays.asList(Double.NEGATIVE_INFINITY, 1.0, 1.0))},
        };
    }

    @Test(dataProvider = "for_checkInfinity_AsTriangleSide")
    public void checkInfinity_AsTriangleSide(ArrayList<Double> parameters) {
        Double side_a = parameters.get(0);
        Double side_b = parameters.get(1);
        Double side_c = parameters.get(2);
        new Triangle(side_a, side_b, side_c);
        assertFalse(Double.isInfinite(side_a));
        assertFalse(Double.isInfinite(side_b));
        assertFalse(Double.isInfinite(side_c));
    }


    @DataProvider(name = "for_checkNaN_AsTriangleSide")
    public Object[][] createDataForСheckNaN_AsTriangleSide() {
        return new Object[][]{
                {new ArrayList<>(Arrays.asList(1.0, Math.sqrt(-8), 1.0))},
                {new ArrayList<>(Arrays.asList(1.0, 1.0, Math.sqrt(-8)))},
                {new ArrayList<>(Arrays.asList(Math.sqrt(-8), 1.0, 1.0))},
        };
    }

    @Test(dataProvider = "for_checkNaN_AsTriangleSide")
    public void checkNaN_AsTriangleSide(ArrayList<Double> parameters) {
        Double side_a = parameters.get(0);
        Double side_b = parameters.get(1);
        Double side_c = parameters.get(2);
        new Triangle(side_a, side_b, side_c);
        assertFalse(Double.isNaN(side_a));
        assertFalse(Double.isNaN(side_b));
        assertFalse(Double.isNaN(side_c));
    }
}