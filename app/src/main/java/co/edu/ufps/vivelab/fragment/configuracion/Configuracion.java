package co.edu.ufps.vivelab.fragment.configuracion;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.Toast;

import co.edu.ufps.vivelab.R;
import co.edu.ufps.vivelab.activity.Inicio;


public class Configuracion extends Fragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.view=inflater.inflate(R.layout.fragment_configuracion, container, false);
        this.cargarPreferencias();
        return this.view;
    }


    private void eventoBtnGuardar(){
        FloatingActionButton btnGuardar=(FloatingActionButton)this.view.findViewById(R.id.btn_guardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                guardarPreferencias();
                //Mostramos un msj en Toast notificando que las preferencias se guardaron
                Toast.makeText(getActivity(),"Preferencias Guardadas",Toast.LENGTH_LONG).show();
                //Mandamos a vibrar el movil
                Vibrator vibrador=(Vibrator)getActivity().getSystemService(Context.VIBRATOR_SERVICE);
                vibrador.vibrate(250);
                //Reiniciamos la actividad para reedirigirlo a la pagina de inicio
                Intent activity=new Intent(getActivity(),Inicio.class);
                startActivity(activity);
            }
        });
    }

    private void guardarPreferencias(){

        SharedPreferences config = getActivity().getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor editar = config.edit();

        editar.putBoolean("checkNotificacion",((Switch)this.view.findViewById(R.id.checkNotifiacion)).isChecked());
        editar.commit();
    }

    private void cargarPreferencias(){
        SharedPreferences config = getActivity().getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        boolean notificacion=config.getBoolean("checkNotificacion",false);
        ((Switch)this.view.findViewById(R.id.checkNotifiacion)).setChecked(notificacion);

    }
}
