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
import javafx.scene.shape.Line;

import javafx.stage.Stage;
 
public class Maze extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Jamazing");

        Button button1 = new Button();
        button1.setText("I'm A Button");

        BorderPane pane = new BorderPane();
        pane.setTop(button1);
        pane.setPadding(new Insets(10));

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}