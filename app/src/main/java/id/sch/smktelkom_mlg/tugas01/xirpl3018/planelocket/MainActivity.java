package id.sch.smktelkom_mlg.tugas01.xirpl3018.planelocket;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner pesawat;
    EditText etNama;
    Button bSubmit;
    RadioButton rbD, rbA;
    CheckBox Dijemput, Diantar, Makanan;
    TextView tvHasil, tvHasil2, tvHasil3, tvHasil4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pesawat = (Spinner) findViewById(R.id.pesawat);
        rbD = (RadioButton) findViewById(R.id.radioButtonD);
        rbA = (RadioButton) findViewById(R.id.radioButtonA);
        Dijemput = (CheckBox) findViewById(R.id.Dijemput);
        Diantar = (CheckBox) findViewById(R.id.Diantar);
        Makanan = (CheckBox) findViewById(R.id.Makanan);
        etNama = (EditText) findViewById(R.id.editTextNama);
        bSubmit = (Button) findViewById(R.id.buttonSubmit);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvHasil2 = (TextView) findViewById(R.id.textViewHasil2);
        tvHasil3 = (TextView) findViewById(R.id.textViewHasil3);
        tvHasil4 = (TextView) findViewById(R.id.textViewHasil4);
        Makanan = (CheckBox) findViewById(R.id.Makanan);
        Diantar = (CheckBox) findViewById(R.id.Diantar);
        Dijemput = (CheckBox) findViewById(R.id.Dijemput);

        findViewById(R.id.buttonSubmit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();

            }
        });
    }


    private void doProcess() {
        String hasil = null;
        if (rbA.isChecked()) {
            hasil = rbA.getText().toString();
        } else if (rbD.isChecked()) {
            hasil = rbD.getText().toString();
        }

        if (hasil == null) {
            tvHasil2.setText("Belum Memilih Jenis Kursi");
        } else {
            tvHasil2.setText("Jenis Kursi Anda : " + hasil);
        }

        String x = "Pelayanan Anda : ";
        int startlen = x.length();
        if (Makanan.isChecked())
            x += Makanan.getText() + " ";
        if (Diantar.isChecked())
            x += Diantar.getText() + " ";
        if (Dijemput.isChecked())
            x += Dijemput.getText() + " ";

        if (x.length() == startlen)
            x += "Pelayanan Anda Ekonomis";

        tvHasil3.setText(x);

        tvHasil4.setText("Maskapai Anda : " + pesawat.getSelectedItem().toString());

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
