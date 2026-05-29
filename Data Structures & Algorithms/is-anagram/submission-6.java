class Solution {
    public boolean isAnagram(String s, String t) {
        boolean[] sArr = new boolean[s.length()];
        boolean[] tArr = new boolean[t.length()];

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            int j = 0;
            while (j < t.length() && sArr[i] != true) {
                if (s.charAt(i) == t.charAt(j) && tArr[j] != true) {
                    sArr[i] = true;
                    tArr[j] = true;
                }
                j += 1;
            }
        }

        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] != true) {
                return false;
            }
        }

        return true;
    }
}
