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

    //helper methods boolean if theres number in row true, else false
    private static boolean numInRow(int[][] board, int number, int row){

        for(int i = 0; i < GridSize; i++){
            if(board[row][i] == number){
                return true;
            }
        }
        return false;
    }

    //helper methods boolean if theres number in column true, else false
    private static boolean numInCol(int[][] board, int number, int col){

        for(int i = 0; i < GridSize; i++){
            if(board[i][col] == number){
                return true;
            }
        }
        return false;
    }

    //traverse the 3 x 3 box to see if a number is in it
    private static boolean numInBox(int[][] board, int number, int col, int row){
        int localBoxRow = row - row % 3;
        int localBoxCol = col - col % 3;

        for(int i = localBoxRow; i < localBoxRow + 3; i++){
            for(int j = localBoxCol; j < localBoxCol + 3; j++){
                if(board[i][j] == number){
                    return true;
                }
            }
        }
        return false;
    }



}
