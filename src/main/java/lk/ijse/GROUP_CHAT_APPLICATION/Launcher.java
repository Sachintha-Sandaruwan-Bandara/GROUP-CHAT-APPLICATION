package lk.ijse.GROUP_CHAT_APPLICATION;
/* 
    @author Sachi_S_Bandara
    @created 1/15/2024 - 9:56 AM 
*/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Launcher extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {


        Parent root = FXMLLoader.load(Launcher.class.getResource("/view/loginPageForm.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        //Image icon= new Image("images/logo.png");
        //stage.getIcons().add(icon);
        stage.setTitle("");
        stage.show();
    }
}
