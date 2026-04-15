class Solution:
    def closestTarget(self, words: List[str], target: str, startIndex: int) -> int:
        n = len(words)
        closest = n+1
        def get_dist(index):
            # left
            left = (index - startIndex + n) % n
            # right
            right = (startIndex - index + n) % n
            # print(f"from {index}: {words[index]}, left : {left}, right : {right}")
            return min (left, right)

        for i, x in enumerate(words):
            if x == target:
                closest = min(closest, get_dist(i))
        if closest > n:
            return -1
        return closest