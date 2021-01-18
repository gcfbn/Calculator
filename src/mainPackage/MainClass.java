package mainPackage;

import GUI.SimpleCalculator;

import javax.swing.*;
import java.awt.*;

public class MainClass extends JFrame{

    private JPanel view;

    public MainClass(){

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        this.setLayout(new GridBagLayout());
        this.setTitle("Calculator");

        view = new SimpleCalculator();
        addGUIToWindow();

        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }

    private void addGUIToWindow(){

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;

        add(view, constraints);
    }
}
