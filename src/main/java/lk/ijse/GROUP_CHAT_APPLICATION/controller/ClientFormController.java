package lk.ijse.GROUP_CHAT_APPLICATION.controller;
/* 
    @author Sachi_S_Bandara
    @created 1/15/2024 - 3:31 PM 
*/
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientFormController {

    @FXML
    private  Label lblName;
    @FXML
    private ScrollPane scrollPane;

    @FXML
    private TextField txtField;
    public   String name="";

    @FXML
    private VBox vBox;
    Socket remoteSocket;
    String massage="";

    ClientChatRowFormController clientChatRowFormController = new ClientChatRowFormController();
    public void initialize(){
        lblName.setText(name);


        new Thread(() -> {
            System.out.println("client");
            try {

                remoteSocket = new Socket("localhost", 3002);




                DataInputStream dataInputStream = new DataInputStream(remoteSocket.getInputStream());
                while (!massage.equals("exit")) {
                    massage = dataInputStream.readUTF();
//                    System.out.println("from server:  " + massage);
//                    clientChatRowFormController.setText(massage);


                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();

    }

    @FXML
    void btnFilesOnAction(ActionEvent event) {

    }

    @FXML
    void btnImojiOnAction(ActionEvent event) {

    }

    @FXML
    void btnSendOnAction(ActionEvent event) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(remoteSocket.getOutputStream());
        String msg = txtField.getText();
        dataOutputStream.writeUTF(msg);
        dataOutputStream.flush();

        //create new v box to hold records
        VBox vBox1 = new VBox();
        vBox1.setSpacing(20);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/clientChatRowForm.fxml"));
        //create row controller
       // ClientChatRowFormController clientChatRowFormController = new ClientChatRowFormController();
        //controller set to fxml
        fxmlLoader.setController(clientChatRowFormController);

        try {
            Node node = fxmlLoader.load();
            clientChatRowFormController.setText(massage);
            vBox1.getChildren().add(node);
            vBox.getChildren().add(vBox1);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
