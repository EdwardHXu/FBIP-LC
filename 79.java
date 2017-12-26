class Solution {
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        //FBIP 2R
        //backtracking approach
        int m = board.length, n = board[0].length;
        visited = new boolean[m][n];
        if (word.length() > m * n)  return false;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (backtracking(board, word, i, j, 0))
                    return true;
        return false;
    }
    private boolean backtracking(char[][] board, String word, int x, int y, int index){
        if (index == word.length()) return true;
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y] || board[x][y] != word.charAt(index))
            return false;
        visited[x][y] = true;
        if (    backtracking(board, word, x + 1, y, index + 1)
           ||   backtracking(board, word, x - 1, y, index + 1)
           ||   backtracking(board, word, x, y + 1, index + 1)
           ||   backtracking(board, word, x, y - 1, index + 1))
            return true;
        visited[x][y] = false;
        return false;
    }
}