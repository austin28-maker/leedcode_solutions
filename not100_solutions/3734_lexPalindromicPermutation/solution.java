class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int[] left = new int[26];
        for (char b : s.toCharArray()) {
            left[b - 'a']++;
        }

        String midCh = "";
        for (int i = 0; i < 26; i++) {
            int c = left[i];
            if (c % 2 == 0) {
                continue;
            }
            // s 不能有超过一个字母出现奇数次
            if (!midCh.isEmpty()) {
                return "";
            }
            // 记录填在正中间的字母
            midCh = "" + (char) ('a' + i);
            left[i]--;
        }

        int n = s.length();
        // 先假设答案左半与 target 的左半（不含正中间）相同
        for (int i = 0; i < n / 2; i++) {
            left[target.charAt(i) - 'a'] -= 2;
        }

        int neg = 0;
        int leftMax = 0;
        for (int i = 0; i < 26; i++) {
            if (left[i] < 0) {
                neg++; // 统计 left 中的负数个数
            } else if (left[i] > 0) {
                leftMax = Math.max(leftMax, i); // 剩余可用字母的最大值
            }
        }

        if (neg == 0) {
            // 特殊情况：把 target 左半翻转到右半，能否比 target 大？
            String leftS = target.substring(0, n / 2);
            String rightS = midCh + new StringBuilder(leftS).reverse();
            if (rightS.compareTo(target.substring(n / 2)) > 0) { // 由于左半是一样的，所以只需比右半
                return leftS + rightS;
            }
        }

        for (int i = n / 2 - 1; i >= 0; i--) {
            int b = target.charAt(i) - 'a';
            left[b] += 2; // 撤销消耗

            if (left[b] == 0) {
                neg--;
            } else if (left[b] == 2) {
                leftMax = Math.max(leftMax, b);
            }

            // left 有负数 or 没有大于 target[i] 的字母
            if (neg > 0 || leftMax <= b) {
                continue;
            }

            // 找到答案（下面的循环在整个算法中只会跑一次）
            int j = b + 1;
            while (left[j] == 0) {
                j++;
            }

            // 把 target[i] 增大到 j
            left[j] -= 2;
            StringBuilder ans = new StringBuilder(target.substring(0, i + 1));
            ans.setCharAt(i, (char) ('a' + j));

            // 中间可以随便填
            for (int k = 0; k < 26; k++) {
                ans.repeat('a' + k, left[k] / 2);
            }

            // 镜像翻转
            StringBuilder rightS = new StringBuilder(ans).reverse();
            return ans.append(midCh).append(rightS).toString();
        }
        return "";
    }
}