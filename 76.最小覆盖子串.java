import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=76 lang=java
 *
 * [76] 最小覆盖子串
 */

// @lc code=start
class Solution {
    Map<Character, Integer> need = new HashMap<Character, Integer>();
    Map<Character, Integer> windows = new HashMap<Character, Integer>();

    public String minWindow(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char iterable_element = t.charAt(i);
            need.put(iterable_element, need.getOrDefault(iterable_element, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        // 记录最小覆盖子串的起始索引及⻓度     
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                windows.put(c, windows.getOrDefault(c, 0) + 1);
                if (windows.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            while (need.size() == valid && left <= right) {
                if (right - left + 1 < len) {
                    start = left;
                    len = right - left;
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (windows.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    windows.put(d, windows.getOrDefault(d, 0) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, len);
    }
}
// @lc code=end
