package Inventory_System.View_Controller;

import Inventory_System.Model.InHouse;
import Inventory_System.Model.Inventory;
import Inventory_System.Model.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.stage.Stage;

import java.io.IOException;

public class Add_Product_Controller {

    //attributes
    @FXML
    private Button productCancelButton;
    @FXML
    private TextField productAddName;
    @FXML
    private TextField productAddInventory;
    @FXML
    private TextField productAddPrice;
    @FXML
    private TextField productAddMax;
    @FXML
    private TextField productAddMin;
    @FXML
    private Button productSaveButton;

    //methods
    @FXML
    private void productBackButtonHandler(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        stage=(Stage) productCancelButton.getScene().getWindow();
        //load up OTHER FXML document
        FXMLLoader loader=new FXMLLoader();
        root = loader.load(getClass().getResource("Main_Screen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void productSaveButtonHandler(ActionEvent event) throws IOException{
        // Grabs the last product ID used from the static variable productGlobalID and increments it by 1
        int incrementedProductID = Inventory.getProductGlobalID() + 1;

        // Setting incremented productGlobalID
        Inventory.setProductGlobalID(incrementedProductID);

        //Setting local variables to data in text fields based on FXML IDs
        String productName = productAddName.getText();
        int productStock = Integer.parseInt(productAddInventory.getText());
        double productPrice = Double.parseDouble(productAddPrice.getText());
        int productMax = Integer.parseInt(productAddMax.getText());
        int productMin = Integer.parseInt(productAddMin.getText());

        //Create new instance of the Product object based on data above
        Product productNew = new Product(incrementedProductID, productName, productPrice, productStock, productMin, productMax);
        Inventory.addProduct(productNew);

        Stage stage;
        Parent root;
        stage = (Stage) productSaveButton.getScene().getWindow();
        //load up OTHER FXML document
        FXMLLoader loader = new FXMLLoader();
        root = loader.load(getClass().getResource("Main_Screen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        }




}
