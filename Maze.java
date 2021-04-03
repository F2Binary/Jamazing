import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
 
public class Maze extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public void AddCell(GridPane grid, int size, Button button){
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

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Jamazing");
        int WindowSize = 500; // Size of the entire application is static so I don't have to worry about resizing. 
        
        Group group = new Group(); // Main group 
        VBox vbox = new VBox(); // Main Vbox
        HBox hbox = new HBox(); //top Hbox
        GridPane Mazegrid = new GridPane();// main grid

        // main button
        Button generateButton = new Button("Generate Maze");

        //text field for button
        TextField MazeSizeUI = new TextField();
        MazeSizeUI.setPromptText("Square Size ex \"5 x 5\" ");
        MazeSizeUI.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(MazeSizeUI, generateButton);
        //populating grid
        generateButton.setOnMouseClicked((new EventHandler<MouseEvent>() { 
            public void handle(MouseEvent event) { 
               Mazegrid.getChildren().clear(); 
               int i = Integer.parseInt(MazeSizeUI.getText());
               if(MazeSizeUI.getText()!=null && !MazeSizeUI.getText().isEmpty()){
                   AddCell(Mazegrid, i);
                }
            } 
         }));

        vbox.getChildren().addAll(hbox, Mazegrid);
        group.getChildren().addAll(vbox); // Adding everything to main group before setting the scene
        Scene scene = new Scene(group, WindowSize, WindowSize);
        primaryStage.getIcons().add(new Image(Maze.class.getResourceAsStream("/Icon/m-icon-png-2.png")));
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setMaxWidth(WindowSize);
        primaryStage.setMaxHeight(WindowSize);
        primaryStage.setMinWidth(WindowSize);
        primaryStage.setMinHeight(WindowSize);

        hbox.setLayoutX(250 - generateButton.getWidth()/2);
    }
}