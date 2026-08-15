
import java.util.HashMap;
import java.util.Map;

public class solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0; // res表示子数组的出现次数
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);// .put()方法可以将键值对加入到哈希映射中，如果键已经存在，就用新值替换旧值
        // 0表示空子数组，出现次数为1次

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]; // 计算前缀和

            // 计算和为k的子数组的出现次数
            res += map.getOrDefault(sum - k, 0);

            // 将当前前缀和加入到map中，出现次数加1
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            // 所以哈希表中存储的键就是当前前缀和，值就是当前前缀和的出现次数
            // 不要把问题想复杂了，本题要解决的不是返回满足要求的子数组的起始索引，而是出现次数
            // 所以只需要计算前缀和为k的子数组的出现次数即可
        }
        return res;
    }
}
