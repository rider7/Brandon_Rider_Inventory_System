package Inventory_System.Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

//class
public class Product {
    //attributes
    //- associatedParts:ObservableList<Part>
    private static ObservableList<Part> associatedParts = FXCollections.observableArrayList();

    private int id;
    private String name;
    private double price;
    private int stock;
    private int min;
    private int max;

    //methods
    public Product(int id, String name, double price, int stock, int min, int max){

    }

    public void setId(int id){

    }

    public void setName(String name){

    }

    public void setPrice(double price){

    }

    public void setStock(int stock){

    }

    public void setMin(int min){

    }

    public void setMax(int max){

    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public int getStock(){
        return stock;
    }

    public int getMin(){
        return min;
    }

    public int getMax(){
        return max;
    }

    public void addAssociatedPart(Part part){

    }

//    public boolean deleteAssociatedPart(Part selectedAssociatedPart){
//
//    }
        //+ getAllAssociatedParts():ObservableList<Part>

}