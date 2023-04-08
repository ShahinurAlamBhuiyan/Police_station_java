module com.example.policestation {
    requires javafx.controls;
    requires javafx.fxml;


    opens Auths.SignIn to javafx.fxml;
    exports Auths.SignIn;

    opens Auths.SignUp to javafx.fxml;
    exports Auths.SignUp;

    opens Dashboard to javafx.fxml;
    exports Dashboard;

    opens Dashboard.FIR to javafx.fxml;
    exports Dashboard.FIR;

    opens Dashboard.Cases to javafx.fxml;
    exports Dashboard.Cases;

    opens Dashboard.Criminals to javafx.fxml;
    exports Dashboard.Criminals;

}