class TicTacToe {
    //FBIP 2R
    //checking row and col and dia and adia condition for winning 
    private int[] rows;
    private int[] cols;
    private int dia = 0;
    private int adia = 0;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        //use turn +1 for player1 -1 for player2
        int turn = player == 1 ? 1 : -1;
        int size = rows.length;
        rows[row] += turn;          //count current row, col, dia, adia, and if one of them reach the board size then win
        cols[col] += turn;
        if (row == col)
            dia += turn;
        if (col == cols.length - 1 - row)
            adia += turn;
        if (Math.abs(rows[row]) == size || Math.abs(cols[col]) == size || Math.abs(dia) == size || Math.abs(adia) == size)
            return player;
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */