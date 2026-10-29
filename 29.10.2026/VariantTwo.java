import java.util.Scanner;

public class VariantTwo {
    private static Scanner scr = new Scanner(System.in);

    public static void main(String[] args) {
        taskOne();
        taskTwo();
        taskThree();
    }

    public static void taskOne() {
        System.out.printf("Задание 1%n%n");

        System.out.printf("Введите n: ");
        int n = scr.nextInt();
        System.out.printf("Введите x: ");
        double x = scr.nextDouble();

        double result = getSum(n, x);
        System.out.printf("Результат: %f%n", result);
    }

    public static double getSum(int n, double x) {
        double result = 0;

        // Аналогично с первым вариантом

        return result;
    }

    public static void taskTwo() {
        System.out.printf("Задание 1%n%n");

        System.out.printf("Введите m: ");
        int m = scr.nextInt();
        System.out.printf("Введите p: ");
        int p = scr.nextInt();
        System.out.printf("Введите %dx%d:%n", m, p);
        
        int count = getRowCount(m, p);

        System.out.printf("Результат: %d%n", count);
    }

    public static int getRowCount(int m, int p) {
        int[] lastNumbers = new int[m];
        boolean[] stateRows = new boolean[m];
        int count = m;

        for (int i=0; i<m; i++) {
            for (int j=0; j<p; j++) {
                int number = scr.nextInt();

                if (j!=0 && !stateRows[i]) {
                    if (lastNumbers[i]%2 == number%2) {
                        stateRows[i] = true;
                        count--;
                    }
                }

                lastNumbers[i] = number;
            }
        }

        return count;
    }

    public static void taskThree() {
        System.out.printf("Задание 3%n%n");

        System.out.printf("Введите t: ");
        int t = scr.nextInt();

        int[] result = getLine(t);

        System.out.printf(
            "Индекс: %d, количество ...: %d%n", 
            result[0],
            result[1]
        );
    }

    public static int[] getLine(int t) {
        int count = 0;
        int ind = -1;

        for (int i=0; i<t; i++) {
            int currentCount = getPair(scr.next());

            if (currentCount > count) {
                count = currentCount;
                ind = i;
            }
        }

        return new int[] {ind, count};
    }

    public static int getPair(String line) {
        int count = 0;

        for (int i=0; i<line.length()-1; i++) {
            char currentCharOne = line.charAt(i);
            char currentCharTwo = line.charAt(i+1);
            int res = currentCharOne-currentCharTwo;

            if (res==1 || res==-1) {
                count++;
            }
        }

        return count;
    }
}