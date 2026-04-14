class Solution:
    def climbStairs(self, n: int) -> int:
        if n == 1 or n == 2:
            return n
        first, second = 1,2
        for _ in range(2, n):
            first, second = second, first + second
        return second
        