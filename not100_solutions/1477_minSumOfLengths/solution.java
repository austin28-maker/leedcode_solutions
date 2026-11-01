class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        // sufMin[i] 表示左端点 >= i 的和为 target 的最短子数组长度
        // 不存在子数组时，长度设为 n+1
        int[] sufMin = new int[n];
        int minLen = n + 1;
        int sum = 0;
        int r = n - 1;
        for (int l = n - 1; l > 0; l--) {
            sum += arr[l];
            while (sum > target) {
                sum -= arr[r];
                r--;
            }
            if (sum == target) {
                minLen = Math.min(minLen, r - l + 1); // 维护遍历过的和为 target 的子数组的最短长度
            }
            sufMin[l] = minLen; // 保存此时此刻的 minLen
        }

        int ans = n + 1;
        sum = 0;
        int l = 0;
        for (r = 0; r < n - 1; r++) {
            sum += arr[r];
            while (sum > target) {
                sum -= arr[l];
                l++;
            }
            if (sum == target) {
                ans = Math.min(ans, r - l + 1 + sufMin[r + 1]);
            }
        }

        return ans > n ? -1 : ans;
    }
}