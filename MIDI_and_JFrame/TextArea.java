package LearnJavaKatyBert.MIDI_and_JFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextArea  {
    int count = 15;
    JTextArea textArea;
    JCheckBox jCheckBox;

    public static void main(String[] args) {
        TextArea textArea1 = new TextArea();
        textArea1.go();
    }

    private void go() {

        JFrame jFrame = new JFrame("Текст арена");
        JPanel jPanel = new JPanel();
        JButton jButton = new JButton("Just a click");
        jCheckBox = new JCheckBox("Новый флаг");

        textArea = new JTextArea(10,20);
        textArea.setLineWrap(true);

        jButton.addActionListener(new ButtonAcLis());
        jCheckBox.addActionListener(new CheckBox());

        JScrollPane scroller = new JScrollPane(textArea);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel.add(scroller);

        jFrame.getContentPane().add(BorderLayout.CENTER,jPanel);
        jFrame.getContentPane().add(BorderLayout.SOUTH,jButton);
        jFrame.getContentPane().add(BorderLayout.WEST,jCheckBox);

        jFrame.setSize(350,300);
        jFrame.setVisible(true);

    }
    class CheckBox implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
    class ButtonAcLis implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            count ++;
            textArea.append("Button Clicked\n");
            if(count == 30){
                jCheckBox.setSelected(true);
            }else {
                jCheckBox.setSelected(false);
            }
        }
    }
}
