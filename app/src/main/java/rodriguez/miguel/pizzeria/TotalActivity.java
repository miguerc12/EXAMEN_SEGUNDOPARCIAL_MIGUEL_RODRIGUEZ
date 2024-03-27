package rodriguez.miguel.pizzeria;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Button;
import java.util.List;




    public class TotalActivity extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_total);

            TextView totalTextView = findViewById(R.id.total_textview);
            TextView selectedDrinksTextView = findViewById(R.id.selected_drinks_textview);

            Intent intent = getIntent();
            List<String> selectedDrinks = intent.getStringArrayListExtra("selectedDrinks");
            int totalDrinks = intent.getIntExtra("totalDrinks", 0);

            StringBuilder selectedDrinksText = new StringBuilder();
            for (String drink : selectedDrinks) {
                selectedDrinksText.append(drink).append("\n");
            }

            totalTextView.setText("Total a pagar por bebidas: $" + totalDrinks);
            selectedDrinksTextView.setText(selectedDrinksText.toString());


            Button backButton = findViewById(R.id.back_button);

            backButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(TotalActivity.this, ActivityChoose.class);
                    startActivity(intent);
                }
            });
        }
    }

