package Inventory_System.Model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

import static Inventory_System.Model.Inventory.allPartsList;

//class
public class Part {
    //attributes
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleDoubleProperty price;
    private SimpleIntegerProperty stock;
    private SimpleIntegerProperty min;
    private SimpleIntegerProperty max;

    // methods
    //constructor
    public Part(int id, String name, double price, int stock, int min, int max) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleDoubleProperty(price);
        this.stock = new SimpleIntegerProperty(stock);
        this.min = new SimpleIntegerProperty(min);
        this.max = new SimpleIntegerProperty(max);
    }


    public void setId(SimpleIntegerProperty id){
        this.id = id;
    }

    public void setName(SimpleStringProperty name){
        this.name = name;
    }

    public void setPrice(double price){

    }

    public void setStock(int stock){

    }

    public void setMin(int min){

    }

    public void setMax(int max){

    }

    public  int getId(){
        return id.get();
    }

    public String getName(){
        return name.get();
    }

    public double getPrice(){
        return price.get();
    }

    public int getStock(){
        return stock.get();
    }

    public int getMin(){
        return min.get();
    }

    public int getMax(){
        return max.get();
    }

    public static ObservableList<Part> getAllParts(){
        return allPartsList;
    }
}
