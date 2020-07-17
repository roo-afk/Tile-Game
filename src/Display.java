import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.*;

/**
 * @author Ronald Wood
 * Class that allows the user to play a game of tile by generating a grid of stackpanes that react to clicks
 */
public class Display extends Application {
    public static final int ROWS = 4;
    public static final int COLS = 6;
    private static int currentScore = 0;
    private static int maxScore = 0;
    private static ObservableList<Node> mainNodes;

    public static void main(String[] args) {
        launch(args);
    }

    private Parent createScene() {
        Pane root = new Pane();
        root.setStyle("-fx-background-color: black;");
        root.setPrefSize(800, 800);
        Text current = new Text("The current score is: " + currentScore);
        Text max = new Text("The max score is: " + maxScore);
        current.setFill(Color.WHITE);
        current.setStyle("-fx-font: 32 arial");
        max.setStyle("-fx-font: 32 arial");
        max.setFill(Color.WHITE);
        current.setTranslateY(600.);
        max.setTranslateY(650.0);
        Board board = new Board(ROWS, COLS);
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {

                Cell cell = new Cell(board.getBoardArray()[i][j]);
                cell.setTranslateX(j * 100);
                cell.setTranslateY(i * 100);

                root.getChildren().add(cell);
            }
        }
        root.getChildren().addAll(current, max);
        mainNodes = root.getChildren();
        return root;
    }

    /**
     * Create the main game window
     * @param stage main game window
     */
    public void start(Stage stage) {
        stage.setTitle("Tiles");

        Parent pane = createScene();
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

    }

    /**
     * Class that allows for custom stackpanes
     */
    private static class Cell extends StackPane {

        private static Queue<Cell> cells = new LinkedList<>();

        private Tile tile;
        private ObservableList<Shape> nodes;
        private static int pairCounter = 0;

        /**
         * Generate a new stackpane that holds tile information and set actions on click
         * @param tile Tile information to draw a stackpane
         */
        public Cell(Tile tile) {


            this.tile = tile;
            Rectangle border = new Rectangle(100, 100);
            Polygon triangle = new Polygon();
            Rectangle square = new Rectangle(30, 30);
            Circle circle = new Circle(25);
            triangle.getPoints().addAll(new Double[]{
                    0.0, 0.0,
                    30.0, 20.0,
                    20.0, 30.0
            });

            switch (tile.getElementColor1()) {
                case RED:
                    triangle.setFill(Color.RED);
                    break;
                case BLUE:
                    triangle.setFill(Color.BLUE);

                    break;
                case GREEN:
                    triangle.setFill(Color.GREEN);

                    break;
                case PINK:
                    triangle.setFill(Color.PINK);

                    break;
                case AQUA:
                    triangle.setFill(Color.AQUA);

                    break;
                case YELLOW:
                    triangle.setFill(Color.YELLOW);

                    break;
            }
            switch (tile.getElementColor2()) {
                case RED:
                    square.setFill(Color.RED);
                    break;
                case BLUE:
                    square.setFill(Color.BLUE);

                    break;
                case GREEN:
                    square.setFill(Color.GREEN);

                    break;
                case PINK:
                    square.setFill(Color.PINK);

                    break;
                case AQUA:
                    square.setFill(Color.AQUA);

                    break;
                case YELLOW:
                    square.setFill(Color.YELLOW);

                    break;
            }
            switch (tile.getElementColor3()) {
                case RED:
                    circle.setFill(Color.RED);
                    break;
                case BLUE:
                    circle.setFill(Color.BLUE);

                    break;
                case GREEN:
                    circle.setFill(Color.GREEN);

                    break;
                case PINK:
                    circle.setFill(Color.PINK);

                    break;
                case AQUA:
                    circle.setFill(Color.AQUA);

                    break;
                case YELLOW:
                    circle.setFill(Color.YELLOW);

                    break;
            }


            border.setFill(null);
            border.setStroke(Color.WHITE);

            StackPane.setAlignment(circle, Pos.CENTER);
            StackPane.setAlignment(triangle, Pos.BOTTOM_LEFT);
            StackPane.setAlignment(square, Pos.TOP_RIGHT);
            ObservableList list = getChildren();
            list.addAll(circle, square, triangle, border);
            nodes = list;

            setOnMouseClicked(event -> {
                handleClick();
            });

        }

        private void handleClick() {


            boolean matched = false;
            Color strokeColor = Color.LIME;
            if (cells.isEmpty()) {

                cells.add(this);
                nodes.get(3).setStroke(strokeColor);


            } else if (cells.size() == 1) {

                Cell previous = cells.peek();

                cells.add(this);
                cells.peek().nodes.get(3).setStroke(Color.WHITE);
                nodes.get(3).setStroke(strokeColor);

                if (tile.getElementColor3() == previous.tile.getElementColor3() && tile.getElementColor3() != null &&
                        previous.tile.getElementColor3() != null) {
                    tile.setElementColor3(null);
                    cells.peek().tile.setElementColor3(null);
                    cells.peek().nodes.get(0).setFill(Color.BLACK);
                    nodes.get(0).setFill(Color.BLACK);
                    pairCounter++;
                    currentScore++;
                    matched = true;

                }
                if (tile.getElementColor2() == previous.tile.getElementColor2() && tile.getElementColor2() != null &&
                        previous.tile.getElementColor2() != null) {
                    tile.setElementColor2(null);
                    cells.peek().tile.setElementColor2(null);
                    cells.peek().nodes.get(1).setFill(Color.BLACK);
                    nodes.get(1).setFill(Color.BLACK);
                    pairCounter++;
                    currentScore++;
                    matched = true;

                }
                if (tile.getElementColor1() == previous.tile.getElementColor1() && tile.getElementColor1() != null &&
                        previous.tile.getElementColor1() != null) {
                    tile.setElementColor1(null);
                    cells.peek().tile.setElementColor1(null);
                    cells.peek().nodes.get(2).setFill(Color.BLACK);
                    nodes.get(2).setFill(Color.BLACK);
                    pairCounter++;
                    currentScore++;
                    matched = true;


                }

                cells.remove();

                //System.out.println(pairCounter);
                if (isTileEmpty()) {
                } else if (!matched) currentScore = 0;
                else if (currentScore > maxScore) {
                    maxScore = currentScore;
                }

                ((Text) mainNodes.get(mainNodes.size() - 2)).setText("The current score is: " + currentScore);
                ((Text) mainNodes.get(mainNodes.size() - 1)).setText("The max score is: " + maxScore);
                if (checkWin(pairCounter)) alertBox.display("Your max score was: " + maxScore);
            }
            /*else if (cells.size() == 2){
                System.err.println("The queue should not be larger than 2.");
                System.exit(0);
            }
            for(Cell c : cells){
                System.out.println(c.tile.toString());
            }
            System.out.println(cells.size());*/

        }



        private boolean checkWin(int counter) {

            int totalPairings = Shapes.values().length * COLS * (ROWS / 2);
            return counter == totalPairings;
        }

        private boolean isTileEmpty() {
            return tile.getElementColor1() == null && tile.getElementColor2() == null && tile.getElementColor3() == null;
        }


    }

    private static class alertBox {
        private static void display(String message) {
            Stage alertWindow = new Stage();
            alertWindow.initModality(Modality.APPLICATION_MODAL);
            alertWindow.setTitle("Game Over");
            alertWindow.setMinWidth(250);
            alertWindow.setMaxHeight(250);
            Label label = new Label();
            label.setText(message);
            Button button = new Button("quit");
            button.setOnAction(e -> System.exit(0));
            VBox layout = new VBox(10);
            layout.getChildren().addAll(label, button);
            layout.setAlignment(Pos.CENTER);
            Scene scene = new Scene(layout);
            alertWindow.setScene(scene);
            alertWindow.showAndWait();

        }

    }
}
