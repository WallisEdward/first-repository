public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        //二搜索树：要么为空树，要么满足根节点的左子树都小于根节点，
        // 根节点的右子树都大于根节点，它的左右子树都小于它的根节点
        return BinarySearchTree(nums, 0, nums.length-1);
    }

    public TreeNode BinarySearchTree(int[] nums, int left, int right){
        if (left > right){
            return null;
        }

        int mid = (left + right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = BinarySearchTree(nums, left, mid-1);
        root.right = BinarySearchTree(nums, mid+1, right);
        return root;
    }

}
