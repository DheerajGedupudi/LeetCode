class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []

        def backtrack(nums, index, path):
            if index == len(nums):
                result.append(list(path))
                return
            # Choose
            path.append(nums[index])
            backtrack(nums, index+1, path)
            path.pop()
            # don't choose
            backtrack(nums, index+1, path)
            
        backtrack(nums, 0, [])
        return result


        