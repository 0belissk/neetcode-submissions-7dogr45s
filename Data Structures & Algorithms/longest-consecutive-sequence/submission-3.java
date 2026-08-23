class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        // Put every number into the set
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int longest = 0;

        for (int num : set) {

            // num is the START of a sequence
            if (!set.contains(num - 1)) {

                int n = num;
                int count = 1;

                while (set.contains(n + 1)) {
                    n++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}
