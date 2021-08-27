package com.example.sesion2_inflate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner sp, sp2;

    //origen de datos
    String[] cuotas = new String[12];

    //Implemetamos un adaptador (vínculo entre spinner y origen de datos).
    ArrayAdapter<String> adaptador;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i = 0; i <= 11; i++) {
            cuotas[i] = String.valueOf(i+1);
        }
        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cuotas); //Dentro del adaptador, primero va el contexto, luego va como nos mostrará la lista y como tercer elemento un arreglo
        sp = findViewById(R.id.spinner);
        sp2 = findViewById(R.id.spinner2); //Estos datos los traemos desde el xml

        sp.setAdapter(adaptador); //Al spinner le asignamos el adaptador.

        //Recuperando los valores del spinner

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) { //En este metodo podemos indicar lo que haremos cuando seleccionemos un elemento de la vista //i hace referencia a la posición o índice de la lista
                //Recuperando el índice
                //Toast.makeText(MainActivity.this, "Index"+i, Toast.LENGTH_SHORT).show();
                String item;
                item = sp.getSelectedItem().toString(); //de esta manera obtenemos el objeto seleccionado y lo guardamos en item
                Toast.makeText(MainActivity.this, "Cuotas: "+item, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) { //En este método podemos indicar que es lo que haremos cuando des marquemos un elemento de la lista

            }
        });
    }
}