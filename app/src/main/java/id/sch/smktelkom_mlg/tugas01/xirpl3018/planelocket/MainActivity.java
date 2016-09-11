package id.sch.smktelkom_mlg.tugas01.xirpl3018.planelocket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner sppesawat;
    EditText etNama;
    Button bSubmit;
    RadioButton rbD, rbA;
    CheckBox Dijemput, Diantar, Makanan;
    TextView tvHasil, tvHasil2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sppesawat = (Spinner) findViewById(R.id.pesawat);
        rbD = (RadioButton) findViewById(R.id.radioButtonD);
        rbA = (RadioButton) findViewById(R.id.radioButtonA);
        Dijemput = (CheckBox) findViewById(R.id.Dijemput);
        Diantar = (CheckBox) findViewById(R.id.Diantar);
        Makanan = (CheckBox) findViewById(R.id.Makanan);
        etNama = (EditText) findViewById(R.id.editTextNama);
        bSubmit = (Button) findViewById(R.id.buttonSubmit);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        findViewById(R.id.buttonSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();

            }
        });
    }


    private void doProcess() {
        if (isValid()) {
            String nama = etNama.getText().toString();
            tvHasil.setText("Nama Anda : " + nama);
        }
    }

    private boolean isValid() {
        boolean valid = true;
        String nama = etNama.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama Belum Diisi");
            valid = false;
        } else if (nama.length() < 3) {
            etNama.setError("Nama Minimal 3 Karakter");
            valid = false;
        } else {
            etNama.setError(null);
        }
        return valid;
    }
}
