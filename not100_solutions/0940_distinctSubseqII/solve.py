MOD = 1_000_000_007

class Solution:
    def distinctSubseqII(self, s: str) -> int:
        f = [0] * 26
        total = 0
        for c in s:
            c = ord(c) - ord('a')
            others = total - f[c]  # total 中不含 f[c] 的部分
            f[c] = 1 + total
            total = (f[c] + others) % MOD
        return total