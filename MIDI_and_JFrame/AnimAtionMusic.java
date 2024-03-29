package LearnJavaKatyBert.MIDI_and_JFrame;

import javax.sound.midi.*;

public class AnimAtionMusic implements ControllerEventListener {
    private static int count;
    public static void main(String[] args) {
        AnimAtionMusic animAtionMusic = new AnimAtionMusic();
        animAtionMusic.go();
    }

    public void go(){
            try {
                Sequencer sequencer = MidiSystem.getSequencer();
                sequencer.open();

                int[] eventsIWant = {127};
                sequencer.addControllerEventListener(this,eventsIWant);

                Sequence seq = new Sequence(Sequence.PPQ, 4);
                Track track = seq.createTrack();


                for (int i = 5; i < 61; i += 4) {
                    track.add(makeEvent(144, 1, i, 100, i));
                    track.add(makeEvent( 176,1,127,0,i));
                    track.add(makeEvent(128, 1, i, 100, i + 2));
                }
                sequencer.setSequence(seq);
                sequencer.setTempoInBPM(220);
                sequencer.start();
            } catch (Exception e) {
            }

        }

        private static MidiEvent makeEvent(int cmd, int chan, int one, int two, int tick) {
            MidiEvent event = null;
            try {
                ShortMessage a = new ShortMessage();
                a.setMessage(cmd, chan, one, two);
                event = new MidiEvent(a, tick);
            } catch (Exception e) {
            }
            return event;
        }

    @Override
    public void controlChange(ShortMessage event) {
        System.out.println("ля " + (count++));
    }
}

