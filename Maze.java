import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
 
public class Maze extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Jamazing");
        int WindowSize = 500; // Size of the entire application is static so I don't have to worry about resizing. 
        
        Group group = new Group(); // Main group 

        HBox hbox = new HBox(); //top Hbox
        Button generateButton = new Button("Generate Maze");
        hbox.getChildren().add(generateButton);

        Pane mazePane = new Pane();
        Line line1 = new Line(0, 10, 500 , 20);
        mazePane.getChildren().addAll(line1);

        group.getChildren().addAll(hbox, mazePane); // Adding everything to main group before setting the scene
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