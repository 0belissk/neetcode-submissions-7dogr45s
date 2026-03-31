class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        h1 = {}
        h2 = {}
        if len(s) != len(t):
            return False
        for char1, char2 in zip(s, t):
            if char1 in h1:
                h1[char1] += 1
            else:
                h1[char1] = 1
            if char2 in h2:
                h2[char2] += 1
            else:
                h2[char2] = 1
        if h1 == h2:
            return True
        else:
            return False