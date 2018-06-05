package co.edu.ufps.vivelab;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class CursosOfertados extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private ReclyclerViewAdapterCursosOfertados reclyclerViewAdapterCursosOfertados;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.view=inflater.inflate(R.layout.fragment_cursos_ofertados, container, false);
        this.recyclerView=(RecyclerView)view.findViewById(R.id.recycler_view_cursos_ofertados);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(inflater.getContext()));
        this.reclyclerViewAdapterCursosOfertados=new ReclyclerViewAdapterCursosOfertados(this.obtenerCursosOfertados(),getContext());
        this.recyclerView.setAdapter(reclyclerViewAdapterCursosOfertados);
        return this.view;
    }


    private ArrayList<Curso> obtenerCursosOfertados(){

        ArrayList<Curso> cursos=new ArrayList<>();
        Curso curso=new Curso("Adobe Premier","02/04/18", "25/04/18",
                "Auditorio JJ Maldonado", "https://pbs.twimg.com/media/DL-s8HHWkAE7CY3.jpg", "Para implementar Serializable no tienes que hacer nada más que agregar implements Serializable a la definición de la clase (los tipicos objetos que uno usa por la mayoría ya lo implementan).", "horario", 10);
        cursos.add(curso);
        curso=new Curso("Video Juegos","10/05/18", "12/05/18",
                "UDES", "https://pbs.twimg.com/media/DL-s8HLWsAIQEaG.jpg", "\n" +
                "Si quieres agradecerme, edita tu pregunta para que sería útil para los demás. También (como eres nuevo) te comento que en stackoverflow la forma preferida de agradecer es votar positivo en respuestas o comentarios útiles y/o aceptar respuestas que te solucionaban tu problema. El mejor agradecimiento en todo caso es de publicar preguntas tal cual que respuestas que sirven a la comunidad :) ¡Bienvenido!", "Lunes-Viernes: 6 AM - 8:AM", 10);
        cursos.add(curso);
        curso=new Curso("Robotica","23/06/18", "30/06/18",
                "Camara de comercio", "http://gidis.ufps.edu.co:8088/ProyectoSocial/temp/img/Hackat%C3%B3n%2013%20y%2014%20de%20Octubre.jpg", "descripcion", "horario", 10);
        cursos.add(curso);
        curso=new Curso("Marketing Digital","23/06/18", "30/06/18",
                "Camara de comercio", "https://pbs.twimg.com/media/DL-s8HNW4AAxQbX.jpg", "descripcion", "horario", 10);
        cursos.add(curso);
        curso=new Curso("Marketing Digital","23/06/18", "30/06/18",
                "Corel Draw", "http://www.nortedesantander.gov.co/Portals/0/xBlog/uploads/2017/6/13/IMG_2312.JPG", "descripcion", "horario", 10);
        cursos.add(curso);
        return cursos;
    }


}
