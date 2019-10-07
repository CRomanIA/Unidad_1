package cl.fjimenez.testpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "TAG-" + MainActivity.class.getName();

    private EditText etUser, etPass, etMatchPass, etEmail;
    private Button btnRegistry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initResources();
    }

    private void initResources() {
        etUser = findViewById(R.id.etUser);
        etPass = findViewById(R.id.etPassword);
        etMatchPass = findViewById(R.id.etMatch);
        etEmail = findViewById(R.id.etEmail);

        btnRegistry = findViewById(R.id.btnRegistry);

        btnRegistry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateForm();
            }
        });
    }

    private void validateForm() {
        try {
            String userValue = etUser.getText().toString().replaceAll(" ", "");
            String passwordValue = etPass.getText().toString();
            String matchPassValue = etMatchPass.getText().toString();
            String emailValue = etEmail.getText().toString();

            Log.d(TAG, "Usuario: " + userValue);
            Log.d(TAG, "Clave: " + passwordValue);
            Log.d(TAG, "Reingreso clave: " + matchPassValue);
            Log.d(TAG, "Email: " + emailValue);

            etUser.setText(userValue);

            if (userValue.isEmpty()  || passwordValue.isEmpty() || matchPassValue.isEmpty() || emailValue.isEmpty()) {
                Log.d(TAG, "No existen datos ingresados");

                etUser.setError(userValue.isEmpty() ? getResources().getString(R.string.hint_user) : null);
                etPass.setError(passwordValue.isEmpty() ? getResources().getString(R.string.hint_password) : null);
                etMatchPass.setError(matchPassValue.isEmpty() ? getResources().getString(R.string.hint_match_password) : null);
                etEmail.setError(emailValue.isEmpty() ? getResources().getString(R.string.hint_email) : null);
            } else {
                boolean validatePasswords = validatePasswords(passwordValue, matchPassValue);
                boolean validateUser = validateUser(userValue);
                boolean validateEmail = validateEmail(emailValue);

                if (validatePasswords && validateEmail && validateUser) {

                    if (validateMatching(passwordValue, matchPassValue)) {
                            Toast.makeText(this, userValue + " " + getResources().getString(R.string.success_validation), Toast.LENGTH_LONG);
                        //en caso de evitar que se muestre algun error.
                        etUser.setError(null);
                        etPass.setError(null);
                        etMatchPass.setError(null);
                        etEmail.setError(null);
                    }

                }
            }
        } catch (Exception e) {
            Log.e(TAG, "Error validando formulario", e);
        }
    }

    private boolean validateUser(String user) {
        try {
            boolean resultUser = user.matches("([\\w])*+");

            etUser.setError(!resultUser ? getResources().getString(R.string.error_no_valid_user) : null);

            return resultUser;
        } catch (Exception e) {
            Log.e(TAG, "Error validando contraseñas", e);
            return false;
        }
    }

    private boolean validateEmail(String email) {
        try {
            boolean resultEmail = email.matches("([\\w\\-\\.]*\\@[\\w]*\\.[\\w]*)+");

            etEmail.setError(!resultEmail ? getResources().getString(R.string.error_no_valid_email) : null);

            return resultEmail;
        } catch (Exception e) {
            Log.e(TAG, "Error validando contraseñas", e);
            return false;
        }
    }

    private boolean validatePasswords(String firstPassword, String secondPassword) {
        int minimumPassLength = 6;
        int maximumPassLength = 10;
        try {
            boolean resultFirstPassword = false;
            boolean resultSecondPassword = false;

            if (firstPassword.length() >= minimumPassLength && firstPassword.length() <= maximumPassLength) {
                resultFirstPassword = validateContentPass(firstPassword);
                etPass.setError(!resultFirstPassword ? getResources().getString(R.string.error_no_valid_password) : null);
            } else {
                etPass.setError(
                        getResources().getString(
                                firstPassword.length() < minimumPassLength ?
                                        R.string.error_min_length_password : R.string.error_max_length_password));
            }

            if (secondPassword.length() >= minimumPassLength && secondPassword.length() <= maximumPassLength) {

                resultSecondPassword = validateContentPass(secondPassword);
                etMatchPass.setError(!resultSecondPassword ? getResources().getString(R.string.error_no_valid_password) : null);
            } else {
                etMatchPass.setError(
                        getResources().getString(
                                secondPassword.length() < minimumPassLength ?
                                        R.string.error_min_length_password : R.string.error_max_length_password));
            }


            return resultFirstPassword && resultSecondPassword;
        } catch (Exception e) {
            Log.e(TAG, "Error validando contraseñas", e);
            return false;
        }
    }

    private boolean validateContentPass(String password) {
        try {
            boolean resultUpper = false;
            boolean resultLower = false;
            boolean resultNumber = false;

            for (char caracter : password.toCharArray()) {
                if (!resultUpper && Character.isUpperCase(caracter)) {
                    resultUpper = true;
                } else if (!resultLower && Character.isLowerCase(caracter)) {
                    resultLower = true;
                } else if (!resultNumber && Character.isDigit(caracter)) {
                    resultNumber = true;
                }
            }

            return resultUpper && resultLower && resultNumber;
        } catch (Exception e) {
            Log.e(TAG, "Error validando contenido", e);
            return false;
        }
    }

    private boolean validateMatching(String firstPassword, String secondPassword) {
        try {
            boolean result = firstPassword.equals(secondPassword);

            etPass.setError(!result ? getResources().getString(R.string.blank_text) : null);
            etMatchPass.setError(!result ? getResources().getString(R.string.error_no_match_password) : null);

            return result;
        } catch (Exception e) {
            Log.e(TAG, "Error validando contraseñas", e);
            return false;
        }
    }
}
