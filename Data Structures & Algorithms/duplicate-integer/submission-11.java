class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> countMap = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if ( countMap.contains(nums[i]) ) {
                return true;
            } else {
                countMap.add(nums[i]);
            }
        }

        return false;
    }
}