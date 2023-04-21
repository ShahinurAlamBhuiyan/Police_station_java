package UserAuths;

import Auths.SignIn.SignInController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.net.URL;
import java.util.ResourceBundle;

public class UserSignUpController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField NIDTF;

    @FXML
    private TextField firstNameTField;

    @FXML
    private TextField lastNameTField;

    @FXML
    private TextField mobileTField;

    @FXML
    private TextField occupationTF;

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
                && (!NIDTF.getText().equals("")) && (!mobileTField.getText().equals(""))
                && (!(occupationTF.getText().equals("")))
        ){
            System.out.println("Success.");
            String AllUserPath = "AllTextFile/AllNormalUser/AllNormalUser.txt";


            try{
                FileWriter writer1 = new FileWriter(AllUserPath, true);
                String UserLine = "["+usernameTField.getText() + "][" + passwordTField.getText() + "][" +
                        occupationTF.getText() + "][" + firstNameTField.getText() + "][" +  lastNameTField.getText() + "][" + NIDTF.getText()+
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

    }
}
