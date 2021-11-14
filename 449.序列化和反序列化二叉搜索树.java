import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=449 lang=java
 *
 * [449] 序列化和反序列化二叉搜索树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    // 代表分隔符的字符
    String SEP = ",";
    // 空字符串
    String NULL = "#";

    /**
     * 前序
     */
    // // Encodes a tree to a single string. 
    // public String serialize(TreeNode root) {
    //     StringBuilder sb = new StringBuilder();
    //     traverse(root, sb);
    //     return sb.toString();
    // }

    // // Decodes your encoded data to tree.
    // public TreeNode deserialize(String data) {
    //     LinkedList<String> nodes = new LinkedList<>();
    //     for (String s : data.split(SEP)) {
    //         nodes.addLast(s);
    //     }
    //     return deserialize(nodes);
    // }

    // void traverse(TreeNode root, StringBuilder sb) {
    //     if (root == null) {
    //         sb.append(NULL).append(SEP);
    //         return;
    //     }
    //     sb.append(root.val).append(SEP);
    //     traverse(root.left, sb);
    //     traverse(root.right, sb);
    // }

    // TreeNode deserialize(LinkedList<String> nodes) {
    //     if (nodes.isEmpty())
    //         return null;
    //     String first = nodes.removeFirst();
    //     if (first.equals(NULL))
    //         return null;
    //     TreeNode root = new TreeNode(Integer.parseInt(first));
    //     root.left = deserialize(nodes);
    //     root.right = deserialize(nodes);
    //     return root;
    // }

    /**
     * 后序
     */
    // // Encodes a tree to a single string. 
    // public String serialize(TreeNode root) {
    //     StringBuilder sb = new StringBuilder();
    //     traverse(root, sb);
    //     return sb.toString();
    // }

    // // Decodes your encoded data to tree.
    // public TreeNode deserialize(String data) {
    //     LinkedList<String> nodes = new LinkedList<>();
    //     for (String s : data.split(SEP)) {
    //         nodes.addLast(s);
    //     }
    //     return deserialize(nodes);
    // }

    // void traverse(TreeNode root, StringBuilder sb) {
    //     if (root == null) {
    //         sb.append(NULL).append(SEP);
    //         return;
    //     }
    //     traverse(root.left, sb);
    //     traverse(root.right, sb);
    //     sb.append(root.val).append(SEP);
    // }

    // TreeNode deserialize(LinkedList<String> nodes) {
    //     if (nodes.isEmpty())
    //         return null;
    //     String first = nodes.removeLast();
    //     if (first.equals(NULL))
    //         return null;
    //     TreeNode root = new TreeNode(Integer.parseInt(first));
    //     root.right = deserialize(nodes);
    //     root.left = deserialize(nodes);
    //     return root;
    // }

    void traverse(TreeNode root, StringBuilder sb) {
        if (root == null)
            return;
        // 初始化队列，将 root 加入队列
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();

            /* 层级遍历代码位置 */
            if (cur == null) {
                sb.append(NULL).append(SEP);
                continue;
            }
            sb.append(cur.val).append(SEP);
            /*****************/

            q.offer(cur.left);
            q.offer(cur.right);
        }
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
// @lc code=end
