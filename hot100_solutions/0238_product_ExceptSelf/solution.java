public class solution {
    public int[] productExceptSelf(int[] nums) {
        // 前缀积，后缀积
        int n = nums.length;
        int pre = 1, suf = 1;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = pre;
            pre *= nums[i];
        }
        for (int j = n - 1; j >= 0; j--) {
            ans[j] *= suf;
            suf *= nums[j];
        }
        return ans;
    }
}
