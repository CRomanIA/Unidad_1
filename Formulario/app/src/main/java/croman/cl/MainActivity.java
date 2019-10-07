package croman.cl;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Donde se Declaran.
    EditText etRutRef;
    EditText etFechaNacimientoRef;
    EditText etEdadRef;
    EditText etCorreoRef;
    EditText etContraseñaRef;
    //Declaraciones Extras
    String email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Donde se referencia la variable
        etRutRef = findViewById(R.id.etRut);
        etFechaNacimientoRef = findViewById(R.id.etFechaNacimiento);
        etEdadRef = findViewById(R.id.etEdad);
        etCorreoRef = findViewById(R.id.etCorreo);
        etContraseñaRef = findViewById(R.id.etPassword);

    }

    public void clickButton(View v){
        if(v.getId() == R.id.btnEnviar){
            //declaración de la función en el metodo al clickbuton
            String rut = etRutRef.getText().toString();
            String fechnac = etFechaNacimientoRef.getText().toString();
            String edad = etEdadRef.getText().toString();
            String correo = etCorreoRef.getText().toString();
            String pass = etContraseñaRef.getText().toString();

            //Se obtiene la funcion en cuestion, la cual permanece en el punto donde fue creada
            etRutRef.setText(rut);
            etEdadRef.setText(fechnac);
            etRutRef.setText(edad);
            etFechaNacimientoRef.setText(correo);
            etContraseñaRef.setText(pass);

            //Ingresar color de variable, así identificamos que no se levanto la variable en el punto sin problemas
            etRutRef.setTextColor(Color.BLUE);
            etFechaNacimientoRef.setTextColor(Color.BLUE);
            etEdadRef.setTextColor(Color.BLUE);
            etCorreoRef.setTextColor(Color.BLUE);


            //Hacer que el Rut Contenga sus restricciones

            //Hacer que Fecha de nacimiento Contenga su forma

            //Hacer que edad tenga su reestriccion de edad 150

            //Hacer que valide formato del correo

            //Hacer que se realice formato de contraseña
            boolean may, dig;
            may = false; dig = false;
            /*
            Genera metodo for para recorrer los caracteres de la contraseña,maximo 8.
            */
            for (int x = 0; x < pass.length(); ++x) {
                char caracter = pass.charAt(x);
                if (Character.isUpperCase(caracter))
                    may = true;
                if (Character.isDigit(caracter))
                    dig = true;
            }
            if(may && dig){
                etRutRef.setError(null);
                Toast.makeText(this, getResources().getString(R.string.mensaje_toast), Toast.LENGTH_SHORT).show();
                etContraseñaRef.setTextColor(Color.BLUE);
            }
            else if (etContraseñaRef.getText().toString().isEmpty()){
                etContraseñaRef.setError(getResources().getString(R.string.set_Error_Pass2));

            }
            /* En Proceso...
                else if (etContraseñaRef.getTextSize() < 6 ) {
                etContraseñaRef.getText().clear();
                etContraseñaRef.setError(getResources().getString(R.string.set_Error_Pass3));
            }*/
            else {
                etContraseñaRef.getText().clear();
                etContraseñaRef.setError(getResources().getString(R.string.set_Error_Pass));
            }
        }else if (v.getId() == R.id.btnSalir){
            finish();
        }
    }
}
