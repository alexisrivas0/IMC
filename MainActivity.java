package com.cice.imc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText altura = findViewById(R.id.Altura);
        final EditText peso =  findViewById(R.id.peso);
        Button calcula =  findViewById(R.id.calcula);
        final TextView resultado = findViewById(R.id.resultado);

        calcula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String alturaDada = altura.getText().toString();
                String pesoDado = peso.getText().toString();

                if(!alturaDada.isEmpty()&&!pesoDado.isEmpty()){
                    try{
                        double alturaNum = Double.parseDouble(alturaDada);
                        double pesoNum = Double.parseDouble(pesoDado);

                        double resultadoIMC = (pesoNum / (alturaNum*alturaNum));

                        resultado.setText(String.valueOf(resultadoIMC));

                    }catch(Throwable ex){

                        Toast.makeText(MainActivity.this, "No has introducido numeros",Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this,"No has introducido un numero",Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
