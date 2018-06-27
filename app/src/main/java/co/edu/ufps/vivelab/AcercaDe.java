package co.edu.ufps.vivelab;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Date;


public class AcercaDe extends Fragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_acerca_de, container, false);
        Date date=new Date();
        ((TextView)view.findViewById(R.id.fecha_acerca_de)).setText(""+(date.getYear()+1900));

        //activar evento del boton.
        ((FloatingActionButton)view.findViewById(R.id.btn_enviar_email)).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //redirigimos al usuario a su cliente de correo y le indicamos
                        // el correo de soporte tecnico y el asunto del correo
                        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                                "mailto", "vivelabcucuta@ufps.edu.co", null));
                        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Soporte Tecnico ViveLab");
                        startActivity(Intent.createChooser(emailIntent, null));
                    }
                }
        );
        return view;
    }



}
