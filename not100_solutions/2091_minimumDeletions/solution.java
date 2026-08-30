class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int p = 0;
        int q = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[p]) {
                p = i;
            } else if (nums[i] > nums[q]) {
                q = i;
            }
        }

        if (p > q) {
            // 保证 p <= q，方便下面计算
            int tmp = p;
            p = q;
            q = tmp;
        }
        return Math.min(Math.min(q + 1, n - p), p + 1 + n - q);
    }
}