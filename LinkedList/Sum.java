import java.util.*;
public class Sum {

    public static float result(int ...num) { // an array

        float avg = 0;

        for(int i : num) {
            avg += i;
        }

        avg = avg / num.length;

        return avg;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size: ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter " + size + " numbers: ");

        for(int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Average is: " + result(arr));
    }
}
