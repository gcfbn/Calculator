package businessLogic;

public class BusinessLogic {

    public static double twoArgumentFunction(String function, double firstArgument, double secondArgument)
            throws IllegalArgumentException {

        switch (function) {
            case "+":
                return firstArgument + secondArgument;

            case "-":
                return firstArgument - secondArgument;

            case "*":
                return firstArgument * secondArgument;
            case "/": {
                if (secondArgument == 0.0) throw new IllegalArgumentException();
                else return firstArgument / secondArgument;
            }
            case "x^y":
                return Math.pow(firstArgument, secondArgument);
            case "nth root": {
                if (firstArgument == 0.0) throw new IllegalArgumentException();
                else return Math.pow(secondArgument, 1.0 / firstArgument);
            }
            case "log_a b": {
                if (firstArgument <= 0 || firstArgument == 1 || secondArgument <= 0)
                    throw new IllegalArgumentException();
                else return Math.log(secondArgument) / Math.log(firstArgument);
            }
            default:
                throw new IllegalArgumentException();
        }
    }

    public static double oneArgumentFunction(String function, double argument) throws IllegalArgumentException {

        switch (function) {

            case "%":
                return argument * 0.01;

            case "\u221A":
                if (argument < 0.0) throw new IllegalArgumentException();
                else return Math.sqrt(argument);

            case "ln":
                if (argument <= 0.0) throw new IllegalArgumentException();
                else return Math.log(argument);

            default:
                throw new IllegalArgumentException();
        }
    }

    public static double trigonometricFunction(String function, double argument) {

        switch (function) {

            case "sin":
                return Math.sin(argument);

            case "cos":
                return Math.cos(argument);

            case "tan":
                if (Math.cos(argument) == 0) throw new IllegalArgumentException();
                return Math.sin(argument) / Math.cos(argument);

            case "ctg":

                if (Math.sin(argument) == 0) throw new IllegalArgumentException();
                return Math.cos(argument) / Math.sin(argument);

            default:
                throw new IllegalArgumentException();
        }
    }

    public static double arcusFunction(String function, double argument) {


        switch (function) {

            case "arcsin":
                if (argument < -1 || argument > 1) throw new IllegalArgumentException();
                else return Math.asin(argument);

            case "arccos":
                if (argument < -1 || argument > 1) throw new IllegalArgumentException();
                else return Math.acos(argument);

            case "arctan":
                return Math.atan(argument);

            case "arcctg":
                return Math.PI / 2 - Math.atan(argument);

            default: throw new IllegalArgumentException();
        }
    }
}
