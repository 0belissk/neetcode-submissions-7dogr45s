class Solution {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Postorder: solve left and right first
        int left = Math.max(0, dfs(node.left));
        int right = Math.max(0, dfs(node.right));

        // Complete path where this node is the highest point
        int pathThroughNode = node.val + left + right;

        // Update global maximum
        maxSum = Math.max(maxSum, pathThroughNode);

        // Return one continuous path upward
        return node.val + Math.max(left, right);
    }
}