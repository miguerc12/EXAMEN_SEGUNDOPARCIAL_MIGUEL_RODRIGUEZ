package rodriguez.miguel.pizzeria;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;




    public class DrinkMenuActivity extends AppCompatActivity {

        private TextView totalPriceTextView;
        private Button deleteSelectionButton;
        private List<String> selectedDrinks = new ArrayList<>();
        private int total = 0;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_drink_menu);

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
                    total += 40;
                    selectedDrinks.add("Refresco Sabor ($40)");
                    updateTotalPrice();
                }
            });

            drinkOption2Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    total += 60;
                    selectedDrinks.add("Refresco pepsi ($60)");
                    updateTotalPrice();
                }
            });

            drinkOption3Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    total += 80;
                    selectedDrinks.add("Refresco coca cola ($80)");
                    updateTotalPrice();
                }
            });

            deleteSelectionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    total = 0;
                    selectedDrinks.clear();
                    updateTotalPrice();
                }
            });

            payButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(DrinkMenuActivity.this, TotalActivity.class);
                    intent.putStringArrayListExtra("selectedDrinks", (ArrayList<String>) selectedDrinks);
                    intent.putExtra("totalDrinks", total);
                    startActivity(intent);
                }
            });




            backButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(DrinkMenuActivity.this, ActivityChoose.class);
                    startActivity(intent);
                }
            });
        }

        private void updateTotalPrice() {
            totalPriceTextView.setText("Total: $" + total);
        }
    }