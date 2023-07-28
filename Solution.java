import java.util.*;

class Solution {

    public static boolean isPalindrome(String s) {
        
        String forward = s.replaceAll("[^a-zA-Z0-9]","");
        String result = forward.toLowerCase();
        String backward = "";
        
        for(int i = result.length() - 1; i >= 0; i--) {
            backward += result.charAt(i);
        }
        
        if(result.equals(backward)) {
            return true;
        }
        
        else {
            return false;
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a palindrome string: ");
        String s = sc.nextLine();
        System.out.println(isPalindrome(s));
    }
}