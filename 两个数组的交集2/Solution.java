import java.util.Arrays;

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0;
        int p2 = 0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        int p = 0;
        int[] res = new int[len1 >=len2?len1:len2];
        while (p1 < len1 && p2 < len2){
            if (nums1[p1] == nums2[p2]){
                res[p] = nums1[p1];
                p++;
                p1++;
                p2++;
            }else if (nums1[p1] > nums2[p2]){
                p2++;
            }else {
                p1++;
            }

        }

        for (int i = 0; i <= p ; i++) {

        }
        return Arrays.copyOfRange(res, 0, p);

    }



}
