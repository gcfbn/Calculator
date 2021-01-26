package controllers;

import businessLogic.BusinessLogic;

import javax.swing.*;

public class SimpleCalculatorController {

    public static String oneArgumentFunction(Object source, String argument) throws IllegalArgumentException {

        String function = ((JButton) source).getText();
        double doubleArgument = Double.parseDouble(ControllerMethods.removeUnnecessaryDot(argument));

        double doubleResult = BusinessLogic.oneArgumentFunction(function, doubleArgument); //throws an exception

        return ControllerMethods.formatResultToString(doubleResult);
    }

    public static String twoArgumentFunction(Object source, String firstArgument, String secondArgument)
            throws IllegalArgumentException {

        String function = ((JButton) source).getText();

        double doubleFirstArgument = Double.parseDouble(ControllerMethods.removeUnnecessaryDot(firstArgument));
        double doubleSecondArgument = Double.parseDouble(ControllerMethods.removeUnnecessaryDot(secondArgument));

        double doubleResult = BusinessLogic.twoArgumentFunction(function, doubleFirstArgument, doubleSecondArgument);
            //throws an exception

        return ControllerMethods.formatResultToString(doubleResult);
    }
}
