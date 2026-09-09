"""字节高频面试题：用数字集合 A 中的数字，组成小于 n 的最大数

示例：n = 23121, A = {2, 4, 9} -> 22999
"""

from typing import List


class Solution:
    """核心思路：贪心 + 回溯（基于 n 的十进制字符串）

    1. 同位数尝试：从左到右逐位贪心选 A 中 <= n 当前位的最大数字；
       某位一旦严格小于 n，后面各位不再受限，直接填最大数字。
    2. 回溯缩小：若某位无数字可选、或构造结果恰好等于 n，
       从右往左找最近一个"能换更小数字"的位置，缩小后其余位填最大数字。
    3. 退一位：回溯彻底失败，改用 L-1 位、全部填最大数字。

    时间复杂度：O(L * |A|)，L 为 n 的位数（|A| <= 10，视为常数）
    空间复杂度：O(L)，存储构造中的数字串
    """

    def maxLessThanN(self, n: int, digit_set: List[int]) -> int:
        """返回由 digit_set 中数字组成的小于 n 的最大数；不存在则返回 -1。

        题目约定 n 为正整数，digit_set 中均为 0~9 的数字。
        """
        digits = sorted(set(digit_set))
        if not digits:
            return -1  # 边界：数字集合为空，无解
        max_d = digits[-1]

        s = str(n)
        length = len(s)

        # ---- 阶段一：同位数贪心构造 ----
        # prefix 保存已确定的各位数字；未提前返回时，每一位都与 n 对应位"相等"
        prefix = []
        for i, ch in enumerate(s):
            cur = int(ch)
            d = self._max_digit_at_most(digits, cur)
            if d < 0:
                break  # 没有数字 <= cur 可选，转入回溯
            prefix.append(d)
            if d < cur:
                # 当前位已严格小于 n，剩余各位直接填最大数字
                return int(''.join(map(str, prefix)) + str(max_d) * (length - i - 1))

        # ---- 阶段二：回溯缩小 ----
        # 从右往左找最近一个能换更小数字的位置
        for j in range(len(prefix) - 1, -1, -1):
            d = self._max_digit_below(digits, prefix[j])
            if d >= 0:
                # 保留前 j 位，第 j 位缩小，剩余各位填最大数字
                prefix[j] = d
                return int(''.join(map(str, prefix[:j + 1])) + str(max_d) * (length - j - 1))

        # ---- 阶段三：退一位 ----
        if length - 1 == 0:
            return -1  # n 只有 1 位且回溯失败，无解
        return int(str(max_d) * (length - 1))

    @staticmethod
    def _max_digit_at_most(digits: List[int], c: int) -> int:
        """digits 中 <= c 的最大数字；不存在返回 -1"""
        best = -1
        for d in digits:
            if best < d <= c:
                best = d
        return best

    @staticmethod
    def _max_digit_below(digits: List[int], c: int) -> int:
        """digits 中严格小于 c 的最大数字；不存在返回 -1"""
        best = -1
        for d in digits:
            if best < d < c:
                best = d
        return best
