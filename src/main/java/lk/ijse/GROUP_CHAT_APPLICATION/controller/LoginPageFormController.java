package lk.ijse.GROUP_CHAT_APPLICATION.controller;
/* 
    @author Sachi_S_Bandara
    @created 1/15/2024 - 10:02 AM 
*/

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.GROUP_CHAT_APPLICATION.Launcher;
import lk.ijse.GROUP_CHAT_APPLICATION.db.DbConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginPageFormController {

    @FXML
    private TextField txtUserName;

    @FXML
    void btnLoginOnAction(ActionEvent event) {
        try {

            Connection connection = DbConnection.getInstance().getConnection();
            String sql = "INSERT INTO USER (usrName) VALUES (?);";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setObject(1, txtUserName.getText());
            boolean isUserSaved = pstm.executeUpdate() > 0;
            if (isUserSaved) {
                System.out.println("usr saved!!");
//                Stage stage = new Stage();
//                Parent root = FXMLLoader.load(Launcher.class.getResource("/view/clientForm.fxml"));
//                Scene scene = new Scene(root);
//                stage.setScene(scene);
//                stage.setTitle("");
//                stage.show();

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/clientForm.fxml"));
                ClientFormController clientFormController = new ClientFormController();
                fxmlLoader.setController(clientFormController);
                clientFormController.name=txtUserName.getText();
                Parent root= fxmlLoader.load();
                Scene scene = new Scene(root);
                Stage stage= new Stage();
                stage.setScene(scene);
                stage.setTitle("");
                stage.show();

            } else {
                System.out.println("something went wrong");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}


