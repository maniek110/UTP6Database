/**
 *
 *  @author Suchora Marcin S18807
 *
 */

package zad1;


import java.beans.*;

public class Purchase {
    private String prod;
    private String data;
    private double price;

    private PropertyChangeSupport propertyChangeSupport=new PropertyChangeSupport(this);
    private VetoableChangeSupport vetoableChangeSupport=new VetoableChangeSupport(this);

    public Purchase(String s1,String s2, double val){
        prod=s1;
        data=s2;
        price=val;
    }

    public String getData() {
        return data;
    }

    public void setData(String data){
        propertyChangeSupport.firePropertyChange("data",this.data,data);
        this.data = data;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) throws PropertyVetoException {
        vetoableChangeSupport.fireVetoableChange("price",this.price,price);
        propertyChangeSupport.firePropertyChange("price",this.price,price);
        this.price = price;
    }

    public void setPropertyChangeSupport(PropertyChangeListener property) {
        this.propertyChangeSupport.addPropertyChangeListener(property);
    }

    public void setVetoableChangeSupport(VetoableChangeListener vetoable) {
        this.vetoableChangeSupport.addVetoableChangeListener(vetoable);
    }

    @Override
    public String toString() {
        return "Purchase [prod="+this.prod+", data="+this.data+", price="+this.price+"]";
    }
}
