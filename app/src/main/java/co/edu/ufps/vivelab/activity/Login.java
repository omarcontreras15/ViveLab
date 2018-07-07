package co.edu.ufps.vivelab.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import co.edu.ufps.vivelab.R;
import co.edu.ufps.vivelab.webService.valueof.RespuestaObject;
import co.edu.ufps.vivelab.webService.connection.ApiAdapter;
import co.edu.ufps.vivelab.webService.valueof.UsuarioValue;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A login screen that offers login via email/password.
 */
public class Login extends AppCompatActivity{


    // UI references.
    private EditText mEmail;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // se  obtiene la instancia compartida del objeto
        mAuth=FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(verificarInicioSesion()){
            finish();
            this.pasarActivity(Inicio.class);
        }else{
            this.cargarEventos();
            this.mEmail=(EditText) findViewById(R.id.email);
            this.mPasswordView = (EditText) findViewById(R.id.password);
            this.mLoginFormView = findViewById(R.id.login_form);
            this.mProgressView = findViewById(R.id.login_progress);
        }

        /*this.cargarEventos();
        this.mEmail=(EditText) findViewById(R.id.email);
        this.mPasswordView = (EditText) findViewById(R.id.password);
        this.mLoginFormView = findViewById(R.id.login_form);
        this.mProgressView = findViewById(R.id.login_progress);*/
    }



    private void attemptLogin() {

        // Reset errors.
        mEmail.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String email = mEmail.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (password.isEmpty() || !isPasswordValid(password)) {
            mPasswordView.setError("La contraseña debe tener mas de 3 caracteres");
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmail.setError("Por favor ingrese un e-mail");
            focusView = mEmail;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            //llamamos al metodo iniciarSesion
           this.iniciarSesion(email, password);
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

    //metodo para pasar a una siquiete activity
    private void pasarActivity(Class clase){
        Intent activity=new Intent(getApplicationContext(),clase);
        startActivity(activity);
    }

    private void iniciarSesion(final String email, final String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //pasamos a la pantalla de inicio

                            UsuarioValue user = new UsuarioValue(email, password, email);
                            user.setTipoUsuario(1);
                            Call<RespuestaObject<UsuarioValue>> call= ApiAdapter.getApiService().login(user);
                            call.enqueue(new LoginCallBack());

                            finish();
                            pasarActivity(Inicio.class);

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(getApplication(),"Error! contraseña o e-mail invalidos",Toast.LENGTH_LONG).show();
                        }

                    }
                });

        /*UsuarioValue user = new UsuarioValue(email, password, email);
        user.setTipoUsuario(1);
        Call<RespuestaObject<UsuarioValue>> call= ApiAdapter.getApiService().login(user);
        call.enqueue(new LoginCallBack());*/

    }

    private boolean verificarInicioSesion(){
        if(mAuth.getCurrentUser()!=null){
            return true;
        }
        return false;
    }

    private void enviarCorreoVerificacion(final String email){
        this.mAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplication(),"Se ha enviado un E-mail" +
                                    " de restablecimiento a "+email,Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(getApplication(),"Error! Se ha presentado un error al enviar" +
                                    "el E-mail de verificación.",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    private void cargarEventos(){
        TextView registro=(TextView) findViewById(R.id.registrate_aqui);
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pasarActivity(Registro.class);
            }
        });

        TextView restablecer_clave=(TextView) findViewById(R.id.restablcer_clave);
        restablecer_clave.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=mEmail.getText().toString().trim();
                if(isEmailValid(email)){
                    enviarCorreoVerificacion(email);
                }else{
                    mEmail.setError("Ingrese un E-mail valido.");
                    ((View)mEmail).requestFocus();
                }
            }
        });

        Button mEmailSignInButton = (Button) findViewById(R.id.boton_inicio_sesion);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

    }

    class LoginCallBack implements Callback<RespuestaObject<UsuarioValue>> {

        @Override
        public void onResponse(Call<RespuestaObject<UsuarioValue>> call, Response<RespuestaObject<UsuarioValue>> response) {
            if(response.isSuccessful()){
                System.out.println(response.body().toString());
                if(response.code() == 200){

                    UsuarioValue usuario = response.body().getData();

                    SharedPreferences settings = getSharedPreferences("Preferencias", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = settings.edit();
                    editor.putInt("estudiante_id", usuario.getPersona_id());
                    editor.putString("token", usuario.getToke());

                    editor.apply();
                    /*finish();
                    pasarActivity(Inicio.class);*/
                }
            }
        }

        @Override
        public void onFailure(Call<RespuestaObject<UsuarioValue>> call, Throwable t) {
            System.out.println("------------------------Ha ocurrido un errror--------------- " + t.getMessage());
        }
    }

}

