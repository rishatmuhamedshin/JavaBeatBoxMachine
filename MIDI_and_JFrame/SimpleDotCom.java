package LearnJavaKatyBert.MIDI_and_JFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SimpleDotCom  {
    JFrame frame;
    JLabel label;
    JButton colorButton;
    JButton labelButton;

    public static void main(String[] args) {
        SimpleDotCom gui = new SimpleDotCom();
        gui.go();

    }
    public void go() {
        frame = new JFrame();
        colorButton = new JButton("Change color");
        labelButton = new JButton("Change label");

        colorButton.addActionListener(new ColorListner());
        labelButton.addActionListener(new LabelListner());

        label = new JLabel("Новая панель");
        //MyDrawPanel myDrawPanel = new MyDrawPanel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(BorderLayout.SOUTH,colorButton);
        //frame.getContentPane().add(BorderLayout.CENTER,myDrawPanel);
        frame.getContentPane().add(BorderLayout.EAST,labelButton);
        frame.getContentPane().add(BorderLayout.WEST,label);

        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    class LabelListner implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            label.setText("Поменяли");
        }
    }
    class ColorListner implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(colorButton)){
                frame.repaint();
            }
        }
    }
}

