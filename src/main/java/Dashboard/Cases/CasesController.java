package Dashboard.Cases;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CasesController implements Initializable {


    @FXML
    private VBox AddCaseContainer;

    @FXML
    private DatePicker ArrestDateTF;
    @FXML
    private TextField ArrestDateTF1;

    @FXML
    private ChoiceBox<String> CaseTypeTF;
    @FXML
    private TextField CaseTypeTF1;
    private String[] CaseTypes = {"Stealing", "Murder", "Threat"};

    @FXML
    private TextField CaseIDTF;
    @FXML
    private TextField CaseIDTF1;

    @FXML
    private TextField FIRIDTF;
    @FXML
    private TextField FIRIDTF1;

    @FXML
    private TextField IncidentPlaceTF;
    @FXML
    private TextField IncidentPlaceTF1;

    @FXML
    private TextField ObjectFoundTF;
    @FXML
    private TextField ObjectFoundTF1;

    @FXML
    private TextField searchCaseIdTF;



    @FXML
    private VBox SearchCaseContainer;


    @FXML
    private VBox aboutContainer;
    @FXML
    private Button formContainer;


    @FXML
    void handleAddCaseBtn(ActionEvent event) {
        AddCaseContainer.setVisible(true);
        SearchCaseContainer.setVisible(false);
        aboutContainer.setVisible(false);
    }


    @FXML
    void handleSearchCaseBtn(ActionEvent event) {
        SearchCaseContainer.setVisible(true);
        aboutContainer.setVisible(false);
        AddCaseContainer.setVisible(false);
    }

    @FXML
    void handleSubmit(ActionEvent event) {
        if((!FIRIDTF.getText().equals("")) &&
                (!CaseIDTF.getText().equals("")) &&
                (!IncidentPlaceTF.getText().equals("")) &&
                (!ObjectFoundTF.getText().equals("")) &&
                (ArrestDateTF.getValue() != null) &&
                (CaseTypeTF.getValue() != null)
        ){
            String AllCasePath = "AllTextFile/AllCase/AllCase.txt";
            try {
                FileWriter writer = new FileWriter(AllCasePath, true);
                String CaseLine = "["+FIRIDTF.getText()+"]["+CaseIDTF.getText()+"]["+ IncidentPlaceTF.getText()+"]["+ObjectFoundTF.getText()+"]["+ArrestDateTF.getValue()+"]["+CaseTypeTF.getValue()+"]\n";
                writer.write(CaseLine);
                writer.close();


                System.out.println("Add successfully");
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Success!");
                alert.setContentText("Case saved successfully.");
                alert.showAndWait();

                FIRIDTF.setText("");
                CaseIDTF.setText("");
                ObjectFoundTF.setText("");
                IncidentPlaceTF.setText("");
                ArrestDateTF.setValue(null);
                CaseTypeTF.setValue("");

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
    void handleSearch(ActionEvent event) {
        String AllCasePath = "AllTextFile/AllCase/AllCase.txt";
        String line;
        String[] data;
        String searchCase = searchCaseIdTF.getText();
        boolean isMatch = false;
        try {
            FileReader fileReader = new FileReader(AllCasePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                data = line.split("\\]\\[");
                String caseId = data[1].trim();
                if(caseId.equals(searchCase)){
                    formContainer.setVisible(true);
                    String FIRId = data[0].substring(1).trim();
                    String incidentPlace = data[2].replace("[", "").replace("]", "").trim();
                    String foundObjects = data[3].replace("[", "").replace("]", "").trim();
                    String arrestedDate = data[4].trim();
                    String caseType = data[5].substring(0, data[5].length() - 1).trim();

                    FIRIDTF1.setText(FIRId);
                    CaseIDTF1.setText(caseId);
                    ObjectFoundTF1.setText(foundObjects);
                    IncidentPlaceTF1.setText(incidentPlace);
                    ArrestDateTF1.setText(arrestedDate);
                    CaseTypeTF1.setText(caseType);

                    isMatch = true;
                    break;

                }
            }

            if(!isMatch){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Missing!");
                alert.setContentText("Case not found!");
                alert.showAndWait();

                FIRIDTF1.setText("");
                CaseIDTF1.setText("");
                ObjectFoundTF1.setText("");
                IncidentPlaceTF1.setText("");
                ArrestDateTF1.setText(null);
                CaseTypeTF1.setText("");
                searchCaseIdTF.setText("");
                searchCaseIdTF.setText("");
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CaseTypeTF.getItems().addAll(CaseTypes);
    }
}
