from collections import defaultdict
from typing import List

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        map = defaultdict(int) # 前缀和出现次数
        map[0] = 1
        sum = 0
        count = 0
        for num in nums:
            sum += num
            count += map[sum - k]
            map[sum] += 1
        return count