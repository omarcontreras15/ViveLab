package co.edu.ufps.vivelab.fragment.cursos_ofertados;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;

import co.edu.ufps.vivelab.R;
import co.edu.ufps.vivelab.fragment.curso.fragment.curso.dto.Curso;
import co.edu.ufps.vivelab.fragment.curso.ViewCurso;

public class ReclyclerViewAdapterCursosOfertados extends RecyclerView.Adapter<ReclyclerViewAdapterCursosOfertados.ViewHolder>{
    private ArrayList<Curso> cursos;
    private Context context;

    public ReclyclerViewAdapterCursosOfertados( ArrayList<Curso> cursos, Context context) {
        this.cursos =cursos;
        this.context=context;
    }

    @Override
    public ReclyclerViewAdapterCursosOfertados.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_cursos_ofertados,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ReclyclerViewAdapterCursosOfertados.ViewHolder holder, final int position) {
            holder.nombre_curso.setText(this.cursos.get(position).getNombre_curso());
            holder.fecha_ini.setText(this.cursos.get(position).getFecha_ini());
            holder.fecha_fin.setText(this.cursos.get(position).getFecha_fin());
            holder.lugar.setText(this.cursos.get(position).getLugar());
            holder.btn_inscribirse.setOnClickListener(new View.OnClickListener() {

                @Override
                //evento de click sobre el boton incribirme en la cardView de cursos ofertados
                public void onClick(View v) {
                    Toast.makeText(context, "Se ha inscrito en el curso "+
                            cursos.get(position).getNombre_curso(), Toast.LENGTH_LONG).show();
                }
            });
            //Cargar la imagen con la liberia picasso
            Picasso.with(this.context).load(this.cursos.get(position).getUrl_img()).into(holder.imagen);
            holder.layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pasarActivity(ViewCurso.class, cursos.get(position));
                }
            });
    }


    @Override
    public int getItemCount() {
        return this.cursos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView fecha_ini,fecha_fin, lugar, nombre_curso;
        private Button btn_inscribirse;
        private ImageView imagen;
        private LinearLayout layout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.fecha_ini=(TextView) itemView.findViewById(R.id.fecha_ini);
            this.fecha_fin=(TextView) itemView.findViewById(R.id.fecha_fin);
            this.lugar=(TextView) itemView.findViewById(R.id.lugar);
            this.nombre_curso=(TextView) itemView.findViewById(R.id.nombre_curso);
            this.btn_inscribirse=(Button)itemView.findViewById(R.id.btn_inscribirme);
            this.imagen=(ImageView)itemView.findViewById(R.id.imagenCurso);
            this.layout= (LinearLayout) itemView.findViewById(R.id.layout_imagen_curso);

        }
    }

    //metodo para pasar a una siquiete activity
    private void pasarActivity(Class clase, Curso curso){
        Bundle bundle=new Bundle();
        bundle.putSerializable("curso", (Serializable) curso);
        Intent activity=new Intent(this.context,clase);
        activity.putExtra("curso",curso);
        this.context.startActivity(activity);
    }

}
