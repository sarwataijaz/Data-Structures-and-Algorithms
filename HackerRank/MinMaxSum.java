import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
    // Write your code here
    long minSum = 0;
    long maxSum = 0;
    
    for(int i=0; i<arr.size(); i++) {
        int temp=arr.get(i);
        long sum=0;
        int duplicateIfExist=0;
        for(int j=0; j<arr.size(); j++) {
            if(arr.get(j)!=temp || duplicateIfExist==temp)
            sum += arr.get(j);
            duplicateIfExist = arr.get(j);
        }
        if(i==0){
            maxSum = sum; // 14
            minSum = sum; // 14
        } else {
            if(sum>maxSum)
            maxSum = sum;
            if(sum<minSum)
            minSum = sum;
        }
    }
    
    System.out.println(minSum+" "+maxSum);

    }

}

public class MinMaxSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}