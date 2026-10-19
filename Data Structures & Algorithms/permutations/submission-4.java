class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] taken = new boolean[nums.length];
        dfs(nums, taken, result, new ArrayList<>());

        return result;
    }

    private void dfs(int[] nums, boolean[] taken, List<List<Integer>> result, List<Integer> path) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (taken[i]) {
                continue;
            } else {
                path.add(nums[i]);
                taken[i] = true;

                dfs(nums, taken, result, path);

                taken[i] = false;
                path.remove(path.size() - 1);
            }
        }

        
    }
}
