package test.jmedina.prueba1_jmedina;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Referencia de Objetos del XML
    private TextView etProductoRef;
    private EditText etCodigoRef;
    private EditText etDescripcionRef;
    private EditText etUbicacionRef;
    private EditText etFechaCompraRef;
    private EditText etStockRef;
    private EditText etCostoRef;
    private EditText etVentaRef;
    private Button btnIngresarRef;

    // Variables Locales para los objetos del XML
    private boolean resultEtProducto;
    private boolean resultEtCodigo;
    private boolean resultEtDescipcion;
    private boolean resultEtUbicacion;
    private boolean resultEtFechaCompra;
    private boolean resultEtStock;
    private boolean resultEtCosto;
    private boolean resultEtVenta;

    // Variables Locales de Validaciones de Negocio
    Producto nuevoProducto = new Producto();
    private boolean valInitForm;
    private boolean resultCamposVacios;
    private boolean resultDescripcionTrim;
    private boolean resultUbicacionTrim;
    private boolean resultValidacionTrim;
    private boolean resultStockPositivo;
    private boolean resultCostoPositivo;
    private boolean resultVentaPositivo;
    private boolean resultValidacionPositivos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initForm();

        try {

            btnIngresarRef.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    Log.d("TAG-", "ClickListener de Clase Anónima, boton Ingresar");
                    //Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();

                    // Método de validación de campos vacios


                    if (valInitForm){
                        valCamposVacios();
                    }else{
                        Log.d("TAG-", "No se puede ejecutar la función valCamposVacios en OnCreate");
                    }

                    if (resultCamposVacios){
                        //Toast.makeText(MainActivity.this, " Los campos Vacios se encuentran validados", Toast.LENGTH_SHORT).show();
                        valCamposTrim();
                    }else{
                        Log.d("TAG-", "No se puede ejecutar la función valCamposTrim en OnCreate");
                    }

                }
            });
        }catch(Exception ex){
            Log.e("TAG-", "Error" + ex.toString());
        } // Cierre Try Catch

        Log.d("TAG-", "Llamada a Método OnCreate");

    } // Cierre OnCreate

    private void initForm() {

        // Inicialización Variables en Formulario
        try{

            // Captura referencias entre objetos desde el DIreño XML hasta la clase Main
            etProductoRef = findViewById(R.id.tvProducto);
            etCodigoRef = findViewById(R.id.etCodigo);
            etDescripcionRef = findViewById(R.id.etDescripcion);
            etUbicacionRef = findViewById(R.id.etUbicacion);
            etFechaCompraRef = findViewById(R.id.etFechaCompra);
            etStockRef = findViewById(R.id.etStock);
            etCostoRef = findViewById(R.id.etCosto);
            etVentaRef = findViewById(R.id.etVenta);
            btnIngresarRef = findViewById(R.id.btnIngresar);

            // Validación de Variables Independientes (Campos Vacios)
            resultEtProducto = false;
            resultEtCodigo = false;
            resultEtDescipcion = false;
            resultEtUbicacion = false;
            resultEtFechaCompra = false;
            resultEtStock = false;
            resultEtCosto = false;
            resultEtVenta = false;

            // Variables para condicionar las reglas de negocio
            resultCamposVacios = false;
            resultDescripcionTrim = false;
            resultUbicacionTrim = false;
            resultValidacionTrim = false;
            resultStockPositivo = false;
            resultCostoPositivo = false;
            resultVentaPositivo = false;
            resultValidacionPositivos = false;

            // Validador initForm
            valInitForm = true;

            // LOG Debug
            Log.d("TAG-", "Llamada a Método Inicialización de Variables");
        }catch(Exception ex){
            Log.e("TAG-", "Error: " + ex.toString());
        } // Cierre Try Catch
    } // Cierre inicializarFormulario

    private boolean valCamposVacios(){

        // Validación Campo Producto

        try{
            //if(etProductoRef.getText().toString().length()!= 0){
            //    resultEtProducto = true;
            //    etProductoRef.setError(null);
            //}else{
            //    etProductoRef.setError(getResources().getString(R.string.setErrorEtProductoVacio));
            //    resultEtProducto = false;
                //resultCampoUsuario = false;
            //}

            // Validación Campo Codigo
            if(etCodigoRef.getText().toString().length()!= 0){
                resultEtCodigo= true;
                etCodigoRef.setError(null);
            }else{
                etCodigoRef.setError(getResources().getString(R.string.setErrorEtCodigoVacio));
                resultEtCodigo = false;
            }

            // Validación Campo Descripcion
            if(etDescripcionRef.getText().toString().length()!= 0){
                resultEtDescipcion = true;
                etDescripcionRef.setError(null);
            }else{
                etDescripcionRef.setError(getResources().getString(R.string.setErrorEtDescripcionVacio));
                resultEtDescipcion = false;
            }

            // Validación Campo Ubicación
            if(etUbicacionRef.getText().toString().length()!= 0){
                resultEtUbicacion = true;
                etUbicacionRef.setError(null);
            }else{
                etUbicacionRef.setError(getResources().getString(R.string.setErrorEtUbicacionVacio));
                resultEtUbicacion = false;
            }

            // Validación Campo FechaCompra
            if(etFechaCompraRef.getText().toString().length()!= 0){
                resultEtFechaCompra = true;
                etFechaCompraRef.setError(null);
            }else{
                etFechaCompraRef.setError(getResources().getString(R.string.setErrorEtFechaCompraVacio));
                resultEtFechaCompra = false;
            }

            // Validación Campo Stock
            if(etStockRef.getText().toString().length()!= 0){
                resultEtStock = true;
                etStockRef.setError(null);
            }else{
                etStockRef.setError(getResources().getString(R.string.setErrorStockVacio));
                resultEtStock = false;
            }

            // Validación Campo Costo
            if(etCostoRef.getText().toString().length()!= 0){
                resultEtCosto = true;
                etCostoRef.setError(null);
            }else{
                etCostoRef.setError(getResources().getString(R.string.setErrorCostoVacio));
                resultEtCosto= false;
            }

            // Validación Campo Venta
            if(etVentaRef.getText().toString().length()!= 0){
                resultEtVenta = true;
                etVentaRef.setError(null);
            }else{
                etVentaRef.setError(getResources().getString(R.string.setErrorVentaVacio));
                resultEtVenta = false;
            }

            // Validación de Todos los campos en condición TRUE
            if (resultEtCodigo && resultEtDescipcion && resultEtUbicacion
            && resultEtFechaCompra && resultEtStock && resultEtCosto && resultEtVenta){
                resultCamposVacios = true;
                Log.d("TAG-", "VALIDACION: Campos no vacios OK");
            }else{
                resultCamposVacios = false;
                Log.d("TAG-", "ERROR: Alguno o varios campos NO se encuentran vacios");
            }
        }catch(Exception ex){
            Log.e("TAG-", "Error" + ex.toString());
        } // FIN TRY CATCH
        return resultCamposVacios;
    } // Cierre valCamposVacios

    private boolean valCamposTrim(){
        // Validación de Campos con aplicación de TRIM, para eliminar espacios vacios
        try {
            if(etDescripcionRef.getText().toString().trim().length() > 0){
                etDescripcionRef.setText(etDescripcionRef.getText().toString().trim());
                etDescripcionRef.setError(null);
                resultDescripcionTrim = true;
            }else{
                etDescripcionRef.setError(getResources().getString(R.string.setErrorDescripcionTrim));
                resultDescripcionTrim = false;
                Log.d("TAG-", "ERROR: Campo Descripción con problemas de conversión TRIM");
            }

            if(etUbicacionRef.getText().toString().trim().length() > 0){
                etUbicacionRef.setText(etUbicacionRef.getText().toString().trim());
                etUbicacionRef.setError(null);
                resultUbicacionTrim = true;
            }else{
                etUbicacionRef.setError(getResources().getString(R.string.setErrorUbicacionTrim));
                resultUbicacionTrim = false;
                Log.d("TAG-", "ERROR: Campo Ubicación con problemas de conversión TRIM");
            }

            // Validación de Reglas de Negocio de campos vacios

            if (resultDescripcionTrim && resultUbicacionTrim){
                resultValidacionTrim = true;
                Log.d("TAG-", "VALIDACION: TRIM Aplicado");
            }else{
                Log.d("TAG-", "ERROR: No se pudo aplicar el TRIM");
            }
        }catch(Exception ex){
            Log.e("TAG-", "Error" + ex.toString());
        }
        return resultValidacionTrim;
    } // Cierre valCamposTrim

    private boolean valCamposMayuscula(){

        String valPasoCodigo = etCodigoRef.getText().toString().toUpperCase();
        String valPasoDescripcion = etDescripcionRef.getText().toString().toUpperCase();
        String valPasoUbicacion = etUbicacionRef.getText().toString().toUpperCase();



        return false;
    }


    private boolean valNumericos(){

        int valPasoStock;
        float valPasoCosto;
        float valPasoVenta;
        //String valEval;

        try{
            valPasoStock = Integer.parseInt(etStockRef.getText().toString().trim());
            valPasoCosto = Float.parseFloat(etCostoRef.getText().toString().trim());
            valPasoVenta = Float.parseFloat(etVentaRef.getText().toString().trim());

            if (valPasoStock >=0){
                etStockRef.setText(valPasoStock);
                etStockRef.setError(null);
                resultStockPositivo = true;
            }else{
                resultStockPositivo = false;
                etStockRef.setError(getResources().getString(R.string.setErrorStockEntero));
                Log.d("TAG-", "ERROR: La variable Stock tiene problemas");
            }

            if(valPasoCosto >=0){
                etCostoRef.setText(String.valueOf(valPasoCosto));
                etCostoRef.setError(null);
                resultCostoPositivo = true;
            }else{
                resultCostoPositivo = false;
                etCostoRef.setError(getResources().getString(R.string.setErrorCostoFloat));
                Log.d("TAG-", "ERROR: La variable Costo tiene problemas");
            }

            if (valPasoVenta >=0){
                etVentaRef.setText(String.valueOf(valPasoVenta));
                etVentaRef.setError(null);
                resultVentaPositivo = true;
            }else{
                resultVentaPositivo = false;
                etVentaRef.setError(getResources().getString(R.string.setErrorVentaFloat));
                Log.d("TAG-", "ERROR: La variable Venta tiene problemas");
            }

            if (resultStockPositivo && resultCostoPositivo && resultVentaPositivo){
                resultValidacionPositivos = true;
                Log.d("TAG-", "VALIDACION: Stock es un Número entero");
            }else{
                resultValidacionPositivos = false;

            }

        }catch(Exception ex){
            Log.e("TAG-", "Error" + ex.toString());
        }

        return true;
    }




    private void initObjForm(){

        try{
            // Variables Tipo String
            nuevoProducto.setProducto(etProductoRef.getText().toString()); // Tipo String
            nuevoProducto.setCodigo(etCodigoRef.getText().toString()); // Tipo String
            nuevoProducto.setDescripcion(etDescripcionRef.getText().toString()); // Tipo String
            nuevoProducto.setUbicacion(etUbicacionRef.getText().toString()); // Tipo String
            nuevoProducto.setFechaCompra(etFechaCompraRef.getText().toString()); // Tipo String

            // Es probable que se presenten errores en el inicio de las variables de tipo numérico
            // Variables de Tipo numérico (INT & FLOAT)
            nuevoProducto.setStock(Integer.parseInt(etStockRef.getText().toString())); // Tipo INT
            nuevoProducto.setCosto(Float.parseFloat(etCostoRef.getText().toString())); // Tipo FLOAT
            nuevoProducto.setVenta(Float.parseFloat(etVentaRef.getText().toString())); // Tipo FLOAT

            //Registro Debug de Comportamiento
            Log.d("TAG-", "Llamada a Método InstanciarObjetoFormulario");
        }catch(Exception ex){
            Log.e("TAG-", "Error: " + ex.toString());
        } // Cierre Try Catch
    } // Cierre InitObjForm



} // Cierre Class
