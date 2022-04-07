import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public static boolean check(TreeNode l, TreeNode r){
        if (l == null && r == null){
            return true;
        }
        if (l == null || r == null){
            return  false;
        }
        return (l.val == r.val)
                && check(l.left, r.right)
                && check(l.right,r.left);
    }

//根据含有null值的int数组（层序遍历）还原二叉树
    public  static TreeNode creatTree(Integer[] arr){
        if (arr[0] == null) {
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 1; i < arr.length; i+=2) {
            TreeNode father = queue.poll();
            if (arr[i] != null){
                TreeNode left = new TreeNode(arr[i]);
                queue.add(left);
                father.left = left;
            }
            if (arr[i+1] != null){
                TreeNode right = new TreeNode(arr[i+1]);
                queue.add(right);
                father.right = right;
            }

        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,2,3,4,4,3};
        TreeNode root = creatTree(arr);
        System.out.println(isSymmetric(root));
    }


}
