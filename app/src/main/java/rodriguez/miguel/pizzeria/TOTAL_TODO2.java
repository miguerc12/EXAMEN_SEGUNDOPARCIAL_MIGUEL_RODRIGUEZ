package rodriguez.miguel.pizzeria;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;
import android.view.View;
public class TOTAL_TODO2 extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_todo2);


        SharedPreferences sharedPreferences = getSharedPreferences("Totales", Context.MODE_PRIVATE);
        int totalPizzas = sharedPreferences.getInt("totalPizzas", 0);
        int totalRefrescos = sharedPreferences.getInt("totalRefrescos", 0);


        int totalCompra = totalPizzas + totalRefrescos;


        TextView textViewTotalPizzas = findViewById(R.id.textViewTotalPizzas);
        textViewTotalPizzas.setText("Total de Pizzas: $" + totalPizzas);

        TextView textViewTotalRefrescos = findViewById(R.id.textViewTotalRefrescos);
        textViewTotalRefrescos.setText("Total de Refrescos: $" + totalRefrescos);


        TextView textViewTotalCompra = findViewById(R.id.textViewTotalCompra);

        if (totalCompra == 0) {
            textViewTotalCompra.setText("Por favor selecciona algo en el menú.");
        } else {
            textViewTotalCompra.setText("Esta es su compra total: $" + totalCompra);
        }

        Button botonNuevoPedido = findViewById(R.id.botonNuevoPedido);
        botonNuevoPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.apply();


                Intent intent = new Intent(TOTAL_TODO2.this, ActivityChoose.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);


                finish();
            }
        });


        Button botonPagoExitoso = findViewById(R.id.botonPagoExitoso);
        botonPagoExitoso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView mensajePagoExitoso = findViewById(R.id.mensajePagoExitoso);
                mensajePagoExitoso.setText("PAGADO CON EXITO, ¡GRACIAS POR SU COMPRA!");
            }
        });
    }
}