import java.util.Scanner;
import java.util.ArrayList;

public class App {
    public static Scanner scr = new Scanner(System.in);

    public static void main(String[] args) {
        taskTwo();
    }

    public static void taskOne() {
        System.out.print("Введите строку: ");
        String line = scr.nextLine();
        System.out.print("Введите шаг: ");
        int key = scr.nextInt();

        if (key > 25 | key < 1) {
            System.out.println("Неверный ключ");
            return;
        }

        String encrypted = encrypt(line, key);        
        System.out.printf("Зашифрованная строка: %s%n", encrypted);
        System.out.printf("Дешифрованная строка: %s%n", decrypt(encrypted, key));

        String mostRepeatedLetter = getRepeatedLetter(line);
        if (mostRepeatedLetter == "?") {
            System.out.println("Латинских букв нет");
        } else {
            System.out.printf("Самая частая буква: %s (%d)%n", mostRepeatedLetter, getCountLetter(line, mostRepeatedLetter.toCharArray()[0]));
        }
    }

    public static String encrypt(String line, int key) {
        char[] ogChars = line.toCharArray();
        String result = "";

        for (int i=0; i<ogChars.length; i++) {
            char newChar = (char) (ogChars[i] + key); // число приводим в char тип

            if (ogChars[i] <= 'Z' & ogChars[i] >= 'A') { // 'A', 'B', ..., 'Z'
                if (newChar > 'Z') { // выходит за пределы алфавита, т.е 'A', 'B', ..., 'Z', ..., newChar
                    result += (char) ('A' + newChar - 'Z' - 1);
                } else { // не выходит за пределы алфавита
                    result += newChar;
                }
            } else if (ogChars[i] <= 'z' & ogChars[i] >= 'a') { // нижний регистр
                if (newChar > 'z') { // выходит за пределы алфавита
                    result += (char) ('a' + newChar - 'z' - 1);
                } else { // не выходит за пределы алфавита
                    result += newChar;
                }
            } else {
                result += ogChars[i];
            }
        }

        return result;
    }

    public static String decrypt(String line, int key) {
        char[] ogChars = line.toCharArray();
        String result = "";

        for (int i=0; i<ogChars.length; i++) {
            char newChar = (char) (ogChars[i] - key); // число приводим в char тип

            if (ogChars[i] <= 'Z' & ogChars[i] >= 'A') { // 'A', 'B', ..., 'Z'
                if (newChar < 'A') { // выходит за пределы алфавита, т.е newChar, ..., 'A', 'B', ..., 'Z'
                    result += (char) ('Z' - 'A' - newChar);
                } else { // не выходит за пределы алфавита
                    result += newChar;
                }
            } else if (ogChars[i] <= 'z' & ogChars[i] >= 'a') { // нижний регистр
                if (newChar < 'a') { // выходит за пределы алфавита
                    result += (char) ('z' - 'a' - newChar);
                } else { // не выходит за пределы алфавита
                    result += newChar;
                }
            } else {
                result += ogChars[i];
            }
        }

        return result;
    }

    public static ArrayList<Character> getLetters(String line) {
        char[] chars = line.toCharArray();
        ArrayList<Character> letters = new ArrayList<>(); // 'a', 'b', ..., 'Z'

        for (int i=0; i<chars.length; i++) {
            char currentLetter = chars[i];

            if (currentLetter <= 'Z' & currentLetter >= 'A' | currentLetter <= 'z' & currentLetter >= 'a') {
                if (!letters.contains(currentLetter)) {
                    letters.add(currentLetter);
                }
            }
        }

        return letters;
    }

    // public static String getRepeatedLetter(String line) {
    //     char[] chars = line.toCharArray();
    //     ArrayList<Character> letters = getLetters(line);

    //     int[] countOfLetters = new int[letters.size()]; // 0, 0, ..., 0

    //     for (char i : chars) {
    //         int ind = letters.indexOf(i);

    //         if (ind == -1) continue; // Убираем не буквы

    //         countOfLetters[ind] += 1;
    //     }

    //     int resultInd = -1;
    //     int resultCount = 0;

    //     for (int i=0; i<countOfLetters.length; i++) {
    //         if (countOfLetters[i] > resultCount) {
    //             resultCount = countOfLetters[i];
    //             resultInd = i;
    //         }
    //     }

    //     return Character.toString(letters.get(resultInd));
    // }

    public static String getRepeatedLetter(String line) {
        char resultLetter = '?';
        int resultCount = 0;

        for (char i : line.toCharArray()) { // O(n)
            int count = getCountLetter(line, i); // O(n)

            if (count > resultCount) {
                resultLetter = i;
                resultCount = count;
            }
        }
        // O(n) * O(n) = O(n^2)

        return Character.toString(resultLetter);
    }

    public static int getCountLetter(String line, char letter) {
        int count = 0;

        for (char i : line.toCharArray()) { // O(n)
            if (i==letter) count++;
        }

        return count;
    }

    public static int lengthNumber (int x) {
        int length = 0;

        while (x>0) {
            length++;
            x/=10;
        }

        return length;
    }

    public static void printMatrix(int[][] arr) {
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[0].length; j++) {
                System.out.print(arr[i][j]);

                int lengthCurrentNumber = 4-lengthNumber(arr[i][j])+1;

                if (j!=arr[0].length-1) {
                    for (int k=0; k<lengthCurrentNumber; k++) {
                        System.out.print(" ");
                    }
                }
            }

            System.out.println();
        }
    }

    public static int getSumLastColumn(int[][] arr) {
        int sum = 0;

        for (int i=0; i<arr.length; i++) {
            sum += arr[i][arr[0].length-1];
        }

        return sum;
    }

    public static int[][] getSneakMatrix(int n, int m) {
        int[][] arr = new int[n][m];
        int number = 1;

        for (int i=0; i<n; i++) {
            if (i%2==0) {
                for (int j=0; j<m; j++) {
                    arr[i][j] = number++;
                }
            } else {
                for (int j=m-1; j>=0; j--) {
                    arr[i][j] = number++;
                }
            }
        }

        return arr;
    }

    public static void taskTwo() {
        System.out.print("Введите n: ");
        int n = scr.nextInt();
        System.out.print("Введите m: ");
        int m = scr.nextInt();

        if (n < 1 | n > 10 | m < 1 | m > 10) {
            System.out.println("Неверный размер");
            return;
        }

        int[][] arr = getSneakMatrix(n, m);

        System.out.println("Матрица:");
        printMatrix(arr);
        System.out.printf("Сумма последнего столбца: %d%n", getSumLastColumn(arr));
    }
}