class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        mx = max(p[1] for p in intervals)

        diff = [0] * (mx * 2 + 2)
        for start, end in intervals:
            # 把区间 [start*2, end*2] 增加 1
            diff[start * 2] += 1
            diff[end * 2 + 1] -= 1

        ans = []
        sum_d = 0
        start = -1  # -1 表示尚未遇到合并后的区间左端点
        for i, d in enumerate(diff):
            sum_d += d  # 计算 diff 的前缀和
            if sum_d > 0:
                if start < 0:
                    start = i  # 合并后的区间左端点
            elif start >= 0:
                # i-1 是合并后的区间右端点
                # 由于乘 2 操作，区间左右端点都是偶数，所以 i-1 是偶数，i 是奇数，(i-1)/2 == floor(i/2)
                ans.append([start // 2, i // 2])
                start = -1
        # 注：最后一轮循环 sum_d == 0，我们不会漏掉最后一个区间
        return ans