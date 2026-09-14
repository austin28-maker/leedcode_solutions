class Solution:
    def maxPalindromes(self, s: str, k: int) -> int:
        n = len(s)
        ans = i = 0
        while i <= n - k:
            if s[i: i + k] == s[i: i + k][::-1]:
                ans += 1
                i += k  # 计算 s[i+k:] 中的最优方案
            elif i < n - k and s[i: i + k + 1] == s[i: i + k + 1][::-1]:
                # 如果跳过不选，即使 s[i+1:i+1+k] 是回文串，剩余内容仍然是 s[i+k+1:]，并不会更优
                # 所以不需要考虑跳过 s[i:i+k+1] 的情况
                ans += 1
                i += k + 1  # 计算 s[i+k+1:] 中的最优方案
            else:
                i += 1  # 计算 s[i+1:] 中的最优方案
        return ans