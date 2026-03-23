import java.util.*;

public class CaesarCipher {

    static String encrypt(String text, int key) {
        String result = "";

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char ch = (char)((c - 'a' + key) % 26 + 'a');
                result += ch;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.print("Enter key: ");
        int key = sc.nextInt();

        System.out.println("Encrypted = " + encrypt(text, key));
    }
}