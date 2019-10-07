package prueba2.cl;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvPantallaRef;
    Button btnUno, btnDos, btnTres, btnCuatro, btnCinco, btnSeis, btnSiete, btnOcho, btnNueve,
            btnCero, btnSuma, btnResta, btnMultiplicacion, btnDivision, btnBorrar, btnPunto, btnIgual, btnAC;
    String mostrar, reserva, operador;
    double resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Gracias por comprar mi calculadora", Toast.LENGTH_SHORT).show();
        tvPantallaRef = findViewById(R.id.tvPantalla);

        btnUno = findViewById(R.id.btnUno);
        btnDos = findViewById(R.id.btnDos);
        btnTres = findViewById(R.id.btnTres);
        btnCuatro = findViewById(R.id.btnCuatro);
        btnCinco = findViewById(R.id.btnCinco);
        btnSeis = findViewById(R.id.btnSeis);
        btnSiete = findViewById(R.id.btnSiete);
        btnOcho = findViewById(R.id.btnOcho);
        btnNueve = findViewById(R.id.btnNueve);
        btnCero = findViewById(R.id.btnCero);
        btnSuma = findViewById(R.id.btnMas);
        btnResta = findViewById(R.id.btnMenos);
        btnMultiplicacion = findViewById(R.id.btnMultiplicacion);
        btnDivision = findViewById(R.id.btnDivision);
        btnPunto = findViewById(R.id.btnPunto);
        btnIgual = findViewById(R.id.btnIgual);
        btnBorrar = findViewById(R.id.btnBorrar);
        btnAC = findViewById(R.id.btnAC);

        btnUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrar = tvPantallaRef.getText().toString();
                mostrar = mostrar + "1";
                tvPantallaRef.setText(mostrar);
                tvPantallaRef.setTextColor(Color.BLACK);
                tvPantallaRef.setTextSize(46);

            }

        });
        btnDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrar = tvPantallaRef.getText().toString();
                mostrar = mostrar + "2";
                tvPantallaRef.setText(mostrar);
                tvPantallaRef.setTextColor(Color.BLACK);
                tvPantallaRef.setTextSize(46);

            }

        });
        btnTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrar = tvPantallaRef.getText().toString();
                mostrar = mostrar + "3";
                tvPantallaRef.setText(mostrar);
                tvPantallaRef.setTextColor(Color.BLACK);
                tvPantallaRef.setTextSize(46);

            }

        });
        btnCuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrar = tvPantallaRef.getText().toString();
                mostrar = mostrar + "4";
                tvPantallaRef.setText(mostrar);
                tvPantallaRef.setTextColor(Color.BLACK);
                tvPantallaRef.setTextSize(46);

            }

        });
        btnCinco.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mostrar = tvPantallaRef.getText().toString();
                mostrar = mostrar + "5";
                tvPantallaRef.setText(mostrar);
                tvPantallaRef.setTextColor(Color.BLACK);
                tvPantallaRef.setTextSize(46);

            }

        });
        btnSeis.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mostrar = tvPantallaRef.getText().toString();
                mostrar = mostrar + "6";
                tvPantallaRef.setText(mostrar);
                tvPantallaRef.setTextColor(Color.BLACK);
                tvPantallaRef.setTextSize(46);

            }

        });
        btnSiete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mostrar = tvPantallaRef.getText().toString();
                mostrar = mostrar + "7";
                tvPantallaRef.setText(mostrar);
                tvPantallaRef.setTextColor(Color.BLACK);
                tvPantallaRef.setTextSize(46);

            }

        });
        btnOcho.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mostrar = tvPantallaRef.getText().toString();
                mostrar = mostrar + "8";
                tvPantallaRef.setText(mostrar);
                tvPantallaRef.setTextColor(Color.BLACK);
                tvPantallaRef.setTextSize(46);

            }

        });
        btnNueve.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mostrar = tvPantallaRef.getText().toString();
                mostrar = mostrar + "9";
                tvPantallaRef.setText(mostrar);
                tvPantallaRef.setTextColor(Color.BLACK);
                tvPantallaRef.setTextSize(46);

            }

        });
        btnCero.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mostrar = tvPantallaRef.getText().toString();
                mostrar = mostrar + "0";
                tvPantallaRef.setText(mostrar);
                tvPantallaRef.setTextColor(Color.BLACK);
                tvPantallaRef.setTextSize(46);
            }

        });
        btnPunto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrar = tvPantallaRef.getText().toString();
                mostrar = mostrar + ".";
                tvPantallaRef.setText(mostrar);
                tvPantallaRef.setTextColor(Color.BLACK);
                tvPantallaRef.setTextSize(46);
            }
        });
        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrar = "";
                tvPantallaRef.setText(mostrar);
                reserva = "";
                operador = "";
            }
        });
        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrar = tvPantallaRef.getText().toString();
                mostrar = mostrar.substring(0, mostrar.length()-1);
                tvPantallaRef.setText(mostrar);
            }
        });
        btnSuma.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                reserva = tvPantallaRef.getText().toString();
                operador = "+";
                tvPantallaRef.setText("");
            }
        });
        btnResta.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                reserva = tvPantallaRef.getText().toString();
                operador = "-";
                tvPantallaRef.setText("");
            }
        });
        btnMultiplicacion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                reserva = tvPantallaRef.getText().toString();
                operador = "*";
                tvPantallaRef.setText("");
            }
        });
        btnDivision.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                reserva = tvPantallaRef.getText().toString();
                operador = "/";
                tvPantallaRef.setText("");
            }
        });
        btnIgual.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mostrar = tvPantallaRef.getText().toString();
                mostrar = mostrar + "1";
                if (operador.equals("-")){
                    resultado = Double.parseDouble(reserva) - Double.parseDouble(tvPantallaRef.getText().toString());
                    tvPantallaRef.setText(String.valueOf(resultado));
                }
                else if(operador.equals("+")){
                    resultado = Double.parseDouble(reserva) + Double.parseDouble(tvPantallaRef.getText().toString());
                    tvPantallaRef.setText(String.valueOf(resultado));
                }
                else if(operador.equals("*")){
                    resultado = Double.parseDouble(reserva) * Double.parseDouble(tvPantallaRef.getText().toString());
                    tvPantallaRef.setText(String.valueOf(resultado));
                }
                else if(operador.equals("/")){
                    resultado = Double.parseDouble(reserva) / Double.parseDouble(tvPantallaRef.getText().toString());
                    tvPantallaRef.setText(String.valueOf(resultado));
                }
            }
        });
    }

    public void clickBoton(View v){

        if(v.getId() == R.id.btnSalir){
            finish();
        }

    }
}
