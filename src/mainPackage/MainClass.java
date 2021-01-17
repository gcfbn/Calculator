package mainPackage;

import GUI.SimpleCalculator;

import javax.swing.*;

public class MainClass {

    public JFrame mainFrame;

    public MainClass(){

        this.mainFrame = new SimpleCalculator();
        mainFrame.setTitle("Calculator");
    }
}
