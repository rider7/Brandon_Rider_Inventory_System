package Inventory_System.View_Controller;

import Inventory_System.Model.Part;
import Inventory_System.Model.Product;
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
    private Button partCancelButton2;
    @FXML
    private Button productCancelButton2;
    Product product;

    public void setProduct(Product product) {
        this.product = product;

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
}
