class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        return [list(combs) for x in range(len(nums)+1) for combs in combinations(nums, x)]
        