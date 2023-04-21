//package FrontPage;
//
//import Auths.SignIn.SignInController;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//
//public class FrontPageController {
//    private Stage stage;
//    private Scene scene;
//    private Parent root;
//    @FXML
//    void handleLoginPolice(ActionEvent event) {
//        try {
//            root = FXMLLoader.load(SignInController.class.getResource("SignIn.fxml"));
//            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            scene = new Scene(root);
//            stage.setScene(scene);
//            stage.setTitle("Police Station");
//            stage.show();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    @FXML
//    void handleLoginUser(ActionEvent event) {
//
//    }
//
//}



package FrontPage;

import Auths.SignIn.SignInController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FrontPageController extends Application {

    static public String loggedInUsername = "";
    static public String loggedInUserFullName = "";
    static public String loggedInUserDesignation = "";
    static public String loggedInUserRole = "";

    private Stage stage;
    private Scene scene;
    private Parent root;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FrontPageController.class.getResource("FrontPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Police Station");
        stage.setScene(scene);

        stage.show();
    }

    @FXML
    void handleLoginPolice(ActionEvent event) {
        loggedInUserRole = "police";
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

    @FXML
    void handleLoginUser(ActionEvent event) {
        loggedInUserRole = "user";
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

    public static void main(String[] args) {
        launch();
    }
}
