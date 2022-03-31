public class SudokuSolver {
    //declares static gridsize to use for later
    private static final int GridSize = 9;

    public static void main(String[] args) {

        //declares 2D array to hold the board
        int [][] board = {
                {7, 0, 2, 0, 5, 0, 6, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0},
                {1, 0, 0, 0, 0, 9, 5, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 9, 0},
                {0, 4, 3, 0, 0, 0, 7, 5, 0},
                {0, 9, 0, 0, 0, 0, 0, 0, 8},
                {0, 0, 9, 7, 0, 0, 0, 0, 5},
                {0, 0, 0, 2, 0, 0, 0, 0, 0},
                {0, 0, 7, 0, 4, 0, 2, 0, 3},
        };
    }

    //helper methods boolean if theres number true, else false
    private static boolean numInRow(int[][] board, int number, int row){

        for(int i = 0; i < GridSize; i++){
            if(board[row][i] == number){
                return true;
            }
        }
        return false;
    }
}
