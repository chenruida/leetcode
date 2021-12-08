/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m != 0 && n == 0) {
            return;
        }
        if (m == 0 && n != 0) {
            nums1 = nums2;
        }
        while (m == 0 && n == 0) {

        }
    }
}
// @lc code=end
