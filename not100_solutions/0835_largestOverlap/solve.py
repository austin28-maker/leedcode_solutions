import numpy as np
from typing import List

class Solution:
    def largestOverlap(self, img1: List[List[int]], img2: List[List[int]]) -> int:
        a = np.array(img1, dtype=np.int8)
        b = np.array(img2, dtype=np.int8)
        b = np.flip(b)

        n = len(img1)
        shape = (n * 2 - 1, n * 2 - 1)
        fa = np.fft.fft2(a, shape)
        fb = np.fft.fft2(b, shape)
        conv = np.rint(np.fft.ifft2(fa * fb).real)

        return int(conv.max())

# 暴力枚举
# class Solution:
#     def largestOverlap(self, img1: List[List[int]], img2: List[List[int]]) -> int:
#         n = len(img1)
#         ans = 0
#         for dx in range(1 - n, n):
#             for dy in range(1 - n, n):
#                 cnt1 = 0
#                 for i in range(max(-dx, 0), min(n - dx, n)):
#                     for j in range(max(-dy, 0), min(n - dy, n)):
#                         # 两个数都是 1，才能让 cnt1 增加 1
#                         cnt1 += img1[i][j] * img2[i + dx][j + dy]
#                 ans = max(ans, cnt1)
#         return ans