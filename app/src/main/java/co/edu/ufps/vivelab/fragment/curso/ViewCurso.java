package co.edu.ufps.vivelab.fragment.curso;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import co.edu.ufps.vivelab.R;
import co.edu.ufps.vivelab.fragment.cursos_ofertados.CursosOfertados;
import co.edu.ufps.vivelab.fragment.cursos_ofertados.ReclyclerViewAdapterCursosOfertados;
import co.edu.ufps.vivelab.webService.connection.ApiAdapter;
import co.edu.ufps.vivelab.webService.valueof.ConvocatoriaValue;
import co.edu.ufps.vivelab.webService.valueof.EstudianteConvocatoriaValue;
import co.edu.ufps.vivelab.webService.valueof.RespuestaObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewCurso extends AppCompatActivity {

    private ConvocatoriaValue convocatoriaValue;
    private EditText disponibilidad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_curso);
        this.convocatoriaValue= (ConvocatoriaValue) getIntent().getExtras().getSerializable("convocatoriaValue");
        this.disponibilidad = findViewById(R.id.disponibilidad);
        System.err.println(this.convocatoriaValue);
        //activar el boton de ir hacia atras en el menubar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //colocamos el nombre del convocatoriaValue como titulo
        getSupportActionBar().setTitle(this.convocatoriaValue.getCurso().getNombre());
        this.cargarVista();
    }

    //metodo sobreescrito para activar el boton hacia atras de titleBar
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }

    private void cargarVista(){
        TextView fecha_ini=(TextView) findViewById(R.id.fecha_incio);
        TextView lugar=(TextView) findViewById(R.id.lugar);
        TextView  horario=(TextView) findViewById(R.id.horario);
        TextView  cupos_disponibles=(TextView) findViewById(R.id.cupos_disponibles);
        TextView  descripcion=(TextView) findViewById(R.id.descripcion);
        Button btn_inscribirse=(Button)findViewById(R.id.btn_inscribirme);
        ImageView imagen=(ImageView) findViewById(R.id.imagenCurso);

        fecha_ini.setText(this.convocatoriaValue.getFecha_inicio());
        lugar.setText(this.convocatoriaValue.getLugar());
        horario.setText("Por acordar");
        descripcion.setText(this.convocatoriaValue.getCurso().getDescripcion());
        cupos_disponibles.setText("Sin limites de cupo");

        Picasso.with(this).load("http://192.168.1.3:80/vivelab_web/files/"+ this.convocatoriaValue.getFoto().substring(6, this.convocatoriaValue.getFoto().length())).into(imagen);

        btn_inscribirse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String disp = disponibilidad.getText().toString();
                if(disp.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Debes espeficificar la disponibilidad de tiempo que tienes.",
                            Toast.LENGTH_LONG).show();
                }else{
                    EstudianteConvocatoriaValue estudianteConvocatoria = new EstudianteConvocatoriaValue();
                    estudianteConvocatoria.setDisponibilidad(disp);
                    estudianteConvocatoria.setConvocatoria_id(convocatoriaValue.getId());

                    SharedPreferences settings = getSharedPreferences("Preferencias", Context.MODE_PRIVATE);
                    int estudiante_id = settings.getInt("estudiante_id", 0);

                    estudianteConvocatoria.setEstudiante_id(estudiante_id);

                    Call<RespuestaObject<String>> call = ApiAdapter.getApiService().registrarEnCurso(estudianteConvocatoria);
                    call.enqueue(new IncribirCursoCallBack());
                }
            }
        });
    }

    class IncribirCursoCallBack implements Callback<RespuestaObject<String>> {

        @Override
        public void onResponse(Call<RespuestaObject<String>> call, Response<RespuestaObject<String>> response) {
            System.out.println(response);
            System.out.println(response.body());
            if(response.isSuccessful()){
                if(response.code() == 201){
                    Toast.makeText(getApplicationContext(), "Se ha inscrito en el curso "+
                            convocatoriaValue.getCurso().getNombre(), Toast.LENGTH_LONG).show();
                }else if(response.code() == 409){
                    Toast.makeText(getApplicationContext(), "Ya ha realizado una inscripción al curso "+
                            convocatoriaValue.getCurso().getNombre(), Toast.LENGTH_LONG).show();
                }
            }else{
                Toast.makeText(getApplicationContext(), "Ya ha realizado una inscripción al curso "+
                        convocatoriaValue.getCurso().getNombre(), Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onFailure(Call<RespuestaObject<String>> call, Throwable t) {
            Toast.makeText(getApplicationContext(), "aaaasdasd", Toast.LENGTH_LONG).show();
        }
    }
}
