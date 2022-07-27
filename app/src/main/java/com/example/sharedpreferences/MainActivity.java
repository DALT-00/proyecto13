package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText nombres, datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombres=(EditText) findViewById(R.id.et_nombre);
        datos=(EditText) findViewById(R.id.et_datos);
    }

    //Metodo para el boton guardar
    public void Guardar(View view){
        String name = nombres.getText().toString();
        String data = datos.getText().toString();
        if (!name.isEmpty() || !data.isEmpty()){
            //comenzar a usar Sharedprefences
            SharedPreferences preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE);
            SharedPreferences.Editor admin = preferencias.edit();
            admin.putString(name,data);
            admin.commit();
            Toast.makeText(this,"Los datos sean aguardo con exito",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Los campos no se puede quedar vacios",Toast.LENGTH_SHORT).show();
        }


    }

    //Metodo para el boton para recuperar
    public void Recuperar(View view){
        String name = nombres.getText().toString();
        if (!name.isEmpty()){
            //comenzar a usar Sharedprefences
            SharedPreferences preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE);
            String data = preferencias.getString(name,"");

            if (data.length()==0){
                Toast.makeText(this, "No se encontro ningun registro",Toast.LENGTH_SHORT).show();
            }else{
                datos.setText(data);
            }
        }else {
            Toast.makeText(this,"Para recuperar los datos el campo de nombre no puede quedar vacio",Toast.LENGTH_LONG).show();
        }

    }
}