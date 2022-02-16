import java.net.Socket;
import java.util.Arrays;

public class QueenBoard {
    private int[][] _board;

    public QueenBoard(int size) {
        _board = new int[size][size];
    }

    // 1 is a queen
    // 0 is a free spot
    // -1 and less is dangerous spot

    private boolean addQueen(int row, int col) {
        if (_board[row][col] != 0) {
            return false;
        }
        _board[row][col] = 1;
        int offset = 1;
        
        while(col + offset < _board[row].length) {
            // right horizontal row
            _board[row][col + offset]--;

            // top right diagonal
            if (row - offset >= 0) {
                _board[row - offset][col + offset]--;
            }

            // bottom right diagonal
            if (row + offset < _board.length) {
                _board[row + offset][col + offset]--;
            }
            offset++;
        }
        return true;
    }

    private boolean removeQueen(int row, int col) {
        if (_board[row][col] != 1) {
            return false;
        }
        _board[row][col] = 0;
        int offset = 1;
        
        while(col + offset < _board[row].length) {
            _board[row][col + offset]++;
            if (row - offset >= 0) {
                _board[row - offset][col + offset]++;
            }
            if (row + offset < _board.length) {
                _board[row + offset][col + offset]++;
            }
            offset++;
        }
        return true;
    }

    public boolean solveHelper(int col) {
        // try placing queens, recursive
        // start at 0,0  left -> right columns; top -> bottom rows

        // base case: we place all the queens
        if (col >= _board.length) {
            System.out.println();
            display();
            return true;
        }

        for (int r = 0; r < _board.length; r++) {
            // System.out.println("r: " + r + " c: " + c);
            // displayData();
            // System.out.println();

            if (addQueen(r, col)) {

                if (solveHelper(col + 1) == true) {
                    return true;
                }

                removeQueen(r, col);
            }
        }

        return false;


    }

    public boolean solve() {
        System.out.println("\nBoard size: " + _board.length);
        if (solveHelper(0)) {
            return true;
        } return false;
    }

    public void displayData() {
        for (int i = 0; i <_board.length; i++) {
            System.out.println(Arrays.toString(_board[i]));
        }
    }
    
    public void display() {
        for (int i = 0; i < _board.length; i++) {
            for (int j = 0; j < _board.length; j++) {
                System.out.print(" " + _board[i][j] + " |");
            }
            System.out.println("\n");
        }
    }
    

    public static void main(String[] args) {
        QueenBoard b = new QueenBoard(8);
        System.out.println(b.solve());
        System.out.println();
    }

}