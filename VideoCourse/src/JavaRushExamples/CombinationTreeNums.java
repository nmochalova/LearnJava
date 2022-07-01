package JavaRushExamples;

//Выведи на экран все возможные комбинации слов «Мама», «Мыла», «Раму».
public class CombinationTreeNums {
    public static void main(String[] args) {
        String result;
        String[] str = {"Мама","Мыла","Раму"};
        int[][] index = new int[3][3];

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                for (int n=0; n<3; n++) {
                    if (i != j && i!=n && j !=n) {
                        result = String.format("%s%s%s",str[i],str[j],str[n]);
                        System.out.println(result);
                    }
                }
            }
        }
    }
}
