class Solution:
    def processStr(self, s: str) -> str:
        result = []
        for c in s:
            if c == '*':
                if result:
                    result.pop()
            elif c == '#':
                result += result.copy()
            elif c == '%':
                result = result[::-1]
            else:
                result.append(c)
        return "".join(result)

        