package rodriguez.miguel.pizzeria;

import android.content.SharedPreferences;
import android.content.Context;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class totalpizzas extends AppCompatActivity {
    private static final String username = "Miguel";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_totalpizzas);

        


        String orderSummary = getIntent().getStringExtra("order_summary");
        int total = getIntent().getIntExtra("total", 0);


        TextView textViewOrderSummary = findViewById(R.id.textViewOrderSummary);
        textViewOrderSummary.setText("Pizzas seleccionadas:\n" + orderSummary);

        TextView textViewTotalPago = findViewById(R.id.textViewTotalPago);
        textViewTotalPago.setText("Total: $" + total);


        SharedPreferences sharedPreferences = getSharedPreferences("Totales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("totalPizzas", total);
        editor.apply();


        Button backButton = findViewById(R.id.salir_boton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(totalpizzas.this, ActivityChoose.class);
                intent.putExtra("USERNAME", username);
                startActivity(intent);
            }
        });


        Button goToOtherActivityButton = findViewById(R.id.btnIrOtraActividad);
        goToOtherActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(totalpizzas.this, TOTAL_TODO2.class); // Reemplaza OtraActividad por el nombre de tu otra actividad
                startActivity(intent);
            }
        });
    }
}