class Solution:
    def __init__(self):
        self.lettermap = [
            "",     # 0
            "",     # 1
            "abc",  # 2
            "def",  # 3
            "ghi",  # 4
            "jkl",  # 5
            "mno",  # 6
            "pqrs", # 7
            "tuv",  # 8
            "wxyz"  # 9
        ]

    def letterCombinations(self, digits: str) -> List[str]:
        result = []
        if len(digits) == 0:
            return result
        self.testmethod(digits, 0, result, [])
        return result
    
    def testmethod(self, digits: str, index: int, result: List, path: List):
        if index == len(digits):
            result.append(''.join(path))
            return
        
        digit = int(digits[index])
        letters = self.lettermap[digit]
        for letter in letters:
            path.append(letter)
            self.testmethod(digits, index + 1, result, path)
            path.pop()