class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        int maxLen = 0;
        int n = s.length();
        if(n == 0) return 0;
        int[] arr = new int[128];// 记录每个字符的最近一次出现的位置
        int start = 0;
        for(int i = 0; i < n; i++){
            char c = s.charAt(i); // .charAt()方法用于获取字符串s的第i个字符，返回值为char类型
            // 为什么是128？
            // 因为ASCII码表中，128个字符，所以要开128个空间，每个空间记录一个字符的最近一次出现的位置

            if(arr[c] != 0){
                // char 可以直接当数组下标，下标 c 就是字符 c 的 ASCII 码值
                // 所以 arr[c] 就是字符 c 最近一次出现的位置
                 start = Math.max(arr[c], start);
            }
            arr[c] = i + 1;
            // 这里为什么要加1？
            // 数组默认值 0 表示"没出现过"。如果直接存 i，那么"出现在第 0 位"也会是 0，和"没出现过"混淆。
            // 所以存 i + 1，让所有真实位置都是 ≥1 的正数，0 专留给"没出现过"。

            len = i - start + 1;
            maxLen = Math.max(len, maxLen);

        }
        return maxLen;
    }
}

class Solution {
    public int maximumLengthSubstring(String S) {
        char[] s = S.toCharArray();
        int ans = 0;
        int left = 0;
        int[] cnt = new int[26];
        for (int i = 0; i < s.length; i++) {
            int b = s[i] - 'a';
            cnt[b]++;
            while (cnt[b] > 2) {
                cnt[s[left] - 'a']--;
                // 我的理解是要遍历字符串中的所有元素去寻找满足要求的最长字串
                // 逻辑是一样的，做指针必须移动到重复字符的下一个位置
                // 只不过在当前代码的表达方式不同于前几种方法，但目的是一样的
                // 在左指针移动的同时，也要将原左指针到新左指针之间的元素出现次数都减去一
                // 这也是为什么要用while循环的原因 
                
                left++;
            }
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }
}
