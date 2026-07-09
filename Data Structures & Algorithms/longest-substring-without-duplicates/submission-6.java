class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int l = 0;
        int best = 0;

        for (int r = 0; r < s.length(); r++) {
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l += 1;
            }

            set.add(s.charAt(r));
            best = Math.max(set.size(), best);
        }

        return best;
    }
}
