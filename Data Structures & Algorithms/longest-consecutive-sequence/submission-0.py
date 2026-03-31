class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        myHash = set(nums)
        longest = 0
        for n in nums:
            if (n-1) not in myHash:
                length = 1
                while (n + length) in myHash:
                    length += 1
                longest = max(length, longest)
        return longest