import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingString {

    public static void main(String[] args) {
        ArrayList<String> listNames = new ArrayList<String>();
        listNames.add("a");
        listNames.add("b");
        listNames.add("c");

        new SortingString().checkSortNatural(listNames);
        new SortingString().checkSortReverseOrder(listNames);
    }

    private void checkSortNatural(ArrayList<String> listNames) {
        System.out.println("=========== Прямая сортировка =============");
        List<String> listNamesSort = (ArrayList<String>) listNames.clone();

        //  Collections.sort(listNamesSort);

        //Прямая сортировка
        listNamesSort = listNamesSort.stream().sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        System.out.println("Сортировка двух массивов");
        for (int i=0; i<listNames.size();i++) {
            System.out.println(listNames.get(i) + " -->  " + listNamesSort.get(i));
        }

        checkSort(listNames, listNamesSort);
    }

    private void checkSortReverseOrder(ArrayList<String> listNames) {
        System.out.println("========== Сортировка в обратном порядке ===========");
        List<String> listNamesSort = (ArrayList<String>) listNames.clone();

        //Сортировка в обратном порядке
        listNamesSort = listNamesSort.stream().sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        System.out.println("Сортировка двух массивов");
        for (int i=0; i<listNames.size();i++) {
            System.out.println(listNames.get(i) + " -->  " + listNamesSort.get(i));
        }

        checkSort(listNames, listNamesSort);
    }

    public void checkSort(ArrayList<String> listNames,List<String> listNamesSort) {
        for (int i=0; i<listNames.size();i++) {
            if (!listNames.get(i).equals(listNamesSort.get(i))) {
                System.out.println("Сортировка нарушена");
                System.out.println(listNames.get(i)+" -->  "+listNamesSort.get(i));
            }
        }
    }
}
