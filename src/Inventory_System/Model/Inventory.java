package Inventory_System.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

//class
public class Inventory {

    //attributes
    // - allParts:ObservableList<Part>
    public static ObservableList<Part> allPartsList = FXCollections.observableArrayList(
            new Part(1,"monitor",30.00, 34, 1, 10),
            new Part(2,"keyboard",10.00, 38, 1, 30),
            new Part(3,"speaker",23.00, 78, 1, 50),
            new Part(4,"mouse",12.00, 12, 1, 70)
    );

    // - allProducts:ObservableList<Product>
    private static ObservableList<Product> allProductsList = FXCollections.observableArrayList();

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



