import java.util.HashSet;
import java.util.Set;

// 优化
class Solution {
    public int longestConsecutive(int[] nums) {
        // 初始化哈希集合
        Set<Integer> st = new HashSet<>();
        for (int num : nums) {
            st.add(num); // 把 nums 转成哈希集合
        }
        int m = st.size();

        int ans = 0;
        for (int x : st) { // 遍历哈希集合
            if (st.contains(x - 1)) { // 如果 x 不是序列的起点，直接跳过
                continue;
            }
            // x 是序列的起点
            int y = x + 1;
            while (st.contains(y)) { // 不断查找下一个数是否在哈希集合中
                y++;
            }
            // 循环结束后，y-1 是最后一个在哈希集合中的数
            ans = Math.max(ans, y - x); // 从 x 到 y-1 一共 y-x 个数
            if (ans * 2 >= m) {
                break;
            }
        }
        return ans;
    }
}

// class solution {
//     class Solution {
//         public int longestConsecutive(int[] nums) {
//             Set<Integer> set = new HashSet<>();
//             for (int num : nums) {
//                 set.add(num);
//             }
//             int maxlength = 0;
//             for (int num : set) {
//                 if (!set.contains(num - 1)) {
//                     int current = num;
//                     int length = 1;
//                     while (set.contains(current + 1)) {
//                         current += 1;
//                         length += 1;
//                     }
//                     maxlength = Math.max(length, maxlength);
//                 }
//             }
//             return maxlength;
//         }
//     }
// }