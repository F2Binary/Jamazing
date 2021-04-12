import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
public class Maze extends Application {
    int MazeSize = 10;
    int i = 0;
    int j = 0;
    Group RootGroup = new Group(); // Self Explanatory.

    GridPane MainGrid = new GridPane();
    Group Cell[][] = new Group[MazeSize][MazeSize];

    public void FillGrid(){
        for (i=0; i<MazeSize; i++){
            for(j=0; j < MazeSize; j++){
                MainGrid.add(Cell[i][j], j, i);
            }
            j=0;
        }
    }
    
    

    public static void main(String[] args) {
        launch(args);
    }

    

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Maze Generator"); // window title
        primaryStage.show(); //spawning window
        primaryStage.getIcons().add(new Image(Maze.class.getResourceAsStream("Icon/m-icon-png-2.png"))); // setting app icon
        primaryStage.setHeight(500);
        primaryStage.setWidth(500);

        
        Scene scene = new Scene(RootGroup);

        Button generator = new Button("Generate Maze");
        generator.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                FillGrid();
            }
        });
        
        RootGroup.getChildren().addAll(generator, MainGrid);

        primaryStage.setScene(scene); //setting our main scene
    }
}