class Solution:
    def rotateString(self, s: str, goal: str) -> bool:
        length = len(s)
        length_2 = len(goal)
        if length != length_2:
            return False
        def isSame(s, t, start):
            for i, c in enumerate(s):
                index = (start+i)%length
                if c != t[index]:
                    return False
                index += 1
            return True
        for i in range(len(s)):
            if isSame(s, goal, i):
                return True
        return False