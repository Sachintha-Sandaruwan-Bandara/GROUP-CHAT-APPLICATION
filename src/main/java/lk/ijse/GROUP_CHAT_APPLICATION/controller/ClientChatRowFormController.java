package lk.ijse.GROUP_CHAT_APPLICATION.controller;
/* 
    @author Sachi_S_Bandara
    @created 1/15/2024 - 3:50 PM 
*/

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ClientChatRowFormController  {
    @FXML
    private Text text;
    @FXML
    private  Label txtTime;
    private LocalDateTime fixedTime;
    @FXML
    private Text text2;
    @FXML
    private Label txtTime2;
    public ClientChatRowFormController() {
    }

    public void initialize() {
        setTime();



    }


    public void setText(String text) {
        this.text.setText(text);
    }
    public void setTime() {
        fixedTime = LocalDateTime.now();

        // Create a label to display the timestamp
        Label timestampLabel = new Label(getFormattedTimestamp());
        String text1 = timestampLabel.getText();
        txtTime.setText(text1);
    }


    private String getFormattedTimestamp() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("                                          HH:mm a");
        return fixedTime.format(formatter);
    }


}
