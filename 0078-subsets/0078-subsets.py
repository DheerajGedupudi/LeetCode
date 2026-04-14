class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        self.result = []
        self.backtrack(nums, 0, [])
        return self.result

    def backtrack(self, nums, index, path):
        if index == len(nums):
            self.result.append(list(path))
            return
        # Choose
        path.append(nums[index])
        self.backtrack(nums, index+1, path)
        path.pop()
        # don't choose
        self.backtrack(nums, index+1, path)

        