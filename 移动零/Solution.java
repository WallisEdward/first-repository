public class Solution {
    public void moveZeroes(int[] nums) {
        int tem = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                int j = i;
                while ((j <nums.length) && (nums[j] == 0)){
                    j++;
                }
                if (j < nums.length){
                    tem = nums[j];
                    nums[j] = 0;
                    nums[i] = tem;
                }

            }
        }
    }



}
