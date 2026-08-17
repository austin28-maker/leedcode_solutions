class Solution {
    public String minWindow(String S, String t) {
        int[] diff = new int[128]; // 窗口每种字母个数 - t 每种字母个数
        int kinds = 0;
        for (char c : t.toCharArray()) {
            if (diff[c] == 0) {
                kinds++; // 统计 t 有多少个不同的字母
            }
            diff[c]--;
        }

        char[] s = S.toCharArray();
        int m = s.length;
        int ansLeft = -1;
        int ansRight = m;
        int geCnt = 0; // 窗口内有 geCnt 种字母的出现次数 >= t 中相应字母的出现次数
        int left = 0;

        for (int right = 0; right < m; right++) { // 移动子串右端点
            char c = s[right]; // 右端点字母
            diff[c]++; // 右端点字母移入子串
            if (diff[c] == 0) { // 原来窗口内 c 的出现次数比 t 的少，现在一样多
                geCnt++; // 从 < 变成 >=
            }

            while (geCnt == kinds) { // 涵盖：所有字母的出现次数都是 >=
                if (right - left < ansRight - ansLeft) { // 找到更短的子串
                    ansLeft = left; // 记录此时的左右端点
                    ansRight = right;
                }

                char x = s[left]; // 左端点字母
                if (diff[x] == 0) {
                    // x 移出窗口之前，检查出现次数，
                    // 如果窗口内 x 的出现次数和 t 一样，
                    // 那么 x 移出窗口后，窗口内 x 的出现次数比 t 的少
                    geCnt--; // 从 >= 变成 <
                }
                diff[x]--; // 左端点字母移出子串
                left++;
            }
        }

        return ansLeft < 0 ? "" : S.substring(ansLeft, ansRight + 1);
    }
}

// 优化前的代码
// class Solution {
//     public String minWindow(String S, String t) {
//         int[] cntS = new int[128]; // s 子串字母的出现次数
//         int[] cntT = new int[128]; // t 中字母的出现次数
//         for (char c : t.toCharArray()) {
//             cntT[c]++; // 这里数组索引c表示的是字母c的ASCII码值，cntT[c]表示的是字母c在t中出现的次数
//         }

//         char[] s = S.toCharArray(); // 将S转换为字符数组
//         int m = s.length;
//         int ansLeft = -1; // 初始化答案左端点为-1
//         int ansRight = m; // 初始化答案右端点为数组长度
//         int left = 0;

//         for (int right = 0; right < m; right++) { // 移动子串右端点
//             cntS[s[right]]++; // 右端点字母移入子串
//             while (isCovered(cntS, cntT)) { // 涵盖
//                 if (right - left < ansRight - ansLeft) { // 找到更短的子串
//                     ansLeft = left; // 记录此时的左右端点
//                     ansRight = right;
//                 }
//                 cntS[s[left]]--; // 左端点字母移出子串
//                 left++;
//             }
//         }

//         return ansLeft < 0 ? "" : S.substring(ansLeft, ansRight + 1); // .substring()方法返回的是一个新的字符串，
//                                                                       // 起始索引是包含在内，结束索引是不包含在内的，所以需要+1
//     }

//     private boolean isCovered(int[] cntS, int[] cntT) {
//         for (int i = 'A'; i <= 'Z'; i++) {
//             if (cntS[i] < cntT[i]) {
//                 return false;
//             }
//         }
//         for (int i = 'a'; i <= 'z'; i++) {
//             if (cntS[i] < cntT[i]) {
//                 return false;
//             }
//         }
//         return true;
//     }
// }