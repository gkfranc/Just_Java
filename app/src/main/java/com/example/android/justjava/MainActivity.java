package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;


public class MainActivity extends ActionBarActivity {
    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    /**This method is called when the order button is clicked**/


    /**
     * This method increases the value of the number of coffees when the + button is clicked
     **/
    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);

    }

    /**
     * This method decreases the value of the number of coffees when the - button is clicked
     **/
    public void decrement(View view) {
        quantity = quantity - 1;
        display(quantity);

    }


    /**
     * This method displays the given quantity value on the screen
     **/
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);

    }

    /**
     * This method displays the given quantity value on the screen
     **/
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.create_order_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));


    }

    /**
     * This method calculates the price
     **/


    public void submitOrder(View view) {

        CheckBox whippedCreamCheckbox = (CheckBox) findViewById(R.id.hasWhippedCream);
        boolean whippedCream = whippedCreamCheckbox.isChecked();

        CheckBox chocolateCheckbox = (CheckBox) findViewById(R.id.Chocolate);
        boolean chocolateTopping = chocolateCheckbox.isChecked();

        EditText editname = (EditText) findViewById(R.id.name);
        String message = editname.getText().toString();

        int price = calculatePrice(whippedCream,chocolateTopping);
        displayMessage(createOrderSummary(price, whippedCream,message,chocolateTopping));


    }

    /**]
     * Calculates the price of the order
     *
     * @return total price
     * **/

    /**
     * This method displays the given the given text on the screen
     **/

    private int calculatePrice(boolean whippedCream,boolean chocolateTopping) {
        int basePrice = 5;

        if (whippedCream){
            basePrice=basePrice + 1;


        }

        if (chocolateTopping){
            basePrice=basePrice + 2;


        }

        int price = quantity * basePrice;
        return price;

    }

    /**
     * Creates a summary or the order
     *
     * @returns the priceMessage
     */
    private String createOrderSummary(int price, boolean cream,String yourname, boolean choco) {
        String priceMessage = yourname;
        priceMessage = priceMessage +  "\nHas WhippedCream: " + cream;
        priceMessage = priceMessage +  "\nHas Chocolate: " + choco;
        priceMessage = priceMessage + "\nQuantity: " + quantity;
        priceMessage = priceMessage + "\nTotal : Ksh " + price;
        priceMessage = priceMessage + "\nThank You!!";
        return priceMessage;


    }


    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.create_order_text_view);
        priceTextView.setText(message);


    }


}