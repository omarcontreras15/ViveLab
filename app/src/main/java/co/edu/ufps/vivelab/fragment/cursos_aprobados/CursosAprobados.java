package co.edu.ufps.vivelab.fragment.cursos_aprobados;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import co.edu.ufps.vivelab.R;
import co.edu.ufps.vivelab.fragment.curso.fragment.curso.dto.Curso;


public class CursosAprobados extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private ReclyclerViewAdapterCursosAprobados reclyclerViewAdapterCursosAprobados;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.view=inflater.inflate(R.layout.fragment_cursos_aprobados, container, false);
        this.recyclerView=(RecyclerView)view.findViewById(R.id.recycler_view_cursos_aprobados);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(inflater.getContext()));
        this.reclyclerViewAdapterCursosAprobados=new ReclyclerViewAdapterCursosAprobados(this.obtenerCursosOfertados(),getContext());
        this.recyclerView.setAdapter(reclyclerViewAdapterCursosAprobados);
        return this.view;
    }

    private ArrayList<Curso> obtenerCursosOfertados(){

        ArrayList<Curso> cursos=new ArrayList<>();
        Curso curso=new Curso("Adobe Premier","02/04/18", "25/04/18",
                "Auditorio JJ Maldonado", "https://pbs.twimg.com/media/DL-s8HHWkAE7CY3.jpg", "descripcion", "horario", 10);
        cursos.add(curso);
        curso=new Curso("Video Juegos","10/05/18", "12/05/18",
                "UDES", "https://pbs.twimg.com/media/DL-s8HLWsAIQEaG.jpg", "descripcion", "horario", 10);
        cursos.add(curso);

        curso=new Curso("Marketing Digital","23/06/18", "30/06/18",
                "Camara de comercio", "https://pbs.twimg.com/media/DL-s8HNW4AAxQbX.jpg", "descripcion", "horario", 10);
        cursos.add(curso);

        return cursos;
    }

}
