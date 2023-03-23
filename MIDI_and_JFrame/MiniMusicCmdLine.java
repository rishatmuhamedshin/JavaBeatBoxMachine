package LearnJavaKatyBert.MIDI_and_JFrame;//import javax.sound.midi.*;
//
//public class LearnJavaKatyBert.MIDI_and_JFrame.MiniMusicCmdLine {
//    public static void main(String[] args) {
//        int instrument = 100;
//        int note = 44;
//        LearnJavaKatyBert.MIDI_and_JFrame.MiniMusicCmdLine mini = new LearnJavaKatyBert.MIDI_and_JFrame.MiniMusicCmdLine();
//        if(args.length < 2){
//            System.out.println("Не забудьте аргументы");
//        }else{
//             instrument = Integer.parseInt(args[0]);
//             note = Integer.parseInt(args[1]);
//            mini.play(instrument,note);
//        }
//        mini.play(instrument,note);
//    }
//
//    private void play(int instrument, int note) {
//        try{
//
//            Sequencer player = MidiSystem.getSequencer();
//            player.open();
//            Sequence seq = new Sequence(Sequence.PPQ,4);
//            Track track = seq.createTrack();
//
//            MidiEvent event = null;
//
//            ShortMessage first = new ShortMessage();
//            first.setMessage(192,1,instrument,0);
//            MidiEvent changeInstrument = new MidiEvent(first,1);
//            track.add(changeInstrument);
//
//            ShortMessage a = new ShortMessage();
//            a.setMessage(144,1,note,100);
//            MidiEvent noteOn = new MidiEvent(a,1);
//            track.add(noteOn);
//
//            ShortMessage b = new ShortMessage();
//            b.setMessage(192,1,note,100);
//            MidiEvent noteOff = new MidiEvent(b,16);
//            track.add(noteOff);
//
//            player.setSequence(seq);
//            player.start();
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//}


public class MiniMusicCmdLine {
    public static void main(String[] args) {
        AnimAtionMusic animAtionMusic = new AnimAtionMusic();
        animAtionMusic.go();
        AnimAtionMusic animAtionMusic2 = new AnimAtionMusic();
        animAtionMusic2.go();
    }
}