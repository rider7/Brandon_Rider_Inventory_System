package Inventory_System.View_Controller;

import Inventory_System.Model.InHouse;
import Inventory_System.Model.Part;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Modify_Part_Controller {

    @FXML
    private TextField partModifyName;
    @FXML
    private TextField partModifyStock;
    @FXML
    private TextField partModifyPrice;
    @FXML
    private TextField partModifyMax;
    @FXML
    private TextField partModifyMin;
    @FXML
    private TextField partModifyCompany;
    @FXML
    private Button partCancelButton2;

    Part part;
    InHouse inhouse;

    /**
     * Initializes the controller class.
     */

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void partBackButtonHandler2(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        stage=(Stage) partCancelButton2.getScene().getWindow();
        //load up OTHER FXML document
        FXMLLoader loader=new FXMLLoader();
        root = loader.load(getClass().getResource("Main_Screen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void setPart(Part part) {
//        this.part = part;
//
//        partModifyName.setText(part.getName());
//        partModifyStock.setText(new Integer(part.getStock()).toString());
//        partModifyPrice.setText(new Double(part.getPrice()).toString());
//        partModifyMin.setText(new Integer(part.getMin()).toString());
//        partModifyMax.setText(new Integer(part.getMax()).toString());
        //partModifyCompany.setText(new Integer(part.getPartCompanyName().toString());


    }
    public void setInHousePart(InHouse inhouse) {
        this.inhouse = inhouse;

        partModifyName.setText(inhouse.getName());
        partModifyStock.setText(new Integer(inhouse.getStock()).toString());
        partModifyPrice.setText(new Double(inhouse.getPrice()).toString());
        partModifyMin.setText(new Integer(inhouse.getMin()).toString());
        partModifyMax.setText(new Integer(inhouse.getMax()).toString());
        partModifyCompany.setText(String.valueOf(inhouse.getPartMachineID()));


    }
}
