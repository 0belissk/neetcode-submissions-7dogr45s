class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        HashSet<List<Integer>> result = new HashSet<>();

        dfs(nums, 0, new ArrayList<>(), result);

        return new ArrayList<>(result);
    }

    private void dfs(int[] nums, int index,
                     List<Integer> path,
                     HashSet<List<Integer>> result) {

        if (index == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        // Include
        path.add(nums[index]);

        dfs(nums, index + 1, path, result);

        // Undo
        path.remove(path.size() - 1);

        // Exclude
        dfs(nums, index + 1, path, result);
    }
}