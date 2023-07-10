import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Fx06 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("root04.xml"));
        Scene scene = new Scene(root);

        scene.getStylesheets().add(getClass().getResource("app.css").toString());
        //장면에 css로 ui적용
        
        stage.setTitle("CSS 적용예시");
        stage.setScene(scene); //무대에 장면적용
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
