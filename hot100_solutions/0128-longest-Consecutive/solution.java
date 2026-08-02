import java.util.HashSet;
import java.util.Set;

public class solution {
    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            int maxlength = 0;
            for (int num : set) {
                if (!set.contains(num - 1)) {
                    int current = num;
                    int length = 1;
                    while (set.contains(current + 1)) {
                        current += 1;
                        length += 1;
                    }
                    maxlength = Math.max(length, maxlength);
                }
            }
            return maxlength;
        }
    }
}
