import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;



// 方法一：排序合并
// class Solution {
//     public int[][] merge(int[][] intervals) {
//         Arrays.sort(intervals, (p, q) -> p[0] - q[0]); // 按照左端点从小到大排序

//         List<int[]> ans = new ArrayList<>();
//         for (int[] p : intervals) {
//             int m = ans.size();
//             if (m > 0 && p[0] <= ans.get(m - 1)[1]) { // 左端点在合并区间内，可以合并
//                 ans.get(m - 1)[1] = Math.max(ans.get(m - 1)[1], p[1]); // 更新合并区间的右端点
//             } else { // 不相交，无法合并
//                 ans.add(p); // 新的合并区间
//             }
//         }
//         return ans.toArray(new int[ans.size()][]);
//     }
// }