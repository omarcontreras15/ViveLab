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

import java.util.List;

import co.edu.ufps.vivelab.R;
import co.edu.ufps.vivelab.fragment.curso.ViewCurso;
import co.edu.ufps.vivelab.webService.valueof.ConvocatoriaValue;

public class ReclyclerViewAdapterCursosOfertados extends RecyclerView.Adapter<ReclyclerViewAdapterCursosOfertados.ViewHolder>{
    private List<ConvocatoriaValue> cursos;
    private Context context;

    public ReclyclerViewAdapterCursosOfertados(List<ConvocatoriaValue> cursos, Context context) {
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
            holder.nombre_curso.setText(this.cursos.get(position).getCurso().getNombre());
            holder.fecha_ini.setText(this.cursos.get(position).getFecha_inicio());
            holder.lugar.setText(this.cursos.get(position).getLugar());

            holder.btn_informacion_curso.setOnClickListener(new View.OnClickListener() {

                @Override
                //evento de click sobre el boton incribirme en la cardView de cursos ofertados
                public void onClick(View v) {
                    pasarActivity(ViewCurso.class, cursos.get(position));
                }
            });
            //Cargar la imagen con la liberia picasso
            Picasso.with(this.context).load("http://192.168.1.3:80/vivelab_web/files/"+ this.cursos.get(position).getFoto().substring(6, this.cursos.get(position).getFoto().length())).into(holder.imagen);
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

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView fecha_ini,fecha_fin, lugar, nombre_curso;
        private Button btn_informacion_curso;
        private ImageView imagen;
        private LinearLayout layout;

        private ViewHolder(View itemView) {
            super(itemView);
            this.fecha_ini=(TextView) itemView.findViewById(R.id.fecha_ini);
            this.fecha_fin=(TextView) itemView.findViewById(R.id.fecha_fin);
            this.lugar=(TextView) itemView.findViewById(R.id.lugar);
            this.nombre_curso=(TextView) itemView.findViewById(R.id.nombre_curso);
            this.btn_informacion_curso = itemView.findViewById(R.id.btn_informacion_curso);
            this.imagen=(ImageView)itemView.findViewById(R.id.imagenCurso);
            this.layout= (LinearLayout) itemView.findViewById(R.id.layout_imagen_curso);

        }
    }

    //metodo para pasar a una siquiete activity
    private void pasarActivity(Class clase, ConvocatoriaValue convocatoriaValue){
        Bundle bundle=new Bundle();
        bundle.putSerializable("convocatoriaValue", convocatoriaValue);
        Intent activity=new Intent(this.context,clase);
        activity.putExtra("convocatoriaValue", convocatoriaValue);
        this.context.startActivity(activity);
    }

}
