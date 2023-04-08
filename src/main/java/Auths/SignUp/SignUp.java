package Auths.SignUp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class SignUp extends Application {
    static public String loggedInUsername = "";
    static public String loggedInUserFullName = "";
    static public String loggedInUserDesignation = "";
//    static public String loggedInUserEmail = "";
//    static public String loggedInUserType = "";

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SignUp.class.getResource("SignUp.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Police Station");
//        File file = new File("src/main/resources/Image/ntlogo1.png");
//        Image image = new Image(file.toURI().toString());
//        stage.getIcons().add(image);
        stage.setScene(scene);

        stage.show();
    }
    // merge with  shahin branch
    public static void main(String[] args) {
        launch();
    }
}
