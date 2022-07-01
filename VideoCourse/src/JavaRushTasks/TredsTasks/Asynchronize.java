package JavaRushTasks.TredsTasks;

import java.util.ArrayList;
import java.util.List;
/*
Демонстрация того как асинхронность потоков может затирать общие ресурсы
 */
public class Asynchronize {
    public static void main(String[] args) {
        new NoteThread().start();
        new NoteThread().start();
    }

    public static class NoteThread extends Thread {
        @Override
        public void run() {
            try {
                for (int i = 0; i < 1000; i++) {
                    Note.addNote(getName() + "-Note" + i);
                    Thread.sleep(1);
                    Note.removeNote(getName());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Note {

        public static final List<String> notes = new ArrayList<>();

        public static void addNote(String note) {
            notes.add(0, note);
        }

        public static void removeNote(String threadName) {
            String note = notes.remove(0);
            if (note == null) {
                System.out.println("Другая нить удалила нашу заметку");
            } else if (!note.startsWith(threadName)) {
                System.out.println("Нить [" + threadName + "] удалила чужую заметку [" + note + "]");
            } else {
                System.out.println("Нить [" + threadName + "] удалила свою заметку [" + note + "]");
            }
        }
    }
}
