package businessLogic;

public class Memory {

    private double currentValue = 0.0;

    public void memoryPlus(String argument) {

        double doubleArgument = Double.parseDouble(Functions.removeUnnecessaryDot(argument));

        currentValue += doubleArgument;
    }

    public void memoryMinus(String argument) {

        double doubleArgument = Double.parseDouble(Functions.removeUnnecessaryDot(argument));

        currentValue -= doubleArgument;
    }

    public void memoryClear() {
        currentValue = 0.0;
    }

    public String memoryRecall() {

        return Functions.removeUnnecessaryFractionalPart(currentValue);
    }
}
