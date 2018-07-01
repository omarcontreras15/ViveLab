package co.edu.ufps.vivelab.activity;

import android.content.Intent;
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
            mPasswordView.setError("Ingrese por favor una contraseña valida");
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmail.setError("Por favor ingrese un e-mail");
            focusView = mEmail;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mEmail.setError("Ingrese e-mail valido");
            focusView = mEmail;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            //llamamos al metodo iniciarSesion
           this.iniciarSesion(mEmail.getText().toString().trim(), mPasswordView.getText().toString());
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

    private void iniciarSesion(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //pasamos a la pantalla de inicio
                            finish();
                            pasarActivity(Inicio.class);

                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(getApplication(),"Error! contraseña o e-mail invalidos",Toast.LENGTH_LONG).show();
                        }

                    }
                });
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

}

