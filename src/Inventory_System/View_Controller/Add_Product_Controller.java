package Inventory_System.View_Controller;

import Inventory_System.Model.InHouse;
import Inventory_System.Model.Inventory;
import Inventory_System.Model.Part;
import Inventory_System.Model.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Add_Product_Controller implements Initializable {

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
    private TextField partsSearchField;
    @FXML
    private Button productSaveButton;
    @FXML
    private Button partsSearchFieldButton;

    //table 1
    @FXML
    private TableView<Part> productPartsTableView;
    @FXML
    private TableColumn<Part, Integer> productPartIDColumn;
    @FXML
    private TableColumn<Part, String> productPartNameColumn;
    @FXML
    private TableColumn<Part, Double> productPriceColumn;
    @FXML
    private TableColumn<Part, Integer> productInventoryLevelColumn;

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

    //methods
    public void initialize(URL location, ResourceBundle resources) {
        //sets the columns parts
        productPartIDColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("id"));
        productPartNameColumn.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
        productPriceColumn.setCellValueFactory(new PropertyValueFactory<Part, Double>("price"));
        productInventoryLevelColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("stock"));

        //set the items on the table from the observable list for parts
        productPartsTableView.setItems(Inventory.getAllParts());

//        //sets the columns parts
//        productPartIDColumn2.setCellValueFactory(new PropertyValueFactory<Product, Integer>("id"));
//        productPartNameColumn2.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
//        productPriceColumn2.setCellValueFactory(new PropertyValueFactory<Product, Double>("price"));
//        productInventoryLevelColumn2.setCellValueFactory(new PropertyValueFactory<Product, Integer>("stock"));
//
//        //set the items on the table from the observable list for parts
//        productPartsTableView2.setItems(Inventory.allProductsList);
    }
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

    //main search functionality
    public void getResultsHandlerParts(ActionEvent actionEvent) {
        //get text user has entered in textfield
        // System.out.println("Search button event worked!");
        String searchStringParts = partsSearchField.getText();

        //create new observable list and set it to the output of searchByPart method after passing in searchStringParts through loops
        ObservableList<Part> filteredPartsList = searchByPartName(searchStringParts);

        //If search does not return part name then look for part id
        if(filteredPartsList.size()==0){
            try {
                int id = Integer.parseInt(searchStringParts);
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
        productPartsTableView.setItems(filteredPartsList);

    }
    //search by part name
    private ObservableList<Part> searchByPartName(String partialPart){
        //System.out.println("Search method ran!");
        //ObservableList to return with filtered Parts
        ObservableList<Part> allPartsTempList = FXCollections.observableArrayList();

        //List from Inventory to walk through finding filtered Parts
        ObservableList<Part> allPartsList = Part.getAllParts();

        //Enhanced loop through allPartsList using temporary variable searchPart
        for(Part searchPart : allPartsList){
            if(searchPart.getName().toLowerCase().contains(partialPart)){
                allPartsTempList.add(searchPart);
                //System.out.println("If statement worked!");
            }
        }

        return allPartsTempList;
    }
    //search by part ID
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
