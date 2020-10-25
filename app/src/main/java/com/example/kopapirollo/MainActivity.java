package com.example.kopapirollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ImageView gepHp1,gepHp2,gepHp3,hHp1,hHp2,hHp3,valasztas,gepValasztas;
    private Button buttonKo, buttonPapir,buttonOllo;
    private TextView dontetlenek;
    private Toast toast;
    private AlertDialog alertDialog;
    private AlertDialog.Builder builder;
    private String  gepTipp;
    private int gepElet,jatekosElet,dontetlenDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        buttonKo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            valasztas.setImageResource(R.drawable.rock);
                gepTippje();
                if (gepTipp.equals("p")){
                    jatekosEletCsokkentes();
                }
                else if(gepTipp.equals("o")){
                    gepEletCsokkentes();
                }
                else{
                    dontetlenDB++;
                    dontetlenek.setText("Döntetlenek száma: "+dontetlenDB);
                }
            }
        });
        buttonPapir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valasztas.setImageResource(R.drawable.paper);
                gepTippje();
                if (gepTipp.equals("o")){
                    jatekosEletCsokkentes();
                }
                else if(gepTipp.equals("k")){
                    gepEletCsokkentes();
                }
                else{
                    dontetlenDB++;
                    dontetlenek.setText("Döntetlenek száma: "+dontetlenDB);
                }
            }
        });
        buttonOllo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valasztas.setImageResource(R.drawable.scissors);
                gepTippje();
                if (gepTipp.equals("k")){
                    jatekosEletCsokkentes();
                }
                else if(gepTipp.equals("p")){
                    gepEletCsokkentes();
                }
                else{
                    dontetlenDB++;
                    dontetlenek.setText("Döntetlenek száma: "+dontetlenDB);
                }
            }
        });

    }

    private void jatekosEletCsokkentes() {
        switch (jatekosElet){
            case 3:
                hHp3.setImageResource(R.drawable.heart1);
                jatekosElet--;
                break;
            case 2:
                hHp2.setImageResource(R.drawable.heart1);
                jatekosElet--;
                break;
            case 1:
                hHp1.setImageResource(R.drawable.heart1);
                jatekosElet--;

                alertDialog.show();
                break;
            default:
                break;
        }
    }

    private void gepEletCsokkentes() {
        switch (gepElet){
            case 3:
                gepHp1.setImageResource(R.drawable.heart1);
                gepElet--;
                break;
            case 2:
                gepHp2.setImageResource(R.drawable.heart1);
                gepElet--;
                break;
            case 1:
                gepHp3.setImageResource(R.drawable.heart1);
                gepElet--;
                builder.setTitle("Nyertél");
                alertDialog.show();
                break;
            default:
                break;
        }
    }

    private void gepTippje(){
        Random rng = new Random();
        int r= rng.nextInt(3);
        if (r==0){
            gepValasztas.setImageResource(R.drawable.rock);
            gepTipp="k";
        }
        if (r==1){
            gepValasztas.setImageResource(R.drawable.paper);
            gepTipp="p";
        }
        if (r==2){
            gepValasztas.setImageResource(R.drawable.scissors);
            gepTipp="o";
        }

    }

    private void init() {
        gepHp1 = findViewById(R.id.gep_hp1);
        gepHp2 = findViewById(R.id.gep_hp2);
        gepHp3 = findViewById(R.id.gep_hp3);
        hHp1 = findViewById(R.id.h_hp1);
        hHp2 = findViewById(R.id.h_hp2);
        hHp3 = findViewById(R.id.h_hp3);
        buttonKo = findViewById(R.id.koButton);
        buttonPapir = findViewById(R.id.papirButton);
        buttonOllo = findViewById(R.id.olloButton);
        valasztas = findViewById(R.id.valasztasImg);
        gepValasztas= findViewById(R.id.gepvalasztasImg);
        dontetlenek= findViewById(R.id.dontetlen);
        gepElet=3;
        jatekosElet=3;
        dontetlenDB=0;


        builder=new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Szeretnénk-e új játékot?")
                .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        gepElet=3;
                        jatekosElet=3;
                        dontetlenDB=0;
                        gepHp1.setImageResource(R.drawable.heart2);
                        gepHp2.setImageResource(R.drawable.heart2);
                        gepHp3.setImageResource(R.drawable.heart2);
                        hHp1.setImageResource(R.drawable.heart2);
                        hHp2.setImageResource(R.drawable.heart2);
                        hHp3.setImageResource(R.drawable.heart2);


                    }
                })
                .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //kilépés
                        //activity bezárása
                        finish();
                        //felugró ablak bezárása
                        dialog.cancel();
                    }
                })
                .setTitle("Játék vége")
                .setCancelable(false);
        alertDialog=builder.create();
        alertDialog.show();
        toast=Toast.makeText(MainActivity.this,"",Toast.LENGTH_LONG);

    }
}
