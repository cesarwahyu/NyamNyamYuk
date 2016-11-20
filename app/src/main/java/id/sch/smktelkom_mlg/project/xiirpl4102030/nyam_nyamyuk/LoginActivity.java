package id.sch.smktelkom_mlg.project.xiirpl4102030.nyam_nyamyuk;

import android.app.ProgressDialog;
import android.content.Intent;
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

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonMasuk;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewDaftar;

    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() != null) {
            //profil activity
            finish();
            startActivity(new Intent(getApplicationContext(), ProfilActivity.class));
        }

        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonMasuk = (Button) findViewById(R.id.buttonMasuk);
        textViewDaftar = (TextView) findViewById(R.id.textViewDaftar);

        progressDialog = new ProgressDialog(this);

        buttonMasuk.setOnClickListener(this);
        textViewDaftar.setOnClickListener(this);
    }

    private void userLogin() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            //email harus diisi
            Toast.makeText(this, " Masukan Email Anda", Toast.LENGTH_SHORT).show();
            //stop eksekusi fungsi
            return;
        }

        if (TextUtils.isEmpty(password)) {
            //password harus diisi
            Toast.makeText(this, " Masukan Password Anda", Toast.LENGTH_SHORT).show();
            //stop eksekusi fungsi
            return;
        }
        //if validasi ok
        //progresbar akan keluar

        progressDialog.setMessage("Mendaftar...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            //start profil activity
                            finish();
                            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {
        if (view == buttonMasuk) {
            userLogin();
        }
        if (view == textViewDaftar) {
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}
