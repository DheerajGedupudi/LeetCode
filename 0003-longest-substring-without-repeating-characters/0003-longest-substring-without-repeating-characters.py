class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        last_indexes = {}
        max_len = 0
        start = -1
        for i, c in enumerate(s):
            if c in last_indexes and last_indexes[c] > start:
                start = last_indexes[c]
            max_len = max(max_len, i-start)
            last_indexes[c] = i
        return max_len
        