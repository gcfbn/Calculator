package mainPackage;

import GUI.ScientificCalculator;
import GUI.SimpleCalculator;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private JPanel view;

    public static void main(String[] args) {

        MainWindow mainWindow = new MainWindow();
    }

    public MainWindow() {

        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        this.setLayout(new GridBagLayout());
        this.setTitle("Calculator");

        view = new ScientificCalculator();
        addGUIToWindow();

        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }

    private void addGUIToWindow() {

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;

        add(view, constraints);
    }
}
