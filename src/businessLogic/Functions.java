package businessLogic;

public class Functions {

    protected static String removeUnnecessaryDot(String argument) {

        if (argument.charAt(argument.length() - 1) == '.') return argument.substring(0, argument.length() - 1);
        else return argument;
    }

    protected static String removeUnnecessaryFractionalPart(double argument) {

        if ((int) argument == argument) return Integer.toString((int) argument);
        else return Double.toString(argument);
    }

    protected static String roundToNineDigits(String argument) {

        if (argument.length() > 9) return argument.substring(0, 9);
        else return argument;
    }
}
