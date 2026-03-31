class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        tracker = {}
        result = 0
        l = 0
        maxF = 0
        for r in range(len(s)):
            tracker[s[r]] = 1 + tracker.get(s[r], 0)
            maxF = max(maxF, tracker[s[r]])
            while r-l + 1 - maxF > k:
                tracker[s[l]] -= 1
                l += 1
            result = max(result, r-l + 1)
        return result