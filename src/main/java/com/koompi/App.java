package com.koompi;

import com.koompi.DemoPattern.DemoType;

/**
 * Hello world!
 *
 */
public class App {
    private static final String UNUSED = "unused";

    public static void main(String[] args) {
        @SuppressWarnings(UNUSED)
        DemoPattern demo = new DemoPattern();
        // demo.executeDemo(DemoType.SingleTon);
        // demo.executeDemo(DemoType.Factory);
        // demo.executeDemo(DemoType.Builder);
        demo.execute_with_interface();
        /**
         * Enum class with Planet example
         */

        // EnumClass.executeEnumClass(175);
    }

}
