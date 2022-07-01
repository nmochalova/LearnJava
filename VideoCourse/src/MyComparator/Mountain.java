package MyComparator;

public class Mountain implements Comparable<Mountain> {
    String name;
    int height;

    Mountain(String n, int h) {
        name = n;
        height = h;
    }

//Перегрузка родительского метода toString() от Object. Это нужно для вывода на печать осмысленной информации.
    @Override
    public String toString() {
        return name + " " + height;
    }

    @Override
    public int compareTo(Mountain o) {
        return name.compareTo(o.name);
    }
}
