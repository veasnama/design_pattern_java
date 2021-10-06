package com.koompi;

import com.koompi.Singleton.SingletonType;

public class DemoPattern {

    private static final String UNUSED = "unused";

    public enum DemoType {
        SingleTon, Factory, Builder
    }

    public DemoPattern() {

    }

    public DemoPattern(DemoType demo_type) {
        extracted(demo_type);
    }

    private void extracted(DemoType demo_type) {
        executeDemo(demo_type);
    }

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
                break;
            }
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

    @SuppressWarnings(UNUSED)
    private boolean BuilderDemo() {

        return true;
    }

    private boolean FactoryMethodDemo() {
        System.out.println("Starting factory demo.");
        FactoryPattern.execute();
        return true;
    }
}
