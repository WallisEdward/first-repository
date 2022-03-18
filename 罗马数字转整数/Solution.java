public class Solution {
    public static int romanToInt(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int nextnum = getValue(s.charAt(i));
            if (preNum < nextnum){
                sum -= preNum;
            }else {
                sum += preNum;
            }
            preNum = nextnum;
        }
        sum += preNum;
        return sum;
    }

    private static int getValue(char ch){
        switch (ch){
            case 'I':return 1;
            case 'V':return 5;
            case 'X':return 10;
            case 'L':return 50;
            case 'C':return 100;
            case 'D':return 500;
            case 'M':return 1000;
            default:return 0;
        }
    }
    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }
}
