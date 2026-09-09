from collections import defaultdict
from typing import List

# class Solution:
#     def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
#         d = {}
#         for s in strs:
#             sorted_s = ''.join(sorted(s))
#             if sorted_s not in d:
#                 d[sorted_s] = []
#             d[sorted_s].append(s)
#         return list(d.values())

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        d = defaultdict(list)  # 如果 key 不在字典中，defaultdict 会自动创建一个空列表作为 value
        for s in strs:
            sorted_s = ''.join(sorted(s))  # 把 s 排序，作为 defaultdict 的 key
            # join() 方法，将列表中的元素用指定的字符连接起来。
            # 这里用空字符串连接，所以结果就是排序后的字符串。
            # 所以，如果两个字符串排序后相同，那么它们的 sorted_s 就是相同的。

            d[sorted_s].append(s)  # 排序后相同的字符串，保存到同一组中
        return list(d.values())  # 哈希表的所有 value 就是分组结果