class Solution:
    def totalNumbers(self, digits: List[int]) -> int:
        cnt = Counter(digits) # 统计每个数字出现的次数

        kinds = len(cnt)
        non_zeros = kinds - (0 in cnt) # 非零数字的数量
        singles = sum(c == 1 for c in cnt.values()) - (cnt.get(0, 0) == 1) # 恰好出现一次的非零数字的数量
        ans = 0

        # 枚举个位填偶数 d
        for d, c in cnt.items():
            if d % 2 > 0:
                continue

            # 十位填任意数字
            k = kinds - (c == 1)

            # 百位填任意非零数字
            nz = non_zeros - (d > 0 and c == 1)

            # 恰好出现一次的非零数字，不能同时填入十位和百位
            s = singles
            if d > 0:
                if c == 1:
                    s -= 1
                elif c == 2:
                    s += 1

            ans += k * nz - s

        return ans