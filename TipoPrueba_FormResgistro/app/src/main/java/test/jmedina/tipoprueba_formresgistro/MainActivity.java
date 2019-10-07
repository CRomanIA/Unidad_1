package test.jmedina.tipoprueba_formresgistro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etUsuarioRef;
    private EditText etClaveRef;
    private EditText etReingresoClaveRef;
    private EditText etCorreoRef;
    private Button btnRegistrarRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsuarioRef = findViewById(R.id.etUsuario);
        etClaveRef = findViewById(R.id.etClave);
        etReingresoClaveRef = findViewById(R.id.etReingresoClave);
        etCorreoRef = findViewById(R.id.etCorreo);
        btnRegistrarRef = findViewById(R.id.btnRegistrar);


        try {

            btnRegistrarRef.setOnClickListener(new View.OnClickListener(){
              public void onClick(View v){
                  Log.d("TAG-", "Click sobre ClickListener de Clase Anónima");
                  //Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();

                  // Método de validación de campos vacios
                  valCamposVacios();
                  if (resultCamposVacios == true){
                      //Toast.makeText(MainActivity.this, "Validado campos Vacios", Toast.LENGTH_SHORT).show();
                      valCampoUsuario();
                  }

                  if (resultCampoUsuario == true){
                      valCampoClave();
                  }

                  if (resultCampoClave== true){
                      //Toast.makeText(MainActivity.this, "Validación Campo Clave SON IGUALES", Toast.LENGTH_SHORT).show();
                      valCompararClaves();
                  }

                  if (resultClaveIgual == true){
                      Toast.makeText(MainActivity.this, etUsuarioRef.getText().toString() + " " + getResources().getString(R.string.mensajeToast), Toast.LENGTH_SHORT).show();
                  }

              }
            });
        }catch(Exception ex){
            Log.e("TAG-", "Error" + ex.toString());
        }
        Log.d("TAG-", "Carga OnCreate");
    } //FIN ONCREATE

    // Variables de condicionales de los EditText
    boolean resultUsuario = false;
    boolean resultClave = false;
    boolean resultReIngresoClave = false;
    boolean resultCorreo = false;

    // Variables condicionales de las Validaciones
    boolean resultCamposVacios = false;
    boolean resultCampoUsuario = false;
    boolean resultClaveIgual = false;
    boolean resultCampoClave = false;

    // Metodos de Validaciones de datos

    private boolean valCamposVacios(){

        // Validación Campo Usuario

        try{
            if(etUsuarioRef.getText().toString().length()!= 0){
                resultUsuario = true;
                etUsuarioRef.setError(null);
            }else{
                etUsuarioRef.setError(getResources().getString(R.string.setErrorUsuarioVacio));
                resultUsuario = false;
                resultCampoUsuario = false;
            }

            // Validación Campo Clave
            if(etClaveRef.getText().toString().length()!= 0){
                resultClave= true;
                etClaveRef.setError(null);
            }else{
                etClaveRef.setError(getResources().getString(R.string.setErrorClaveVacio));
                resultClave= false;
            }

            // Validación Campo ReIngreso Clave
            if(etReingresoClaveRef.getText().toString().length()!= 0){
                resultReIngresoClave = true;
                etReingresoClaveRef.setError(null);
            }else{
                etReingresoClaveRef.setError(getResources().getString(R.string.setErrorReingresoClaveVacio));
                resultReIngresoClave = false;
            }

            // Validación Campo Correo
            if(etCorreoRef.getText().toString().length()!= 0){
                resultCorreo = true;
                etCorreoRef.setError(null);
            }else{
                etCorreoRef.setError(getResources().getString(R.string.setErrorCorreo));
                resultCorreo = false;
            }

            if (resultUsuario && resultClave && resultReIngresoClave && resultCorreo){
                resultCamposVacios = true;
                Log.d("TAG-", "Validación de Campos No Vacios OK");
            }else{
                resultCamposVacios = false;
                Log.d("TAG-", "Validación de Campos No Vacios NO OK");
            }
        }catch(Exception ex){
            Log.e("TAG-", "Error" + ex.toString());
        } // FIN TRY CATCH
        return resultCamposVacios;
    }// Cierre valCamposVacios

    private boolean valCampoUsuario(){
        String var = etUsuarioRef.getText().toString();
        String pasoVar = "";

        // Recorrer String var y analizar si contiene espacios
        try {
            for (int x = 0; x < var.length(); ++x) {
                char caracter = var.charAt(x);

                if(Character.isWhitespace(caracter)){
                    pasoVar = pasoVar + "";
                }else{
                    pasoVar = pasoVar + var.charAt(x);
                }
            }//Cierre FOR
            etUsuarioRef.setText(pasoVar);
            resultCampoUsuario = true;
        }catch(Exception ex){
            Log.e("TAG-", "Error" + ex.toString());
        } // FIN TRY CATCH

        Log.d("TAG-", "Limpiar espacios en campo usuario OK");
        return resultCampoUsuario;
    }// Cierre valCampoUsuario

    private boolean valCampoClave(){
        String varClave = etClaveRef.getText().toString();

        // Validación reglas de Clave (6 a 10)
        try{
            if (varClave.length() >=6 && varClave.length() <= 10){
                // Validación de Mayuscula Minuscula y Digitos
                boolean may, dig, min;
                may = false; dig = false; min = false;

                for (int x = 0; x < varClave.length(); ++x) {
                    char varChar = varClave.charAt(x);

                    if(Character.isUpperCase(varChar)){
                        may = true;
                    }

                    if(Character.isLowerCase(varChar)){
                        min = true;
                    }

                    if (Character.isDigit(varChar)){
                        dig = true;
                    }
                }// Cierre for

                if (may == true && dig == true && min == true){
                    //Toast.makeText(MainActivity.this, "Validación Clave Min, Max y Dig", Toast.LENGTH_SHORT).show();
                    etClaveRef.setError(null);
                    resultCampoClave = true;
                    Log.d("TAG-", "Valiradión Clave OK - Mayuscula, Minuscula y Digito");
                }else{
                    etClaveRef.setError(getResources().getString(R.string.setErrorValidacionClave));
                    resultCampoClave = false;
                    Log.d("TAG-", "Valiradión Clave NO OK");
                }
            }else{
                etClaveRef.setError(getResources().getString(R.string.setErroretClaveMinMax));
                etReingresoClaveRef.setError(getResources().getString(R.string.setErroretClaveMinMax));
                resultCampoClave = false;
                Log.d("TAG-", "Valiradión Clave sin largo definido, entre 6 y 10");
            }

        }catch(Exception ex){
            Log.e("TAG-", "Error" + ex.toString());
        } // FIN TRY CATCH

        return resultCampoClave;
    } //Cierre valCamposClaves

    private boolean valCompararClaves(){
        String varClave = etClaveRef.getText().toString();
        String varReIngresoClave = etReingresoClaveRef.getText().toString();

        // Validación clave Identica
        try{
            if (varClave.equals(varReIngresoClave)){
                //Toast.makeText(MainActivity.this, "Claves Iguales", Toast.LENGTH_SHORT).show();
                resultClaveIgual = true;
                etReingresoClaveRef.setError(null);
                Log.d("TAG-", "Valiradión Clave y ReIngreso Clave OK");
            }else{
                resultClaveIgual = false;
                etReingresoClaveRef.setError(getResources().getString(R.string.setErrorReingresoClaveNoMatch));
                Log.d("TAG-", "Valiradión Clave y ReIngreso Clave NO OK");
            }
        }catch(Exception ex){
            Log.e("TAG-", "Error" + ex.toString());
        } // FIN TRY CATCH

        return resultClaveIgual;
    }// Cierre valCampoClave



}// FIN
