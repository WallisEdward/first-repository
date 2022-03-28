
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        for (int i = 0; i < n; i++) {
//            nums1[m+i] = nums2[i];
//        }
//        Arrays.sort(nums1);
        int point1 = m - 1;
        int point2 = n - 1;
        int aim = m + n - 1;
        while (point1 >= 0 || point2 >=0){
            if (point1 == -1){
                nums1[aim] = nums2[point2];
                point2--;
                aim --;
            }else if(point2 == -1){
                nums1[aim] = nums1[point1];
                point1--;
                aim --;
            }else if(nums1[point1] > nums2[point2]){
                nums1[aim] = nums1[point1];
                point1--;
                aim --;
            }else {
                nums1[aim] = nums2[point2];
                point2--;
                aim --;
            }
        }
    }
}
