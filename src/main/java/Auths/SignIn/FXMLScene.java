package Auths.SignIn;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;

public class FXMLScene {
    public Parent root = null;
    public Object controller = null;

    public static FXMLScene load(String fxmlpath) throws IOException {

        FXMLScene fxmlScene = new FXMLScene();

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(fxmlScene.getClass().getResource(fxmlpath));

        fxmlScene.root = fxmlLoader.load();
        fxmlScene.controller = fxmlLoader.getController();

        return fxmlScene;

    }
}