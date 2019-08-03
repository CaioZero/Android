package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText etAlcool, etGasolina;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etAlcool = findViewById(R.id.etAlcool);
        etGasolina = findViewById(R.id.etGasolina);
        tvResultado = findViewById(R.id.tvResultado);

    }

    public Boolean validarCampo(String Alcool, String Gasolina){
        Boolean camposValidados = true;
        if(Alcool.equals("")|| Alcool==null){
            camposValidados=false;
        }
        if(Gasolina.equals("")|| Gasolina==null){
            camposValidados=false;
        }

        return camposValidados;
    }

    public void calcularPreco(View view){
        //recuperando precos
        String precoAlcool = etAlcool.getText().toString();
        String precoGasolina = etGasolina.getText().toString();

        //validando se os valores estao corretos
        Boolean camposValidados = this.validarCampo(precoAlcool,precoGasolina);
        if(camposValidados){
            this.calcularMelhorPreco(precoAlcool,precoGasolina);
        }else{
            tvResultado.setText("Algum dos valores foi informado de forma incorreta");
        }

    }

    public void calcularMelhorPreco(String alcool, String gasolina){
        //convertendo String para numero
        Double pAlcool = Double.parseDouble(alcool);
        Double pGasolina = Double.parseDouble(gasolina);

        /*Calcular precoAlcool/precoGasolina
            Se resultado for >=0.7, usar alcool
            se nao, gasolina
         */

        Double resultado = pAlcool/pGasolina;
        if(resultado>=0.7){
            tvResultado.setText("Melhor utilizar Gasolina");
        }else{
            tvResultado.setText("Melhor utilizar Alcool");
        }
    }
}
