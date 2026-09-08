import java.util.Arrays;

// 方法一：Dynamic programming.
// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         if(nums.length == 0) return 0;
//         int[] dp = new int[nums.length];
//         int res = 0;
//         Arrays.fill(dp, 1);
//         for(int i = 0; i < nums.length; i++) {
//             for(int j = 0; j < i; j++) {
//                 if(nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
//             }
//             res = Math.max(res, dp[i]);
//         }
//         return res;
//     }
// }

// 方法二：Dynamic规划 + 二分查找
import java.util.*;

public class solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        List<Integer> dp = new ArrayList<>();
        dp.add(nums[0]);
        
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > dp.get(dp.size() - 1)) {
                dp.add(num);
            } else {
                // 二分查找第一个 >= num 的位置（左边界）
                int left = 0, right = dp.size() - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (dp.get(mid) >= num) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                // 用 num 替换该位置（原 Python 代码中误用了 dp[right]，此处修正为 dp[left]）
                dp.set(left, num);
            }
        }
        return dp.size();
    }
}