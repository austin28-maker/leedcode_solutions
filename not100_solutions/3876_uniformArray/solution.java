class Solution {
    public boolean uniformArray(int[] nums1) {
        // 计算最小偶数、最小奇数
        int[] mn = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        for (int x : nums1) {
            mn[x & 1] = Math.min(mn[x & 1], x); // &1 比 %2 好，nums1 有负数也适用
        }

        // 只有偶数，或者偶数 >= 最小的偶数 > 最小的奇数
        // 只有奇数的情况蕴含在 mn[0] > mn[1] 中
        return mn[1] == Integer.MAX_VALUE || mn[0] > mn[1];
    }
}