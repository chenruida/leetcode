/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = digits.length - 1; i >= 0; i--) {
            // 有零则进位
            if (digits[i] == 9) {
                digits[i] = 0;
                // 一旦发现不用进位的index,直接返回
            } else {
                digits[i]++;
                return digits;
            }
        }
        // 全都是
        int[] a = new int[len + 1];
        a[0] = 1;
        for (int i = 1; i < len + 1; i++) {
            a[i] = 0;
        }
        return a;

    }
}
// @lc code=end
