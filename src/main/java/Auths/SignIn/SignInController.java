package Auths.SignIn;

import Auths.SignUp.SignUpController;
import UserAuths.UserSignUpController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static FrontPage.FrontPageController.*;
public class SignInController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private PasswordField passwordTF;

    @FXML
    private TextField usernameTF;


    @FXML
    void handleSignIn(ActionEvent event) throws IOException {
        String fileName;
        if(loggedInUserRole.equals("police")){
            fileName = "AllTextFile/AllPolice/AllPolice.txt";
        }else {
            fileName = "AllTextFile/AllNormalUser/AllNormalUser.txt";
        }
        String line;
        String[] data;
        boolean isSuccess = false;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String usernameTf = usernameTF.getText();
            String passwordTf = passwordTF.getText();
            while ((line = bufferedReader.readLine()) != null) {
                data = line.split("\\]\\[");

                String username =data[0].substring(1).trim();
                String password = data[1].trim();
                if(username.equals(usernameTf) && password.equals(passwordTf)) {
                    String designation = data[2].trim();
                    String firstname = data[3].trim();
                    String lastname = data[4].trim();
                    String policeStationId = data[5].trim();
                    String phone = data[6].trim();
                    System.out.println("Field 1: " + username);
                    System.out.println("Field 2: " + password);
                    System.out.println("Field 3: " + designation);
                    System.out.println("Field 4: " + firstname);
                    System.out.println("Field 5: " + lastname);
                    System.out.println("Field 6: " + policeStationId);
                    System.out.println("Field 7: " + phone);
                    isSuccess = true;
                    loggedInUserFullName = firstname  + " " + lastname;
                    loggedInUserDesignation = designation;
                    loggedInUsername = username;
                    break;
                }
            }

            if(isSuccess){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Congratulations!");
                alert.setContentText("Successfully logged in.");
                alert.showAndWait();
                switchToDashboard(event);
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Wrong!");
                alert.setContentText("Please, check your username and password.");
                alert.showAndWait();
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    void switchToDashboard(ActionEvent event) throws IOException {
        try {
            FXMLScene scene = FXMLScene.load("/Dashboard/Dashboard.fxml");
            Parent root = scene.root;
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Police Station");
            stage.show();
        } catch (Exception e) {
            System.out.println("$Error: " + e.getMessage());
        }
    }

    @FXML
    void switchToSignUp(ActionEvent event) {
        if(loggedInUserRole.equals("police")){
            try {
                root = FXMLLoader.load(SignUpController.class.getResource("SignUp.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Police Station");
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
    }else{
            try {
                root = FXMLLoader.load(UserSignUpController.class.getResource("UserSignUp.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Police Station");
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
