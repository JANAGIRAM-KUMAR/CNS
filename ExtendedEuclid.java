import java.util.*;

public class ExtendedEuclid {

    static int modInverse(int a, int m) {
        a = a % m;

        for (int x = 1; x < m; x++) {
            if ((a * x) % m == 1)
                return x;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int a = sc.nextInt();

        System.out.print("Enter modulo: ");
        int m = sc.nextInt();

        int inv = modInverse(a, m);

        if (inv == -1)
            System.out.println("Inverse doesn't exist");
        else
            System.out.println("Modular Inverse = " + inv);
    }
}