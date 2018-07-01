package co.edu.ufps.vivelab.fragment.editar_usuario;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import co.edu.ufps.vivelab.R;


public class EditarUsuario extends Fragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.view=inflater.inflate(R.layout.fragment_editar_usuario, container, false);
        return this.view;
    }



}
