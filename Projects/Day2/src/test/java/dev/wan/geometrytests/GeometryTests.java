package dev.wan.geometrytests;
import dev.wan.tdd.GeoCalcImpl;
import dev.wan.tdd.GeometryCalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GeometryTests {
    GeometryCalculator calc = new GeoCalcImpl();
    // anything can be a test if you add @Test
    @Test
    void something(){
        System.out.println("test");
    }

    @Test
    void area_square_test_1(){
        //tests will always pass unless there is an error
        double area = calc.areaSquare(10);
        assert area == 100;
    }

    @Test
    void area_circle_test_1(){
        double area = calc.areaCircle(5);
        Assertions.assertEquals(area, 78.6475, 1);
        // can add delta tolerance
    }

    @Test
    void distance_test_1(){
        double len = calc.distance(0,0,3,4);
        assert len == 5;
    }
}
