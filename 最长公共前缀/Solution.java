

public class Solution {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        String preFix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; (j < preFix.length()) && (j < strs[i].length()); j++) {
                if (strs[i].charAt(j) != preFix.charAt(j)){
                    break;
                }
            }
            preFix = preFix.substring(0,j);
            if (preFix == ""){
                return preFix;
            }
        }
        return preFix;
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
