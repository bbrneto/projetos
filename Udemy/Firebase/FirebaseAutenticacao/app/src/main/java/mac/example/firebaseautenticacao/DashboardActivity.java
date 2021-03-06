package mac.example.firebaseautenticacao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DashboardActivity extends AppCompatActivity {

    private Button buttonSair;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        inicializaActivity();

        configuraButtonSair();

        firebaseAuth = FirebaseAuth.getInstance();
    }

    private void inicializaActivity() {
        buttonSair = findViewById(R.id.activity_dashboard_button_sair);
    }

    private void configuraButtonSair() {
        buttonSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sai();
            }
        });
    }

    private void sai() {
        firebaseAuth.signOut();

        finish();
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser user = firebaseAuth.getCurrentUser();

        if (user == null) {
            startLoginActivity();
        } else {
            Toast.makeText(this, "Olá, " + user.getEmail() + "!", Toast.LENGTH_SHORT).show();
        }
    }

    private void startLoginActivity() {
        startActivity(new Intent(this, LoginActivity.class));

        finish();
    }

}
