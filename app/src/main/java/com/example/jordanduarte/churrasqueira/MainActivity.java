package com.example.jordanduarte.churrasqueira;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button)findViewById(R.id.calcular)).setOnClickListener(this);
        ((SeekBar)findViewById(R.id.seekHomens)).setOnSeekBarChangeListener(this);
        ((SeekBar)findViewById(R.id.seekMulheres)).setOnSeekBarChangeListener(this);
        ((SeekBar)findViewById(R.id.seekCriancas)).setOnSeekBarChangeListener(this);


    }

    public void onClick(View view) {
        SeekBar qtdHomens = (SeekBar) findViewById(R.id.seekHomens);
        SeekBar qtdMulheres = (SeekBar) findViewById(R.id.seekMulheres);
        SeekBar qtdCriancas = (SeekBar) findViewById(R.id.seekCriancas);
        TextView tvCarne = (TextView) findViewById(R.id.carne);
        TextView tvLinguica = (TextView) findViewById(R.id.linguica);

        int homens = (qtdHomens.getProgress());
        int mulheres = (qtdMulheres.getProgress());
        int criancas = (qtdCriancas.getProgress());

        float carneTotal = (homens * 500 + mulheres * 300 + criancas * 200) / 1000;
        float linguicaTotal = (homens * 450 + mulheres * 250 + criancas * 200) / 1000;

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        tvCarne.setText("Total de Kg CARNE: " + decimalFormat.format(carneTotal));
        tvLinguica.setText("Total de Kg LINGUIÇA: " + decimalFormat.format(carneTotal));
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        try {
            switch (seekBar.getId()) {
                case R.id.seekMulheres:
                    ((TextView) findViewById(R.id.qtdMulheres)).setText(Integer.toString(progress));
                    break;
                case R.id.seekHomens:
                    ((TextView) findViewById(R.id.qtdHomens)).setText(Integer.toString(progress));
                    break;
                case R.id.seekCriancas:
                    ((TextView) findViewById(R.id.qtdCriancas)).setText(Integer.toString(progress));
                    break;
            }
        } catch (Exception e) {
            System.out.println( e.getMessage());
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
