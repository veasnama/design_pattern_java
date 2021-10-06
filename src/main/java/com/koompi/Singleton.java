/**
 * Author : Ma veasna, Khmer
 * Date: Oct 6 , time: 15:20 PM
 * Singleton Design pattern Properties
 * ! Creational design pattern
 * ! Only one instance of the class should exist
 * ! Other classes should be able to get instance of Single class
 * ! Used in Logging, Cache, Session, Drivers
 * License: Destiny​​ - វាសនា
 */
package com.koompi;

public class Singleton {
    public enum SingletonType {
        Eager, Lazy, SynchronizedMethod, SynchronizedBlock
    }

    private static Singleton lazy_instance = null;
    private static Singleton eager_instance = new Singleton();

    private Singleton() {
        System.out.println("You're not allowed to call me directory but calling my public methods.");
    }

    /**
     * this method is very short but self-explained
     * 
     * @return a single instance like other methods
     */
    private static Singleton Eager_Singleton() {
        return eager_instance;
    }

    /**
     * this method is called lazy singleton which check the instance to ensure that
     * there is only one instance get created
     * 
     * @return a single instance that client ask for.
     */
    private static Singleton Lazy_Singleton() {

        if (lazy_instance != null) {
            return lazy_instance;
        }
        lazy_instance = new Singleton();
        return lazy_instance;
    }

    /**
     * this method is called synchronized singleton considering as a thread safe way
     * of implementing singleton
     * 
     * @return a single instance when mulitiple thread trying to create instances at
     *         the same it will be created synchroniously
     */
    private static synchronized Singleton SynchronizedSingleton() {
        if (lazy_instance == null) {
            lazy_instance = new Singleton();
            return lazy_instance;
        }
        return lazy_instance;
    }

    /**
     * this method is consider as a thread safe way of creating singleton instance
     * with a synchronized blockd i don't know if this actually forces object to be
     * created synchroniously
     * 
     * @return a single instnace
     */
    private static Singleton SynchronizedBlockSingleton() {
        if (lazy_instance == null) {
            synchronized (Singleton.class) {
                lazy_instance = new Singleton();
                return lazy_instance;
            }
        }
        return lazy_instance;
    }

    /**
     * This method is a public API that allows client to access our Sngleton Class
     */
    public static Singleton SingleTonAccesser(SingletonType type) {
        Singleton instance = null;
        switch (type) {
            case Lazy:
                instance = Lazy_Singleton();
                break;
            case Eager:
                instance = Eager_Singleton();
                break;
            case SynchronizedBlock:
                instance = SynchronizedBlockSingleton();
                break;
            case SynchronizedMethod:
                instance = SynchronizedSingleton();
                break;
            default:
                break;
        }

        return instance;
    }
}
