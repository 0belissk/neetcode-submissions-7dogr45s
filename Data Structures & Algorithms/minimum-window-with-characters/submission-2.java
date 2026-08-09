class Solution {
    public String minWindow(String s, String t) {

        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> windowMap = new HashMap<>();

        // Build frequency map for t
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int need = tMap.size();
        int have = 0;

        int l = 0;

        int bestStart = 0;
        int bestLength = Integer.MAX_VALUE;

        for (int r = 0; r < s.length(); r++) {

            char c = s.charAt(r);

            // Only track characters that matter
            if (tMap.containsKey(c)) {
                windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

                // This character now satisfies its required amount
                if (windowMap.get(c).equals(tMap.get(c))) {
                    have++;
                }
            }

            // Window is valid, so try shrinking it
            while (have == need) {

                // Save shortest window
                if (r - l + 1 < bestLength) {
                    bestLength = r - l + 1;
                    bestStart = l;
                }

                char leftChar = s.charAt(l);

                if (tMap.containsKey(leftChar)) {

                    // If this character was satisfied before removing it,
                    // removing it will make it unsatisfied
                    if (windowMap.get(leftChar).equals(tMap.get(leftChar))) {
                        have--;
                    }

                    windowMap.put(
                        leftChar,
                        windowMap.get(leftChar) - 1
                    );
                }

                l++;
            }
        }

        if (bestLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(bestStart, bestStart + bestLength);
    }
}