/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] intArray = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int test = nums[i] + nums[j];
                if (test == target) {
                    intArray[0] = i;
                    intArray[1] = j;
                }
            }
        }
        return intArray;
    }
}
// @lc code=end
