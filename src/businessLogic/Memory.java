package businessLogic;

import controllers.ControllerMethods;

public class Memory {

    private static double currentValue = 0.0;

    public static void memoryPlus(double argument) {
        currentValue += argument;
    }

    public static void memoryMinus(double argument) {

        currentValue -= argument;
    }

    public static void memoryClear() {
        currentValue = 0.0;
    }

    public static double memoryRecall() {
        return currentValue;
    }
}
