package controllers;

import businessLogic.Memory;

public class MemoryController {

    public static void memoryPlus(String argument){

        double doubleArgument = Double.parseDouble(ControllerMethods.removeUnnecessaryDot(argument));
        Memory.memoryPlus(doubleArgument);
    }

    public static void memoryMinus(String argument){

        double doubleArgument = Double.parseDouble(ControllerMethods.removeUnnecessaryDot(argument));
        Memory.memoryMinus(doubleArgument);
    }

    public static void memoryClear(){ Memory.memoryClear();}

    public static String memoryRecall(){

        double doubleValue = Memory.memoryRecall();

        return ControllerMethods.formatResultToString(doubleValue);
    }
}
