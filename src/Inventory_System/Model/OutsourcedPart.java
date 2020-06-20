package Inventory_System.Model;

//class
public class OutsourcedPart extends Part{
    //attributes
    private String companyName;

    public OutsourcedPart(int id, String name, double price, int stock, int min, int max) {
        super(id, name, price, stock, min, max);
    }

    //methods
    public void Outsourced(int id, String name, double price, int stock, int min, int max, String companyName){

    }

    public void setCompanyName(String companyName){

    }

    public String getCompanyName(){
    return companyName;
    }

}
