package com.example.alcoolougasolina;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textResultado;
    EditText editPrecoAlcool;
    EditText editPrecoGasolina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.tietPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.tietPrecoGasolina);
        textResultado = findViewById(R.id.tvResultado);
    }

    public void calcular(View view){

        //Recuperar Valores digitados
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        //Validar
        Boolean camposValidados = validarCampos(precoAlcool ,precoGasolina);
        if(camposValidados){
            calcularMelhorPreco(precoAlcool, precoGasolina);
        }else{
            textResultado.setText("Preencha o(s) preço(s) primeiro!");
        }
    }

    public void calcularMelhorPreco(String pAlcool, String pGasolina){
        Double precoAlcool = Double.parseDouble(pAlcool);
        Double precoGasolina = Double.parseDouble(pGasolina);

        if((precoAlcool/precoGasolina) <= 0.7){
            this.textResultado.setText("Melhor abastecer com Álcool!");
        }
        else{
            this.textResultado.setText("Melhor abastecer com Gasolina!");
        }
    }

    public Boolean validarCampos(String pAlcool, String pGasolina){
        Boolean camposValidados = true;

        //Validando os campos
        if(pAlcool==null || pAlcool.equals(""))
            camposValidados = false;

        else if(pGasolina==null || pGasolina.equals(""))
            camposValidados = false;

        return camposValidados;
    }
}
