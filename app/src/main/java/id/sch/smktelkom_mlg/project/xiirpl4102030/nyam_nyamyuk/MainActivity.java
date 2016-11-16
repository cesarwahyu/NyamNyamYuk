package id.sch.smktelkom_mlg.project.xiirpl4102030.nyam_nyamyuk;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonDaftar;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewMasuk;

    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);

        buttonDaftar = (Button) findViewById(R.id.buttonDaftar);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        textViewMasuk = (TextView) findViewById(R.id.textViewMasuk);

        buttonDaftar.setOnClickListener(this);
        textViewMasuk.setOnClickListener(this);
    }

    private void DaftarUser() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            //email harus diisi
            Toast.makeText(this, "Isikan Email Anda", Toast.LENGTH_SHORT).show();
            //stop eksekusi fungsi
            return;
        }

        if (TextUtils.isEmpty(password)) {
            //password harus diisi
            Toast.makeText(this, "Isikan Password Anda", Toast.LENGTH_SHORT).show();
            //stop eksekusi fungsi
            return;
        }
        //if validasi ok
        //progresbar akan keluar

        progressDialog.setMessage("Mendaftar...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //user sukses terdaftar dan masuk
                            //profil activity akan segera keluar
                            Toast.makeText(MainActivity.this, "User Sukses Terdaftar", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Tidak Bisa Mendaftar.. Silahkan Coba Lagi", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {
        if (view == buttonDaftar) {
            DaftarUser();
        }

        if (view == textViewMasuk) {
            //akan membuka login activity
        }
    }
}
