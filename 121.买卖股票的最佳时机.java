/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        if (prices.length == 1)
            return max;
        for (int i = 0; i < prices.length - 1; i++) {
            int temp = findMax(prices, i);
            int tempMax = temp - prices[i];
            if (tempMax > max) {
                max = tempMax;
            }
        }
        return max;
    }

    private int findMax(int[] arr, int head) {
        int max = 0;
        for (int i = head + 1; i < arr.length; i++) {
            if (arr[i] > max) { // 当前值大于最大值，赋值为最大值
                max = arr[i];
            }
        }
        return max;
    }
}
// @lc code=end
