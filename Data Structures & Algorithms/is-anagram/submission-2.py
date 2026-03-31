class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        hashS, hashT = {}, {}
        for index in range(len(s)):
            hashS[s[index]] = 1 + hashS.get(s[index], 0)
            hashT[t[index]] = 1 + hashT.get(t[index], 0)
        return hashS == hashT