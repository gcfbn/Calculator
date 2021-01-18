package businessLogic;

import javax.swing.*;

public class BusinessLogic {

    public static String twoArgumentFunction(Object source, String firstArgument, String secondArgument)
            throws IllegalArgumentException {

        String function = ((JButton) source).getText();

        double doubleFirstArgument = Double.parseDouble(Functions.removeUnnecessaryDot(firstArgument));
        double doubleSecondArgument = Double.parseDouble(Functions.removeUnnecessaryDot(secondArgument));

        double doubleResult;

        switch (function) {

            case "+":
                doubleResult = doubleFirstArgument + doubleSecondArgument;
                break;

            case "-":
                doubleResult = doubleFirstArgument - doubleSecondArgument;
                break;

            case "*":
                doubleResult = doubleFirstArgument * doubleSecondArgument;
                break;

            case "/": {
                if (doubleSecondArgument == 0.0) throw new IllegalArgumentException();
                else doubleResult = doubleFirstArgument / doubleSecondArgument;
                break;
            }

            default:
                return "";
        }

        String stringResult = Functions.removeUnnecessaryFractionalPart(doubleResult);
        return Functions.roundToNineDigits(stringResult);
    }

    public static String oneArgumentFunction(Object source, String argument) throws IllegalArgumentException {

        String function = ((JButton) source).getText();
        System.out.println("function: " + function);
        double doubleArgument = Double.parseDouble(Functions.removeUnnecessaryDot(argument));
        System.out.println("arg: " + doubleArgument);

        double doubleResult;

        switch (function) {

            case "%":
                doubleResult = doubleArgument * 0.01;
                System.out.println("xyz");
                break;

            case "\u221A":
                if (doubleArgument < 0) throw new IllegalArgumentException();
                else doubleResult = Math.sqrt(doubleArgument);
                break;

            default:
                doubleResult = 0;
                System.out.println("abc");
                break;
        }

        String stringResult = Functions.removeUnnecessaryFractionalPart(doubleResult);
        return Functions.roundToNineDigits(stringResult);


    }

}