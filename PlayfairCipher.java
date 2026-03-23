import java.util.*;

public class PlayfairCipher {

    static char matrix[][] = new char[5][5];

    // Generate key matrix
    static void generateMatrix(String key) {
        boolean used[] = new boolean[26];

        key = key.toUpperCase().replaceAll("J", "I");

        int row = 0, col = 0;

        for (char c : key.toCharArray()) {
            if (!used[c - 'A']) {
                matrix[row][col] = c;
                used[c - 'A'] = true;
                col++;

                if (col == 5) {
                    col = 0;
                    row++;
                }
            }
        }

        for (char c = 'A'; c <= 'Z'; c++) {
            if (c == 'J') continue;

            if (!used[c - 'A']) {
                matrix[row][col] = c;
                used[c - 'A'] = true;
                col++;

                if (col == 5) {
                    col = 0;
                    row++;
                }
            }
        }
    }

    // Find position of character
    static int[] findPosition(char c) {
        if (c == 'J') c = 'I';

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matrix[i][j] == c)
                    return new int[]{i, j};
            }
        }
        return null;
    }

    // Encrypt message
    static String encrypt(String text) {

        text = text.toUpperCase().replaceAll("J", "I");
        String prepared = "";

        // Prepare pairs
        for (int i = 0; i < text.length(); i++) {
            prepared += text.charAt(i);

            if (i + 1 < text.length() && text.charAt(i) == text.charAt(i + 1))
                prepared += 'X';
        }

        if (prepared.length() % 2 != 0)
            prepared += 'X';

        String cipher = "";

        for (int i = 0; i < prepared.length(); i += 2) {

            char a = prepared.charAt(i);
            char b = prepared.charAt(i + 1);

            int pos1[] = findPosition(a);
            int pos2[] = findPosition(b);

            int r1 = pos1[0];
            int c1 = pos1[1];
            int r2 = pos2[0];
            int c2 = pos2[1];

            // Same row
            if (r1 == r2) {
                cipher += matrix[r1][(c1 + 1) % 5];
                cipher += matrix[r2][(c2 + 1) % 5];
            }
            // Same column
            else if (c1 == c2) {
                cipher += matrix[(r1 + 1) % 5][c1];
                cipher += matrix[(r2 + 1) % 5][c2];
            }
            // Rectangle rule
            else {
                cipher += matrix[r1][c2];
                cipher += matrix[r2][c1];
            }
        }

        return cipher;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter key: ");
        String key = sc.nextLine();

        generateMatrix(key);

        System.out.println("\nKey Matrix:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }

        System.out.print("\nEnter plaintext: ");
        String text = sc.nextLine();

        String cipher = encrypt(text);

        System.out.println("Encrypted Text: " + cipher);
    }
}