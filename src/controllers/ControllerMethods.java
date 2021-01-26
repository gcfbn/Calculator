package controllers;

public class ControllerMethods {

    public static String removeUnnecessaryDot(String argument) {

        if (argument.charAt(argument.length() - 1) == '.') return argument.substring(0, argument.length() - 1);
        else return argument;
    }

    public static String formatResultToString(double result) {

        String stringResult = ((int) result == result) ? Integer.toString((int) result) : Double.toString(result);

        return (stringResult.length() > 9) ? stringResult.substring(0, 9) : stringResult;
    }
}
