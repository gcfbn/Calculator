package controllers;

import businessLogic.BusinessLogic;

import javax.swing.*;

public class ScientificCalculatorController {

    public static String trigonometricFunction(Object source, String argument, boolean useDegrees)
            throws IllegalArgumentException {

        String function = ((JButton) source).getText();
        double doubleArgument = Double.parseDouble(ControllerMethods.removeUnnecessaryDot(argument));

        if (useDegrees) doubleArgument = doubleArgument * Math.PI / 180; //converts from deg to rad

        double doubleResult = BusinessLogic.trigonometricFunction(function, doubleArgument);
        //throws an exception

        return ControllerMethods.formatResultToString(doubleResult);
    }

    public static String arcusFunction(Object source, String argument, boolean useDegrees)
            throws IllegalArgumentException {

        String function = ((JButton) source).getText();
        double doubleArgument = Double.parseDouble(ControllerMethods.removeUnnecessaryDot(argument));

        double doubleResult = BusinessLogic.arcusFunction(function, doubleArgument); //throws an exception

        if (useDegrees) doubleResult = doubleResult * 180 / Math.PI; //converts from rad to deg

        return ControllerMethods.formatResultToString(doubleResult);
    }
}
