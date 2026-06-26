class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // Stores triplets we already added
        Set<String> usedTriplets = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            Set<Integer> seen = new HashSet<>();

            for (int j = i + 1; j < nums.length; j++) {
                int needed = -nums[i] - nums[j];

                if (seen.contains(needed)) {
                    int a = nums[i];
                    int b = nums[j];
                    int c = needed;

                    int min = Math.min(a, Math.min(b, c));
                    int max = Math.max(a, Math.max(b, c));
                    int sum = a + b + c;
                    int mid = sum - min - max;

                    String key = min + "," + mid + "," + max;

                    if (!usedTriplets.contains(key)) {
                        usedTriplets.add(key);

                        result.add(Arrays.asList(min, mid, max));
                    }
                }

                seen.add(nums[j]);
            }
        }

        return result;
    }
}