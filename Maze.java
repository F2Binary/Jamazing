import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
public class Maze extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("GGgg");
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));

        Text scenetitle = new Text("welcome");
        scenetitle.setFont(Font.font("Tahoma" , FontWeight.NORMAL, 30));
        grid.add(scenetitle, 0,0,2,1);

        Label userName = new Label("User Name");
        grid.add(userName, 0 , 1);

        Label userPassword = new Label("Password");
        grid.add(userPassword, 0 , 2);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);
        
        TextField userTextField2 = new TextField();
        grid.add(userTextField2, 01, 2);

        Scene scene = new Scene(grid , 400 , 375);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}