package rodriguez.miguel.pizzeria;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Button;
import java.util.List;
import android.content.SharedPreferences;
import android.content.Context;



    public class TotalActivity extends AppCompatActivity {
        private static final String username = "Miguel";
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


            SharedPreferences sharedPreferences = getSharedPreferences("Totales", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("totalRefrescos", totalDrinks);
            editor.apply();


            Button backButton = findViewById(R.id.back_button);
            backButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(TotalActivity.this, ActivityChoose.class);
                    intent.putExtra("USERNAME", username);
                    startActivity(intent);
                }
            });


            Button goToOtherActivityButton = findViewById(R.id.btnIrOtraActividad);
            goToOtherActivityButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(TotalActivity.this, TOTAL_TODO2.class); // Reemplaza OtraActividad por el nombre de tu otra actividad
                    startActivity(intent);
                }
            });
        }
    }

