/*
 * @lc app=leetcode.cn id=875 lang=java
 *
 * [875] 爱吃香蕉的珂珂
 */

// @lc code=start
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left =1;
        int right = 1000000000+1;
        while(left < right){
            int mid = left+(right - left) /2;
            if(f(piles,mid) <= h){
                right = mid;
            }
            else{
                left =mid +1;
            }
        }
        return left;
    }
    int f(int[] piles,int x){
        int hour =0;
        for (int i = 0; i < piles.length; i++) {
            hour += piles[i] / x;
            if(piles[i] % x >0){
                hour++;
            }
        }
        return hour;
    }
}
// @lc code=end

