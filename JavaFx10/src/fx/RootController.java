package fx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class RootController implements Initializable {

    @FXML private Button btn01; // root02.xml에서 fx:id 속성값과 같아야함
    @FXML private Button btn02;
    @FXML private Button btn03;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        btn01.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                handleBtn1Action(event);
            }
        });

        btn03.setOnAction(this::handleBtn3Action);
    }

    public void handleBtn1Action(ActionEvent event){
        System.out.println("첫번째 버튼 클릭");
        System.out.println(event);
    }

    public void handleBtn2Action(ActionEvent event){
        System.out.println("두번째 버튼 클릭");
        System.out.println(event);
    }

    public void handleBtn3Action(ActionEvent event){
        System.out.println("세번째 버튼 클릭");
        System.out.println(event);
    }
}
