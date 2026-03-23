import java.util.*;

class OneTimePad {

    // Generate random key (same length as text)
    static String generateKey(int length) {
        Random rand = new Random();
        String key = "";

        for (int i = 0; i < length; i++) {
            key += (char)(rand.nextInt(26) + 'A');
        }

        return key;
    }

    // Encryption
    static String encrypt(String text, String key) {
        String result = "";
        text = text.toUpperCase();

        for (int i = 0; i < text.length(); i++) {

            char t = text.charAt(i);

            if (Character.isLetter(t)) {
                // int x = (t - 'A' + key.charAt(i) - 'A') % 26;

                // result += (char)(x + 'A');
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
    static String decrypt(String cipher, String key) {
        String result = "";

        for (int i = 0; i < cipher.length(); i++) {

            char t = cipher.charAt(i);

            if (Character.isLetter(t)) {
                // int x = (c - 'A' - (key.charAt(i) - 'A') + 26) % 26;
                // result += (char)(x + 'A');
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

        System.out.print("Enter plaintext: ");
        String text = sc.nextLine().toUpperCase();

        String key = generateKey(text.length());

        String cipher = encrypt(text, key);
        String decrypted = decrypt(cipher, key);

        System.out.println("Generated Key: " + key);
        System.out.println("Encrypted Text: " + cipher);
        System.out.println("Decrypted Text: " + decrypted);
    }
}