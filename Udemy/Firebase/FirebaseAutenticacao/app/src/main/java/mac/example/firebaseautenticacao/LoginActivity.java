package mac.example.firebaseautenticacao;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import com.google.firebase.auth.FirebaseAuthException;

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
                identificaUsuario(email, senha);
            } else {
                Toast.makeText(this, "Verifique se sua comexão de Wifi ou 3G está funcionando.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void identificaUsuario(String email, String senha) {
        firebaseAuth.signInWithEmailAndPassword(email, senha).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
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
        } else if (errorCode.equals("ERROR_USER_NOT_FOUND")) {
            Toast.makeText(this, "E-mail não cadastrado.", Toast.LENGTH_SHORT).show();
        } else if (errorCode.equals("ERROR_WRONG_PASSWORD")) {
            Toast.makeText(this, "Senha incorreta.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, errorCode, Toast.LENGTH_SHORT).show();
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
