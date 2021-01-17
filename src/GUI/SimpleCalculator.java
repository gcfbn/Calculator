package GUI;

import javax.swing.*;

import buttons.*;

import java.awt.*;

public class SimpleCalculator extends JFrame {

    private JTextArea screen;
    private OtherButton nine, eight, seven, six, five, four, three, two, one, comma, zero, equals;
    private TwoArgumentFunction plus, minus, multiply, divide;
    private OtherButton sqrt, percent, delete, clear, memoryRecall, memoryClear, memoryPlus, memoryMinus;

    public SimpleCalculator() {

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        this.createGUI();
        this.pack();
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

        screen = new JTextArea("0");
        screen.setEditable(false);
        screen.setFont(new Font("Arial", Font.BOLD, 24));
        this.getContentPane().add(screen, constraints);

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
        comma = new OtherButton(",");
        this.getContentPane().add(comma, constraints);

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

}
