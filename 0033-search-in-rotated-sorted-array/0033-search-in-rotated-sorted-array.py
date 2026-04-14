class Solution:
    def search(self, nums: List[int], target: int) -> int:
        intersect = 0
        low = 1 # look for possibilities where it is actually rotated
        high = len(nums)-1
        while low <= high:
            mid = low + (high-low)//2
            if nums[mid] > nums[(mid+1)%len(nums)]:
                # at intersect
                intersect = mid
                break
            if nums[mid]>nums[0] and nums[mid]>nums[-1]:
                # 1st half
                low = mid+1
            else:
                # 2nd half
                high = mid-1
        result = self.bin_search(nums, target, 0, intersect)
        if result != -1:
            return result
        return self.bin_search(nums, target, intersect+1, len(nums)-1)
        
    

    def bin_search(self, nums, target, start, end) -> int:
        low, high = start, end
        while low <= high:
            mid = low + (high-low)//2
            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                low = mid+1
            else:
                high = mid-1
        return -1