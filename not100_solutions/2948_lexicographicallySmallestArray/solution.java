class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        Integer[] pos = new Integer[n];
        Arrays.setAll(pos, i -> i); // 初始化 pos[i] = i
        Arrays.sort(pos, (i, j) -> nums[i] - nums[j]);
        // 排序后，nums[pos[i]] 是递增的

        int[] ans = new int[n];
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || nums[pos[i + 1]] - nums[pos[i]] > limit) { // 这一段的末尾
                // subPos 是 ans 中的一组空位（不一定有序）
                // 我们需要把 subPos 对应的 nums 中的数从小到大地填入空位（从左到右填）
                // 为了能从左到右填，需要把 subPos 排序
                Integer[] subPos = Arrays.copyOfRange(pos, start, i + 1);
                Arrays.sort(subPos);
                for (int j = 0; j < subPos.length; j++) {
                    ans[subPos[j]] = nums[pos[start + j]];
                }
                start = i + 1;
            }
        }
        return ans;
    }
}