class Solution:
    def canJump(self, nums: List[int]) -> bool:
        dp = [False]*len(nums)
        dp[0] = True
        for i, x in enumerate(nums):
            if not dp[i]:
                return False
            for step in range(1, x + 1):
                if i+step == len(nums):
                    break
                dp[i+step] = True
                if i+step == len(nums)-1:
                    return True
        return dp[-1]
        