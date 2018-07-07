package co.edu.ufps.vivelab.fragment.cursos_ofertados;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import co.edu.ufps.vivelab.R;
import co.edu.ufps.vivelab.fragment.curso.fragment.curso.dto.Curso;
import co.edu.ufps.vivelab.webService.valueof.RespuestaObject;
import co.edu.ufps.vivelab.webService.connection.ApiAdapter;
import co.edu.ufps.vivelab.webService.valueof.ConvocatoriaValue;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


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
        this.initCards();
        return this.view;
    }


    private void initCards(){
        Call<RespuestaObject<List<ConvocatoriaValue>>> call = ApiAdapter.getApiService().getConvocatorias();
        call.enqueue(new ListProjetCallBack());
    }

    class ListProjetCallBack implements Callback<RespuestaObject<List<ConvocatoriaValue>>> {

        @Override
        public void onResponse(Call<RespuestaObject<List<ConvocatoriaValue>>> call, Response<RespuestaObject<List<ConvocatoriaValue>>> response) {
            System.out.println(response);
            System.out.println(response.body());
            if(response.isSuccessful()){
                if(response.code() == 200){
                    List<ConvocatoriaValue> convocatorias = response.body().getData();
                    if(reclyclerViewAdapterCursosOfertados == null){
                        reclyclerViewAdapterCursosOfertados = new ReclyclerViewAdapterCursosOfertados(convocatorias, getContext());
                    }
                    recyclerView.setAdapter(reclyclerViewAdapterCursosOfertados);
                }
            }else{
                System.out.println("------------------Ha ocurrido un error-------------------");
            }
        }

        @Override
        public void onFailure(Call<RespuestaObject<List<ConvocatoriaValue>>> call, Throwable t) {
            System.out.println("------------------------Ha ocurrido un errror---------------");
        }
    }
}
