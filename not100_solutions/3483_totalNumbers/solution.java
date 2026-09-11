class Solution {
    public int totalNumbers(int[] digits) {
        int[] cnt = new int[10];
        for (int d : digits) {
            cnt[d]++;
        }

        int nonZeros = 0;
        int kinds = 0;
        int singles = 0;
        for (int d = 0; d < 10; d++) {
            if (cnt[d] == 0) {
                continue;
            }
            kinds++;
            if (d > 0) {
                nonZeros++;
                if (cnt[d] == 1) {
                    singles++;
                }
            }
        }

        int ans = 0;

        // 枚举个位填偶数 d
        for (int d = 0; d < 10; d += 2) {
            int c = cnt[d];
            if (c == 0) {
                continue;
            }

            // 十位填任意数字
            int k = kinds;
            if (c == 1) {
                k--;
            }

            // 百位填任意非零数字
            int nz = nonZeros;
            if (d > 0 && c == 1) {
                nz--;
            }

            // 恰好出现一次的非零数字，不能同时填入十位和百位
            int s = singles;
            if (d > 0) {
                if (c == 1) {
                    s--;
                } else if (c == 2) {
                    s++; // 个位数填入 d 后，d 恰好出现一次
                }
            }

            ans += k * nz - s;
        }

        return ans;
    }
}