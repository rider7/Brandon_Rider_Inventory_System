package Inventory_System.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
//class
public class InhousePart extends Part{
    //attributes
    private int machineId;

    public InhousePart(int id, String name, double price, int stock, int min, int max) {
        super(id, name, price, stock, min, max);
    }

    //methods
    public void setMachineId(){

    }

    public int getMachineId() {
        return machineId;
    }
}





