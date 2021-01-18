package GUI;

import javax.swing.*;

import businessLogic.BusinessLogic;
import businessLogic.Memory;
import buttons.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JPanel {

    private JTextArea display;
    private OtherButton nine, eight, seven, six, five, four, three, two, one, point, zero, equals;
    private TwoArgumentFunction plus, minus, multiply, divide;
    private OtherButton sqrt, percent, delete, clear, memoryRecall, memoryClear, memoryPlus, memoryMinus;
    private final Memory memory;

    private final String ERROR_TEXT = "ERROR";

    private boolean nextDigitReplacesDisplay = false;
    //is true, when last operation was '=' or
    // there is an error on the screen
    // so next entered digit will replace the already displayed numbers
    // for example: when you enter '2' '+' '2' '=' there should be '4' on the display and next entered digit
    // will replace this '4'
    // if false, next entered digit will be appended to current number on the display

    private JButton calledFunction = null;
    private String firstArgument;   //both this fields are used for two-argument functions

    public SimpleCalculator() {

        this.memory = new Memory();

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

        constraints.fill = GridBagConstraints.NONE;
        constraints.gridwidth = 1;
        constraints.gridy = 1;
        seven = new OtherButton("7");
        this.add(seven, constraints);

        constraints.gridx = 1;
        eight = new OtherButton("8");
        this.add(eight, constraints);

        constraints.gridx = 2;
        nine = new OtherButton("9");
        this.add(nine, constraints);

        constraints.gridy = 2;
        constraints.gridx = 0;
        four = new OtherButton("4");
        this.add(four, constraints);

        constraints.gridx = 1;
        five = new OtherButton("5");
        this.add(five, constraints);

        constraints.gridx = 2;
        six = new OtherButton("6");
        this.add(six, constraints);

        constraints.gridy = 3;
        constraints.gridx = 0;
        one = new OtherButton("1");
        this.add(one, constraints);

        constraints.gridx = 1;
        two = new OtherButton("2");
        this.add(two, constraints);

        constraints.gridx = 2;
        three = new OtherButton("3");
        this.add(three, constraints);

        constraints.gridy = 4;
        constraints.gridx = 0;
        point = new OtherButton(".");
        this.add(point, constraints);

        constraints.gridx = 1;
        zero = new OtherButton("0");
        this.add(zero, constraints);

        constraints.gridx = 2;
        equals = new OtherButton("=");
        this.add(equals, constraints);

        constraints.gridy = 1;
        constraints.gridx = 3;
        plus = new TwoArgumentFunction("+");
        this.add(plus, constraints);

        constraints.gridy = 2;
        minus = new TwoArgumentFunction("-");
        this.add(minus, constraints);

        constraints.gridy = 3;
        multiply = new TwoArgumentFunction("*");
        this.add(multiply, constraints);

        constraints.gridy = 4;
        divide = new TwoArgumentFunction("/");
        this.add(divide, constraints);

        constraints.gridy = 1;
        constraints.gridx = 4;
        delete = new OtherButton("C");
        this.add(delete, constraints);

        constraints.gridx = 5;
        clear = new OtherButton("CE");
        this.add(clear, constraints);

        constraints.gridy = 2;
        constraints.gridx = 4;
        sqrt = new OtherButton("\u221A");
        this.add(sqrt, constraints);

        constraints.gridx = 5;
        percent = new OtherButton("%");
        this.add(percent, constraints);

        constraints.gridy = 3;
        constraints.gridx = 4;
        memoryRecall = new OtherButton("MR");
        this.add(memoryRecall, constraints);

        constraints.gridx = 5;
        memoryClear = new OtherButton("MC");
        this.add(memoryClear, constraints);

        constraints.gridy = 4;
        constraints.gridx = 4;
        memoryPlus = new OtherButton("M+");
        this.add(memoryPlus, constraints);

        constraints.gridx = 5;
        memoryMinus = new OtherButton("M-");
        this.add(memoryMinus, constraints);
    }

    private void addNumberToScreen(String text) {

        if (display.getText().length() >= 9) return;

        if (nextDigitReplacesDisplay) setScreenText(text);

        if (display.getText().equals("0") && !text.equals(".")) {
            setScreenText(text);
        } else display.append(text);
    }

    private void setScreenText(String text) {

        display.setForeground(Color.BLACK);
        if (text.length() < 1) display.setText("0");
        else display.setText(text);
    }

    private void setScreenError() {

        display.setForeground(Color.RED);
        display.setText(ERROR_TEXT);
        nextDigitReplacesDisplay = true;
    }

    class NumberActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            Object source = e.getSource();
            String buttonText = ((OtherButton) source).getText();

            if (nextDigitReplacesDisplay) setScreenText(buttonText);
            else addNumberToScreen(buttonText);

            nextDigitReplacesDisplay = false;
        }
    }

    class PointActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String currentText = display.getText();
            if (!currentText.contains(".")) {
                String newText = currentText + ".";

                display.setText(newText);
            }

            nextDigitReplacesDisplay = false;
        }
    }

    class DeleteActionListener implements ActionListener {

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

    class ClearActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            setScreenText("0");
            nextDigitReplacesDisplay = false;
        }
    }

    class TwoArgumentFunctionActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            calledFunction = (JButton) e.getSource();
            firstArgument = display.getText();
            nextDigitReplacesDisplay = true;
        }
    }

    class OneArgumentFunctionActionListener implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent e) {

            String argument = display.getText();

            if (!argument.equals(ERROR_TEXT)) {

                try {
                    String result = BusinessLogic.oneArgumentFunction(e.getSource(), argument);
                    setScreenText(result);
                } catch (IllegalArgumentException exception) {
                    setScreenError();
                } finally {
                    nextDigitReplacesDisplay = false;
                }
            }
        }
    }

    class EqualsActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (!nextDigitReplacesDisplay) {

                String result;
                String secondArgument = display.getText();

                try {
                    result = BusinessLogic.twoArgumentFunction(calledFunction, firstArgument, secondArgument);
                    setScreenText(result);
                } catch (IllegalArgumentException exception) {
                    setScreenError();
                } finally {
                    nextDigitReplacesDisplay = true;
                }
            }

        }
    }

    class MemoryActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String function = ((JButton) e.getSource()).getText();

            switch (function) {

                case "M+" -> {
                    String value = display.getText();
                    if (!value.equals(ERROR_TEXT)) memory.memoryPlus(value);
                }

                case "M-" -> {
                    String value = display.getText();
                    if (!value.equals(ERROR_TEXT)) memory.memoryMinus(value);
                }

                case "MC" -> memory.memoryClear();

                case "MR" -> {
                    setScreenText(memory.memoryRecall());
                    nextDigitReplacesDisplay = false;
                }
            }
            System.out.println(memory.memoryRecall());
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
