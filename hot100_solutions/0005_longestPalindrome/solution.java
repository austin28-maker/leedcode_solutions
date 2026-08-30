class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        int maxStart = 0;
        int maxLength = 0;
        for (int i = 0; i< length; i++) {
            // j=0表示中心节点只有 i，j=1，表示中心节点有两个 i，i+1;
            for (int j=0; j <=1; j++) {
                int l = i;
                int r = i+j;

                while(l >=0 && r < length && s.charAt(l) == s.charAt(r)){
                    l--;
                    r++;
                }
                
                // 回溯到回文字符串的起始和结束位置
                l++;
                r--;
                // 经过加减操作后，此刻的 l 和 r 分别指向回文字符串的起始和结束位置
                
                // 比较并保存最长的字符串起始位置和长度。
                if (maxLength < r - l + 1) {
                    maxLength = r - l + 1;
                    maxStart = l;
                }
            }
        }

        return s.substring(maxStart, maxStart + maxLength);
    }
}

// class Solution {
//     public String longestPalindrome(String s) {
//         if (s == null || s.length() < 2) {
//             return s;
//         }
//         int strLen = s.length();
//         int maxStart = 0;  //最长回文串的起点
//         int maxEnd = 0;    //最长回文串的终点
//         int maxLen = 1;  //最长回文串的长度

//         boolean[][] dp = new boolean[strLen][strLen];

//         for (int r = 1; r < strLen; r++) {
//             for (int l = 0; l < r; l++) {
//                 if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
//                     dp[l][r] = true;
//                     if (r - l + 1 > maxLen) {
//                         maxLen = r - l + 1;
//                         maxStart = l;
//                         maxEnd = r;

//                     }
//                 }

//             }

//         }
//         return s.substring(maxStart, maxEnd + 1);

//     }
// }