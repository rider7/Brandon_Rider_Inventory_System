package Inventory_System.Model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

//class
public abstract class Part {
    //attributes
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleDoubleProperty price;
    private SimpleIntegerProperty stock;
    private SimpleIntegerProperty min;
    private SimpleIntegerProperty max;

    // methods


    public Part(int id, String name, double price, int stock, int min, int max) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
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
}
