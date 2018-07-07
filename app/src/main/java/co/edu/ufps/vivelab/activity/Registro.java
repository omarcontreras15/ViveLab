package co.edu.ufps.vivelab.activity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
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

import java.util.Calendar;

import co.edu.ufps.vivelab.R;
import co.edu.ufps.vivelab.webService.connection.ApiAdapter;
import co.edu.ufps.vivelab.webService.valueof.EstudianteValue;
import co.edu.ufps.vivelab.webService.valueof.RespuestaObject;
import co.edu.ufps.vivelab.webService.valueof.UsuarioValue;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Registro extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Button botonRegistrar;
    private EditText mCorreo;
    private EditText mPassword;
    private EditText apellido1, apellido2, nombres, username, numeroDocumeto, telefono, fechaNacimiento;
    private Spinner tipo_documento;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        //activar el boton de ir hacia atras en el menubar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // se  obtiene la instancia compartida del objeto
        this.mAuth = FirebaseAuth.getInstance();
        this.botonRegistrar = findViewById(R.id.boton_registrar_usuario);
        this.mCorreo = findViewById(R.id.email);
        this.mPassword = findViewById(R.id.password);
        this.botonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarRegistro();
            }
        });
        this.tipo_documento = findViewById(R.id.tipo_documento);
        this.apellido1 = findViewById(R.id.apellido1);
        this.apellido2 = findViewById(R.id.apellido2);
        this.nombres = findViewById(R.id.nombre);
        this.username = findViewById(R.id.usuario);
        this.numeroDocumeto = findViewById(R.id.numero_documento);
        this.telefono = findViewById(R.id.telefono);
        this.fechaNacimiento = findViewById(R.id.fecha_nacimiento);
        //cargar boton calendario
        this.cargarBotonCalendario();
    }

    //metodo sobreescrito para activar el boton hacia atras de titleBar
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
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

            String nombres = this.nombres.getText().toString();
            String apellido1 = this.apellido1.getText().toString();
            String apellido2 = this.apellido2.getText().toString();
            String username = this.username.getText().toString();
            String numeroDocumento = this.numeroDocumeto.getText().toString();
            String telefono = this.telefono.getText().toString();
            String fechaNacimiento = this.fechaNacimiento.getText().toString();

            String tipoDocumento = tipo_documento.getSelectedItem().toString();
            int tipoDoc = 0;

            if(tipoDocumento.equals("Cédula de ciudadanía")) tipoDoc = 1;
            else if(tipoDocumento.equals("Tarjeta de Identidad")) tipoDoc = 2;
            else if(tipoDocumento.equals("Cédula de extranjería")) tipoDoc = 3;

            EstudianteValue estudiante = new EstudianteValue();
            estudiante.setTipo_documento(tipoDoc);
            estudiante.setApellido1(apellido1);
            estudiante.setApellido2(apellido2);
            estudiante.setNombre(nombres);
            estudiante.setUsername(username);
            estudiante.setDocumento(numeroDocumento);
            estudiante.setTelefono(telefono);
            estudiante.setFechaNac(fechaNacimiento);
            estudiante.setEmail(email);
            estudiante.setPassword(password);
            estudiante.setAvatar("https://png.icons8.com/cotton/50/000000/gender-neutral-user.png");
            this.registrarUsuario(mCorreo.getText().toString().trim(), mPassword.getText().toString(), estudiante);
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
                        fechaNacimiento.setText(year+"-"+(month+1)+"-"+dayOfMonth);
                    }
                },anio,mes,dia);

                datePicker.show();
            }
        });

    }

    private void registrarUsuario(String email, String password, final EstudianteValue estudianteValue) {
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Toast.makeText(getApplication(), "Registro exitos, ya puedes iniciar sesiòn", Toast.LENGTH_LONG).show();

                        Call<RespuestaObject<EstudianteValue>> call= ApiAdapter.getApiService().registrarUsuario(estudianteValue);
                        call.enqueue(new RegistrarUsuarioCallBack());
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(getApplication(), "Error! Ya existe el correo electonico.", Toast.LENGTH_LONG).show();
                    }
                }
            });
    }

    class RegistrarUsuarioCallBack implements Callback<RespuestaObject<EstudianteValue>> {

        @Override
        public void onResponse(Call<RespuestaObject<EstudianteValue>> call, Response<RespuestaObject<EstudianteValue>> response) {
            System.out.println(response.message()+"----------------------------");
            if(response.isSuccessful()){

                if(response.code() == 200){

                }
            }
        }

        @Override
        public void onFailure(Call<RespuestaObject<EstudianteValue>> call, Throwable t) {
            System.out.println("------------------------Ha ocurrido un errror--------------- " + t.getMessage());
        }
    }

}
