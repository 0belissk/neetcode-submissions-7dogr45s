class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        res = []
        for i in tokens:
            if i in "+-/*":
                a, b = res.pop(), res.pop()
                if i == "+":
                    val = b + a
                elif i == "-":
                    val = b - a
                elif i == "*":
                    val = b * a
                elif i == "/": 
                    val = int(float(b) / a)
                res.append(val)
            else:
                res.append(int(i))
        return res[-1]
