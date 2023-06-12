import java.util.*;
public class Solution
{ 
    public static int findSum(int A[],int N) 
    {
        int min = A[0];
        int max = A[0];
        
        for(int i = 1; i < N; i++) {
            
            if(A[i] < min) {
                min = A[i];
            }
            
            if(A[i] > max) {
                max = A[i];
            }
        }
        
        int result = max + min;
        
        return result;
    }

    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int size = sc.nextInt();
            int arr[] = new int[size];

            for(int i = 0; i < size; i++) {
                System.out.println("A["+i+"]");
                arr[i] = sc.nextInt();
            }

            System.out.print(findSum(arr, size));
    }
}