package rodriguez.miguel.pizzeria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class PizzaMenuActivity extends AppCompatActivity {

    private TextView totalPriceTextView;
    private Button deleteSelectionButton;
    private List<String> selectedPizzas = new ArrayList<>();
    private int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_menu);

        totalPriceTextView = findViewById(R.id.total_price_textview);
        deleteSelectionButton = findViewById(R.id.delete_selection_button);

        Button drinkOption1Button = findViewById(R.id.drink_option_1);
        Button drinkOption2Button = findViewById(R.id.drink_option_2);
        Button drinkOption3Button = findViewById(R.id.drink_option_3);
        Button payButton = findViewById(R.id.pay_button_drink);
        Button backButton = findViewById(R.id.back_button);

        drinkOption1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total += 300;
                selectedPizzas.add("pizza 1 ($300)");
                updateTotalPrice();
            }
        });

        drinkOption2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total += 500;
                selectedPizzas.add("pizza 2 ($500)");
                updateTotalPrice();
            }
        });

        drinkOption3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total += 450;
                selectedPizzas.add("pizza 3 ($450)");
                updateTotalPrice();
            }
        });

        deleteSelectionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total = 0;
                selectedPizzas.clear();
                updateTotalPrice();
            }
        });

        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Al apretar el botón "Pagar", inicia la actividad TotalActivity"
                Intent intent = new Intent(PizzaMenuActivity.this, TotalActivity.class);
                intent.putStringArrayListExtra("selectedPizzas", (ArrayList<String>) selectedPizzas);
                intent.putExtra("totalPizzas", total); // Cambiado "total" a "totalPizzas"
                startActivity(intent);
            }
        });

       //volver a la pantalla anterior//
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PizzaMenuActivity.this, ActivityChoose.class);
                startActivity(intent);
            }
        });
    }

    private void updateTotalPrice() {
        totalPriceTextView.setText("Total: $" + total);
    }
}