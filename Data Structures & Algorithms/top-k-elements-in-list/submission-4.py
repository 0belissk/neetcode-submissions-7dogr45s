class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        hash_storage = {}
        bucket = [[] for i in range(len(nums)+ 1)]
        for i in nums:
            hash_storage[i] = 1 + hash_storage.get(i, 0)
        for n, c in hash_storage.items():
            bucket[c].append(n)
        
        result = []
        for s in range(len(bucket) - 1, 0, -1):
            for a in bucket[s]:
                result.append(a)
                if len(result) == k:
                    return result