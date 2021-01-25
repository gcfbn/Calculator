package mainPackage;

import GUI.ScientificCalculator;
import GUI.SimpleCalculator;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public static void main(String[] args) {

        MainWindow mainWindow = new MainWindow();
    }

    public MainWindow() {

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setLayout(new CardLayout());
        setTitle("Calculator");

        addGUIToWindow();

        this.pack();
        this.setResizable(false);
        this.setVisible(true);
    }


    private void addGUIToWindow() {

        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.add("Simple calculator", new SimpleCalculator());
        tabbedPane.add("Scientific calculator", new ScientificCalculator());

        this.getContentPane().add(tabbedPane);
    }
}
