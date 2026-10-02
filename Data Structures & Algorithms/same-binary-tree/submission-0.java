/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    boolean same = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //check if current node p is equal to current node q, if no return false
        //go down left side, checking if each left p and left q are the same
        //go down right side, checking if each right p and right q are the same

        if (p != null && q == null || p == null && q != null) {
            same = false;
            return false;
            
        } else if (p == null && q == null){
            return true;
        }

        if (p.val != q.val) {
            same = false;
        }

        isSameTree(p.left, q.left);
        isSameTree(p.right, q.right);

        return same;
        
    }

    
}
