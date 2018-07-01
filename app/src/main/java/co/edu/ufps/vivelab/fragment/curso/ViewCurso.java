package co.edu.ufps.vivelab.fragment.curso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import co.edu.ufps.vivelab.R;
import co.edu.ufps.vivelab.fragment.curso.fragment.curso.dto.Curso;

public class ViewCurso extends AppCompatActivity {

    private Curso curso;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_curso);
        this.curso= (Curso)getIntent().getExtras().getSerializable("curso");
        System.err.println(this.curso);
        //activar el boton de ir hacia atras en el menubar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //colocamos el nombre del curso como titulo
        getSupportActionBar().setTitle(this.curso.getNombre_curso());
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
        TextView fecha_fin=(TextView)findViewById(R.id.fecha_final);
        TextView lugar=(TextView) findViewById(R.id.lugar);
        TextView  horario=(TextView) findViewById(R.id.horario);
        TextView  cupos_disponibles=(TextView) findViewById(R.id.cupos_disponibles);
        TextView  descripcion=(TextView) findViewById(R.id.descripcion);
        Button btn_inscribirse=(Button)findViewById(R.id.btn_inscribirme);
        ImageView imagen=(ImageView) findViewById(R.id.imagenCurso);

        fecha_ini.setText(this.curso.getFecha_ini());
        fecha_fin.setText(this.curso.getFecha_fin());
        lugar.setText(this.curso.getLugar());
        horario.setText(this.curso.getHorario());
        descripcion.setText(this.curso.getDescripcion());
        cupos_disponibles.setText(""+this.curso.getCupos_disponibles());
        Picasso.with(this).load(this.curso.getUrl_img()).into(imagen);

        btn_inscribirse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Se ha inscrito en el curso "+
                        curso.getNombre_curso(), Toast.LENGTH_LONG).show();
            }
        });
    }


}
