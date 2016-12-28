/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 */
package com.example.android.justjava;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        //display(2);
        int price = quantity*5;
        CheckBox WhippedCreamCheckBox = (CheckBox) findViewById(R.id.checkbox_view);
        CheckBox ChocalteToppingdCheckbox =(CheckBox) findViewById(R.id.checkboxviewChocalate);

        boolean has = WhippedCreamCheckBox.isChecked();
        boolean has2 = ChocalteToppingdCheckbox.isChecked();
        EditText name = (EditText) findViewById(R.id.name_edit_field);
       // String nametext = (String) name.getText();

        int totalPrice = getTotalPrice(has,has2);
        createOrederSummary(price,has,has2,name.getText().toString(),totalPrice);


        //String message="Thank You !!\n"+"Your Total: $"+price;
        //displayMessage(message);
    }

    public int getTotalPrice(boolean has,boolean has2)
    {
       int price=0;
        price=quantity*5;
        if(has)
        {

           price=price+1;

        }
         if(has2)
         {
             price+=2;


         }

      return price;
    }


    public void createOrederSummary(int price,boolean has,boolean has2, String name,int total)
    {
        String message="Thank You!!:"+name+"\n"+"hasWhippedCream?:"+has+"\n hasChcocalteToppings:"+has2+"\nYour Total Price :$"+total;
        TextView text = (TextView) findViewById(R.id.price_text_view);
        text.setText(message);

    }

    public void displayMessage(String message){
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);


    }

    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));

    }

    public void increment(View view){

        quantity+=1;
        display(quantity);


    }

    public void decrement(View view){

        quantity-=1;
        display(quantity);

    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);

    }
}