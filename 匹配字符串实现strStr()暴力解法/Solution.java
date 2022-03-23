public class Solution {
    public int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        for (int i = 0; i + n <= m; i++) {
            Boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)){
                    flag = false;
                    break;
                }
            }
            if (flag){
                return i;
            }
        }

        return -1;
    }
}
