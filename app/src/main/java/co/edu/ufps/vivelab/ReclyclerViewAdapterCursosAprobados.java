package co.edu.ufps.vivelab;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ReclyclerViewAdapterCursosAprobados extends RecyclerView.Adapter<ReclyclerViewAdapterCursosAprobados.ViewHolder>{
    private ArrayList<Curso> cursos;
    private Context context;

    public ReclyclerViewAdapterCursosAprobados(ArrayList<Curso> cursos, Context context) {
        this.cursos =cursos;
        this.context=context;
    }

    @Override
    public ReclyclerViewAdapterCursosAprobados.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_cursos_aprobados,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ReclyclerViewAdapterCursosAprobados.ViewHolder holder, final int position) {
        holder.nombre_curso.setText(this.cursos.get(position).getNombre_curso());
        holder.fecha_terminacion.setText(this.cursos.get(position).getFecha_fin());
        //colocamos un valor aleatorio
        int valor= (int) Math.floor(Math.random()*(100-0+1));
        holder.progressBar.setProgress(valor);
        holder.btn_ver_certificado.setOnClickListener(new View.OnClickListener() {

            @Override
            //evento de click sobre el boton incribirme en la cardView de cursos ofertados
            public void onClick(View v) {
                Toast.makeText(context, "Se ha descargado el certificado de "+
                        cursos.get(position).getNombre_curso(), Toast.LENGTH_LONG).show();
            }
        });
        //Cargar la imagen con la liberia picasso
        Picasso.with(this.context).load(this.cursos.get(position).getUrl_img()).into(holder.imagen);
    }


    @Override
    public int getItemCount() {
        return this.cursos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView fecha_terminacion, nombre_curso;
        private Button btn_ver_certificado;
        private ImageView imagen;
        private ProgressBar progressBar;
        public ViewHolder(View itemView) {
            super(itemView);
            this.fecha_terminacion=(TextView) itemView.findViewById(R.id.fecha_terminacion);
            this.nombre_curso=(TextView) itemView.findViewById(R.id.nombre_curso);
            this.btn_ver_certificado=(Button)itemView.findViewById(R.id.btn_ver_certificado);
            this.imagen=(ImageView)itemView.findViewById(R.id.imagenCurso);
            this.progressBar=(ProgressBar)itemView.findViewById(R.id.progressbar_curso);

        }
    }

}
