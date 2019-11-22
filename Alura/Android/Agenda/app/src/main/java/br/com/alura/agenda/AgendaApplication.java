package br.com.alura.agenda;

import android.app.Application;

import br.com.alura.agenda.dao.AlunoDAO;
import br.com.alura.agenda.model.Aluno;

/*
    Application é a entidade que mantém o estado global da aplicação. Portanto, é a entidade mais estável do App.
    Application é uma entidade que permite a execução de tarefas uma única vez e se mantém estável enquanto o App não é destruído.
 */
@SuppressWarnings("WeakerAccess")
public class AgendaApplication extends Application {

//    Qualquer tarefa que demanda tempo durante a criação da Application afeta o tempo de exibição da Activity launcher.
    @Override
    public void onCreate() {
        super.onCreate();

        criaAlunosDeTeste();
    }

    private void criaAlunosDeTeste() {
        AlunoDAO dao = new AlunoDAO();
        dao.salva(new Aluno("Alex", "123", "a@gmail.com"));
        dao.salva(new Aluno("Fran", "456", "f@gmail.com"));
    }

}
