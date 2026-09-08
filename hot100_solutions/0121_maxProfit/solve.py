class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        cost = prices[0]
        profit = 0
        for price in prices:
            cost = min(cost, price)
            profit = max(profit, price - cost)
        return profit