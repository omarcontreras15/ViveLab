package co.edu.ufps.vivelab;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Calendar;

public class Registro extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Button botonRegistrar;
    private EditText mCorreo;
    private EditText mPassword;
    private Spinner tipo_documento;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        //activar el boton de ir hacia atras en el menubar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // se  obtiene la instancia compartida del objeto
        mAuth=FirebaseAuth.getInstance();
        botonRegistrar=(Button)findViewById(R.id.boton_registrar_usuario);
        mCorreo=(EditText)findViewById(R.id.email);
        mPassword=(EditText)findViewById(R.id.password);
        EditText usuario=(EditText)findViewById(R.id.usuario);
        botonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarRegistro();
            }
        });
        tipo_documento=(Spinner) findViewById(R.id.tipo_documento);
        //cargar boton calendario
        this.cargarBotonCalendario();
    }

    //metodo sobreescrito para activar el boton hacia atras de titleBar
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }

    private boolean registrarUsuario(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(getApplication(), "Se ha creado exitosamente la cuenta.", Toast.LENGTH_LONG).show();
                            finishAffinity();
                            pasarActivity(Inicio.class);
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(getApplication(), "Error! Ya existe el correo electonico.", Toast.LENGTH_LONG).show();
                        }

                    }
                });
        return false;
    }


    //metodo para pasar a una siquiete activity
    private void pasarActivity(Class clase){
        Intent activity=new Intent(getApplicationContext(),clase);
        startActivity(activity);
    }

    private void verificarRegistro() {

        // Reset errors.
        mCorreo.setError(null);
        mPassword.setError(null);

        // Store values at the time of the login attempt.
        String email = mCorreo.getText().toString();
        String password = mPassword.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (password.isEmpty() || !isPasswordValid(password)) {
            mPassword.setError("Ingrese por favor una contraseña valida");
            focusView = mPassword;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mCorreo.setError("Por favor ingrese un e-mail");
            focusView = mCorreo;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mCorreo.setError("Ingrese e-mail valido");
            focusView = mCorreo;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            //llamamos al metodo iniciarSesion
            registrarUsuario(mCorreo.getText().toString().trim(), mPassword.getText().toString());
        }
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

    //Este metodo se encargar de cargar el DatePicker en el formulario de registro
    private void cargarBotonCalendario(){

        ImageView btn=(ImageView)findViewById(R.id.btn_calendario);
        final EditText fechaNacimiento=(EditText)findViewById(R.id.fecha_nacimiento);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar=Calendar.getInstance();
                int anio=calendar.get(Calendar.YEAR);
                int mes=calendar.get(Calendar.MONTH);
                int dia=calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePicker=new DatePickerDialog(Registro.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        fechaNacimiento.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                    }
                },anio,mes,dia);

                datePicker.show();
            }
        });



    }



}
