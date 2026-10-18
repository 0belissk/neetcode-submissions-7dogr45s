class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, new ArrayList<>(), 0, target, result, 0);
        return result;
    }

    private void dfs(int[] candidates, List<Integer> path, int start, int target, List<List<Integer>> result, int sum) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            
            if (i > start && candidates[i] == candidates[i-1]) {
                continue;
            }
            path.add(candidates[i]);
            sum += candidates[i];

            dfs(candidates, path, i + 1, target, result, sum);

            sum -= candidates[i];
            path.remove(path.size() - 1);

            
        }
    }
}
