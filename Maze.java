import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
public class Maze extends Application {
    public static void main(String[] args) {
        launch(args);
    }
//------------------------------------- All 4 Box Methods Start ---------------------------------------------//
    public Group DrawBox_Full(int size){
        double xCoord = 0;
        double yCoord = 0;
        Line lineTop = new Line(xCoord     ,      yCoord     ,      xCoord+size,      yCoord     );
        Line lineR   = new Line(xCoord+size,      yCoord     ,      xCoord+size,      yCoord+size);
        Line lineBot = new Line(xCoord+size,      yCoord+size,      xCoord     ,      yCoord+size);
        Line lineL   = new Line(xCoord     ,      yCoord+size,      xCoord     ,      yCoord     );
        Group box = new Group(lineBot, lineTop, lineL, lineR);
        return box;
    }
    public Group DrawBox_NoTop(int size){
        double xCoord = 0;
        double yCoord = 0;
        //Line lineTop = new Line(xCoord     ,      yCoord     ,      xCoord+size,      yCoord     );
        Line lineR   = new Line(xCoord+size,      yCoord     ,      xCoord+size,      yCoord+size);
        Line lineBot = new Line(xCoord+size,      yCoord+size,      xCoord     ,      yCoord+size);
        Line lineL   = new Line(xCoord     ,      yCoord+size,      xCoord     ,      yCoord     );
        Group box = new Group(lineBot, lineL, lineR);
        return box;
    }
    public Group DrawBox_NoRight(int size){
        double xCoord = 0;
        double yCoord = 0;
        Line lineTop = new Line(xCoord     ,      yCoord     ,      xCoord+size,      yCoord     );
        //Line lineR   = new Line(xCoord+size,      yCoord     ,      xCoord+size,      yCoord+size);
        Line lineBot = new Line(xCoord+size,      yCoord+size,      xCoord     ,      yCoord+size);
        Line lineL   = new Line(xCoord     ,      yCoord+size,      xCoord     ,      yCoord     );
        Group box = new Group(lineBot, lineTop, lineL);
        return box;
    }
    public Group DrawBox_NoBot(int size){
        double xCoord = 0;
        double yCoord = 0;
        Line lineTop = new Line(xCoord     ,      yCoord     ,      xCoord+size,      yCoord     );
        Line lineR   = new Line(xCoord+size,      yCoord     ,      xCoord+size,      yCoord+size);
        //Line lineBot = new Line(xCoord+size,      yCoord+size,      xCoord     ,      yCoord+size);
        Line lineL   = new Line(xCoord     ,      yCoord+size,      xCoord     ,      yCoord     );
        Group box = new Group(lineTop, lineL, lineR);
        return box;
    }
    public Group DrawBox_NoLeft(int size){
        double xCoord = 0;
        double yCoord = 0;
        Line lineTop = new Line(xCoord     ,      yCoord     ,      xCoord+size,      yCoord     );
        Line lineR   = new Line(xCoord+size,      yCoord     ,      xCoord+size,      yCoord+size);
        Line lineBot = new Line(xCoord+size,      yCoord+size,      xCoord     ,      yCoord+size);
        //Line lineL   = new Line(xCoord     ,      yCoord+size,      xCoord     ,      yCoord     );
        Group box = new Group(lineBot, lineTop, lineR);
        return box;
    }
//------------------------------------- All 4 Box Methods End --------------------------------------------//
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Maze Generator"); // window title
        primaryStage.show(); //spawning window
        primaryStage.getIcons().add(new Image(Maze.class.getResourceAsStream("Icon/m-icon-png-2.png"))); // setting app icon
        primaryStage.setHeight(500);
        primaryStage.setWidth(500);

        // setting up a box
        int size = 10; // Size of Maze
        int CellSize = 40;
        int i = 0;
        int j = 0;

        // populating Array with Full Boxes;
        Group[][] GroupGrid = new Group[size][size];
        for(j = 0; j<size; j++){
            for(i = 0; i<size; i++){
                GroupGrid[i][j] = DrawBox_Full(CellSize);
            }
            i = 0;
        }
        //-------------------------------------------------------

        GridPane MainMaze = new GridPane();
        MainMaze.setPadding(new Insets(10));

        //populating GridPane
        for(j = 0; j<size; j++){
            for(i = 0; i<size; i++){
                MainMaze.add(GroupGrid[i][j], j, i);
            }
            i = 0;
        }
        j=0;
        //--------------------------------------------------------

        //GroupGrid[0][0] = DrawBox_NoLeft(CellSize);
        MainMaze.getChildren().remove(i, j);
        //MainMaze.add(GroupGrid[0][0], i, j);
        Scene scene = new Scene(MainMaze);

        primaryStage.setScene(scene); //setting our main scene
    }
}