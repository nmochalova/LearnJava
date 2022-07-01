package JavaRushExamples;

public class Reference
{
    public static void main (String[] args)
    {
        int m = 5;
        int n = 6;

        System.out.println("M=" +m+ " N=" + n);
        swap(m, n);
        System.out.println("M=" +m+ " N=" + n);
    }

    private static void swap(int a, int b)
    {
        System.out.println("a=" +a+ " b=" + b);
        int c = a;
        a = b;
        b = c;
        System.out.println("a=" +a+ " b=" + b);
    }
}