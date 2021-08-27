package com.example.sesion2_checkbox_radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox chk1, chk2, chk3;
    RadioButton rb1, rb2;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chk1 = findViewById(R.id.checkBox);
        chk2 = findViewById(R.id.checkBox2);
        chk3 = findViewById(R.id.checkBox3);
        rb1 = findViewById(R.id.radioButton);
        rb2 = findViewById(R.id.radioButton2);
        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //seleccion();
                seleccionRadioButton();
            }
        });

        chk2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String valor = "algo";
                chk2(valor);
            }
        });

    }

    public void seleccion() {
        if(!chk1.isChecked() && !chk2.isChecked() && chk3.isChecked()) {
            Toast.makeText(this, "Seleccione al menos una red social", Toast.LENGTH_SHORT).show();
        } else {
            if(chk1.isChecked()) {
                Toast.makeText(this, "Facebook seleccionado", Toast.LENGTH_SHORT).show();
            }
            if (chk2.isChecked()) {
                Toast.makeText(this, "Instagram seleccionado", Toast.LENGTH_SHORT).show();
            }
            if (chk3.isChecked()) {
                Toast.makeText(this, "Twitter seleccionado", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void chk1(View view) { //Este tipo de método lo llamamos directamente desde el activity_main.xml
        if(chk1.isChecked()) {
            Toast.makeText(this, "Hacemos aquí algo cuando seleccionemos facebook", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Hacemos otra cosa cuando se desmarque facebook", Toast.LENGTH_SHORT).show();
        }
    }

    public void chk2(String valor) { //Este tipo de método lo llamamos directamente desde el activity_main.xml
        if(chk2.isChecked()) {
            Toast.makeText(this, "Hacemos algo para cuando seleccionamos instagram"+valor, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Hacemos otra cosa cuando se desmarque instagram", Toast.LENGTH_SHORT).show();
        }
    }

    public void seleccionRadioButton() {
        if (rb1.isChecked()) {
            Toast.makeText(this, "Seleccionó Crédito", Toast.LENGTH_SHORT).show();
        } else if(rb2.isChecked()) {
            Toast.makeText(this,"Seleccionó débito", Toast.LENGTH_SHORT).show();
        }
    }

}