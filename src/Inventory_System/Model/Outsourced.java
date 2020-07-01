package Inventory_System.Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

//class
public class Outsourced extends Part{
    //attributes
    private final SimpleStringProperty partCompanyName;

    //methods
    public Outsourced(int id, String name, double price, int stock, int min, int max, String companyName) {
        super(id, name, price, stock, min, max);
        partCompanyName = new SimpleStringProperty();
    }

    //Setter
    public void setPartCompanyName(String partCompanyName){
    this.partCompanyName.set(partCompanyName);
    }

    //Getter
    public String getPartCompanyName(){
    return this.partCompanyName.get();
    }

}


