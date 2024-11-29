package com.donkillha;
import javax.swing.JOptionPane;

/**
 * Hello world!
 *
 */
public class App {

  
    public static void main(String[] args) {
        Helpers helpers = new Helpers("eur");

        Object[] currencies=helpers.getCurrencies();
        String currencyToConverTo = (String) JOptionPane.showInputDialog(
            null, 
            "Choose a currency to convert to:", 
            "Select Dialog", 
            JOptionPane.QUESTION_MESSAGE, 
            null, 
            currencies, 
            currencies[0] 
        );

        float conversionRate=helpers.getConversion(currencyToConverTo);
        JOptionPane.showMessageDialog(null,"1 "+ "eur" +" is: "+ conversionRate+" "+currencyToConverTo);
        

    }
}
