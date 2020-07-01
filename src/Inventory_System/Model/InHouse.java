package Inventory_System.Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

//class
public class InHouse extends Part{
    //attributes
    private final SimpleIntegerProperty partMachineID;

    //methods
    public InHouse(int id, String name, double price, int stock, int min, int max, int machineID) {
        super(id, name, price, stock, min, max);

        partMachineID = new SimpleIntegerProperty();
    }

    //Setter
    public void setPartMachineID(int partMachineID){
    this.partMachineID.set(partMachineID);
    }

    //Getter
    public int getPartMachineID() {
        return this.partMachineID.get();
    }
}





