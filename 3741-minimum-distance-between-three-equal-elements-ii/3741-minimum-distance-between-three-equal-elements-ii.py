class Solution:
    def minimumDistance(self, nums: List[int]) -> int:
        count = {}
        for i in range(len(nums)):
            x = nums[i]
            indexes = []
            if x in count:
                indexes = count[x]
            indexes.append(i)
            count[x] = indexes
        # print(count)
        min = 1000000000
        for indexes2 in count.values():
            dist = self.get(indexes2)
            if dist < min:
                min = dist
        
        if min == 1000000000:
            return -1
        return min

    def get(self, nums):
        min = 1000000000
        for i in range(1,len(nums)-1):
            a = nums[i-1]
            b = nums[i]
            c = nums[i+1]
            dist = self.getDist(a,b,c)
            if dist < min:
                min = dist
        return min
        

    def getDist(self, a,b,c):
        return abs(a-b)+abs(b-c)+abs(c-a)