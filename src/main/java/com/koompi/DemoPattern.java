package com.koompi;

import java.util.ArrayList;

import com.koompi.Singleton.SingletonType;

/**
 * Demoable is consider a better good approach because every time we want to
 * show a new demo we just need to create a class and implement demo fucntion
 * that's it
 */
interface Demoable {
    public boolean demo();
}

class SingleTonDemo implements Demoable {
    public SingleTonDemo() {

    }

    @Override
    public boolean demo() {

        System.out.println("========== Factory Design Pattern Demo =========");
        Singleton object1 = Singleton.SingleTonAccesser(SingletonType.Lazy);
        Singleton object2 = Singleton.SingleTonAccesser(SingletonType.Eager);
        Singleton object3 = Singleton.SingleTonAccesser(SingletonType.SynchronizedMethod);
        Singleton object4 = Singleton.SingleTonAccesser(SingletonType.SynchronizedBlock);
        System.out.println("Lazy singleton = " + object1.hashCode());
        // the reason why eager singleton has different hashcode because we create a
        // different static varible in the Singleton class
        System.out.println("Eager singleton = " + object2.hashCode());
        System.out.println("SynchronizeMethod singleton = " + object3.hashCode());
        System.out.println("Synchronized block singleton = " + object4.hashCode());
        return true;
    }
}

class FactoryDemo implements Demoable {
    public FactoryDemo() {

    }

    @Override
    public boolean demo() {

        System.out.println("========== Factory Design Pattern Demo =========");
        System.out.println("Starting factory demo.");
        FactoryPattern.execute();
        return true;
    }
}

class BuilderDemo implements Demoable {
    public BuilderDemo() {

    }

    @Override
    public boolean demo() {

        System.out.println("========== Builder Design Pattern Demo =========");
        System.out.println("Start");
        BuilderPattern.execute();
        return true;
    }
}

class PrototypeDemo implements Demoable {
    public PrototypeDemo() {
    }

    @Override
    public boolean demo() {

        System.out.println("========== Prototype Design Pattern Demo =========");
        PrototypePattern.execute();
        return true;
    }
}

public class DemoPattern {

    private ArrayList<Demoable> poly_demo = null;
    private SingleTonDemo singleTonDemo;
    private FactoryDemo factoryDemo;
    private BuilderDemo builderDemo;
    private PrototypeDemo prototypeDemo;

    public enum DemoType {
        SingleTon, Factory, Builder, Prototype
    }

    public DemoPattern() {
        poly_demo = new ArrayList<>();
        this.singleTonDemo = new SingleTonDemo();
        this.factoryDemo = new FactoryDemo();
        this.builderDemo = new BuilderDemo();
        this.prototypeDemo = new PrototypeDemo();
        /**
         * another way to add object into array is simply by
         * 
         * poly_demo.add(new SingleTonDemo());
         * 
         * poly_demo.add(new FactoryDemo());
         * 
         * poly_demo.add(new BuilderDemo())
         */
        poly_demo.add(singleTonDemo);
        poly_demo.add(factoryDemo);
        poly_demo.add(builderDemo);
        poly_demo.add(prototypeDemo);
    }

    public DemoPattern(DemoType demo_type) {
        extracted(demo_type);
    }

    private void extracted(DemoType demo_type) {
        executeDemo(demo_type);
    }

    // good way of readability but we have to change code in the function mantuuly
    // switch case
    public void executeDemo(DemoType demo) {

        switch (demo) {
            case SingleTon: {
                SingleTonDemo();
                break;
            }
            case Factory: {
                FactoryMethodDemo();
                break;
            }
            case Builder: {
                BuilderDemo();
                break;
            }
        }
    }

    public void execute_with_interface() {
        for (Demoable demoable : poly_demo) {
            demoable.demo();
        }
    }

    /**
     * Used for demo singleTon design pattern !it's very important to notice that. !
     * danger this is not for enterprise purpose don't use it anywhere.
     * 
     * @return boolean indicates whether we run success or fail
     */
    private boolean SingleTonDemo() {

        Singleton object1 = Singleton.SingleTonAccesser(SingletonType.Lazy);
        Singleton object2 = Singleton.SingleTonAccesser(SingletonType.Eager);
        Singleton object3 = Singleton.SingleTonAccesser(SingletonType.SynchronizedMethod);
        Singleton object4 = Singleton.SingleTonAccesser(SingletonType.SynchronizedBlock);
        System.out.println("Lazy singleton = " + object1.hashCode());
        // the reason why eager singleton has different hashcode because we create a
        // different static varible in the Singleton class
        System.out.println("Eager singleton = " + object2.hashCode());
        System.out.println("SynchronizeMethod singleton = " + object3.hashCode());
        System.out.println("Synchronized block singleton = " + object4.hashCode());

        return true;
    }

    private boolean BuilderDemo() {
        System.out.println("Start");
        BuilderPattern.execute();
        return true;
    }

    private boolean FactoryMethodDemo() {
        System.out.println("Starting factory demo.");
        FactoryPattern.execute();
        return true;
    }
}
