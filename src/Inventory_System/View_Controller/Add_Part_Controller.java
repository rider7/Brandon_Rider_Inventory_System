package Inventory_System.View_Controller;

import Inventory_System.Model.Inventory;
import Inventory_System.Model.Outsourced;
import Inventory_System.Model.Part;
import Inventory_System.Model.InHouse;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static Inventory_System.Model.Inventory.allPartsList;

public class Add_Part_Controller implements Initializable {

    @FXML
    private RadioButton partInHouseOption;
    @FXML
    private RadioButton partOutsourceOption;
    @FXML
    private ToggleGroup partSourceOptions;
    @FXML
    private TextField partAddName;
    @FXML
    private TextField partAddInventory;
    @FXML
    private TextField partAddPrice;
    @FXML
    private TextField partAddID;
    @FXML
    private TextField partAddMachineID;
    @FXML
    private TextField partAddMax;
    @FXML
    private TextField partAddMin;
    @FXML
    private Label machineIDLabel;
    @FXML
    private Button partCancelButton;
    @FXML
    private Button partSaveButton;
    Part part;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        partInHouseOption.setSelected(true);
    }

    @FXML
    private void partBackButtonHandler(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) partCancelButton.getScene().getWindow();
        //load up OTHER FXML document
        FXMLLoader loader = new FXMLLoader();
        root = loader.load(getClass().getResource("Main_Screen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setPart(Part part) {
        this.part = part;

        //partsIDColumn.setText(new Integer(part.getId()).toString());
        partAddName.setText(part.getName());
    }

    @FXML
    private void partInHouseOptionHandler(ActionEvent event) {
        partOutsourceOption.setSelected(false);
        partAddMachineID.clear();
        //System.out.println("InHouseOptionHandler");
        machineIDLabel.setText("Machine ID");
        partAddMachineID.setPromptText("Machine ID");

    }

    @FXML
    private void partOutsourceOptionHandler(ActionEvent event) {
        partInHouseOption.setSelected(false);
        partAddMachineID.clear();
        //System.out.println("OutsourcedOptionHandler");
        machineIDLabel.setText("Company Name");
        partAddMachineID.setPromptText("Company Name");
    }

    @FXML
    private void partSaveButtonHandler (ActionEvent event) throws IOException {
        // Grabs the last part ID used from the static variable partGlobalID and increments it by 1
        int incrementedPartID = Inventory.getPartGlobalID() + 1;
        //System.out.println(incrementedPartID);

        // Setting incremented partGlobalID
        Inventory.setPartGlobalID(incrementedPartID);

        String partName = partAddName.getText();
        int partStock = Integer.parseInt(partAddInventory.getText());
        double partPrice = Double.parseDouble(partAddPrice.getText());
        int partMax = Integer.parseInt(partAddMax.getText());
        int partMin = Integer.parseInt(partAddMin.getText());
        //used for Company Name and Machine ID
        String partCompanyName = partAddMachineID.getText();

        // Gathers which radio button was selected at the time of save
        Toggle optionSelected = partSourceOptions.getSelectedToggle();

        // In House radio button selected
        if (optionSelected == partInHouseOption) {
            //parse companyName String to partMachineID int
            int partMachineID = Integer.parseInt(partCompanyName);
            System.out.println("InHouse");
            InHouse partNew = new InHouse(incrementedPartID, partName, partPrice, partStock, partMin, partMax, partMachineID);
            Inventory.addPart(partNew);

        } else {
            System.out.println("Outsourced");
            Outsourced partNew = new Outsourced(incrementedPartID, partName, partPrice, partStock, partMin, partMax, partCompanyName);
            Inventory.addPart(partNew);

//        }

        }
        Stage stage;
        Parent root;
        stage = (Stage) partSaveButton.getScene().getWindow();
        //load up OTHER FXML document
        FXMLLoader loader = new FXMLLoader();
        root = loader.load(getClass().getResource("Main_Screen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
}
