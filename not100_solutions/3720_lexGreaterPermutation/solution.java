class Solution {
    public String lexGreaterPermutation(String s, String target) {
        char[] t = target.toCharArray();
        int n = t.length;
        int[] left = new int[26];
        for (int i = 0; i < n; i++) {
            left[s.charAt(i) - 'a']++;
            left[t[i] - 'a']--; // 消耗 s 中的一个字母 t[i]
        }

        int neg = 0;
        int mx = 0;
        for (int i = 0; i < 26; i++) {
            if (left[i] < 0) {
                neg++; // 统计 left 中的负数个数
            } else if (left[i] > 0) {
                mx = Math.max(mx, i);
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            int b = t[i] - 'a';
            left[b]++; // 撤销消耗

            if (left[b] == 0) {
                neg--;
            } else if (left[b] == 1) {
                mx = Math.max(mx, b);
            }

            // left 有负数 or 没有大于 target[i] 的字母
            if (neg > 0 || b >= mx) {
                continue;
            }

            int j = b + 1;
            while (left[j] == 0) {
                j++;
            }

            // 把 target[i] 增大到 j
            left[j]--;
            StringBuilder ans = new StringBuilder(target.substring(0, i + 1));
            ans.setCharAt(i, (char) ('a' + j));

            for (int k = 0; k < 26; k++) {
                ans.repeat('a' + k, left[k]);
            }
            return ans.toString();
        }
        return "";
    }
}