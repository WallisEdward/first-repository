public class Solution {
    public int maxSubArray(int[] nums) {

        int curNum = nums[0];
        int maxNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curNum = max(nums[i] , curNum + nums[i]);
            maxNum = max(curNum, maxNum);
        }
        return maxNum;
    }

    public int max(int num1, int num2){
        if (num1 > num2){
            return num1;
        }else {
            return num2;
        }
    }
}
