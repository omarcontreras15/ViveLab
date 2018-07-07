package co.edu.ufps.vivelab.fragment.editar_usuario;


import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Calendar;

import co.edu.ufps.vivelab.R;
import co.edu.ufps.vivelab.activity.Registro;


public class EditarUsuario extends Fragment {
    private View view;
    private Button boton_cambiar_clave;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        this.view = inflater.inflate(R.layout.fragment_editar_usuario, container, false);
        this.cargarBotonCalendario();
        this.cargarEventos();
        return this.view;
    }

    private void cargarEventos() {
        this.boton_cambiar_clave = (Button) this.view.findViewById(R.id.boton_cambiar_clave);
        this.boton_cambiar_clave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext());
                builder1.setTitle("Cambiar Contraseña");

                // configuramos el input que tendra el AlertDialog
                final EditText input1 = new EditText(getContext());
                // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input1.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                builder1.setView(input1);

                //se configura el codigo que se ejecuta si se da clic en el boton cambiar
                builder1.setPositiveButton("Cambiar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                        AlertDialog.Builder builder2 = new AlertDialog.Builder(getContext());
                        builder2.setTitle("Confirmar Contraseña");

                        // Set up the input
                        final EditText input2 = new EditText(getContext());
                        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                        input2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                        builder2.setView(input2);

                        // Set up the buttons
                        builder2.setPositiveButton("Cambiar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(input1.getText().toString().equals(input2.getText().toString())){
                                    System.out.print("se cambio la contraseña");
                                }else{
                                    System.out.println("Error al cambiar");
                                }
                            }
                        });
                        builder2.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                        builder2.show();


                    }
                });
                //se configura el codigo que se ejecuta si se da clic en el boton cancelar
                builder1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder1.show();
            }
        });

    }

    //Este metodo se encargar de cargar el DatePicker en el formulario de registro
    private void cargarBotonCalendario() {

        ImageView btn = (ImageView) this.view.findViewById(R.id.btn_calendario);
        final EditText fechaNacimiento = (EditText) this.view.findViewById(R.id.fecha_nacimiento);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar = Calendar.getInstance();
                int anio = calendar.get(Calendar.YEAR);
                int mes = calendar.get(Calendar.MONTH);
                int dia = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePicker = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        fechaNacimiento.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, anio, mes, dia);

                datePicker.show();
            }
        });

    }
}