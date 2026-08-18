import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        if (k == n) {
            return Arrays.stream(nums).max().getAsInt();
            // .stream() 是一个流操作，返回一个流对象，可以对流中的元素进行操作
            // .max() 是一个流操作，返回一个 OptionalInt 对象，包含流中的最大值
            // .getAsInt() 是一个方法引用，返回 OptionalInt 对象中的值，如果 OptionalInt 对象为空，则抛出 NoSuchElementException 异常
        }
        if (k == 1) {
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int x : nums) {
                cnt.merge(x, 1, Integer::sum); // 等价于cnt[x]++
                // .merge() 是一个方法操作，用于更新映射中的值
                // 这里使用 Integer::sum 函数，将当前值与 1 相加，得到新的值
                // 如果映射中不存在指定键，则创建一个新的键值对，键为 x，值为 1
                // 如果映射中存在指定键，则将当前值与 1 相加，得到新的值，更新映射中的值
            }
            int ans = -1;
            for (var e : cnt.entrySet()) { // .entrySet() 是一个方法操作，返回一个 Set 对象，包含映射中的所有键值对
                if (e.getValue() == 1) {
                    ans = Math.max(ans, e.getKey());
                }
            }
            return ans;
        }
        // nums[0] 不能出现在其他地方，nums[n-1] 同理
        return Math.max(f(nums, 1, n, nums[0]), f(nums, 0, n - 1, nums[n - 1]));
    }

    // 检查 x 是否在 nums[begin:end) 中
    private int f(int[] nums, int begin, int end, int x) {
        for (int i = begin; i < end; i++) {
            if (nums[i] == x) {
                return -1;
            }
        }
        return x;
    }
}