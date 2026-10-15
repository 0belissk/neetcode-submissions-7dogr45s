class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, target, 0, new ArrayList<>(), 0, result);
        return result;
    }

    private void dfs(int[] nums, int target, int index, List<Integer> combo, int sum, List<List<Integer>> result) {
        //base case
        if (sum == target) {
            result.add(new ArrayList<>(combo));
            return;
        } else if (sum > target) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            combo.add(nums[i]);

            dfs(nums, target, i, combo, sum + nums[i], result);

            combo.remove(combo.size() - 1);
        }


    }
}