package rodriguez.miguel.pizzeria;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;

import java.util.List;




    public class TotalActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_total);

            TextView totalTextView = findViewById(R.id.total_textview);
            TextView selectedDrinksTextView = findViewById(R.id.selected_drinks_textview);
            TextView selectedPizzasTextView = findViewById(R.id.selected_pizzas_textview);

            Intent intent = getIntent();
            List<String> selectedDrinks = intent.getStringArrayListExtra("selectedDrinks");
            int totalDrinks = intent.getIntExtra("totalDrinks", 0);

            List<String> selectedPizzas = intent.getStringArrayListExtra("selectedPizzas");
            int totalPizzas = intent.getIntExtra("totalPizzas", 0);

            StringBuilder selectedDrinksText = new StringBuilder();
            for (String drink : selectedDrinks) {
                selectedDrinksText.append(drink).append("\n");
            }

            StringBuilder selectedPizzasText = new StringBuilder();
            for (String pizza : selectedPizzas) {
                selectedPizzasText.append(pizza).append("\n");
            }

            totalTextView.setText("Total a pagar: $" + (totalDrinks + totalPizzas));
            selectedDrinksTextView.setText(selectedDrinksText.toString());
            selectedPizzasTextView.setText(selectedPizzasText.toString());
        }
    }

