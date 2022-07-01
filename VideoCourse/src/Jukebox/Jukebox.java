package Jukebox;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class Jukebox {
    ArrayList<Song> songList = new ArrayList<Song>();

    public static void main(String[] args) {
        new Jukebox().go();
    }

    //Сортируем по исполнителю
    class ArtistCompare implements Comparator<Song> {
        public int compare(Song one, Song two) {
            return (one.getArtist().compareTo(two.getArtist()));
        }
    }

    public void go() {
        getSongs();
        System.out.println("Без сортировки");
        System.out.println(songList);

        Collections.sort(songList);
        System.out.println("\nСортируем интерфейсом Comparable по названию (1 - title)");
        System.out.println(songList);

        HashSet<Song> songSet = new HashSet<Song>();
        songSet.addAll(songList);
        System.out.println("\nПерекладываем в HashSet для удаления дубликатов");
        System.out.println(songSet);

        TreeSet<Song> songTreeSet = new TreeSet<Song>();
        songTreeSet.addAll(songList);
        System.out.println("\nПерекладываем в TreeSet для удаления дубликатов и сортировки по compareTo() из каждого эл-та ");
        System.out.println(songTreeSet);

        ArtistCompare ac = new ArtistCompare();
        Collections.sort(songList,ac);
        System.out.println("\nСортируем интерфейсом Comparator по исполнителю (2 - artist)");
        System.out.println(songList);
    }

    void getSongs() {
        try {
            File file = new File("SongList.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line=reader.readLine()) != null) {
                addSong(line);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void addSong(String lineToParse) {
        String[] tokens = lineToParse.split("/");

        Song nextSong = new Song(tokens[0],tokens[1],tokens[2],tokens[3]);
        songList.add(nextSong);
    }
}
