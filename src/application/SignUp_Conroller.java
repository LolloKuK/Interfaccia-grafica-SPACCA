package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;

public class SignUp_Conroller {

    @FXML
    TextField signup_username;
    @FXML
    PasswordField signup_password;

    @FXML
    Button signup_button;
    @FXML
    Button login_button;
    @FXML
    Label signup_status;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void signedUp(ActionEvent event) {
        String username = signup_username.getText();
        String password = signup_password.getText();

        addCredentials(username, password);
    }

    public void addCredentials(String username, String password) {
        String pathFile = "/Users/lorenzocuoco/Desktop/Cartelle/IntelliJ-workspace/Spacca/src/saved_data/credenziali.txt";
        //da cambiare nel caso si usi su un'altro pc

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathFile, true))) {
            if (credentialsVerify(username, password)) {
                signup_status.setOpacity(1.0);
                signup_status.setText("Accout esistente");
            }
            else {
                if (!username.isEmpty() && !password.isEmpty()) {
                    writer.newLine();
                    writer.write(username + "/=/" + password);
                    writer.close();
                    signup_status.setOpacity(1.0);
                    signup_status.setText("Success!");
                }
                else {
                    signup_status.setOpacity(1.0);
                    signup_status.setText("Errore!");
                }
            }
        } catch (IOException e) {
            System.out.println("File non trovato");
        }
    }

    public boolean credentialsVerify(String username, String password) {
        String pathFile = "/Users/lorenzocuoco/Desktop/Cartelle/IntelliJ-workspace/Spacca/src/saved_data/credenziali.txt";
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

    public void changeToLogin(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void closeApp(ActionEvent event) {
        System.exit(0);
    }
}
