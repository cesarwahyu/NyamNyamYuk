package id.sch.smktelkom_mlg.project.xiirpl4102030.nyam_nyamyuk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class RegistrasiActivity extends AppCompatActivity {

    EditText nama;
    EditText email;
    EditText pass;
    EditText jk;
    RadioButton laki, perem;
    Button ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);

        nama = (EditText) findViewById(R.id.Tnama);
        email = (EditText) findViewById(R.id.Temail);
        pass = (EditText) findViewById(R.id.Tpass);
        laki = (RadioButton) findViewById(R.id.rbLaki);
        perem = (RadioButton) findViewById(R.id.rbPerempuan);
        ok = (Button) findViewById(R.id.bdaftar);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nam = nama.getText().toString();

            }
        });
    }
}
