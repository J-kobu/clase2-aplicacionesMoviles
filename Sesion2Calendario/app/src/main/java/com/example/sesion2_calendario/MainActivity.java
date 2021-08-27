package com.example.sesion2_calendario;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView tv1;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.textView);
        btn1 = findViewById(R.id.button);

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarCalendario();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                capturarFecha();
            }
        });
    }

    public void mostrarCalendario() {

        //Primero crear una instancia de la clase calendar que trae el framework de android
        final Calendar calendar = Calendar.getInstance();
        int anio, mes, dia;
        anio = calendar.get(Calendar.YEAR);
        mes = calendar.get(Calendar.MONTH);
        dia = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() { //Este objeto despliega un calendario en la interfaz
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) { //Estas variables corresponden al año, mes y día
                String diaFormulario, mesFormulario, fecha;

                if(dayOfMonth < 10) {
                    diaFormulario = "0" + dayOfMonth; // 01, 02, 03 .... 10, 11, etc  De esta forma guardamos/mostramos la fecha una vez el usuario la seleccionó en el calendario
                } else {
                    diaFormulario = String.valueOf(dayOfMonth);
                }

                if((month+1) < 10) { //+1, porque el calendario gregoriano no empieza desde el mes 1, sino que del mes 0
                    mesFormulario = "0" + (month+1);
                } else {
                    mesFormulario = String.valueOf(month+1);
                }

                fecha = diaFormulario + "-" + mesFormulario + "-" + year;

                tv1.setText(fecha);
            }
        }, anio, mes, dia);

        datePickerDialog.show();
    }

    public void capturarFecha() {
        String cfecha;
        cfecha = tv1.getText().toString();
        Toast.makeText(this, "Fecha capturada: "+cfecha, Toast.LENGTH_LONG).show();
    }
}