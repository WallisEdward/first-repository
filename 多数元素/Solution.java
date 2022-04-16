
import java.util.HashMap;
import java.util.Map;
//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数
// 大于  n/2 ⌋的元素。
//
//你可以假设数组是非空的，并且给定的数组总是存在多数元素。
public class Solution {
    public int majorityElement(int[] nums) {
        //方法一：先排序，再返回下标为n/2的元素的值
//        Arrays.sort(nums);
//        return nums[nums.length/2];

        //方法二：用hashMap来存储
        Map<Integer,Integer> ans = new HashMap<>();
        int majkey = 0;
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            if (ans.isEmpty() || !ans.containsKey(nums[i])){
                ans.put(nums[i], 1);
                if (majkey == 0){
                    majkey = nums[i];
                }
            }else {
                ans.put(nums[i], ans.get(nums[i]) + 1);
                if (ans.get(nums[i]) >= count){
                    count = ans.get(nums[i]);
                    majkey = nums[i];
                }
            }
        }
        return majkey;

    }
}
