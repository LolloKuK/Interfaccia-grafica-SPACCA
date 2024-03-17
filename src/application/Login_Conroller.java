package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Login_Conroller {

    @FXML
    TextField login_username;
    @FXML
    PasswordField login_password;

    @FXML
    Button login_button;
    @FXML
    Button signup_button;
    @FXML
    Button loadgame_button;
    @FXML
    Button launch_button;
    @FXML
    Label login_error;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void loggedIn(ActionEvent event) throws IOException {
        String username = login_username.getText();
        String password = login_password.getText();

        if (credentialsVerify(username, password)) {
            launchGame(event);
        }
        else {
            login_error.setOpacity(1.0);
            login_error.setText("Errore!");
        }
    }

    public boolean credentialsVerify(String username, String password) {
        String pathFile = "/Users/lorenzocuoco/Desktop/Cartelle/Programmazione/IntelliJ-workspace/Spacca/src/saved_data/credenziali.txt";
        //da cambiare nel caso si usi su un'altro pc

        try (BufferedReader reader = new BufferedReader(new FileReader(pathFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("/=/");
                if (parts.length == 2) {
                    String savedUsername = parts[0].trim();
                    String savedPassword = parts[1].trim();
                    if (savedUsername.equals(username)  && savedPassword.equals(password)) {
                        return true;
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("File non trovato");
        }
        return false;
    }

    public void changeToSignUp(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("signup.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void changeToLoadGame(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("loadgame.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void launchGame(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("menu.fxml"));
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