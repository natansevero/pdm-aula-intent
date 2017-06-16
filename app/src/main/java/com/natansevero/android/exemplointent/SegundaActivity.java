package com.natansevero.android.exemplointent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {

    private Button botaoVoltar;
    private ImageView imagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        int numero = getIntent().getExtras().getInt("numero");
        TextView text = (TextView) findViewById(R.id.texto_id);
        text.setText(""+numero);

        int numeroMoeda = getIntent().getExtras().getInt("numeroMoeda");
        imagem = (ImageView) findViewById(R.id.imagem);
        if(numeroMoeda == 0){
            imagem.setImageResource(R.drawable.moeda_cara);
        } else {
            imagem.setImageResource(R.drawable.moeda_coroa);
        }

        // Voltar Pra tela anterior
        botaoVoltar = (Button) findViewById(R.id.botao_voltar);
        botaoVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
