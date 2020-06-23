package Inventory_System.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

//class
public class Inventory {

    //attributes
    // - allParts:ObservableList<Part>
    public static ObservableList<Part> allPartsList = FXCollections.observableArrayList(
            new Part(1,"Monitor",30.00, 34, 1, 10),
            new Part(2,"Keyboard",10.00, 38, 1, 30),
            new Part(3,"Speaker",23.00, 78, 1, 50),
            new Part(4,"Mouse",12.00, 12, 1, 70)
    );

    // - allProducts:ObservableList<Product>
    public static ObservableList<Product> allProductsList = FXCollections.observableArrayList(
            new Product(1,"Gaming Desktop System",1200.00, 34, 1, 5),
            new Product(2,"Home Desktop System",800.00, 24, 1, 3),
            new Product(3,"Enterprise Desktop System",1200.00, 34, 1, 5),
            new Product(4,"Designer Desktop System",1600.00, 64, 1, 10)
    );

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

    public static ObservableList<Part> getAllParts(){
        return allPartsList;
    }

    public static ObservableList<Product> getAllProducts(){ return allProductsList; }

}



