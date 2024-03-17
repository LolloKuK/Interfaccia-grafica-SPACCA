package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoadGame_Conroller {

    @FXML
    TextField game_code;

    @FXML
    Button login_button;
    @FXML
    Button loadgame_button;
    @FXML
    Label loadgame_error;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void loadGame(ActionEvent actionEvent) {
    }

    public void changeToLogin(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Load game application");
        stage.show();
    }

    public void closeApp(ActionEvent event) {
        System.exit(0);
    }
}
