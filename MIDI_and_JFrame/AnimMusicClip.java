package LearnJavaKatyBert.MIDI_and_JFrame;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;

public class AnimMusicClip {
    static JFrame jFrame = new JFrame("Первыый музакльный клип");
    static MyDrawpanel myDrawpanel;

    public static void main(String[] args) {
        AnimMusicClip animMusicClip = new AnimMusicClip();
        animMusicClip.go();
    }

    public void setUpGui(){
        myDrawpanel = new MyDrawpanel();
        jFrame.setContentPane(myDrawpanel);
        jFrame.setBounds(30,30,300,300);
        jFrame.setVisible(true);
    }
    public void go(){
        setUpGui();
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.addControllerEventListener(myDrawpanel,new int[]{127});
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            int r = 0;
            for (int i = 0; i < 60; i += 4) {
                r = (int) ((Math.random() * 50) + 1);

                track.add(makeEvent(144, 1, r, 100, i));

                track.add(makeEvent( 176,1,127,0,i));

                track.add(makeEvent(128, 1, r, 100, i + 2));
            }
            sequencer.setSequence(seq);

            sequencer.start();
            sequencer.setTempoInBPM(120);
        } catch (Exception e) {e.printStackTrace();}
    }
    public MidiEvent makeEvent(int cmd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(cmd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception e) {}
        return event;
    }

    class MyDrawpanel extends JPanel implements ControllerEventListener{

        boolean msg = false;

        @Override
        public void controlChange(ShortMessage event) {
            msg = true;
            repaint();
        }
        public void paintComponent(Graphics g){
            if(msg) {

                Graphics2D g2 = (Graphics2D) g;

                int green  = (int) (Math.random() * 250);
                int blue =  (int) (Math.random() * 250);
                int red =  (int) (Math.random() * 250);

                g.setColor(new Color(green,blue,red));

                int ht  = (int) ((Math.random() * 120)+ 10);
                int width =  (int) ((Math.random() * 120)+ 10);
                int x =  (int) ((Math.random() * 40)+ 10);
                int y =  (int) ((Math.random() * 40)+ 10);

                g.fillRect(x,y,ht,width);
                msg = false;

            }
        }
    }
}
