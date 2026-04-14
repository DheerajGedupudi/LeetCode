class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        return heapq.nsmallest(k, points, key=lambda p : self.dist_squared(p[0], p[1]))
            


    def dist_squared(self, x, y):
        return x**2 + y**2