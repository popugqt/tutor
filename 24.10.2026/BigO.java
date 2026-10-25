public class BigO {
    public static void main(String[] args) {
        
    }

    public static void taskOne() {
        int n = 2; // O(1)
        int[][] arr = {{1, 2}, {2, 3}}; // O(1)
        // O(1) + O(1) = O(1)
        int sum = 0; // O(1)
        // O(1) + O(1) = O(1)

        for (int i=0; i<n; i++) { // O(n)
            for (int j=0; j<n; i++) { // O(n)
                sum += arr[i][j]; // O(1)
            }
            // O(n) * O(1) = O(n*1) = O(n)
        }
        // O(n) * O(n) = O(n*n) = O(n^2)

        // O(1) + O(n^2) = O(n^2)
    }

    public static void taskTwoAlt() {
        int n = 3;
        int m = 4;
        // O(1)

        for (int i=0; i<n; i++) { // O(n)
            System.out.println(i); // O(1)
        }
        // O(n) + O(1) = O(n)

        for (int i=0; i<m; i++) { // O(m)
            System.out.println(m); // O(1)
        }
        // O(m) + O(1) = O(m)

        // O(1) + O(n) + O(m) = O(n+m)
    }

    public static void taskTwoAltTwo() {
        int n = 3;
        // O(1)

        for (int i=0; i<n; i++) { // O(n)
            System.out.println(i); // O(1)
        }
        // O(n) + O(1) = O(n)

        for (int i=0; i<n; i++) { // O(n)
            System.out.println(i); // O(1)
        }
        // O(n) + O(1) = O(n)

        // O(1) + O(n) + O(n) = O(2n) = O(n), тк 2 - константа (Сложности O(2n) не существует)
    }

    public static void taskTwo() {
        int n = 3;
        int m = 4;
        // O(1)

        for (int i=0; i<n; i++) { // O(n)
            for (int j=0; j<m; j++) { // O(m)
                System.out.println(i + " " + j); // O(1)
            }
            // O(m) * O(1) = O(m)
        }
        // O(n) * O(m) = O(nm)

        // O(1) + O(nm) = O(nm)
    }

    public static void taskThree() {
        int i = 1;
        int n = 100;
         // O(1)

        while (i < n) {
            i *= 2;
        }
        // O(logn)
    }
}
