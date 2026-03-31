class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        storage = defaultdict(list)
        for word in strs:
            my_list = [0] * 26
            for letter in word:
                my_list[ord(letter) - ord('a')] += 1
            storage[tuple(my_list)].append(word)
        return list(storage.values())