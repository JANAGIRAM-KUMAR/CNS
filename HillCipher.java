import java.util.*;

public class HillCipher {

    static int[][] keyMatrix;
    static int size;

    // Function to generate key matrix
    static void getKeyMatrix(String key) {
        int k = 0;
        keyMatrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                keyMatrix[i][j] = key.charAt(k++) - 'A';
            }
        }
    }

    // Function to encrypt
    static String encrypt(String text) {

    text = text.toUpperCase().replaceAll("[^A-Z]", "");

    // Padding
    while (text.length() % size != 0) {
        text += "X";
    }

    String result = "";

    // Process each block
    for (int i = 0; i < text.length(); i += size) {

        // Step 1: Convert block → numbers
        int[] plain = new int[size];
        for (int j = 0; j < size; j++) {
            plain[j] = text.charAt(i + j) - 'A';
        }

        // Step 2: Multiply with key matrix
        int[] cipher = new int[size];

        for (int row = 0; row < size; row++) {
            int sum = 0;

            for (int col = 0; col < size; col++) {
                sum += keyMatrix[row][col] * plain[col];
            }

            cipher[row] = sum % 26;
        }

        // Step 3: Convert back to letters
        for (int j = 0; j < size; j++) {
            result += (char)(cipher[j] + 'A');
        }
    }

    return result;
}

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of key matrix (e.g., 2 or 3): ");
        size = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter key (length = size*size): ");
        String key = sc.nextLine().toUpperCase();

        getKeyMatrix(key);

        System.out.println("\nKey Matrix:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(keyMatrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.print("\nEnter plaintext: ");
        String text = sc.nextLine();

        String cipher = encrypt(text);

        System.out.println("Encrypted Text: " + cipher);
    }
}