/*
 * @lc app=leetcode.cn id=1011 lang=java
 *
 * [1011] 在 D 天内送达包裹的能力
 */

// @lc code=start
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left =0;
        int right =1;
        for (int i : weights) {
            left = Math.max(left, i);
            right += i;
        }
        while(left <right){
            int mid = left + (right -left )/2;
            if(f(weights, mid) <= days){
                right = mid;
            }
            else{
                left = mid+1;
            }
        }
        return left;
    }
    int f(int[] weights ,int x){
        int day = 0;
        for (int i = 0; i < weights.length; ) {
            int cap = x;
            while(i <weights.length ){
                if(cap < weights[i]) break;
                else cap -= weights[i];
                i++;
            }
            day++;
        }
        return day;
    }
}
// @lc code=end

