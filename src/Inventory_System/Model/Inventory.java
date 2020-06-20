package Inventory_System.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

//class
public class Inventory {

    //attributes
    // - allParts:ObservableList<Part>
    //ListView<Part> partListView = new ListView<Part>();
    private static ObservableList<Part> allParts = FXCollections.observableArrayList();

    // - allProducts:ObservableList<Product>
    //ListView<Product> productListView = new ListView<Product>();
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();

    //methods
    public void addPart(Part newPart){

    }

    public void addProduct(Product newProduct){

    }

//    public Part lookupPart(int partId){
//        return
//    }

//    public Product lookupProduct(int productId){
//        return
//    }

//    public ObservableList<Part> lookupPart(String partName){
//        return
//    }

//    public ObservableList<Product> lookupProduct(String productName){
//        return
//    }

    public void updatePart(int index, Part selectedPart){

    }

    public void updateProduct(int index, Product newProduct){

    }

//    public boolean deletePart(Part selectedPart){
//        return;
//    }

//    public boolean deleteProduct(Product selectedProduct){
//        return;
//    }

//    public ObservableList<Part> getAllParts(){
//        return;
//    }

//    public ObservableList<Product> getAllProducts(){
//        return;
//    }

}



