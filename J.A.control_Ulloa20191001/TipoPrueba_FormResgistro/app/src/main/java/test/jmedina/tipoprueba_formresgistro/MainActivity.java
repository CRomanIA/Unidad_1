package test.jmedina.tipoprueba_formresgistro;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TAG-";
    private EditText etUsuarioRef;
    private EditText etClaveRef;
    private EditText etReingresoClaveRef;
    private EditText etCorreoRef;
    private Button btnRegistrarRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            initResources();

    } //FIN ONCREATE


    private void initResources(){
        etUsuarioRef = findViewById(R.id.etUsuario);
        etClaveRef = findViewById(R.id.etClave);
        etReingresoClaveRef = findViewById(R.id.etReingresoClave);
        etCorreoRef = findViewById(R.id.etCorreo);
        btnRegistrarRef = findViewById(R.id.btnRegistrar);

            btnRegistrarRef.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    camposObligatorios();
                    //validateForm();
                    eliminarEspacios();

                }
            });
        }

    private void validateForm(){
        try{
            String userValue = etUsuarioRef.getText().toString().replaceAll(" ", "");
            String passValue = etClaveRef.getText().toString();
            String confirmPassValue = etReingresoClaveRef.getText().toString();
            String emailValue = etCorreoRef.getText().toString();
            //Debug campos
            Log.d(TAG, "Usuario " + userValue);
            Log.d(TAG, "Password " + passValue);
            Log.d(TAG, "Confirm_Password " + confirmPassValue);
            Log.d(TAG, "Email " + emailValue);

            etUsuarioRef.setText(userValue);

            if (userValue.isEmpty() || passValue.isEmpty() || confirmPassValue.isEmpty() || emailValue.isEmpty()){
                Log.d(TAG , "No Existe Datos Ingresados");

                etUsuarioRef.setError(getResources().getString(R.string.set_Error_Pass));

            }

            etClaveRef.setText(passValue);
            etReingresoClaveRef.setText(confirmPassValue);
            etCorreoRef.setText(emailValue);

        } catch (Exception e){
            Log.e(TAG, "Error formulario valido");
        }
    }
    //Metodo para practicar la wea... era...
    private void metodoPrueba(){
        for(int x = 0; x <=10; ++x){
            Toast.makeText(this, "Ciclo " + x , Toast.LENGTH_SHORT).show();
        }
    }

    private void camposObligatorios(){
        try {
            if (etUsuarioRef.getText().toString().isEmpty()) {
                etUsuarioRef.setError(getResources().getString(R.string.set_Error_Pass));
            }
            if (etClaveRef.getText().toString().isEmpty()) {
                etClaveRef.setError(getResources().getString(R.string.set_Error_Pass));
            }
            if (etReingresoClaveRef.getText().toString().isEmpty()) {
                etReingresoClaveRef.setError(getResources().getString(R.string.set_Error_Pass));
            }
            if (etCorreoRef.getText().toString().isEmpty()) {
                etCorreoRef.setError(getResources().getString(R.string.set_Error_Pass));
            }
        }catch (Exception e){
            Log.e(TAG, "Error en validacion de campos.");

        }
    }//Fin camposObligatorios

    private  void eliminarEspacios(){
        try {
            Log.d(TAG, "Espacio eliminado en usuario");
            String usuario = etUsuarioRef.getText().toString().replaceAll(" ", "");
            etUsuarioRef.setText(usuario);
        }catch (Exception e){
            Log.e(TAG,"Error en eliminacion en espacio de usuario");
        }
    }//Fin eliminarEspacios
    private void validarCamposClave (){
        String passValue = etClaveRef.getText().toString();
        try{
            if(passValue.length() >= 6 && passValue.length() <=10){

            }else{

            }
        }catch (Exception e){
            Log.e(TAG,"Error al validar campos clave");
        }


    }
}// FIN Main Activity