import java.util.*;

public class VigenereCipher {

    // Generate repeated key
    static String generateKey(String text, String key) {
        key = key.toUpperCase();
        StringBuilder newKey = new StringBuilder();

        int j = 0;
        for (int i = 0; i < text.length(); i++) {

            if (Character.isLetter(text.charAt(i))) {
                newKey.append(key.charAt(j % key.length()));
                j++;
            } else {
                newKey.append(text.charAt(i)); // keep spaces
            }
        }

        return newKey.toString();
    }

    // Encryption
    static String encrypt(String text, String key) {
        String result = "";
        text = text.toUpperCase();

        for (int i = 0; i < text.length(); i++) {

            char t = text.charAt(i);

            if (Character.isLetter(t)) {
                int x = (t + key.charAt(i)) % 26;
                x += 'A';
                result += (char)x;
            } else {
                result += t;
            }
        }

        return result;
    }

    // Decryption
    static String decrypt(String text, String key) {
        String result = "";
        text = text.toUpperCase();

        for (int i = 0; i < text.length(); i++) {

            char t = text.charAt(i);

            if (Character.isLetter(t)) {
                int x = (t - key.charAt(i) + 26) % 26;
                x += 'A';
                result += (char)x;
            } else {
                result += t;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.print("Enter key: ");
        String key = sc.nextLine();

        String newKey = generateKey(text, key);

        String encrypted = encrypt(text, newKey);
        String decrypted = decrypt(encrypted, newKey);

        System.out.println("Generated Key: " + newKey);
        System.out.println("Encrypted Text: " + encrypted);
        System.out.println("Decrypted Text: " + decrypted);
    }
}