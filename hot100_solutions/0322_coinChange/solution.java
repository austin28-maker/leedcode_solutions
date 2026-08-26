class Solution {
    public int coinChange(int[] coins, int amount) {
        // 自底向上的动态规划
        if(coins.length == 0){
            return -1;
        }

        // memo[n]的值： 表示的凑成总金额为n所需的最少的硬币个数
        int[] memo = new int[amount+1];
        memo[0] = 0;
        for(int i = 1; i <= amount; i++){
            int min = Integer.MAX_VALUE; // Integer.MAX_VALUE = 2^31 - 1

            // 解释一下下面的for循环在做什么事情？
            // 遍历所有可能的硬币，找到凑成总金额为i所需的最少的硬币个数
            // 如果i - coins[j] >= 0，说明当前硬币可以被使用
            // 如果memo[i - coins[j]] < min，说明当前硬币可以被使用，且当前硬币的个数更少
            // 则更新min为memo[i - coins[j]] + 1
            // 否则，当前硬币不能被使用，或者当前硬币的个数更多
            for(int j = 0; j < coins.length; j++){
                if(i - coins[j] >= 0 && memo[i - coins[j]] < min){
                    min = memo[i - coins[j]] + 1;
                }
            }
            // memo[i] = (min == Integer.MAX_VALUE ? Integer.MAX_VALUE : min);
            memo[i] = min;
        }

        return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];
    }
}