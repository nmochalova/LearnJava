package Gui;

import javax.swing.*;
import java.awt.event.ActionListener;

public class SimpleGui2  {
    JButton button;

    public static void main(String[] args) {
        SimpleGui2 gui = new SimpleGui2();
        gui.go();
    }

    private void go() {
        JFrame frame = new JFrame();
        button = new JButton("click me");

        ActionListener listener = (t) ->button.setText("hello");

        button.addActionListener(listener);

        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);
    }

}
