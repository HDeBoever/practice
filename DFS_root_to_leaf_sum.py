# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def hasPathSum(self, root: TreeNode, sum: int) -> bool:

        # Use DFS

        if root:

            curr_sum = 0
            sub_sum = sum - root.val
            if sub_sum == 0 and root.right == None and root.left == None:
                return True
            if root.left:
                curr_sum = curr_sum or self.hasPathSum(root.left, sub_sum)
            if root.right:
                curr_sum = curr_sum or self.hasPathSum(root.right, sub_sum)

            return curr_sum

        else:
            return False
