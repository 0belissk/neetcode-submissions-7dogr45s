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
    boolean heightBalanced = true;
    public boolean isBalanced(TreeNode root) {
        //go down left
        //go down right
        //parent node, compares left and right, if the comparison is greater than 1 return false
        dfs(root);
        return heightBalanced;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        if (Math.max(left,right) - Math.min(left, right) > 1) {
            heightBalanced = false;
        }
        
        return 1 + Math.max(left,right);
    }
}
