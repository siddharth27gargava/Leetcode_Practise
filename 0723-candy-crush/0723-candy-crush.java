class Solution {
    public int[][] candyCrush(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        boolean shouldContinue = true;

        // Loop until no more candies can be crushed
        while (shouldContinue) {
            shouldContinue = false;

            // Mark candies that need to be crushed in the horizontal direction
            for (int i = 0; i < rows; ++i) {
                for (int j = 0; j < cols - 2; ++j) {
                    int value = Math.abs(board[i][j]);
                    if (value != 0 && value == Math.abs(board[i][j + 1]) && value == Math.abs(board[i][j + 2])) {
                        shouldContinue = true;
                        board[i][j] = board[i][j + 1] = board[i][j + 2] = -value;
                    }
                }
            }

            // Mark candies that need to be crushed in the vertical direction
            for (int j = 0; j < cols; ++j) {
                for (int i = 0; i < rows - 2; ++i) {
                    int value = Math.abs(board[i][j]);
                    if (value != 0 && value == Math.abs(board[i + 1][j]) && value == Math.abs(board[i + 2][j])) {
                        shouldContinue = true;
                        board[i][j] = board[i + 1][j] = board[i + 2][j] = -value;
                    }
                }
            }
          
            // Crush the candies and let new ones fall down
            if (shouldContinue) {
                for (int j = 0; j < cols; ++j) {
                    // Start from bottom of the board
                    int writeIndex = rows - 1;
                    for (int i = rows - 1; i >= 0; --i) {
                        // If this candy is not marked to be crushed, bring it down
                        if (board[i][j] > 0) {
                            board[writeIndex][j] = board[i][j];
                            writeIndex--;
                        }
                    }
                    // Fill the remaining spaces with 0s to indicate empty spaces
                    while (writeIndex > -1) {
                        board[writeIndex][j] = 0;
                        writeIndex--;
                    }
                }
            }
        }

        return board;
    }
}