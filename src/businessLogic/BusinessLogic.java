package businessLogic;

import javax.swing.*;

public class BusinessLogic {

    public static String twoArgumentFunction(Object source, String firstArgument, String secondArgument)
            throws IllegalArgumentException {

        String function = ((JButton) source).getText();

        double doubleFirstArgument = Double.parseDouble(Functions.removeUnnecessaryDot(firstArgument));
        double doubleSecondArgument = Double.parseDouble(Functions.removeUnnecessaryDot(secondArgument));

        double doubleResult = 0;

        switch (function) {
            case "+" -> doubleResult = doubleFirstArgument + doubleSecondArgument;
            case "-" -> doubleResult = doubleFirstArgument - doubleSecondArgument;
            case "*" -> doubleResult = doubleFirstArgument * doubleSecondArgument;
            case "/" -> {
                if (doubleSecondArgument == 0.0) throw new IllegalArgumentException();
                else doubleResult = doubleFirstArgument / doubleSecondArgument;
            }
            case "x^y" -> doubleResult = Math.pow(doubleFirstArgument, doubleSecondArgument);
            case "nth root" -> {
                if (doubleFirstArgument == 0.0) throw new IllegalArgumentException();
                else doubleResult = Math.pow(doubleSecondArgument, 1.0 / doubleFirstArgument);
            }
            case "log_a b" -> {
                if (doubleFirstArgument <= 0 || doubleFirstArgument == 1 || doubleSecondArgument <= 0)
                    throw new IllegalArgumentException();
                else doubleResult = Math.log(doubleSecondArgument) / Math.log(doubleFirstArgument);
            }
        }

        String stringResult = Functions.removeUnnecessaryFractionalPart(doubleResult);
        return Functions.roundToNineDigits(stringResult);
    }

    public static String oneArgumentFunction(Object source, String argument) throws IllegalArgumentException {

        String function = ((JButton) source).getText();
        double doubleArgument = Double.parseDouble(Functions.removeUnnecessaryDot(argument));

        double doubleResult = 0;

        switch (function) {

            case "%":
                doubleResult = doubleArgument * 0.01;
                break;

            case "\u221A":
                if (doubleArgument < 0.0) throw new IllegalArgumentException();
                else doubleResult = Math.sqrt(doubleArgument);
                break;

            case "ln":
                if (doubleArgument <= 0.0) throw new IllegalArgumentException();
                else doubleResult = Math.log(doubleArgument);
        }

        String stringResult = Functions.removeUnnecessaryFractionalPart(doubleResult);
        return Functions.roundToNineDigits(stringResult);


    }

    public static String trigonometricFunction(Object source, String argument, boolean useDegrees) {

        String function = ((JButton) source).getText();
        double doubleArgument = Double.parseDouble(Functions.removeUnnecessaryDot(argument));

        if (useDegrees) doubleArgument = doubleArgument * Math.PI / 180; //converts from deg to rad

        double doubleResult = 0;

        switch (function) {

            case "sin":
                doubleResult = Math.sin(doubleArgument);
                break;

            case "cos":
                doubleResult = Math.cos(doubleArgument);
                break;

            case "tan":
                if (Math.cos(doubleArgument) == 0) throw new IllegalArgumentException();
                else doubleResult = Math.sin(doubleArgument) / Math.cos(doubleArgument);

                break;

            case "ctg":

                if (Math.sin(doubleArgument) == 0) throw new IllegalArgumentException();
                else doubleResult = Math.cos(doubleArgument) / Math.sin(doubleArgument);

                break;

        }

        String stringResult = Functions.removeUnnecessaryFractionalPart(doubleResult);
        return Functions.roundToNineDigits(stringResult);
    }

    public static String arcusFunction(Object source, String argument, boolean useDegrees) {

        String function = ((JButton) source).getText();
        double doubleArgument = Double.parseDouble(Functions.removeUnnecessaryDot(argument));

        double doubleResult = 0;

        switch (function) {

            case "arcsin":
                if (doubleArgument < -1 || doubleArgument > 1) throw new IllegalArgumentException();
                else doubleResult = Math.asin(doubleArgument);
                break;

            case "arccos":
                if (doubleArgument < -1 || doubleArgument > 1) throw new IllegalArgumentException();
                else doubleResult = Math.acos(doubleArgument);
                break;

            case "arctan":
                doubleResult = Math.atan(doubleArgument);
                break;

            case "arcctg":
                doubleResult = Math.PI / 2 - Math.atan(doubleArgument);
                break;
        }

        if (useDegrees) doubleResult = doubleResult * 180 / Math.PI;

        String stringResult = Functions.removeUnnecessaryFractionalPart(doubleResult);
        return Functions.roundToNineDigits(stringResult);
    }

}
