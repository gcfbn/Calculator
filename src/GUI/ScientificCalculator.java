package GUI;

import controllers.ControllerMethods;
import controllers.ScientificCalculatorController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScientificCalculator extends SimpleCalculator {

    private JButton sin, cos, tan, ctg, arcSin, arcCos, arcTan, arcCtg;
    private JRadioButton degrees, radians;
    private JButton xPowerOfY, nRootOfX;
    private JButton pi, e;
    private JButton ln, log;

    public ScientificCalculator() {
        super();
        createGUI();

        addActionListeners();
    }

    private void createGUI() {
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.insets = new Insets(2, 2, 2, 2); //margins

        sin = new JButton("sin");
        this.add(sin, constraints);

        constraints.gridx = 1;
        cos = new JButton("cos");
        this.add(cos, constraints);

        constraints.gridx = 2;
        tan = new JButton("tan");
        this.add(tan, constraints);

        constraints.gridx = 3;
        ctg = new JButton("ctg");
        this.add(ctg, constraints);

        constraints.gridx = 4;
        arcSin = new JButton("arcsin");
        this.add(arcSin, constraints);

        constraints.gridx = 5;
        arcCos = new JButton("arccos");
        this.add(arcCos, constraints);

        constraints.gridy = 7;

        constraints.gridx = 0;
        arcTan = new JButton("arctan");
        this.add(arcTan, constraints);

        constraints.gridx = 1;
        arcCtg = new JButton("arcctg");
        this.add(arcCtg, constraints);

        constraints.gridwidth = 2;

        constraints.gridx = 2;
        degrees = new JRadioButton("degrees (" + "\u00B0" + ")");
        degrees.setSelected(false);
        this.add(degrees, constraints);

        constraints.gridx = 4;
        radians = new JRadioButton("radians (rad)");
        radians.setSelected(true);
        this.add(radians, constraints);

        ButtonGroup angleUnit = new ButtonGroup();
        angleUnit.add(degrees);
        angleUnit.add(radians);

        constraints.gridy = 8;
        constraints.gridwidth = 1;

        constraints.gridx = 0;
        xPowerOfY = new JButton("x^y");
        this.add(xPowerOfY, constraints);

        constraints.gridx = 1;
        nRootOfX = new JButton("nth root");
        this.add(nRootOfX, constraints);

        constraints.gridx = 2;
        pi = new JButton("pi");
        this.add(pi, constraints);

        constraints.gridx = 3;
        e = new JButton("e");
        this.add(e, constraints);

        constraints.gridx = 4;
        ln = new JButton("ln");
        this.add(ln, constraints);

        constraints.gridx = 5;
        log = new JButton("log_a b");
        this.add(log, constraints);
    }

    protected class TrigonometricFunctionActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String argument = display.getText();

            try {
                String result = ScientificCalculatorController.trigonometricFunction(e.getSource(), argument, degrees.isSelected());
                setScreenText(result);
            } catch (IllegalArgumentException exception) {
                setScreenError();
            } finally {
                nextDigitReplacesDisplay = true;
            }
        }
    }

    protected class ArcusFunctionActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String argument = display.getText();

            try {
                String result = ScientificCalculatorController.arcusFunction(e.getSource(), argument, degrees.isSelected());
                setScreenText(result);
            } catch (IllegalArgumentException exception) {
                setScreenError();
            } finally {
                nextDigitReplacesDisplay = true;
            }

        }
    }

    protected class ConstantActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            JButton source = (JButton) e.getSource();
            String constant = source.getText();

            switch (constant) {
                case "pi" -> setScreenText(ControllerMethods.formatResultToString(Math.PI));
                case "e" -> setScreenText(ControllerMethods.formatResultToString(Math.E));
            }

            nextDigitReplacesDisplay = false;
        }
    }

    private void addActionListeners() {

        sin.addActionListener(new TrigonometricFunctionActionListener());
        cos.addActionListener(new TrigonometricFunctionActionListener());
        tan.addActionListener(new TrigonometricFunctionActionListener());
        ctg.addActionListener(new TrigonometricFunctionActionListener());

        arcSin.addActionListener(new ArcusFunctionActionListener());
        arcCos.addActionListener(new ArcusFunctionActionListener());
        arcTan.addActionListener(new ArcusFunctionActionListener());
        arcCtg.addActionListener(new ArcusFunctionActionListener());

        xPowerOfY.addActionListener(new TwoArgumentFunctionActionListener());
        nRootOfX.addActionListener(new TwoArgumentFunctionActionListener());

        pi.addActionListener(new ConstantActionListener());
        e.addActionListener(new ConstantActionListener());

        ln.addActionListener(new OneArgumentFunctionActionListener());
        log.addActionListener(new OneArgumentFunctionActionListener());
    }
}
