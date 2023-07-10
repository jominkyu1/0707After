import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Fx03 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("root03.xml"));
        //root.xml파일 로드

        Scene scene = new Scene(root); //장면 객체생성

        stage.setTitle("XML Layout");
        stage.setScene(scene);
        stage.show();
    }
}
