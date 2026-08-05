
import java.util.HashMap;
import java.util.Map;

public class solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);// .put()方法可以将键值对加入到哈希映射中，如果键已经存在，就用新值替换旧值
        // 0表示空子数组，出现次数为1次
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            res += map.getOrDefault(sum - k, 0);// .getOrDefault()方法可以获取键为sum - k的值，如果键不存在，就返回0
            // 这里sum - k表示子数组的和为k，所以如果sum - k在map中，就说明存在一个子数组的和为k，
            // 所以就将map中sum - k的值加入到结果中，
            // 为什么不是k-sum？因为sum表示当前子数组的和，所以k-sum表示子数组的和为k，
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
