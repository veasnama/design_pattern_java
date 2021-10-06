package com.koompi;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.koompi.Singleton.SingletonType;

/**
 * SingleTonTest which tests the equation of two objects
 */
public class SingleTonTest {

    @Test
    public void TwoSingleObjectShouldEqual() {
        Singleton obj1 = Singleton.SingleTonAccesser(SingletonType.SynchronizedBlock);
        Singleton obj2 = Singleton.SingleTonAccesser(SingletonType.SynchronizedMethod);
        assertEquals(obj1, obj2);
    }
}