package LearnJavaKatyBert.MIDI_and_JFrame;

import javax.swing.*;
import java.awt.*;

public class SimpleAnimation {
        int x = 70;
        int y = 70;
        int wid = 70;
        int hei = 70;


        public static void main(String[] args) {
            SimpleAnimation gui = new SimpleAnimation();
            gui.go();

        }
        public void go() {
            JFrame frame = new JFrame();

            MyPanel myPanel = new MyPanel();

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.getContentPane().add(myPanel);
            frame.setSize(300, 300);
            frame.setVisible(true);

            for (int i = 0; i < 130 ; i++) {
                x++;
                y++;

                myPanel.repaint();

                try{
                    Thread.sleep(50);
                }catch (Exception e){}
            }

        }
        class MyPanel extends JPanel{
            public void paintComponent(Graphics g){
                g.setColor(Color.white);
                g.fillRect(0,0,this.getWidth(),this.getHeight());

                g.setColor(Color.GREEN);
                g.fillOval(x,y,wid,hei);
            }
        }
}
