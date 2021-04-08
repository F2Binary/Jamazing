import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
public class Maze extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public void AddCell(GridPane grid, int size){
        int cellx = 0;
        int celly = 0;
        while(cellx < size && celly < size){
            while(cellx < size){
                grid.add(new Button("ff"), cellx, celly);
                cellx++;
            }
            cellx = 0;
            celly++;
        }
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

    // method to check if parameter is type int or not. 
    public boolean IsInt(String str){
        try{
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException ex){
            return false;
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Jamazing"); // window title
        int WindowSize = 500; // Size of the entire application is static so I don't have to worry about resizing. 
        primaryStage.show(); //spawning window
        primaryStage.getIcons().add(new Image(Maze.class.getResourceAsStream("Icon/m-icon-png-2.png"))); // setting app icon
        primaryStage.setHeight(WindowSize);
        primaryStage.setWidth(WindowSize);

        
        Group group = new Group(); // Main group 
        VBox vbox = new VBox(); // Main Vbox
        HBox hbox = new HBox(); //top Hbox
        GridPane Mazegrid = new GridPane();// main grid

        // main button
        Button generateButton = new Button("Generate Maze"); // Button with functionality

        //text field for button
        TextField MazeSizeUI = new TextField();
        MazeSizeUI.setPromptText("Square Size ex \"5 x 5\" ");
        MazeSizeUI.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(MazeSizeUI, generateButton);
        // Adding funcionality to the Button
        
        // setting up a box
        int size = 10; // Size of Maze
        int CellSize = 40;

        /*/ populating Array with Full Boxes;
        Group[][] GroupGrid = new Group[size][size];
        for(j = 0; j<size; j++){
            for(i = 0; i<size; i++){
                GroupGrid[i][j] = DrawBox_Full(CellSize);
            }
            i = 0;
        }
        *///-------------------------------------------------------

        GridPane MainMaze = new GridPane();
        // Moving GridPane Down
        /*
        Unnecessary now but keeping here cause might be useful later.
        Translate GridMove = new Translate();
        GridMove.setY(30);
        MainMaze.getTransforms().add(GridMove);
        */

        //populating GridPane
        generateButton.setOnMouseClicked((new javafx.event.EventHandler<MouseEvent>() { 
            public void handle(MouseEvent event) { 
                int i = 0;
                int j = 0;
               MainMaze.getChildren().clear(); 
               /*int i = Integer.parseInt(MazeSizeUI.getText());
               if(MazeSizeUI.getText()!=null && !MazeSizeUI.getText().isEmpty()){
                   AddCell(Mazegrid, i);
                }*/ // old button grid method
                if(IsInt(MazeSizeUI.getText()) && MazeSizeUI.getText()!=null && !MazeSizeUI.getText().isEmpty()){
                int ill = Integer.parseInt(MazeSizeUI.getText());
                
                Group[][] GroupGrid = new Group[ill][ill];
                for(j = 0; j<ill; j++){
                    for(i = 0; i<ill; i++){
                    GroupGrid[i][j] = DrawBox_Full(CellSize);
                    }
                    i = 0;
                }
                for(j = 0; j<ill; j++){
                    for(i = 0; i<ill; i++){
                        MainMaze.add(GroupGrid[i][j], j, i);
                    }
                    i = 0;
                }
                j=0;
            }
            else if (!IsInt(MazeSizeUI.getText())){
                Alert eAlert = new Alert(AlertType.CONFIRMATION);
                eAlert.setContentText("A NUMBER PLS STOOPID");
                eAlert.show();
            }
            } 
         }));

        //--------------------------------------------------------
        vbox.getChildren().addAll(hbox, Mazegrid,MainMaze);
        group.getChildren().addAll(vbox);
        Scene scene = new Scene(group);
        primaryStage.setScene(scene); //setting our main scene
    }
}