class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        storage = defaultdict(list)
        for s in strs:
            string_track = [0] * 26 
            for c in s:
                string_track[ord(c) - ord('a')] += 1
            storage[tuple(string_track)].append(s)
        return list(storage.values())
    
           
