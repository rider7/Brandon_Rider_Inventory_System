package Inventory_System.View_Controller;

import java.net.URL;
import java.sql.SQLOutput;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import static Inventory_System.Model.Inventory.allProductsList;


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
    private Button addPartsButton;

    @FXML
    private Button modifyPartsButton;

    @FXML
    private Button partsDeleteButton;

    @FXML
    private Button partsSearchButton;

    @FXML
    private TextField partsSearchField;

    @FXML
    private TableView<Product> productsTableView;

    @FXML
    private TableColumn<Product, Integer> productsIDColumn;

    @FXML
    private TableColumn<Product, String> productsNameColumn;

    @FXML
    private TableColumn<Product, Integer> productsInventoryColumn;

    @FXML
    private TableColumn<Product, Double> productsPriceColumn;

    @FXML
    private Button addProductsButton;

    @FXML
    private Button productsDeleteButton;

    @FXML
    private Button modifyProductsButton;

    @FXML
    private Button productsSearchButton;

    @FXML
    private TextField productsSearchField;

    @FXML
    private Button exitButton;

    @FXML
    private void addPartSceneHandler(ActionEvent event) throws IOException {
        //System.out.println("addPartButton Click Worked");
        Parent root = FXMLLoader.load(getClass().
                getResource(
                        "Add_Part.fxml"));
        Stage stage = (Stage) addPartsButton.getScene().getWindow();
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
        Stage stage = (Stage) modifyPartsButton.getScene().getWindow();
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
        Stage stage = (Stage) addProductsButton.getScene().getWindow();
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
        Stage stage = (Stage) modifyProductsButton.getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //sets the columns parts
        partsIDColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("id"));
        partsNameColumn.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
        partsPriceColumn.setCellValueFactory(new PropertyValueFactory<Part, Double>("price"));
        partsInventoryColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("stock"));

        //set the items on the table from the observable list for parts
        partsTableView.setItems(allPartsList);

        //sets the columns parts
        productsIDColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));
        productsNameColumn.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        productsPriceColumn.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));
        productsInventoryColumn.setCellValueFactory(new PropertyValueFactory<Product, Integer>("stock"));


        //set the items on the table from the observable list for parts
        productsTableView.setItems(allProductsList);
    }

    public void getResultsHandlerParts(ActionEvent actionEvent) {
        //get text user has entered in textfield
       // System.out.println("Search button event worked!");
        String searchString = partsSearchField.getText();

        //create new observable list and set it to the output of searchByPart method after passing in q through loops
        ObservableList<Part> filteredPartsList = searchByPartName(searchString);

        //If search does not return part name then look for part id
        if(filteredPartsList.size()==0){
            try {
                int id = Integer.parseInt(searchString);
                Part searchPart = searchByPartID(id);
                if (searchPart!= null) {
                    filteredPartsList.add(searchPart);
                }
            }
            catch(NumberFormatException e)
                {
                    //ignore
                }

        }
        partsTableView.setItems(filteredPartsList);

    }

    private ObservableList<Part> searchByPartName(String partialPart){
        //System.out.println("Search method ran!");
        //ObservableList to return with filtered Parts
        ObservableList<Part> allPartsTempList =FXCollections.observableArrayList();

        //List from Inventory to walk through finding filtered Parts
        ObservableList<Part> allPartsList = Part.getAllParts();

        //Enhanced loop through allPartsList using temporary variable searchPart
        for(Part searchPart : allPartsList){
            if(searchPart.getName().contains(partialPart)){
                allPartsTempList.add(searchPart);
                //System.out.println("If statement worked!");
            }
        }

        return allPartsTempList;
}

    private Part searchByPartID(int id){
        //List from Inventory to walk through finding filtered Parts
        ObservableList<Part> allPartsList = Part.getAllParts();
        //Loop through list as long as less than the list size
        for(int i=0; i < allPartsList.size(); i++){
            Part searchPart = allPartsList.get(i);
        //if the id is equal than return
            if(searchPart.getId() == id) {
                return searchPart;
            }
        }
        return null;
    }

}
