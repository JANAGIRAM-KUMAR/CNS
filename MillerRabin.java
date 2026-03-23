import java.util.*;

public class MillerRabin {

    static boolean isPrime(int n) {

        if (n < 2)
            return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int n = sc.nextInt();

        if (isPrime(n))
            System.out.println("Probably Prime Number");
        else
            System.out.println("Composite Number");
    }
}