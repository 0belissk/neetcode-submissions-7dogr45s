class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(n, 0, 0, "", result);
        return result;
    }

    private void dfs(int n, int open, int closed, String pairs, List<String> result) {
        if (pairs.length() == 2 * n) {
            result.add(pairs);
            return;
        }

        if (open < n) {
            dfs(n, open + 1, closed, pairs + "(", result);
        }

        if (closed < open) {
            dfs(n, open, closed + 1, pairs + ")", result);
        }
    }
}