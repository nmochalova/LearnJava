package BeatBox;

import javax.sound.midi.*;

public class MiniMiniMusicApp {
    public static void main(String[] args) {
        MiniMiniMusicApp mini = new MiniMiniMusicApp();
        mini.play();
    }

    public void play() {
        try {
            Sequencer player = MidiSystem.getSequencer(); //получаем синтезатор
            player.open();                                //открываем синтезатор

            //музыкальная последовательность - это композиция, кот. будет воспроизводить синтезатор
            Sequence seq = new Sequence(Sequence.PPQ,4);

           //запрашиваем трек у последовательности. Трек внутри последовательности, а MIDI-данные в треке.
            Track track = seq.createTrack();

            //Помещаем в трек MIDI-события
            //Message говорит что делать, MidiEvent - когда это делать
            ShortMessage a = new ShortMessage();                        //создаем сообщение
            a.setMessage(144,1,44,100);     //инструкция: играем ноту 44
            MidiEvent noteOn = new MidiEvent(a,1);                 //событие: сообщение а сработает на первом такте (бит 1)
            track.add(noteOn);                                         //добавляем событие в трек

            ShortMessage b = new ShortMessage();
            b.setMessage(128,1,44,100);
            MidiEvent noteOff = new MidiEvent(b,16);
            track.add(noteOff);

            //Передаем последовательность синтезатору (как будто вставляем в CD прогрыватель)
            player.setSequence(seq);

            //Запускаем синтезатор (как будто нажимаем Play)
            player.start();

            //player.stop();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
