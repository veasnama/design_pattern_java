
/**
 * * Author Ma veasna * Date: Oct 6 : time: 16:52 * Builder Design pattern -
 * *Properties creational design pattern
 * Used when we have too many arguments to
 * send in constructor & it's hard to maintain the order. When we don't want to
 * send all parameters in Object initialisation (Generally we send optional
 * parameters as NULL) 
 * * Builder Design pattern - Implementation - We create a
 * 'static nested class' which contains all arguments of outer class. - As per
 * namming convention , if class name is 'Vehicle', builder classs Should be
 * Buider classs have a public constructor with all required parameters
 * 'VehicleBuilder' - Builder class should have methods for optional parameters.
 * Method will return the Builder object - A 'build()' method that will return
 * the final Object.
 * The main class 'Vehicle  such as car, bike', has private constructor 
 * so to create instance only via Builder class.
 * The main class 'Vehicle', has only getters.
 */
package com.koompi;

class NewVehicle {
    private String engine;
    private int wheel;
    private int airbag;

    private NewVehicle(NewVehicleBuilder builder) {
        this.engine = builder.engine;
        this.wheel = builder.wheel;
        this.airbag = builder.airbag;
    }

    public String getEngine() {
        return engine;
    }

    public int getWheel() {
        return wheel;
    }

    public int getAirBag() {
        return airbag;
    }

    public static class NewVehicleBuilder {
        public String engine;
        public int wheel;
        public int airbag;

        public NewVehicleBuilder(String engine, int wheel) {
            this.engine = engine;
            this.wheel = wheel;
        }

        public NewVehicleBuilder setAirBag(int airbag) {
            this.airbag = airbag;
            return this;
        }

        public NewVehicle build() {
            return new NewVehicle(this);
        }
    }
}

public class BuilderPattern {
    public static void execute() {
        NewVehicle newVehicle = new NewVehicle.NewVehicleBuilder("Car", 4).setAirBag(4).build();
        NewVehicle newBike = new NewVehicle.NewVehicleBuilder("Bike", 2).build();
        System.out.println(newVehicle.getEngine());
        System.out.println(newVehicle.getWheel());
        System.out.println(newVehicle.getAirBag());
        System.out.println(newBike.getEngine());
        System.out.println(newBike.getWheel());
        System.out.println(newBike.getAirBag());
    }
}
