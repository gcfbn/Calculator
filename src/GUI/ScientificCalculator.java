package GUI;

import javax.swing.*;
import java.awt.*;

public class ScientificCalculator extends SimpleCalculator{

    private JButton sin, cos, tan, ctg, arcSin, arcCos, arcTan, arcCtg;
    private JRadioButton degrees, radians;
    private ButtonGroup angleUnit;
    private JButton xPowerOfY, nRootOfX;
    private JButton pi, e;
    private JButton ln, log;

    public ScientificCalculator(){
        super();
        createGUI();
    }

    private void createGUI(){
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

        angleUnit = new ButtonGroup();
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
}
