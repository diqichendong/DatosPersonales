package com.example.datospersonales;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private EditText[] txts;
    private ImageButton ib1, ib2;
    private SwitchCompat sw;

    private boolean logActivado;
    private int numTxt;
    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txts = new EditText[] {
                findViewById(R.id.txt1),
                findViewById(R.id.txt2),
                findViewById(R.id.txt3),
                findViewById(R.id.txt4)
        };

        ib1 = findViewById(R.id.ib1);
        ib2 = findViewById(R.id.ib2);

        sw = findViewById(R.id.sw);

        ib1.setOnClickListener(view -> clickArriba());
        ib2.setOnClickListener(view -> clickAbajo());
        sw.setOnCheckedChangeListener((compoundButton, b) -> mostrarLog(b));

        txts[0].requestFocus();
        logActivado = false;
        numTxt = txts.length;
        pos = 0;
    }

    private void mostrarLog(boolean b) {
        logActivado = b;
    }

    private void clickAbajo() {
        if (pos != numTxt - 1) {
            pos++;
            txts[pos].requestFocus();

            if (logActivado) Log.d("Último texto", txts[pos - 1].getText().toString());
        }
    }

    private void clickArriba() {
        if (pos != 0) {
            pos--;
            txts[pos].requestFocus();

            if (logActivado) Log.d("Último texto", txts[pos + 1].getText().toString());
        }
    }
}