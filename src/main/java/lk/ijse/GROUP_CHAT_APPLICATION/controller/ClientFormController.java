package lk.ijse.GROUP_CHAT_APPLICATION.controller;
/* 
    @author Sachi_S_Bandara
    @created 1/15/2024 - 3:31 PM 
*/
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ClientFormController {
    @FXML
    private ScrollPane scrollPane;

    @FXML
    private TextField txtField;

    @FXML
    private VBox vBox;

    @FXML
    void btnFilesOnAction(ActionEvent event) {

    }

    @FXML
    void btnImojiOnAction(ActionEvent event) {

    }

    @FXML
    void btnSendOnAction(ActionEvent event) {
        String text = txtField.getText();
        //create new v box to hold records
        VBox vBox1 = new VBox();
        vBox1.setSpacing(20);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/clientChatRowForm.fxml"));
        //create row controller
        ClientChatRowFormController clientChatRowFormController = new ClientChatRowFormController();
        //controller set to fxml
        fxmlLoader.setController(clientChatRowFormController);

        try {
            Node node = fxmlLoader.load();
            clientChatRowFormController.setText(text);
            vBox1.getChildren().add(node);
            vBox.getChildren().add(vBox1);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
