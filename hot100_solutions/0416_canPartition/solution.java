class Solution {
    public boolean canPartition(int[] nums) {
        int s = 0;
        for (int x : nums) {
            s += x;
        }
        if (s % 2 != 0) {
            return false;
        }
        s /= 2; // 注意这里把 s 减半了

        boolean[] f = new boolean[s + 1];
        f[0] = true;
        int s2 = 0;
        for (int x : nums) {
            s2 = Math.min(s2 + x, s);
            for (int j = s2; j >= x; j--) {
                f[j] = f[j] || f[j - x];
            }
            if (f[s]) {
                return true;
            }
        }
        return false;
    }
}