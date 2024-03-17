package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class Menu_Controller {

    @FXML
    Button newgame_button;
    @FXML
    Button newtournament_button;
    @FXML
    Button loadgame_button;
    @FXML
    Button exit_button;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void openGameSetup(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("newgame.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void openTournementSetup(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("newtournament.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void openLoadGame(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("loadgame.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        double centerX = bounds.getMinX() + (bounds.getWidth() - stage.getWidth()) / 2;
        double centerY = bounds.getMinY() + (bounds.getHeight() - stage.getHeight()) / 2;

        stage.setX(centerX);
        stage.setY(centerY);

        stage.show();
    }

    public void closeApp(ActionEvent event) {
        System.exit(0);
    }
}
