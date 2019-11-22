package mac.example.firebaseautenticacao;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

import mac.example.firebaseautenticacao.util.Util;

public class RegisterActivity extends AppCompatActivity {

    private EditText editEmail, editSenha, editConfirmacao;

    private Button buttonCadastrar, buttonCancelar;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        inicializaActivity();

        configuraButtonCadastrar();

        configuraButtonCancelar();

        firebaseAuth = FirebaseAuth.getInstance();
    }

    private void inicializaActivity() {
        editEmail = findViewById(R.id.activity_register_edit_email);
        editSenha = findViewById(R.id.activity_register_edit_senha);
        editConfirmacao = findViewById(R.id.activity_register_edit_confirmacao);

        buttonCadastrar = findViewById(R.id.activity_register_button_cadastrar);
        buttonCancelar = findViewById(R.id.activity_register_button_cancelar);
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
        String email = editEmail.getText().toString().trim();

        String senha = editSenha.getText().toString().trim();

        String confirmacao = editConfirmacao.getText().toString().trim();

        if (email.isEmpty() || senha.isEmpty() || confirmacao.isEmpty()) {
            Toast.makeText(this, "Preencha os campos.", Toast.LENGTH_SHORT).show();
        } else {
            if (senha.equals(confirmacao)) {
                if (Util.verificaInternet(this)) {
                    criaUsuario(email, senha);
                } else {
                    Toast.makeText(this, "Verifique se sua comexão de Wifi ou 3G está funcionando.", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Senhas diferentes.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void criaUsuario(String email, String senha) {
        firebaseAuth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    startDashboard();
                } else {
                    FirebaseAuthException e = (FirebaseAuthException) task.getException();

                    exibeMensagem(e.getErrorCode());
                }
            }
        });
    }

    private void startDashboard() {
        startActivity(new Intent(this, DashboardActivity.class));

        finish();
    }

    private void exibeMensagem(String errorCode) {
        if (errorCode.equals("ERROR_INVALID_EMAIL")) {
            Toast.makeText(this, "E-mail inválido.", Toast.LENGTH_SHORT).show();
        } else if (errorCode.equals("ERROR_EMAIL_ALREADY_IN_USE")) {
            Toast.makeText(this, "E-mail já cadastrado.", Toast.LENGTH_SHORT).show();
        }else if (errorCode.equals("ERROR_WEAK_PASSWORD")) {
            Toast.makeText(this, "Senha com menos de 6 caracteres.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, errorCode, Toast.LENGTH_SHORT).show();
        }
    }

    private void configuraButtonCancelar() {
        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancela();
            }
        });
    }

    private void cancela() {
        finish();
    }

}
