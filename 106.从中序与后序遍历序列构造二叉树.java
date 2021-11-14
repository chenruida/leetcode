import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
 */

// @lc code=start
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    TreeNode build(int[] inorder, int inStar, int inEnd, int[] postorder, int postStar, int postEnd) {
        if (inStar > inEnd)
            return null;
        int rootVal = postorder[postEnd];
        int index = 0;
        for (int i = inStar; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        int leftSize = index - inStar;
        TreeNode root = new TreeNode(rootVal);
        root.left = build(inorder, inStar, index - 1, postorder, postStar, postStar + leftSize - 1);
        root.right = build(inorder, index + 1, inEnd, postorder, postStar + leftSize, postEnd - 1);
        return root;
    }
}
// @lc code=end
