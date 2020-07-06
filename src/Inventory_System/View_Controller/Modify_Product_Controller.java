package Inventory_System.View_Controller;

import Inventory_System.Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

import static Inventory_System.Model.Inventory.allProductsList;

public class Modify_Product_Controller implements Initializable {

    //attributes
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
    private TableView<Part> productPartsTableView2;
    @FXML
    private TableColumn<Part, Integer> productPartIDColumn2;
    @FXML
    private TableColumn<Part, String> productPartNameColumn2;
    @FXML
    private TableColumn<Part, Double> productPriceColumn2;
    @FXML
    private TableColumn<Part, Integer> productInventoryLevelColumn2;

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
    @FXML
    private TextField partsSearchField;

    //buttons
    @FXML
    private Button productCancelButton2;
    @FXML
    private Button productSaveButton2;
    @FXML
    private Button productsPartsDeleteButton;
    @FXML
    private Button addProductsButton2;
    @FXML
    private Button partsSearchFieldButton;

    Product product;

    //Initialize and setup the table with data

    public void initialize(URL location, ResourceBundle resources) {
        //create new instance of Product with default values
        product = new Product(0,"Product Name Here",0.00,0,0,0);

        //sets the columns parts
        productPartIDColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("id"));
        productPartNameColumn.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
        productPriceColumn.setCellValueFactory(new PropertyValueFactory<Part, Double>("price"));
        productInventoryLevelColumn.setCellValueFactory(new PropertyValueFactory<Part, Integer>("stock"));

        //set the items on the table from the observable list for parts
        productPartsTableView.setItems(Inventory.getAllParts());

        //sets the columns parts
        productPartIDColumn2.setCellValueFactory(new PropertyValueFactory<Part, Integer>("id"));
        productPartNameColumn2.setCellValueFactory(new PropertyValueFactory<Part, String>("name"));
        productPriceColumn2.setCellValueFactory(new PropertyValueFactory<Part, Double>("price"));
        productInventoryLevelColumn2.setCellValueFactory(new PropertyValueFactory<Part, Integer>("stock"));

        //set the items on the table from the observable list for parts
        productPartsTableView2.setItems(product.getAllAssociatedParts());
        //productPartsTableView2.setItems(productPartsTableView2.getSelectionModel().getSelectedItem().getAssociatedParts());
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

    //delete products handler
    @FXML
    private void productsPartsDeleteButtonHandler(ActionEvent event){
        // Select the product
        Part deleteSelectedAssociatedPart = productPartsTableView2.getSelectionModel().getSelectedItem();
        //Delete the part
        this.product.deleteAssociatedPart(deleteSelectedAssociatedPart);
    }

    //main search functionality
    public void getResultsHandlerParts(ActionEvent actionEvent) {
        //get text user has entered in textfield
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

    @FXML
    private void addAssociatedPartHandler2(ActionEvent event)    {
        //Get the selected item for the associated part
        Part selectedItem = productPartsTableView.getSelectionModel().getSelectedItem();
        //Add the part to the part associated array for this instance
        this.product.addAssociatedPart(selectedItem);
    }
}
