package mac.example.firebaseautenticacao;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import mac.example.firebaseautenticacao.util.Util;

public class LoginActivity extends AppCompatActivity {

    private EditText editEmail, editSenha;

    private Button buttonEntrar, buttonRecuperar;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inicializaActivity();

        configuraButtonEntrar();

        configuraButtonRecuperar();

        firebaseAuth = FirebaseAuth.getInstance();
    }

    private void inicializaActivity() {
        editEmail = findViewById(R.id.activity_login_edit_email);
        editSenha = findViewById(R.id.activity_login_edit_senha);

        buttonEntrar = findViewById(R.id.activity_login_button_entrar);
        buttonRecuperar = findViewById(R.id.activity_login_button_recuperar);
    }

    private void configuraButtonEntrar() {
        buttonEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                entra();
            }
        });
    }

    private void entra() {
        String email = editEmail.getText().toString().trim();

        String senha = editSenha.getText().toString().trim();

        if (email.isEmpty() || senha.isEmpty()) {
            Toast.makeText(this, "Preencha os campos.", Toast.LENGTH_SHORT).show();
        } else {
            if (Util.verificaInternet(this)) {
                confirmaUsuario(email, senha);
            } else {
                Toast.makeText(this, "Verifique se sua comexão de Wifi ou 3G está funcionando.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void confirmaUsuario(String email, String senha) {
        firebaseAuth.signInWithEmailAndPassword(email, senha).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    startDashboard();
                } else {
                    String resposta = task.getException().toString();

                    exibeErro(resposta);
                }
            }
        });
    }

    private void startDashboard() {
        Intent intent = new Intent(this, DashboardActivity.class);

        startActivity(intent);

        Toast.makeText(LoginActivity.this, "Usuário logado com sucesso.", Toast.LENGTH_SHORT).show();

        finish();
    }

    private void exibeErro(String resposta) {
        if (resposta.contains("least 6 characters")) {
            Toast.makeText(this, "Digite uma senha maior que 5 caracteres.", Toast.LENGTH_SHORT).show();
        } else if (resposta.contains("address is badly")) {
            Toast.makeText(this, "E-mail inválido.", Toast.LENGTH_SHORT).show();
        } else if (resposta.contains("interrupted connection")) {
            Toast.makeText(this, "Sem conexão com o Firebase.", Toast.LENGTH_SHORT).show();
        } else if (resposta.contains("password is invalid")) {
            Toast.makeText(this, "Senha inválida.", Toast.LENGTH_SHORT).show();
        } else if (resposta.contains("There is no user")) {
            Toast.makeText(this, "E-mail não cadastrado.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, resposta, Toast.LENGTH_SHORT).show();
        }
    }

    private void configuraButtonRecuperar() {
        buttonRecuperar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recupera();
            }
        });
    }

    private void recupera() {
        String email = editEmail.getText().toString().trim();

        if (email.isEmpty()) {
            Toast.makeText(this, "Preencha o campo de e-mail.", Toast.LENGTH_SHORT).show();
        } else {
            enviaEmail(email);
        }
    }

    private void enviaEmail(String email) {
        firebaseAuth.sendPasswordResetEmail(email).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(LoginActivity.this, "Acesse sua caixa de e-mails para redefinir a senha.", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.i("mensagem", e.toString());

                Toast.makeText(LoginActivity.this, "Falha ao enviar e-mail para redefinir a senha.", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
