class Solution:
    def isValid(self, s: str) -> bool:
        pairs = {')' : '(', ']' : '[', '}' :'{'}
        stack = []
        for c in s:
            if c in pairs:
                # closing
                if not stack:
                    return False
                if stack[-1] == pairs[c]:
                    stack.pop()
                else:
                    return False
            else:
                # opening
                stack.append(c)
        return not stack