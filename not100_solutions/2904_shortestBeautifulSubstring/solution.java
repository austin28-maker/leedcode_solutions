// 方法一：枚举右端
class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        // 1 的个数不足 k
        if (s.replace("0", "").length() < k) {
            // s.replace("0", "") 会将 s 中的 0 全部替换为 ""
            // 所以 s.replace("0", "").length() 就是 s 中的 1 的个数
            return "";
        }
        // 否则一定有解
        for (int size = k; ; size++) {
            String ans = "";

            //  i 是“窗口的右端”，不是起点
            for (int i = size; i <= s.length(); i++) {
                String t = s.substring(i - size, i);
                if ((ans.isEmpty() || t.compareTo(ans) < 0) && t.replace("0", "").length() == k) { // 如果 t 是一个符合条件的子字符串
                    ans = t;
                }
            }
            if (!ans.isEmpty()) {
                return ans;
            }
        }
    }
}

// 方法二：滑动窗口
// class Solution {
//     public String shortestBeautifulSubstring(String S, int k) {
//         if (S.replace("0", "").length() < k) {
//             return "";
//         }
//         char[] s = S.toCharArray();
//         String ans = S;
//         int cnt1 = 0, left = 0;
//         for (int right = 0; right < s.length; right++) {
//             cnt1 += s[right] - '0';
//             while (cnt1 > k || s[left] == '0') {
//                 cnt1 -= s[left++] - '0';
//             }
//             if (cnt1 == k) {
//                 String t = S.substring(left, right + 1);
//                 if (t.length() < ans.length() || t.length() == ans.length() && t.compareTo(ans) < 0) {
//                     ans = t;
//                 }
//             }
//         }
//         return ans;
//     }
// }