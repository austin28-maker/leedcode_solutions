from copy import deepcopy
import json
import sys

def deep_merge(a, b):
    """
    深度合并两个对象

    合并规则是：
    1. 如果两个对象都是字典，递归合并字典
    2. 如果两个对象都是列表，合并列表
    3. 如果两个对象都是布尔值，取或值
    4. 如果两个对象都是字符串，拼接字符串
    5. 其他情况，直接返回第二个对象
    """

    # 递归合并字典
    if isinstance(a, dict) and isinstance(b, dict):
        res = deepcopy(a)
        for key, value in b.items():
            if key in res:
                res[key] = deep_merge(res[key], value)
            else:
                res[key] = deepcopy(value)
        return res
    
    # 递归合并列表
    if isinstance(a, list) and isinstance(b, list):
        return deepcopy(a) + deepcopy(b)

    if isinstance(a, bool) and isinstance(b, bool):
        return a or b
    
    if isinstance(a, str) and isinstance(b, str):
        return a + b

    return deepcopy(b)

def main():
    a = json.loads(sys.stdin.readline())
    b=  json.loads(sys.stdin.readline())

    res = deep_merge(a, b)
    print(json.dumps(res, ensure_ascii = False))

if __name__ == "__main__":
    main()
