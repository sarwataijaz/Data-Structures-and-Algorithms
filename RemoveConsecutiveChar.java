public class RemoveConsecutiveChar {
    class Solution{
        public String removeConsecutiveCharacter(String S){

            StringBuilder sb = new StringBuilder(S);
            String result = "";

            for(int i = 1; i < sb.length();) {

                if(sb.charAt(i) == sb.charAt(i-1)) {
                    sb.deleteCharAt(i);
                }

                else {
                    i++;
                }
            }

            result += sb;

            return result;
        }
    }
}
