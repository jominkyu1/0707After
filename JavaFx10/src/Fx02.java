import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Fx02 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();

        root.setPrefWidth(380); //가로
        root.setPrefHeight(150); //세로
        root.setAlignment(Pos.CENTER); //중앙정렬
        root.setSpacing(20); //수직간격

        Label label = new Label();
        label.setText("Hello JavaFx");
        label.setFont(new Font(50));

        Button button = new Button();
        button.setText("확인");
        button.setOnAction(e -> Platform.exit());

        root.getChildren().add(label);
        root.getChildren().add(button);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
