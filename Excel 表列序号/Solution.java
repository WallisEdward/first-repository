public class Solution {
    public int titleToNumber(String columnTitle) {
        int sum = 0;
        int n = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            int k = columnTitle.charAt(i) - 'A' + 1;
            sum += k * n;
            n *= 26;
        }
        return sum;
    }
}
