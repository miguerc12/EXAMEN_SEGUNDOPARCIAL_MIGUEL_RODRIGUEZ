package rodriguez.miguel.pizzeria;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import android.view.View;
import android.widget.Button;
import android.os.Bundle;

public class ActivityChoose extends AppCompatActivity {
    Button pizzaButton;
    Button drinkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        pizzaButton = findViewById(R.id.btnChoosePizza);
        drinkButton = findViewById(R.id.btnChooseSoda);


        String username = getIntent().getStringExtra("USERNAME");


        TextView textViewWelcomeMessage = findViewById(R.id.textViewWelcomeMessage);
        textViewWelcomeMessage.setText("Bienvenido, usuario: " + username);

        Button showCombinedTotalButton = findViewById(R.id.btnShowCombinedTotal);
        showCombinedTotalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityChoose.this, TOTAL_TODO2.class);
                startActivity(intent);
            }
        });

        pizzaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityChoose.this, PizzaMenuActivity.class);
                startActivity(intent);
            }
        });

        drinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityChoose.this, DrinkMenuActivity.class);
                startActivity(intent);
            }
        });
    }
}