package Inventory_System.View_Controller;

import Inventory_System.Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Modify_Product_Controller implements Initializable {

    //attributes
    //table 1
    @FXML
    private TableView<Product> productPartsTableView;
    @FXML
    private TableColumn<Product, Integer> productPartIDColumn;
    @FXML
    private TableColumn<Product, String> productPartNameColumn;
    @FXML
    private TableColumn<Product, Double> productPriceColumn;
    @FXML
    private TableColumn<Product, Integer> productInventoryLevelColumn;

    //table 2
    @FXML
    private TableView<Product> productPartsTableView2;
    @FXML
    private TableColumn<Product, Integer> productPartIDColumn2;
    @FXML
    private TableColumn<Product, String> productPartNameColumn2;
    @FXML
    private TableColumn<Product, Double> productPriceColumn2;
    @FXML
    private TableColumn<Product, Integer> productInventoryLevelColumn2;

    //text fields
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

    //buttons
    @FXML
    private Button productCancelButton2;
    @FXML
    private Button productSaveButton2;

    Product product;

    //Initialize and setup the table with data

    public void initialize(URL location, ResourceBundle resources) {
        //sets the columns parts
        productPartIDColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));
        productPartNameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        productPriceColumn.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));
        productInventoryLevelColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("stock"));

        //set the items on the table from the observable list for parts
        productPartsTableView.setItems(Inventory.allProductsList);

        //sets the columns parts
        productPartIDColumn2.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));
        productPartNameColumn2.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        productPriceColumn2.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));
        productInventoryLevelColumn2.setCellValueFactory(new PropertyValueFactory<Product, Integer>("stock"));

        //set the items on the table from the observable list for parts
        productPartsTableView2.setItems(Inventory.allProductsList);
    }

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
