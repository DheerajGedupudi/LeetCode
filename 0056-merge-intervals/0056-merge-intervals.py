class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort()
        last_start, last_end = intervals[0][0], intervals[0][1]
        result = []
        for interval in intervals:
            # if overlap, keep going
            # if no overlap, add last interval
            ovrlp = interval[0] <= last_end
            if ovrlp:
                last_start, last_end = min(last_start, interval[0]), max(last_end, interval[1])
            else:
                result.append([last_start, last_end])
                last_start, last_end = interval[0], interval[1]
        # add last interval
        result.append([last_start, last_end])
        return result

        