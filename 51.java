class Solution {
    public List<List<String>> solveNQueens(int n) {
        //FBIP 2R
        //classic problem solving by backtracking or dfs: for every recursion check column, 45 diagonal and 135 diagonal
        List<List<String>> result = new ArrayList();
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                map[i][j] = '.';
        backtracking(result, map, 0);
        return result;
    }
    private void backtracking(List<List<String>> result, char[][] map, int  index){
        if (index == map.length){
            result.add(construct(map));
            return;
        }
        for (int i = 0; i < map.length; i++){
            if (valid(map, i, index)){
                map[i][index] = 'Q';
                backtracking(result, map, index + 1);
                map[i][index] = '.';
            }
        }
    }
    private List<String> construct(char[][] map){
        List<String> list = new ArrayList();
        for (int i = 0; i < map.length; i++){
            String s = new String(map[i]);
            list.add(s);
        }
        return list;
    }
    private boolean valid(char[][] map, int x, int y){
        for (int i = 0; i < map.length; i++)
            for (int j = 0; j < y; j++)
                if (map[i][j] == 'Q' && (x + y == i + j || x + j == y + i || x == i))
                    return false;           //check same row same 45 dia same 135 dia
        return true;
    }
}