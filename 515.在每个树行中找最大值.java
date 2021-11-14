import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=515 lang=java
 *
 * [515] 在每个树行中找最大值
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
    List<Integer> maxList = new ArrayList<>();

    public List<Integer> largestValues(TreeNode root) {
        levelOrder(root, 0);
        return maxList;
    }

    void levelOrder(TreeNode root, int deep) {
        if (root == null)
            return;
        // 增加一层
        deep++;
        if (maxList.size() < deep) {
            List<Integer> item = new ArrayList<Integer>();
            maxList.add(root.val);
        }
        //当前层存在
        maxList.set(deep - 1, Math.max(maxList.get(deep - 1), root.val));
        levelOrder(root.left, deep);
        levelOrder(root.right, deep);
    }

}
// @lc code=end
