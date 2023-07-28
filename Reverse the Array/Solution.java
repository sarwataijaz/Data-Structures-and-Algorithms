class Solution {
    public boolean isPalindrome(String s) {
        
        String forward = s.replaceAll("[^a-zA-Z0-9]", "");
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
}