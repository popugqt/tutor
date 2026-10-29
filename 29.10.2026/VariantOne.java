import java.util.Scanner;

public class VariantOne {
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
        double lastX = x*x;
        long lastFac = 2;

        for (int k=1; k<=n; k++) {
            result += lastX/(lastFac+k);

            lastX *= x*x*x;
            lastFac *= (2*k+1)*(2*k+2);
        }

        return result;
    }

    public static void taskTwo() {
        System.out.printf("Задание 2%n%n");

        System.out.printf("Введите m: ");
        int m = scr.nextInt();
        System.out.printf("Введите p: ");
        int p = scr.nextInt();
        System.out.printf("Введите %dx%d:%n", m, p);

        int count = getColumnCount(m, p);

        System.out.printf("Результат: %d%n", count);
    }

    public static int getColumnCount(int m, int p) {
        int count = p;
        int[][] arr = new int[m][p];
        boolean[] columnState = new boolean[p];

        for (int i=0; i<m; i++) {
            for (int j=0; j<p; j++) {
                int number = scr.nextInt();

                if (i!=0 && !columnState[j]) {
                    if (arr[i-1][j] >= number) {
                        columnState[j] = true;
                        count--;
                    }
                }

                arr[i][j] = number;
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
            "Индекс: %d, количество фрагментов: %d%n", 
            result[0],
            result[1]
        );
    }

    public static int[] getLine(int t) {
        int count = 0;
        int ind = -1;

        for (int i=0; i<t; i++) {
            int currentCount = getDublicatesCount(scr.next());

            if (currentCount > count) {
                count = currentCount;
                ind = i;
            }
        }

        return new int[] {ind, count};
    }

    public static int getDublicatesCount(String line) {
        int count = 0;

        for (int i=0; i<line.length()-2; i++) {
            if (line.charAt(i) == line.charAt(i+2)) {
                count++;
            }
        }

        return count;
    } 
}