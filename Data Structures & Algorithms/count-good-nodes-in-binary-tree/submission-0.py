# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        def dsf(node, maxValue):
            if not node:
                return 0
            if node.val >= maxValue:
                res = 1
            else:
                res = 0
            maxValue = max(node.val, maxValue)
            res += dsf(node.left, maxValue)
            res += dsf(node.right, maxValue)
            return res
        return dsf(root, root.val)