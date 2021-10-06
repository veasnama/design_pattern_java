package com.koompi;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FactoryPatternTest {

    @Test
    public void CarShouldHaveFourWheel() {
        Vehicle car = FactoryClass.getInstace("Car", 4);
        assertEquals(car.toString(), "Wheel + 4");
    }

    @Test
    public void BikeShouldHaveTwoWheel() {
        Vehicle bike = FactoryClass.getInstace("Bike", 2);
        assertEquals(bike.toString(), "Wheel + 2");
    }
}
