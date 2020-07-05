package Inventory_System.View_Controller;

import Inventory_System.Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Modify_Product_Controller {

    //attributes
    @FXML
    private TextField productModifyID;
    @FXML
    private TextField productModifyName;
    @FXML
    private TextField productModifyStock;
    @FXML
    private TextField productModifyPrice;
    @FXML
    private TextField productModifyMax;
    @FXML
    private TextField productModifyMin;
    @FXML
    private Button productCancelButton2;
    @FXML
    private Button productSaveButton2;

    Product product;

    public void setProduct(Product product) {
        this.product = product;

        productModifyID.setText(new Integer(product.getId()).toString());
        productModifyName.setText(product.getName());
        productModifyStock.setText(new Integer(product.getStock()).toString());
        productModifyPrice.setText(new Double(product.getPrice()).toString());
        productModifyMin.setText(new Integer(product.getMin()).toString());
        productModifyMax.setText(new Integer(product.getMax()).toString());

    }


    @FXML
    private void productBackButtonHandler2(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        stage=(Stage) productCancelButton2.getScene().getWindow();
        //load up OTHER FXML document
        FXMLLoader loader=new FXMLLoader();
        root = loader.load(getClass().getResource("Main_Screen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void productSaveHandler(ActionEvent event) throws IOException{
        //variables for product parameters
        int productID = Integer.parseInt(productModifyID.getText());
        String productName = productModifyName.getText();
        int productStock = Integer.parseInt(productModifyStock.getText());
        double productPrice = Double.parseDouble(productModifyPrice.getText());
        int productMax = Integer.parseInt(productModifyMax.getText());
        int productMin = Integer.parseInt(productModifyMin.getText());

        // modify product using updateProduct method in Inventory
            //System.out.println("modify product save handler");
            Product product = new Product(productID, productName, productPrice, productStock, productMin, productMax);
            Inventory.updateProduct(product);

        Stage stage;
        Parent root;
        stage = (Stage) productSaveButton2.getScene().getWindow();
        //load up OTHER FXML document
        FXMLLoader loader = new FXMLLoader();
        root = loader.load(getClass().getResource("Main_Screen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
