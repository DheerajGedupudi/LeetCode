class Solution:
    def processStr(self, s: str) -> str:
        result = []
        for c in s:
            if c == '*':
                if result:
                    result.pop()
            elif c == '#':
                arr = result.copy()
                result.extend(arr)
            elif c == '%':
                result.reverse()
            else:
                result.append(c)
        return "".join(result)

        