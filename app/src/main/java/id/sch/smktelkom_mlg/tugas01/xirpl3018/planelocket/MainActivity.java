package id.sch.smktelkom_mlg.tugas01.xirpl3018.planelocket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner sppesawat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sppesawat = (Spinner) findViewById(R.id.pesawat);
    }
}
