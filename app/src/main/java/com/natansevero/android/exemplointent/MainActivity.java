package com.natansevero.android.exemplointent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button botaoIntent;
    private Button botaoTela;
    private Button botaoJogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoIntent = (Button) findViewById(R.id.botao_intent);
        botaoTela = (Button) findViewById(R.id.botao_tela);
        botaoJogar = (Button) findViewById(R.id.botao_jogar);

        botaoIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Uri uri = Uri.parse("http://www.twitter.com");
                // Intent implicita
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        botaoTela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                // Intente explicita
                Intent intent = new Intent(MainActivity.this, SegundaActivity.class);
                intent.putExtra("numero", 11);
//                Bundle bundle = new Bundle();
//                bundle.putInt("numero", 12);
//
//                intent.putExtras(bundle);

                startActivity(intent);
            }
        });

        botaoJogar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Random random = new Random();
                int numeroAlea = random.nextInt(2); // 0 => Cara, 1 => Coroa

                Intent intent = new Intent(MainActivity.this, SegundaActivity.class);
                intent.putExtra("numeroMoeda", numeroAlea);

                startActivity(intent);
            }
        });
    }
}
