package BeatBox;

import javax.sound.midi.*;
import java.util.Scanner;

public class MiniMusicCmdLine {
    public static void main(String[] args) {
        MiniMusicCmdLine mini = new MiniMusicCmdLine();
        System.out.println("Игра ноты. Примеры: 102 30 или 80 20 или 40 70. Для выхода: 222");
        Scanner sc = new Scanner(System.in);
        int command = 1;

        while (true) {
            if (command == 1) {
                System.out.println("Введите инструмент (от 0 д о 127): ");
                int instrument = sc.nextInt();
                System.out.println("Введите ноту (от 0 д о 127): ");
                int note = sc.nextInt();
                mini.play(instrument, note);
            } else if (command == 0) {
                System.out.println("Выход");
              //  break;
                System.exit(0);
            }
            printMenu();
            command = sc.nextInt();
        }
    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Играть ноту");
        System.out.println("0 - Выход");
    }

    public void play(int instrument, int note) {
        try {
            Sequencer player = MidiSystem.getSequencer();
            player.open();
            Sequence seq = new Sequence(Sequence.PPQ,4);
            Track track = seq.createTrack();

            MidiEvent event = null;

            ShortMessage first = new ShortMessage();
            first.setMessage(192,1,instrument,0);
            MidiEvent changeInstrument = new MidiEvent(first,1);
            track.add(changeInstrument);

            ShortMessage a = new ShortMessage();
            a.setMessage(144,1,note,100);
            MidiEvent noteOn = new MidiEvent(a,1);
            track.add(noteOn);

            ShortMessage b = new ShortMessage();
            b.setMessage(128,1,note,100);
            MidiEvent noteOff = new MidiEvent(b,16);
            track.add(noteOff);

            player.setSequence(seq);
            player.start();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
