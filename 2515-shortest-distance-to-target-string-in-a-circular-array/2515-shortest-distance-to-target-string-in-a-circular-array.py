class Solution:
    def closestTarget(self, words: List[str], target: str, startIndex: int) -> int:
        n = len(words)
        closest = math.inf
        def get_dist(index):
            # left
            left = (index - startIndex + n) % n
            # right
            right = (startIndex - index + n) % n
            return min(left, right)

        for i, x in enumerate(words):
            if x == target:
                closest = min(closest, get_dist(i))
        if closest is math.inf:
            return -1
        return closest