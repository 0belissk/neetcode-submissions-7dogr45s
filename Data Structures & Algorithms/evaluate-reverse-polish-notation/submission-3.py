class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        result = []
        for i in tokens:
            if i in "+-/*":
                a, b = result.pop(), result.pop()
            if i == "+":
                value = a + b
                result.append(value)
            elif i == "-":
                value = b - a
                result.append(value)
            elif i == "*":
                value = a * b
                result.append(value)
            elif i == "/":
                value = int(b/a)
                result.append(value)
            else:
                result.append(int(i))
        return result[-1]
        