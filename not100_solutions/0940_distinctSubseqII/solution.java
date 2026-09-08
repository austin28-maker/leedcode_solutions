import java.util.Arrays;

class Solution {
    private static final int MOD = 1_000_000_007;

    public int distinctSubseqII(String s) {
        int total = 0;
        int[] f = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            int others = (total - f[c] + MOD) % MOD; // total 中不含 f[c] 的部分（+MOD 保证结果非负）
            f[c] = 1 + total;
            total = (f[c] + others) % MOD;
        }
        return total;
    }
}

// // 优化前
// class Solution {
//     private static final int MOD = 1_000_000_007;

//     public int distinctSubseqII(String s) {
//         int n = s.length();
//         long[][] f = new long[n + 1][26];
//         for (int i = 0; i < n; i++) {
//             f[i + 1] = f[i].clone(); // clone()是深拷贝，避免修改原数组
//             f[i + 1][s.charAt(i) - 'a'] = (1 + Arrays.stream(f[i]).sum()) % MOD;
//         }
//         return (int) (Arrays.stream(f[n]).sum() % MOD);
//     }
// }
