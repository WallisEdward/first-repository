import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int turnSum(int n){
        int sum = 0;
        while (n > 0){
            int last = n % 10;
            sum += last*last;
            n = n / 10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)){//这里不能拆开写会超出时间限制
            set.add(n);
            n = turnSum(n);

        }
        return n == 1;
    }
}
