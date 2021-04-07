import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
 
public class Maze extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Bruh Moment");
        primaryStage.show();
        primaryStage.getIcons().add(new Image(Maze.class.getResourceAsStream("Icon/m-icon-png-2.png")));
        Group group = new Group();
        Scene scene = new Scene(group);
        primaryStage.setScene(scene);
    }
}