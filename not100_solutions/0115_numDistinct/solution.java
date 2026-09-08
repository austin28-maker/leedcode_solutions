class Solution {
    public int numDistinct(String S, String T) {
        int n = S.length();
        int m = T.length();
        if (n < m) {
            return 0;
        }

        char[] s = S.toCharArray();
        char[] t = T.toCharArray();

        int[] f = new int[m + 1];
        f[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = Math.min(i, m - 1); j >= Math.max(m - n + i, 0); j--) {
                if (s[i] == t[j]) {
                    f[j + 1] += f[j];
                }
            }
        }
        return f[m];
    }
}