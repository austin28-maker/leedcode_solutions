class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        last = {}  # 字符 -> 最后出现的下标
        left = 0
        max_len = 0
        for i, ch in enumerate(s):
            if ch in last and last[ch] >= left:   # 重复且旧位置还在窗口内
                left = last[ch] + 1               # ← 你说的“直接跳”！
            max_len = max(max_len, i - left + 1)
            last[ch] = i
        return max_len

# class Solution:
#     def lengthOfLongestSubstring(self, s: str) -> int:
#         if not s:
#             return 0
        
#         left = 0
#         lookup = set()
#         n = len(s)
#         max_len = 0
#         cur_len = 0

#         for i in range(n):
#             cur_len += 1
#             while s[i] in lookup:
#                 lookup.remove(s[left])
#                 left += 1
#                 cur_len -= 1
#             max_len = max(max_len, cur_len)
#             lookup.add(s[i])
        
#         return max_len