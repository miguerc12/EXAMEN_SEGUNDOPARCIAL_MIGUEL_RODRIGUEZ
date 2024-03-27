package rodriguez.miguel.pizzeria;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class totalpizzas extends AppCompatActivity {


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




        Button backButton = findViewById(R.id.salir_boton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(totalpizzas.this, ActivityChoose.class);
                startActivity(intent);
            }
        });
    }
}