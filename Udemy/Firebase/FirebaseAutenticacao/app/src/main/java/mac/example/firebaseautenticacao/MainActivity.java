package mac.example.firebaseautenticacao;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private Button buttonAutenticar, buttonCadastrar;

    private FirebaseAuth firebaseAuth;

    private FirebaseAuth.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializaActivity();

        configuraButtonAutenticar();

        configuraButtonCadastrar();

        firebaseAuth = FirebaseAuth.getInstance();

        exibeEstado();
    }

    private void inicializaActivity() {
        buttonAutenticar = findViewById(R.id.activity_main_button_autenticar);
        buttonCadastrar = findViewById(R.id.activity_main_button_cadastrar);
    }

    private void configuraButtonAutenticar() {
        buttonAutenticar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                autentica();
            }
        });
    }

    private void autentica() {
        FirebaseUser user = firebaseAuth.getCurrentUser();

        if (user == null) {
            startActivity(new Intent(this, LoginActivity.class));
        } else {
            startActivity(new Intent(this, DashboardActivity.class));
        }
    }

    private void configuraButtonCadastrar() {
        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastra();
            }
        });
    }

    private void cadastra() {
        startActivity(new Intent(this, RegisterActivity.class));
    }

    private void exibeEstado() {
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                
                if (user != null) {
                    Toast.makeText(MainActivity.this, user.getEmail() + " está logado.", Toast.LENGTH_SHORT).show();
                }
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();

        firebaseAuth.addAuthStateListener(authStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();

        if (authStateListener != null) {
            firebaseAuth.removeAuthStateListener(authStateListener);
        }
    }

}
