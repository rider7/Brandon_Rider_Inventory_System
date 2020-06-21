package Inventory_System.Model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

//class
public class Part {
    //attributes
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty name;
    private final SimpleDoubleProperty price;
    private final SimpleIntegerProperty stock;
    private final SimpleIntegerProperty min;
    private final SimpleIntegerProperty max;

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
}
