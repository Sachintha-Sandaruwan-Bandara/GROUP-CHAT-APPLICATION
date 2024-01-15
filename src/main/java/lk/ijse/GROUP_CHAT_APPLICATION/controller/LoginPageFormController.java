package lk.ijse.GROUP_CHAT_APPLICATION.controller;
/* 
    @author Sachi_S_Bandara
    @created 1/15/2024 - 10:02 AM 
*/

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import lk.ijse.GROUP_CHAT_APPLICATION.db.DbConnection;

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
            } else {
                System.out.println("somthing went wrong");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}


