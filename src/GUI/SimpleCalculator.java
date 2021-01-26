package GUI;

import businessLogic.Memory;
import controllers.MemoryController;
import controllers.SimpleCalculatorController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SimpleCalculator extends JPanel {

    protected JTextArea display;
    private JButton nine, eight, seven, six, five, four, three, two, one, point, zero, equals;
    private JButton plus, minus, multiply, divide;
    private JButton sqrt, percent, delete, clear, memoryRecall, memoryClear, memoryPlus, memoryMinus;

    protected final String ERROR_TEXT = "ERROR";

    protected boolean nextDigitReplacesDisplay = false;
    //is true, when last operation was '=' or
    // there is an error on the screen
    // so next entered digit will replace the already displayed numbers
    // for example: when you enter '2' '+' '2' '=' there should be '4' on the display and next entered digit
    // will replace this '4'
    // if false, next entered digit will be appended to current number on the display

    protected javax.swing.JButton calledFunction = null;
    protected String firstArgument;   //both this fields are used for two-argument functions

    public SimpleCalculator() {

        this.setLayout(new GridBagLayout());
        this.createGUI();
        this.addActionListeners();
    }

    private void createGUI() {

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridwidth = 6;
        constraints.gridheight = 1;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(2, 2, 2, 2); //margins

        display = new JTextArea("0");
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        this.add(display, constraints);

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridwidth = 1;
        constraints.gridy = 1;
        seven = new JButton("7");
        this.add(seven, constraints);

        constraints.gridx = 1;
        eight = new JButton("8");
        this.add(eight, constraints);

        constraints.gridx = 2;
        nine = new JButton("9");
        this.add(nine, constraints);

        constraints.gridy = 2;
        constraints.gridx = 0;
        four = new JButton("4");
        this.add(four, constraints);

        constraints.gridx = 1;
        five = new JButton("5");
        this.add(five, constraints);

        constraints.gridx = 2;
        six = new JButton("6");
        this.add(six, constraints);

        constraints.gridy = 3;
        constraints.gridx = 0;
        one = new JButton("1");
        this.add(one, constraints);

        constraints.gridx = 1;
        two = new JButton("2");
        this.add(two, constraints);

        constraints.gridx = 2;
        three = new JButton("3");
        this.add(three, constraints);

        constraints.gridy = 4;
        constraints.gridx = 0;
        point = new JButton(".");
        this.add(point, constraints);

        constraints.gridx = 1;
        zero = new JButton("0");
        this.add(zero, constraints);

        constraints.gridx = 2;
        equals = new JButton("=");
        this.add(equals, constraints);

        constraints.gridy = 1;
        constraints.gridx = 3;
        plus = new JButton("+");
        this.add(plus, constraints);

        constraints.gridy = 2;
        minus = new JButton("-");
        this.add(minus, constraints);

        constraints.gridy = 3;
        multiply = new JButton("*");
        this.add(multiply, constraints);

        constraints.gridy = 4;
        divide = new JButton("/");
        this.add(divide, constraints);

        constraints.gridy = 1;
        constraints.gridx = 4;
        delete = new JButton("C");
        this.add(delete, constraints);

        constraints.gridx = 5;
        clear = new JButton("CE");
        this.add(clear, constraints);

        constraints.gridy = 2;
        constraints.gridx = 4;
        sqrt = new JButton("\u221A");
        this.add(sqrt, constraints);

        constraints.gridx = 5;
        percent = new JButton("%");
        this.add(percent, constraints);

        constraints.gridy = 3;
        constraints.gridx = 4;
        memoryRecall = new JButton("MR");
        this.add(memoryRecall, constraints);

        constraints.gridx = 5;
        memoryClear = new JButton("MC");
        this.add(memoryClear, constraints);

        constraints.gridy = 4;
        constraints.gridx = 4;
        memoryPlus = new JButton("M+");
        this.add(memoryPlus, constraints);

        constraints.gridx = 5;
        memoryMinus = new JButton("M-");
        this.add(memoryMinus, constraints);
    }

    private void addNumberToScreen(String text) {

        if (display.getText().length() >= 9) return;

        if (nextDigitReplacesDisplay) setScreenText(text);

        if (display.getText().equals("0") && !text.equals(".")) {
            setScreenText(text);
        } else display.append(text);
    }

    protected void setScreenText(String text) {

        display.setForeground(Color.BLACK);
        if (text.length() < 1) display.setText("0");
        else display.setText(text);
    }

    protected void setScreenError() {

        display.setForeground(Color.RED);
        display.setText(ERROR_TEXT);
        nextDigitReplacesDisplay = true;
    }

    protected class NumberActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            Object source = e.getSource();
            String buttonText = ((JButton) source).getText();

            if (nextDigitReplacesDisplay) setScreenText(buttonText);
            else addNumberToScreen(buttonText);

            nextDigitReplacesDisplay = false;
        }
    }

    protected class PointActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (nextDigitReplacesDisplay) {
                setScreenText("0.");
                nextDigitReplacesDisplay = false;
                return;
            }

            String currentText = display.getText();
            if (!currentText.contains(".")) {
                String newText = currentText + ".";

                display.setText(newText);
            }

            nextDigitReplacesDisplay = false;
        }
    }

    protected class DeleteActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String currentText = display.getText();

            if (currentText.length() <= 1) setScreenText("0");
            else {
                String newText = currentText.substring(0, currentText.length() - 1);
                setScreenText(newText);
            }
        }
    }

    protected class ClearActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            setScreenText("0");
            nextDigitReplacesDisplay = false;
        }
    }

    protected class TwoArgumentFunctionActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            calledFunction = (javax.swing.JButton) e.getSource();
            firstArgument = display.getText();
            nextDigitReplacesDisplay = true;
        }
    }

    protected class OneArgumentFunctionActionListener implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {

            String argument = display.getText();

            if (!argument.equals(ERROR_TEXT)) {

                try {
                    String result = SimpleCalculatorController.oneArgumentFunction(e.getSource(), argument);
                    setScreenText(result);
                } catch (IllegalArgumentException exception) {
                    setScreenError();
                } finally {
                    nextDigitReplacesDisplay = true;
                }
            }
        }
    }

    protected class EqualsActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (!nextDigitReplacesDisplay && calledFunction != null) {

                String secondArgument = display.getText();

                try {
                    String result = SimpleCalculatorController.twoArgumentFunction(calledFunction, firstArgument, secondArgument);
                    setScreenText(result);
                } catch (IllegalArgumentException exception) {
                    setScreenError();
                } finally {
                    nextDigitReplacesDisplay = true;
                    calledFunction = null;
                }
            }

        }
    }

    protected class MemoryActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String function = ((javax.swing.JButton) e.getSource()).getText();

            switch (function) {

                case "M+" -> {
                    String value = display.getText();
                    if (!value.equals(ERROR_TEXT)) MemoryController.memoryPlus(value);
                }

                case "M-" -> {
                    String value = display.getText();
                    if (!value.equals(ERROR_TEXT)) MemoryController.memoryMinus(value);
                }

                case "MC" -> MemoryController.memoryClear();

                case "MR" -> {
                    setScreenText(MemoryController.memoryRecall());
                    nextDigitReplacesDisplay = false;
                }
            }
        }
    }

    private void addActionListeners() {

        zero.addActionListener(new NumberActionListener());
        one.addActionListener(new NumberActionListener());
        two.addActionListener(new NumberActionListener());
        three.addActionListener(new NumberActionListener());
        four.addActionListener(new NumberActionListener());
        five.addActionListener(new NumberActionListener());
        six.addActionListener(new NumberActionListener());
        seven.addActionListener(new NumberActionListener());
        eight.addActionListener(new NumberActionListener());
        nine.addActionListener(new NumberActionListener());

        point.addActionListener(new PointActionListener());

        delete.addActionListener(new DeleteActionListener());
        clear.addActionListener(new ClearActionListener());

        plus.addActionListener(new TwoArgumentFunctionActionListener());
        minus.addActionListener(new TwoArgumentFunctionActionListener());
        multiply.addActionListener(new TwoArgumentFunctionActionListener());
        divide.addActionListener(new TwoArgumentFunctionActionListener());

        equals.addActionListener(new EqualsActionListener());

        sqrt.addActionListener(new OneArgumentFunctionActionListener());
        percent.addActionListener(new OneArgumentFunctionActionListener());

        memoryPlus.addActionListener(new MemoryActionListener());
        memoryMinus.addActionListener(new MemoryActionListener());
        memoryClear.addActionListener(new MemoryActionListener());
        memoryRecall.addActionListener(new MemoryActionListener());
    }
}
