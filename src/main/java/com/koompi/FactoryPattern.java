package com.koompi;

abstract class Vehicle {
    public abstract int getWheel();

    public String toString() {
        return "Wheel + " + this.getWheel();
    }
}

class Car extends Vehicle {
    int wheel;

    public Car(int wheel) throws Exception {
        if (wheel > 0) {
            this.wheel = wheel;
            return;
        }
        throw new Exception("Number cannot be negative ");
    }

    @Override
    public int getWheel() {
        return this.wheel;
    }
}

class Bike extends Vehicle {
    int wheel;

    public Bike(int wheel) throws Exception {
        if (wheel > 0) {
            this.wheel = wheel;
            return;
        }
        throw new Exception("Number cannot be negative");
    }

    @Override
    public int getWheel() {
        return this.wheel;
    }
}

class FactoryClass {
    public static Vehicle getInstace(String name, int wheel) {
        if (name == "Car") {
            try {

                return new Car(wheel);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else if (name == "Bike") {
            try {
                return new Bike(wheel);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }
}

/**
 * FactoryClass is our client slide code that is going to use our factory method
 * ! danger you need to be careful when using this code ? Should this class
 * exposed in public API * Important informaiton is highlighted this method so
 * that it conforms the API
 * 
 */
class FactoryPattern {

    public static void execute() {
        Vehicle car = FactoryClass.getInstace("Car", 4);
        Vehicle bike = FactoryClass.getInstace("Bike", 2);
        System.out.println(car.toString());
        System.out.println(bike.toString());
    }
}
