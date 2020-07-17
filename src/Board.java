import java.util.*;

/**
 * @author  Ronald Wood
 * Class to store a random 2D array of tiles
 *
 */
public class Board {
    private Tile[][] board;

    /**
     * Create a new random board of tiles
     * @param rows Num of rows of board
     * @param cols Num of columns of board
     */
    public Board(int rows, int cols){
        createBoard(rows, cols);
    }

    private void createBoard(int rows, int cols){
        Tile[][] board = null;
        List<Colors> enums1 = new ArrayList<>(Arrays.asList(Colors.values()));
        List<Colors> enums2 = new ArrayList<>(Arrays.asList(Colors.values()));
        List<Colors> enums3 = new ArrayList<>(Arrays.asList(Colors.values()));
        if (cols != 6 && !(rows % 2 == 0)) {System.err.println("Error: incorrect dimensions");
                System.exit(-1);
        }
        else {
            board = new Tile[rows][cols];
            for (int i = 0; i < rows; i++){
                for (int j = 0; j < cols; j++){
                    board[i][j] = new Tile(Shapes.TRIANGLE, Shapes.SQUARE, Shapes.CIRCLE);
                }
            }
            for (int i = 0; i < rows; i++){
                Collections.shuffle(enums1);
                Collections.shuffle(enums2);
                Collections.shuffle(enums3);
                for (int j = 0; j < cols; j++){
                    board[i][j].setElementColor1(enums1.get(j));
                    board[i][j].setElementColor2(enums2.get(j));
                    board[i][j].setElementColor3(enums3.get(j));
                }
            }

        }


        this.board = board;
    }

    /**
     * Get the board of tiles
     * @return 2D array of tiles
     */
    public Tile[][] getBoardArray(){
        return board;
    }

}
