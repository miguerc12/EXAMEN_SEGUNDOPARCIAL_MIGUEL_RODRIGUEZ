package rodriguez.miguel.pizzeria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PizzaMenuActivity extends AppCompatActivity {
    private TextView textViewTotal;
    private int total;
    private StringBuilder orderSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_menu);

        textViewTotal = findViewById(R.id.textViewTotal);
        Button buttonPagar = findViewById(R.id.buttonPagar);
        Button buttonPizza1 = findViewById(R.id.buttonPizza1);
        Button buttonPizza2 = findViewById(R.id.buttonPizza2);
        Button buttonPizza3 = findViewById(R.id.buttonPizza3);

        orderSummary = new StringBuilder();

        buttonPizza1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total += 300;
                updateOrderSummary("Pizza Peperoni", 300);
                updateTotal();
            }
        });

        buttonPizza2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total += 400;
                updateOrderSummary("Pizza Hawaiana", 400);
                updateTotal();
            }
        });

        buttonPizza3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total += 500;
                updateOrderSummary("Pizza Mexicana", 500);
                updateTotal();
            }
        });

        buttonPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PizzaMenuActivity.this, totalpizzas.class);
                intent.putExtra("total", total);
                intent.putExtra("order_summary", orderSummary.toString());
                startActivity(intent);
            }
        });

    }

    private void updateTotal() {
        textViewTotal.setText("Total: $" + total);
    }

    private void updateOrderSummary(String pizzaName, int price) {
        if (orderSummary.length() > 0) {
            orderSummary.append("\n");
        }
        orderSummary.append(pizzaName).append(": $").append(price);
    }

}