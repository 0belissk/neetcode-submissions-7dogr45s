class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        prevMap = {}  # val -> index

        for i, n in enumerate(nums):
            diff = target - n
            if diff in prevMap: #checks for key
                return [prevMap[diff], i]
            prevMap[n] = i #updates the dict with elements and its respective index