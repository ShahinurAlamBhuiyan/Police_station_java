package Auths.SignUp;

import Auths.SignIn.SignInController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.fxml.Initializable;

import java.io.FileWriter;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable{
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ChoiceBox<String> designationTypeChoiceBox;
    private String[] designations = {"Inspector", "Sub-Inspector", "Sergeant", "Assistant Sub-Inspector", "Nayek", "Constable"};

    @FXML
    private TextField PSIDTField;
    @FXML
    private TextField firstNameTField;

    @FXML
    private TextField lastNameTField;

    @FXML
    private TextField mobileTField;

    @FXML
    private PasswordField passwordTField;

    @FXML
    private Button signUpNowBtn;

    @FXML
    private TextField usernameTField;

    @FXML
    void handleSignUp(ActionEvent event) {
        if((!firstNameTField.getText().equals("")) && (!lastNameTField.getText().equals(""))
            && (!usernameTField.getText().equals("")) && (!passwordTField.getText().equals(""))
                && (!PSIDTField.getText().equals("")) && (!mobileTField.getText().equals(""))
                && (!(designationTypeChoiceBox.getValue()==null))
        ){
            System.out.println("Success.");
            String AllUserPath = "AllTextFile/AllPolice/AllPolice.txt";


            try{
                FileWriter writer1 = new FileWriter(AllUserPath, true);
                String UserLine = "["+usernameTField.getText() + "][" + passwordTField.getText() + "][" +
                        designationTypeChoiceBox.getValue() + "][" + firstNameTField.getText() + "][" +  lastNameTField.getText() + "][" + PSIDTField.getText()+
                        "][" + mobileTField.getText()+"]\n";
                writer1.write(UserLine);

                writer1.close();
                System.out.println("Add successfully");
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Congratulations!");
                alert.setContentText("Your account created successfully. Sign-in now!");
                alert.showAndWait();
                switchToSignIn(event);
            }catch (Exception e){
                System.out.println("not added");
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Wrong!");
                alert.setContentText("Something went wrong. Please try again later.");
                alert.showAndWait();
            }
        }else{
            System.out.println("Not Success.");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Information shortage!");
            alert.setContentText("Please, Fill all the data.");
            alert.showAndWait();
        }
    }

    @FXML
    void switchToSignIn(ActionEvent event) {
        try {
            root = FXMLLoader.load(SignInController.class.getResource("SignIn.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Police Station");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        designationTypeChoiceBox.getItems().addAll(designations);
    }
}
