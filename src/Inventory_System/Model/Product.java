package Inventory_System.Model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static Inventory_System.Model.Inventory.allProductsList;

//class
public class Product {
    /**************************************ATTRIBUTES*******************************************/

    private ObservableList<Part> associatedParts = FXCollections.observableArrayList();


    private final SimpleIntegerProperty id;
    private final SimpleStringProperty name;
    private final SimpleDoubleProperty price;
    private final SimpleIntegerProperty stock;
    private final SimpleIntegerProperty min;
    private final SimpleIntegerProperty max;

    /**********************************METHODS*************************************/

    public Product(int id, String name, double price, int stock, int min, int max) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleDoubleProperty(price);
        this.stock = new SimpleIntegerProperty(stock);
        this.min = new SimpleIntegerProperty(min);
        this.max = new SimpleIntegerProperty(max);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {this.name.set(name);

    }

    public double getPrice() {
        return price.get();
    }

    public void setPrice(double price) {this.price.set(price);

    }

    public int getStock() {
        return stock.get();
    }

    public void setStock(int stock) {this.stock.set(stock);

    }

    public int getMin() {
        return min.get();
    }

    public void setMin(int min) {this.min.set(min);

    }

    public int getMax() {
        return max.get();
    }

    public void setMax(int max) {this.max.set(max);

    }

    public ObservableList<Part> getAssociatedParts(){
        return this.associatedParts;
    }

    public void addAssociatedPart(Part associatedPart){
        this.associatedParts.add(associatedPart);
    }

    public void addAssociatedParts(ObservableList<Part> associatedParts){
        this.associatedParts.setAll(associatedParts);
    }

    public static ObservableList<Product> getAllProducts(){
        return allProductsList;
    }

    public boolean deleteAssociatedPart(Part part){
        this.associatedParts.remove(part);
        return true;

    }
    public ObservableList getAllAssociatedParts() {return this.associatedParts;}

    public int checkForErrors(){
        int errorNumber;
        if(this.getMin() >= this.getMax()){
            errorNumber = 1;

        } else{
            errorNumber = 0;
        }
        return errorNumber;

    }

    public void updateAssociatedList(Part associatedPart){
        System.out.println("update Product method");
        associatedParts.set(associatedPart.getId()-1, associatedPart);
    }

}