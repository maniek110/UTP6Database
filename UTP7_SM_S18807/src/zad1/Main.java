/**
 *
 *  @author Suchora Marcin S18807
 *
 */

package zad1;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

public class Main {
  public static void main(String[] args) {

    Purchase purch = new Purchase("komputer", "nie ma promocji", 3000.00);
    System.out.println(purch);

    // --- tu należy dodać odpowiedni kod

    PropertyChangeListener propertyChangeListener=new PropertyChangeListener() {
      @Override
      public void propertyChange(PropertyChangeEvent evt) {
        if(!"prod".equals(evt.getPropertyName()))
        System.out.println("Change value of: "+evt.getPropertyName()+" from: "+evt.getOldValue()+" to:"+evt.getNewValue());
      }
    };
    VetoableChangeListener vetoableChangeListener=new VetoableChangeListener() {
      @Override
      public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
        if("price".equals(evt.getPropertyName())){
          if(Double.parseDouble(evt.getNewValue().toString())>1000){}
          else throw new PropertyVetoException("Price change to: "+evt.getNewValue()+" not allowed",evt);
        }
      }
    };
      purch.setPropertyChangeSupport(propertyChangeListener);
      purch.setVetoableChangeSupport(vetoableChangeListener);
    // ----------------------------------

    try {
      purch.setData("w promocji");
      purch.setPrice(2000.00);
      System.out.println(purch);

      purch.setPrice(500.00);

    } catch (PropertyVetoException exc) {
      System.out.println(exc.getMessage());
    }
    System.out.println(purch);

  }
}
