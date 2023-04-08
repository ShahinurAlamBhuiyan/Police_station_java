package Auths.SignIn;

import Auths.SignUp.SignUpController;
import Dashboard.DashboardController;
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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static Auths.SignUp.SignUp.*;
public class SignInController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private PasswordField passwordTF;

    @FXML
    private TextField usernameTF;


//    public String userRandomId=null;
//    public String userEmail = null;


    @FXML
    void handleSignIn(ActionEvent event) throws IOException {
        ArrayList<UserInformation> allUserInfo = new ArrayList<UserInformation>();
        if(((!usernameTF.getText().equals(""))) && (!passwordTF.getText().equals(""))){

            boolean isMatch = false;
            try{
                File file  = new File("AllTextFile/AllPolice/AllPolice.txt");
                Scanner fileReader = new Scanner(file);
                while(fileReader.hasNext())
                {
                    allUserInfo.add(new UserInformation(fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(), fileReader.next(),fileReader.next()));
                }

                for(UserInformation user : allUserInfo){
                    if(user.getUsername().equals(usernameTF.getText()) && user.getPassword().equals(passwordTF.getText())){
                        isMatch = true;
                        loggedInUserFullName = user.getFirstName()  + " " + user.getLastName();
                        loggedInUserDesignation = user.getDesignation();
                        loggedInUsername = user.getUsername();
                        break;
                    }
                }

            }catch(Exception e){
                System.out.println("Something went wrong. SignInController 62 line.");
                e.printStackTrace();
            }

            if(isMatch== true){
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
        }

    }

    void switchToDashboard(ActionEvent event) throws IOException {
        try {
            FXMLScene scene = FXMLScene.load("/Dashboard/Dashboard.fxml");
            Parent root = scene.root;
            // sending data for dashboard. --------------------------------
//            DashboardController dashboardsController = (DashboardController) scene.controller;
//            dashboardsController.setSignedUserInfo(role,userEmailTF.getText(), userRandomId);
//            dashboardsController.handleSidebar();
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
    }

}
