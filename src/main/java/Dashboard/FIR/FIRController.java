package Dashboard.FIR;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FIRController {
    @FXML
    private TextField ACTTF;
    @FXML
    private TextField ACTTF1;
    @FXML
    private TextField NameTF;
    @FXML
    private TextField NameTF1;
    @FXML
    private TextField CityTF;

    @FXML
    private TextField CityTF1;

    @FXML
    private DatePicker DateTF;
    @FXML
    private TextField DateTF1;

    @FXML
    private TextField DetailsTF;
    @FXML
    private TextArea DetailsTF1;
    @FXML
    private TextField EmailTF;

    @FXML
    private TextField EmailTF1;
    @FXML
    private TextField FIRIDTF;
    @FXML
    private TextField FIRIDTF1;
    @FXML
    private TextField PhoneTF;
    @FXML
    private TextField PhoneTF1;
    @FXML
    private TextField stationNameTF;
    @FXML
    private TextField SearchFIRTF;

    @FXML
    private TextField StationNameTF1;

    @FXML
    private TextField subjectTF;
    @FXML
    private TextField SubjectTF1;
    @FXML
    private VBox aboutContainer;
    @FXML
    private VBox AddFIRContainer;
    @FXML
    private VBox SearchFIRContainer;
    @FXML
    private Button formContainer;




    @FXML
    void handleAddFIRBtn(ActionEvent event) {
        AddFIRContainer.setVisible(true);
        SearchFIRContainer.setVisible(false);
        aboutContainer.setVisible(false);
    }

    @FXML
    void handleSearchFIRBtn(ActionEvent event) {
        SearchFIRContainer.setVisible(true);
        aboutContainer.setVisible(false);
        AddFIRContainer.setVisible(false);

    }
    @FXML
    void handleAddSubmit(ActionEvent event) {
        if((!FIRIDTF.getText().equals("")) &&
                (!PhoneTF.getText().equals("")) && (!stationNameTF.getText().equals(""))
                && (!subjectTF.getText().equals("")) && (!NameTF.getText().equals("")) &&
                (!CityTF.getText().equals("")) && (!EmailTF.getText().equals("")) && (!DetailsTF.getText().equals(""))
                && ( DateTF.getValue() != null) && (!ACTTF.getText().equals(""))
        ){
            String AllFIRPath = "AllTextFile/AllFIR/AllFIR.txt";
            try {
                FileWriter writer = new FileWriter(AllFIRPath, true);
                String FIRLine = "["+FIRIDTF.getText()+"]["+stationNameTF.getText()+"]["+ subjectTF.getText()+"]["+ACTTF.getText()+"]["+NameTF.getText()+"]["+CityTF.getText()+"]["+PhoneTF.getText()+"][" + EmailTF.getText()+"][" + DateTF.getValue()+"]["+DetailsTF.getText()+"]\n";
                writer.write(FIRLine);
                writer.close();
                System.out.println("Add successfully");
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Success!");
                alert.setContentText("FIR saved successfully.");
                alert.showAndWait();
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
    void handleSearchSubmitBtn(ActionEvent event) {
        String AllFIRPath = "AllTextFile/AllFIR/AllFIR.txt";
        String line;
        String[] data;
        String searchFIR = SearchFIRTF.getText();
        boolean isMatch = false;
        try {
                FileReader fileReader = new FileReader(AllFIRPath);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                while ((line = bufferedReader.readLine()) != null) {
                    data = line.split("\\]\\[");
                    String firId = data[0].substring(1).trim();
                    if(firId.equals(searchFIR)){
                        formContainer.setVisible(true);
                        String stationName = data[1].trim();
                        String subject = data[2].trim();
                        String act = data[3].trim();
                        String name = data[4].trim();
                        String city = data[5].trim();
                        String phone = data[6].trim();
                        String email = data[7].substring(0, data[7].length() - 1).trim();
                        String date = data[8].trim();
                        String details = data[9].substring(0, data[9].length() - 1).trim();

                        FIRIDTF1.setText(firId);
                        StationNameTF1.setText(stationName);
                        SubjectTF1.setText(subject);
                        ACTTF1.setText(act);
                        NameTF1.setText(name);
                        CityTF1.setText(city);
                        PhoneTF1.setText(phone);
                        EmailTF1.setText(email);
                        DateTF1.setText(date);
                        DetailsTF1.setText(details);
                        isMatch = true;
                        break;
                    }else{

                        FIRIDTF1.setText("");
                        StationNameTF1.setText("");
                        SubjectTF1.setText("");
                        ACTTF1.setText("");
                        NameTF1.setText("");
                        CityTF1.setText("");
                        PhoneTF1.setText("");
                        EmailTF1.setText("");
                        DateTF1.setText("");
                        DetailsTF1.setText("");
                    }
                }
                if(!isMatch){
                    SearchFIRTF.setText("");
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Missing!");
                    alert.setContentText("FIR not found!");
                    alert.showAndWait();
                }

                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

}

