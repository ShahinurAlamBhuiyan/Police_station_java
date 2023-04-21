package Dashboard.Criminals;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.util.ResourceBundle;

public class CriminalsController implements Initializable {

    @FXML
    private TextField ACTTF;
    @FXML
    private TextField ACTTF1;

    @FXML
    private Button AddCriminalBtn;

    @FXML
    private VBox AddCriminalContainer;

    @FXML
    private DatePicker ArrestDateTF;
    @FXML
    private TextField ArrestDateTF1;

    @FXML
    private TextField CityTF;
    @FXML
    private TextField CityTF1;
    @FXML
    private TextField EmailTF;
    @FXML
    private TextField EmailTF1;

    @FXML
    private ChoiceBox<String> GenderTF;
    @FXML
    private TextField GenderTF1;
    private String[] Gender = {"Male", "Female", "Others"};

    @FXML
    private TextField HeightTF;
    @FXML
    private TextField HeightTF1;

    @FXML
    private ChoiceBox<String> MaritalStatusTF;
    @FXML
    private TextField MaritalStatusTF1;
    private String[] maritalStatus = {"Married", "Unmarried"};
    @FXML
    private TextField NameTF;
    @FXML
    private TextField NameTF1;

    @FXML
    private TextField OccupationTF;
    @FXML
    private TextField OccupationTF1;


    @FXML
    private TextField PhoneTF;
    @FXML
    private TextField PhoneTF1;

    @FXML
    private DatePicker ReleaseDateTF;
    @FXML
    private TextField ReleaseDateTF1;


    @FXML
    private VBox SearchCriminalContainer;

    @FXML
    private TextField StationNameTF;
    @FXML
    private TextField StationNameTF1;

    @FXML
    private TextField SubjectTF;
    @FXML
    private TextField SubjectTF1;

    @FXML
    private TextField WeightTF;
    @FXML
    private TextField WeightTF1;


    @FXML
    private VBox aboutContainer;

    @FXML
    private TextField criminalIDTF;
    @FXML
    private TextField CriminalIDTF1;


    @FXML
    private TextField searchCriminalIDTF1;


    @FXML
    private Button formContainer;

    @FXML
    void handleAddCriminalBtn(ActionEvent event) {
        AddCriminalContainer.setVisible(true);
        SearchCriminalContainer.setVisible(false);
        aboutContainer.setVisible(false);
    }



    @FXML
    void handleSearchCriminalBtn(ActionEvent event) {
        SearchCriminalContainer.setVisible(true);
        aboutContainer.setVisible(false);
        AddCriminalContainer.setVisible(false);
    }

    @FXML
    void handleSubmit(ActionEvent event) {
        if((!criminalIDTF.getText().equals("")) && (!StationNameTF.getText().equals(""))
            && (!SubjectTF.getText().equals("")) && (!ACTTF.getText().equals(""))
            && (!NameTF.getText().equals("")) && (!CityTF.getText().equals(""))
            && (!PhoneTF.getText().equals("")) && (!EmailTF.getText().equals(""))
            && (ArrestDateTF.getValue() != null) && (ReleaseDateTF.getValue() != null)
            && (MaritalStatusTF.getValue() != null) && (GenderTF.getValue() != null)
            && (!WeightTF.getText().equals("")) && (!HeightTF.getText().equals("")) && (!OccupationTF.getText().equals(""))
        ){
            String AllCriminalPath = "AllTextFile/AllCriminal/AllCriminal.txt";
            try {
                FileWriter writer = new FileWriter(AllCriminalPath, true);
                String CriminalLine = "["+criminalIDTF.getText()+"]["+StationNameTF.getText()+"]["+ SubjectTF.getText()+"]["+ACTTF.getText()+"]["+NameTF.getText()+"]["+CityTF.getText()+"]["+PhoneTF.getText()+"]["+EmailTF.getText()+"]["+ArrestDateTF.getValue()+"]["+ReleaseDateTF.getValue()+"]["+MaritalStatusTF.getValue()+"]["+GenderTF.getValue()+"]["+WeightTF.getText()+"]["+HeightTF.getText()+"]["+OccupationTF.getText()+"]\n";
                writer.write(CriminalLine);
                writer.close();

                System.out.println("Add successfully");
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Success!");
                alert.setContentText("Criminal saved successfully.");
                alert.showAndWait();

                criminalIDTF.setText("");
                StationNameTF.setText("");
                SubjectTF.setText("");
                ACTTF.setText("");
                NameTF.setText("");
                CityTF.setText("");
                PhoneTF.setText("");
                EmailTF.setText("");
                WeightTF.setText("");
                HeightTF.setText("");
                OccupationTF.setText("");
                ArrestDateTF.setValue(null);
                ReleaseDateTF.setValue(null);
                MaritalStatusTF.setValue(null);
                GenderTF.setValue(null);

            }catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Information shortage!");
                alert.setContentText("Something went wrong, try again later.");
                alert.showAndWait();
            }

        }else{
            System.out.println("not work");
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Information shortage!");
            alert.setContentText("Please, Fill all the data.");
            alert.showAndWait();
        }
    }

    @FXML
    void handleSearchCriminalIDBtn(ActionEvent event) {
        String AllCriminalPath = "AllTextFile/AllCriminal/AllCriminal.txt";
        if(!searchCriminalIDTF1.getText().equals("")){
            String line;
            String[] data;
            String searchCriminal = searchCriminalIDTF1.getText();
            boolean isMatch = false;
            try {
                FileReader fileReader = new FileReader(AllCriminalPath);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                while ((line = bufferedReader.readLine()) != null) {
                    data = line.split("\\]\\[");
                    String criminalId = data[0].substring(1).trim();
                    if(criminalId.equals(searchCriminal)){
                        formContainer.setVisible(true);
                        String stationName = data[1].trim();
                        String subject = data[2].trim();
                        String act = data[3].trim();
                        String name = data[4].trim();
                        String city = data[5].trim();
                        String phone = data[6].substring(0, data[6].length()).trim();
                        String email = data[7].trim();
                        String arrestDate = data[8].trim();
                        String releaseDate = data[9].trim();
                        String maritalStatus = data[10].trim();
                        String gender = data[11].trim();
                        String weight = data[12].trim();
                        String height = data[13].trim();
                        String occupation = data[14].substring(0, data[14].length() - 1).trim();

                        CriminalIDTF1.setText(criminalId);
                        StationNameTF1.setText(stationName);
                        SubjectTF1.setText(subject);
                        ACTTF1.setText(act);
                        NameTF1.setText(name);
                        CityTF1.setText(city);
                        PhoneTF1.setText(phone);
                        EmailTF1.setText(email);
                        ArrestDateTF1.setText(arrestDate);
                        ReleaseDateTF1.setText(releaseDate);
                        MaritalStatusTF1.setText(maritalStatus);
                        GenderTF1.setText(gender);
                        WeightTF1.setText(weight);
                        HeightTF1.setText(height);
                        OccupationTF1.setText(occupation);

                        isMatch = true;
                        break;
                    }
                }
                if(!isMatch){
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Missing!");
                    alert.setContentText("Case not found!");
                    alert.showAndWait();

                    searchCriminalIDTF1.setText("");

                    CriminalIDTF1.setText(null);
                    StationNameTF1.setText(null);
                    SubjectTF1.setText(null);
                    ACTTF1.setText(null);
                    NameTF1.setText(null);
                    CityTF1.setText(null);
                    PhoneTF1.setText(null);
                    EmailTF1.setText(null);
                    ArrestDateTF1.setText(null);
                    ReleaseDateTF1.setText(null);
                    MaritalStatusTF1.setText(null);
                    GenderTF1.setText(null);
                    WeightTF1.setText(null);
                    HeightTF1.setText(null);
                    OccupationTF1.setText(null);
                }
        }catch (Exception e){
                e.printStackTrace();
            }
    }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MaritalStatusTF.getItems().addAll(maritalStatus);
        GenderTF.getItems().addAll(Gender);
    }
}
