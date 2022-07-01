package Jukebox;

public class Song implements Comparable<Song>{
    String title; //название
    String artist; //исполнитель
    String rating;
    String bpm;

    //Переопредляем методы hashCod() и Equals() (от Oblect), чтобы отсеять дубликаты в HashSet
    public boolean equals(Object aSong) {
        Song s = (Song) aSong;
        return getTitle().equals(s.getTitle()); //здесь используем метод equals от String
    }

    public int hashCode() {
        return title.hashCode();               //здесь используем метод hashCode от String
    }

    //сортируем по названию
    public int compareTo(Song s ) {
        return title.compareTo(s.getTitle());
    }

    Song(String t, String a, String r, String b) {
        title = t;
        artist = a;
        rating = r;
        bpm = b;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getRating() {
        return rating;
    }

    public String getBpm() {
        return bpm;
    }

    public String toString() {
        //  return titile + ": " + artist;
        return title;
    }
}
