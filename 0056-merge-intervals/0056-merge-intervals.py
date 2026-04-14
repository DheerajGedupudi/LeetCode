class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort()
        last_start = intervals[0][0]
        last_end = intervals[0][1]
        result = []
        for interval in intervals:
            # if overlap, keep going
            # if no overlap, add last interval
            ovrlp = min(last_end, interval[1])-max(last_start,interval[0])>=0
            if ovrlp:
                last_start = min(last_start, interval[0])
                last_end = max(last_end, interval[1])
            else:
                result.append([last_start, last_end])
                last_start = interval[0]
                last_end = interval[1]
        # add last interval
        result.append([last_start, last_end])
        return result

        