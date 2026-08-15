class Solution {
    public int longestSubsequence(int[] nums) {
        boolean hasNonZero = false;
        int xor = 0;
        for (int x : nums) {
            hasNonZero = hasNonZero || x != 0;
            xor ^= x;
        }
        if (!hasNonZero) {
            return 0; // nums 全为 0，无解
        }

        int ans = nums.length;
        if (xor == 0) {
            ans--; // 去掉 nums 的一个非零元素，就可以使 xor 不为 0
        }
        return ans;
    }
}

