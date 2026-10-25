import java.util.Scanner;

public class AppOne {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Укажите номер задания");
        }

        int taskNumber = Integer.parseInt(args[0]);

        switch (taskNumber) {
            case 1 -> taskOne();
            case 2 -> taskTwo();
            case 3 -> taskThree();
            default -> System.out.println("Указан неверный номер задания");
        }
    }

    public static void taskOne() {
        Scanner scr = new Scanner(System.in);

        int n = scr.nextInt();
        int x = scr.nextInt();

        int pow = getPower(n, x);

        System.out.println(pow);
    }

    public static int getPower(int a, int b) {
        int result = 1;

        for (int i=1; i<=b; i++) {
            result *= a;
        }

        return result;
    }

    public static void taskTwo() {
        Scanner scr = new Scanner(System.in);
        int n = scr.nextInt();
        int fakeNumberLine;

        for (int i=1; i<=n; i++) {
            if (i<=n/2+1) {
                fakeNumberLine = i;
            } else {
                fakeNumberLine = n-i+1;
            }

            for (int j=1; j<=n; j++) {
                if (j<=n/2-fakeNumberLine+1) {
                    System.out.print(" ");
                } else if (j<=n/2+fakeNumberLine) {
                    System.out.print("*");
                } else {
                    break;
                }
            }

            System.out.println();
        }
    }

    public static void taskThree() {
        int n = 10; // O(1)

        for (int i=1; i<=n; i++) { // O(n)
            System.out.println(i);
        }

        for (int i=1; i<=n+1; i++) { // O(n)*O(n)
            for (int j=1; j<=i; j++) { // O(n)
                System.out.println(j);
            }
        }

        int i = 1;
        while (i < n) {
            i *= 2;
        }
    }
}