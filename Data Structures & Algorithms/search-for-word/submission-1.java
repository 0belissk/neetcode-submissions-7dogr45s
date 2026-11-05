class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] seen = new boolean[board.length][board[0].length];

        // Try every cell as a starting position
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (dfs(board, word, seen, row, col, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, boolean[][] seen,
                        int row, int col, int index) {

        // Entire word has been found
        if (index == word.length()) {
            return true;
        }

        // Check boundaries
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length) {
            return false;
        }

        // Check if already visited
        if (seen[row][col]) {
            return false;
        }

        // Check if character matches
        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        // Mark current cell as visited
        seen[row][col] = true;

        // Explore all four directions
        boolean found =
            dfs(board, word, seen, row + 1, col, index + 1) ||
            dfs(board, word, seen, row - 1, col, index + 1) ||
            dfs(board, word, seen, row, col + 1, index + 1) ||
            dfs(board, word, seen, row, col - 1, index + 1);

        // Backtrack
        seen[row][col] = false;

        return found;
    }
}