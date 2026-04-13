class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        indexes_hashed = {}
        for i, x in enumerate(nums):
            required = target-x
            if required in indexes_hashed:
                return [indexes_hashed[required], i]
            indexes_hashed[x] = i
        return []
        