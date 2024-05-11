import java.util.*;

public class Recursion {
    static int sum(int n, int lastDigitSum) {

        int currentDigit = n % 10; // 1010-> 0+101,  1+
        // Add the current digit only if it's different from the last processed digit
        lastDigitSum = currentDigit == lastDigitSum ? lastDigitSum : lastDigitSum + currentDigit;
        return sum(n / 10, lastDigitSum);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();
        int k = sum(n, 0); // Initialize lastDigitSum to 0 for the first call
        System.out.println(k);
    }
}

