package Inventory_System.View_Controller;

import java.net.URL;
import java.sql.SQLOutput;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import Inventory_System.Model.Inventory;
import Inventory_System.Model.Product;
import Inventory_System.Model.Part;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Inventory_System.Inventory_System;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.cell.PropertyValueFactory;

import static Inventory_System.Model.Inventory.allPartsList;

public class Main_Screen_Controller implements Initializable {

    @FXML
    private TableView<Part> partsTableView;

    @FXML
    private TableColumn<Part, Integer> partsIDColumn;

    @FXML
    private TableColumn<Part, String> partsNameColumn;

    @FXML
    private TableColumn<Part, Integer> partsInventoryColumn;

    @FXML
    private TableColumn<Part, Double> partsPriceColumn;

    @FXML
    private Button addPartButton;

    @FXML
    private Button modifyPartButton;

    @FXML
    private Button partDeleteButton;

    @FXML
    private Button partSearchButton;

    @FXML
    private TextField partSearchField;

    @FXML
    private TableView<Product> productsTableView;

    @FXML
    private TableColumn<Product, Integer> productIDColumn;

    @FXML
    private TableColumn<Product, String> productNameColumn;

    @FXML
    private TableColumn<Product, Integer> productInventoryColumn;

    @FXML
    private TableColumn<Product, Double> productPriceColumn;

    @FXML
    private Button addProductButton;

    @FXML
    private Button productDeleteButton;

    @FXML
    private Button modifyProductButton;

    @FXML
    private Button productSearchButton;

    @FXML
    private TextField productSearchField;

    @FXML
    private Button exitButton;

    @FXML
    private void addPartSceneHandler(ActionEvent event) throws IOException {
        //System.out.println("addPartButton Click Worked");
        Parent root = FXMLLoader.load(getClass().
                        getResource(
                                "Add_Part.fxml"));
                Stage stage = (Stage) addPartButton.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
        }

    @FXML
    private void modifyPartSceneHandler(ActionEvent event) throws IOException {
        //System.out.println("modifyPartButton Click Worked");
        Parent root = FXMLLoader.load(getClass().
                getResource(
                        "Modify_Part.fxml"));
        Stage stage = (Stage) modifyPartButton.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void addProductSceneHandler(ActionEvent event) throws IOException {
        //System.out.println("addProductButton Click Worked");
        Parent root = FXMLLoader.load(getClass().
                getResource(
                        "Add_Product.fxml"));
        Stage stage = (Stage) addProductButton.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void modifyProductSceneHandler(ActionEvent event) throws IOException {
        //System.out.println("modifyProductButton Click Worked");
        Parent root = FXMLLoader.load(getClass().
                getResource(
                        "Modify_Product.fxml"));
        Stage stage = (Stage) modifyProductButton.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //sets the columns
        partsIDColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("id"));
        partsNameColumn.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
        partsPriceColumn.setCellValueFactory(new PropertyValueFactory<Part, Double>("price"));
        partsInventoryColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("stock"));


        //set the items on the table from the observable list
        partsTableView.setItems(allPartsList);
    }

}
