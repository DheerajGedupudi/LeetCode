class Solution:
    def maxDistance(self, colors: List[int]) -> int:
        colors_last_index = {}
        for i, c in enumerate(colors):
            colors_last_index[c] = i
        ans = 0
        for i, c in enumerate(colors):
            for diff_c, j in colors_last_index.items():
                if c != diff_c:
                    diff = j-i
                    ans = max(ans, diff)
        return ans