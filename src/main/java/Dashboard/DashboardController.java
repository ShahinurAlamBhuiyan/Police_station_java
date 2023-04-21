package Dashboard;

import Auths.SignIn.SignInController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

//import static Auths.SignUp.SignUp.*;

import static FrontPage.FrontPageController.*;
public class DashboardController  implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private BorderPane DashboardBorderPane;

    @FXML
    private Label UserDesignation;

    @FXML
    private Label UserFullName;

    @FXML
    private Label UserNameLabel;
    @FXML
    private Button criminalBtn;



    @FXML
    void handleCases(ActionEvent event) {
        try {
            Pane p = FXMLLoader.load(getClass().getResource("/Dashboard/Cases/Cases.fxml"));
            DashboardBorderPane.setCenter(p);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Police Station");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleCriminals(ActionEvent event) {
        try {
            Pane p = FXMLLoader.load(getClass().getResource("/Dashboard/Criminals/Criminals.fxml"));
            DashboardBorderPane.setCenter(p);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Police Station");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleFIR(ActionEvent event) {
        try {
            Pane p = FXMLLoader.load(getClass().getResource("/Dashboard/FIR/FIR.fxml"));
            DashboardBorderPane.setCenter(p);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("NTStock");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handleShowProfileBtn(ActionEvent event) {

    }

    @FXML
    void handleSignOut(ActionEvent event) {
        try {
            root = FXMLLoader.load(SignInController.class.getResource("SignIn.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Police Station");
            stage.show();

            loggedInUserFullName = "";
            loggedInUserDesignation = "";
            loggedInUsername = "";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(loggedInUserRole.equals("police")){
            criminalBtn.setVisible(true);
        }else{
            criminalBtn.setVisible(false);
        }
        UserDesignation.setText(loggedInUserDesignation);
        UserFullName.setText(loggedInUserFullName);
        UserNameLabel.setText(loggedInUsername);
    }
}
