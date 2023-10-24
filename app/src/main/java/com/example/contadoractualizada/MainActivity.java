package com.example.contadoractualizada;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button aumenta;
    private Button decrementa;
    private CheckBox checkActivo;
    private EditText numeroResetea;
    private Button resetea;
    private TextView resultado;

    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aumenta = findViewById(R.id.buttonAumenta);
        decrementa = findViewById(R.id.buttonDecrementa);
        checkActivo = findViewById(R.id.checkNegativos);
        numeroResetea = findViewById(R.id.editTextNumeroResetea);
        resetea = findViewById(R.id.buttonResetea);
        resultado = findViewById(R.id.textViewResultado);

        aumenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador++;
                updateResult();
            }
        });

        decrementa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkActivo.isChecked() || contador > 0) {
                    contador--;
                    updateResult();
                }
            }
        });

        resetea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numero = numeroResetea.getText().toString();
                if (!numero.isEmpty()) {
                    contador = Integer.parseInt(numero);
                    updateResult();
                }else{
                    contador = 0;
                }
            }
        });
    }

    private void updateResult() {
        resultado.setText(String.valueOf(contador));

    }
}