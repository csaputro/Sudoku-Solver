public class SudokuSolver {
    //declares static gridsize to use for later
    private static final int GridSize = 9;

    public static void main(String[] args) {

        //declares 2D array to hold the board
        int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9},
        };

        System.out.println("Board:");
        printBoard(board);
        System.out.println("-----------");

        if(solveBoard(board)){
            System.out.println("solved!");
        }
        else{
            System.out.println("cant be solved, Error!");
        }

        printBoard(board);
    }

    private static void printBoard(int[][] board) {
        for (int row = 0; row < GridSize; row++){
            if(row % 3 == 0 && row != 0){
                System.out.println("-----------");
            }
            for(int col = 0; col < GridSize; col++){
                if(col % 3 == 0 && col != 0){
                    System.out.print("|");
                }
                System.out.print(board[row][col]);
            }
            System.out.println();
        }
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
    private static boolean numInBox(int[][] board, int number, int row, int col){
        // example, row = 1, 1 - (mod(1/3) = 1) = 0
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

    //this method checks for all 3 of them
    private static boolean ValidPlacement(int[][] board, int number, int row, int col){
        return !numInRow(board, number, row) &&
                !numInCol(board, number, col) &&
                !numInBox(board, number, row, col);
    }

    //recursion to go through the board and fills it out one by one or return it back to 0
    private static boolean solveBoard(int[][] board){
        for(int row = 0; row < GridSize; row++){
            for(int col = 0; col < GridSize; col++){

                if(board[row][col] == 0){

                    for(int numberTry = 1; numberTry <= GridSize; numberTry++){
                        if(ValidPlacement(board, numberTry, row, col)){
                            board[row][col] = numberTry;

                            //recursion
                            if(solveBoard(board)){
                                return true;
                            }
                            else{
                                board[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
