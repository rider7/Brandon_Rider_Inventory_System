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
    private Button partCancelButton;
    Part part;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void partSaveButtonHandler(ActionEvent event) {
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
        String partCompany = partAddMachineID.getText();

        // Gathers which radio button was selected at the time of save
        Toggle optionSelected = partSourceOptions.getSelectedToggle();

        // In House radio button selected
        if (optionSelected == partInHouseOption) {
            InHouse partNew = new InHouse(incrementedPartID, partName, partPrice, partStock, partMin, partMax);
            Inventory.addPart(partNew);
//            int partOptionSelected = Integer.parseInt(partAddMachineID.getText());
//            InHouse partNew = new InHouse();
//            partNew.setPartID(partID);
//            partNew.setName(partName);
//            partNew.setPrice(partPrice);
//            partNew.setInStock(partInventory);
//            partNew.setMin(partMin);
//            partNew.setMax(partMax);
//            partNew.setPartMachineID(partOptionSelected);
//            Inventory.addPart(partNew);
        } else {
            InHouse partNew = new InHouse(incrementedPartID, partName, partPrice, partStock, partMin, partMax);
            Inventory.addPart(partNew);
//            System.out.println(allPartsList);
//        }

        }


        // Outsourced radio button selected
//        else {
//            Outsourced partNew = new Outsourced();
//            partNew.setPartID(partID);
//            partNew.setName(partName);
//            partNew.setPrice(partPrice);
//            partNew.setInStock(partInventory);
//            partNew.setMin(partMin);
//            partNew.setMax(partMax);
//            partNew.setCompanyName(altFieldText);
//            Inventory.addPart(partNew);
//        }
//


    }
}
