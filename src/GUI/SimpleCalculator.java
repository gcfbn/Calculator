package GUI;

import javax.swing.*;

import businessLogic.BusinessLogic;
import buttons.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame {

    private JTextArea display;
    private OtherButton nine, eight, seven, six, five, four, three, two, one, point, zero, equals;
    private TwoArgumentFunction plus, minus, multiply, divide;
    private OtherButton sqrt, percent, delete, clear, memoryRecall, memoryClear, memoryPlus, memoryMinus;

    private final String ERROR_TEXT = "ERROR";

    private boolean nextDigitReplacesDisplay = false;  //is true, when last operation was '=' or
    // there is an error on the screen
    // so next entered digit will replace the already displayed numbers
    // for example: when you enter '2' '+' '2' '=' there should be '4' on the display and next entered digit
    // will replace this '4'
    // if false, next entered digit will be appended to current number on the display

    private JButton calledFunction = null;
    private String firstArgument;   //both this fields are used for two-argument functions

    public SimpleCalculator() {

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        this.createGUI();
        this.pack();
        this.addActionListeners();
        this.setResizable(false);
        this.setVisible(true);


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
        this.getContentPane().add(display, constraints);

        constraints.fill = GridBagConstraints.NONE;
        constraints.gridwidth = 1;
        constraints.gridy = 1;
        seven = new OtherButton("7");
        this.getContentPane().add(seven, constraints);

        constraints.gridx = 1;
        eight = new OtherButton("8");
        this.getContentPane().add(eight, constraints);

        constraints.gridx = 2;
        nine = new OtherButton("9");
        this.getContentPane().add(nine, constraints);

        constraints.gridy = 2;
        constraints.gridx = 0;
        four = new OtherButton("4");
        this.getContentPane().add(four, constraints);

        constraints.gridx = 1;
        five = new OtherButton("5");
        this.getContentPane().add(five, constraints);

        constraints.gridx = 2;
        six = new OtherButton("6");
        this.getContentPane().add(six, constraints);

        constraints.gridy = 3;
        constraints.gridx = 0;
        one = new OtherButton("1");
        this.getContentPane().add(one, constraints);

        constraints.gridx = 1;
        two = new OtherButton("2");
        this.getContentPane().add(two, constraints);

        constraints.gridx = 2;
        three = new OtherButton("3");
        this.getContentPane().add(three, constraints);

        constraints.gridy = 4;
        constraints.gridx = 0;
        point = new OtherButton(".");
        this.getContentPane().add(point, constraints);

        constraints.gridx = 1;
        zero = new OtherButton("0");
        this.getContentPane().add(zero, constraints);

        constraints.gridx = 2;
        equals = new OtherButton("=");
        this.getContentPane().add(equals, constraints);

        constraints.gridy = 1;
        constraints.gridx = 3;
        plus = new TwoArgumentFunction("+");
        this.getContentPane().add(plus, constraints);

        constraints.gridy = 2;
        minus = new TwoArgumentFunction("-");
        this.getContentPane().add(minus, constraints);

        constraints.gridy = 3;
        multiply = new TwoArgumentFunction("*");
        this.getContentPane().add(multiply, constraints);

        constraints.gridy = 4;
        divide = new TwoArgumentFunction("/");
        this.getContentPane().add(divide, constraints);

        constraints.gridy = 1;
        constraints.gridx = 4;
        delete = new OtherButton("C");
        this.getContentPane().add(delete, constraints);

        constraints.gridx = 5;
        clear = new OtherButton("CE");
        this.getContentPane().add(clear, constraints);

        constraints.gridy = 2;
        constraints.gridx = 4;
        sqrt = new OtherButton("\u221A");
        this.getContentPane().add(sqrt, constraints);

        constraints.gridx = 5;
        percent = new OtherButton("%");
        this.getContentPane().add(percent, constraints);

        constraints.gridy = 3;
        constraints.gridx = 4;
        memoryRecall = new OtherButton("MR");
        this.getContentPane().add(memoryRecall, constraints);

        constraints.gridx = 5;
        memoryClear = new OtherButton("MC");
        this.getContentPane().add(memoryClear, constraints);

        constraints.gridy = 4;
        constraints.gridx = 4;
        memoryPlus = new OtherButton("M+");
        this.getContentPane().add(memoryPlus, constraints);

        constraints.gridx = 5;
        memoryMinus = new OtherButton("M-");
        this.getContentPane().add(memoryMinus, constraints);
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
    }
}
