import java.util.Scanner;

public class HW4 {
    public static Scanner scr = new Scanner(System.in);

    public static void main(String[] args) {
        taskNineAlt();
    }

    public static void taskNine() {
        int n = scr.nextInt(); // 5
        int x = n*2-1; // 9

        for (int i=1; i<=x; i++) {
            if (i<n) { // i<5
                // последовательность звездочек в строчке 2, 4, 6, 8, 9, где 9 - центр бабочки
                // арифм. прогр., где a1=2, шаг прогр. = i => an = a1*i - количество звездочек
                int countStars = i; // Заметим, что кол-во звездочек = номеру строки
                int countSpaces = x-countStars*2; // Количество пробелов между звездочками

                for (int j=1; j<=x; j++) {
                    if (j<=countStars) {
                        System.out.print("*");
                    } else if (j<=countStars+countSpaces) {
                        System.out.print(" ");
                    } else {
                        System.out.print("*");
                    }
                }

                System.out.println();
            } else if (i==n) {
                for (int j=1; j<=x; j++) {
                    System.out.print("*");
                }

                System.out.println();
            } else { // i>5
                // У нас отличается номер строки от количества звездочек
                // Поэтому мы произведем мат. операции
                int fakeNumberLine = x-i+1;
                int countStars = fakeNumberLine;
                int countSpaces = x-countStars*2;

                for (int j=1; j<=x; j++) {
                    if (j<=countStars) {
                        System.out.print("*");
                    } else if (j<=countStars+countSpaces) {
                        System.out.print(" ");
                    } else {
                        System.out.print("*");
                    }
                }

                System.out.println();
            }
        }
    }

    public static void taskNineAlt() {
        int n = scr.nextInt(); // 5
        int x = n*2-1; // 9

        for (int i=1; i<=x; i++) {
            int fakeNumberLine = i<=n?i:x-i+1;

            for (int j=1; j<=x; j++) {
                if (j<=fakeNumberLine) {
                    System.out.print("*");
                } else if (j<=x-fakeNumberLine) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }

            System.out.println();
        }
    }
}
