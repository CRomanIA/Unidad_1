package com.example.referencias;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Declaración
    private TextView tvMensajeRef;
    private TextView etNombreRef;
    private Button btnAceptarRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Referencia
        tvMensajeRef = findViewById(R.id.tvReferencia);
        etNombreRef = findViewById(R.id.etNombre);
        btnAceptarRef = findViewById(R.id.btnAceptar);

           btnAceptarRef.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("TAG-","click pero en clase anonima");
                    Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                    metodoPrueba();
                }
            });


    }

    private void metodoPrueba(){
        for (int x = 0; x <= 10; ++x){
            Toast.makeText(this, "Ciclo" + x, Toast.LENGTH_SHORT).show();
        }
        for(int x = 0; x <=10; ++x){
            Log.d("TAG-","Ciclo" + x);
        }
    }
    public void clickBoton(View V){
        if(V.getId() == R.id.btnAceptar){
            //btnAceptarRef.animate().rotationYBy(180f).setDuration(1000 * 2);
            //tvMensajeRef.setText("Josecijirijillo");
            tvMensajeRef.setTextColor(Color.RED);
            tvMensajeRef.setTextSize(36);
            String nombre = etNombreRef.getText().toString();
            Toast.makeText(this,getResources().getString(R.string.mensaje_toast), Toast.LENGTH_SHORT).show();
            tvMensajeRef.setText(nombre);
            if (etNombreRef.getText().toString().length() == 0) {
                etNombreRef.setError(getResources().getString(R.string.set_error_nombre));
            //Metodo Character es la mas necesaria para las contraseñas (para validar digito, mayusculas, numeros, etc)
            boolean may, dig;

            may = false; dig = false;
            //TODO: Christian arreglar el codigo a lo ultimo de la clase, por favor.
            for (int x = 0; x < nombre.length(); ++x){
                char caracter = nombre.charAt(x);
                if(Character.isUpperCase(caracter))
                    may = true;
                if (Character.isDigit(caracter))
                    dig = true;
            }
            if (may && dig) {
                etNombreRef.setError(null);
            }else{
                etNombreRef.setError(getResources().getString(R.string.set_error_nombre));
            }
           }
        }else if(V.getId() == R.id.btnSalir){
            finish();
        }
    }
}
