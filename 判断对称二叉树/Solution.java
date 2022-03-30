
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode l, TreeNode r){
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



}
