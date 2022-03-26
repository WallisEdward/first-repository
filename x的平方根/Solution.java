public class Solution {
    public static int mySqrt(int x) {
        int pre = 0;
        int back = x;
        int ans = -1;
        while (pre <= back){
            int mid = pre + (back -pre)/2;
            System.out.println("mid=" + mid);
            if ((long)mid * mid <= x){
                ans = mid;
                System.out.println("ans=" + ans);
                pre = mid + 1;
                System.out.println("pre=" + pre);
            }else {
                back = mid-1;
                System.out.println("back=" + back);
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int  a = 10;
        System.out.println(mySqrt(a));
    }
}
