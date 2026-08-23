import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 第一步：统计每个元素的出现次数
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            cnt.merge(x, 1, Integer::sum); // cnt[x]++
        }
        int maxCnt = Collections.max(cnt.values());

        // 第二步：把出现次数相同的元素，放到同一个桶中
        List<Integer>[] buckets = new ArrayList[maxCnt + 1];

        // 给数组的每个格子都装上一个空 ArrayList，用于存储出现次数相同的元素
        Arrays.setAll(buckets, _ -> new ArrayList<>()); // 对数组每个下标 i，调用一次箭头函数，把返回值填进 buckets[i]

        for (Map.Entry<Integer, Integer> e : cnt.entrySet()) {
            buckets[e.getValue()].add(e.getKey());
        }

        // 第三步：倒序遍历 buckets，把出现次数前 k 大的元素加入答案
        int[] ans = new int[k];
        int j = 0;
        for (int i = maxCnt; j < k; i--) {
            // 注意题目保证答案唯一，一定会出现某次循环结束后 j 恰好等于 k 的情况
            for (int x : buckets[i]) {
                ans[j++] = x; // 等价于ans[j] = x; j++;
            }
        }
        return ans;
    }
}