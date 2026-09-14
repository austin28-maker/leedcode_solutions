class Solution {
    public int maxPalindromes(String S, int k) {
        char[] s = S.toCharArray();
        int n = s.length;
        int ans = 0;
        for (int i = 0; i <= n - k;) {
            if (isPalindrome(s, i, i + k - 1)) {
                ans++;
                i += k; // 计算 s[i+k,n-1] 中的最优方案
            } else if (i < n - k && isPalindrome(s, i, i + k)) {
                // 如果跳过不选，即使 s[i+1,i+k] 是回文串，剩余内容仍然是 s[i+k+1,n-1]，并不会更优
                // 所以不需要考虑跳过 s[i,i+k] 的情况
                ans++;
                i += k + 1; // 计算 s[i+k+1,n-1] 中的最优方案
            } else {
                i++; // 计算 s[i+1,n-1] 中的最优方案
            }
        }
        return ans;
    }

    private boolean isPalindrome(char[] s, int l, int r) {
        while (l < r) {
            if (s[l] != s[r]) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}