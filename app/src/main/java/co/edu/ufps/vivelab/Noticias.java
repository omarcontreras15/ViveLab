package co.edu.ufps.vivelab;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Noticias extends Fragment {
    private View view;
    private RecyclerViewAdapterFacebook recyclerViewAdapterFacebook;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_noticias, container, false);

        this.recyclerView=(RecyclerView)view.findViewById(R.id.recycler_view_facebook);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(inflater.getContext()));
        RecyclerViewAdapterFacebook recyclerViewAdapterFacebook =new RecyclerViewAdapterFacebook();
        recyclerViewAdapterFacebook.agregarPublicacion("2F1020011878147143");
        recyclerViewAdapterFacebook.agregarPublicacion("2F958110501003948");
        recyclerViewAdapterFacebook.agregarPublicacion("2F1021759644639033");
        recyclerViewAdapterFacebook.agregarPublicacion("2F1021636377984693");

        this.recyclerView.setAdapter(recyclerViewAdapterFacebook);
        return view;
    }



}