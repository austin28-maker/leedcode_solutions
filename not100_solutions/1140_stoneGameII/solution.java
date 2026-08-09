class Solution {
    public int stoneGameII(int[] piles) {
        int[] nums = new int[piles.length+1];
        for(int i=piles.length-1; i>=0; i--){
            nums[i] = nums[i+1] + piles[i];
        }
        int[][] dp = new int[piles.length][1 << 6];
        return dfs(0,1,dp,nums);
    }
    private int dfs(int j, int m, int[][] dp, int[] nums){
        if(j >= dp.length) return 0;
        if(dp[j][m] != 0) return dp[j][m];
        for(int i=j; i<Math.min(dp.length,j + (m << 1)); i++){
            dp[j][m] = Math.max(dp[j][m],nums[j] - dfs(i+1,Math.max(m,i-j+1),dp,nums));
        }
        return dp[j][m];
    }
}