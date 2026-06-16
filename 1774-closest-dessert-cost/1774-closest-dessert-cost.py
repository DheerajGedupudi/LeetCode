class Solution:
    def closestCost(self, baseCosts: List[int], toppingCosts: List[int], target: int) -> int:
        sums = {0}
        for t in toppingCosts:
            sums = {s + t * k for s in sums for k in [0,1,2]}
        sums = sorted(sums)
        # print(sums)
        result = baseCosts[0]
        for base in baseCosts:
            required = target-base
            low, high = 0, len(sums) - 1
            best = float('inf')   
            while low <= high:
                mid = low + (high-low)//2
                num = sums[mid]+base
                if num < target:
                    low = mid+1
                else:
                    high = mid-1
                diff = abs(target-num)
                if diff <= abs(target-best):
                    if diff == abs(target-best):
                        if num < best:
                            best = num
                    else:
                        best = num
            diff = abs(target-best)
            if diff <= abs(target-result):
                if diff == abs(target-result):
                    if best < result:
                        result = best
                else:
                    result = best
        return result



"""
t = 18

(2, 3)

0 4 8
2 6 10
0 5 10
0 100 200

"""    