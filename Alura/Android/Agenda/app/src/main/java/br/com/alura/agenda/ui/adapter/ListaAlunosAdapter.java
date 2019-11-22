package br.com.alura.agenda.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.agenda.R;
import br.com.alura.agenda.model.Aluno;

public class ListaAlunosAdapter extends BaseAdapter {

    private final List<Aluno> alunos = new ArrayList<>();

    private final Context context;

    public ListaAlunosAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return alunos.size();
    }

    @Override
    public Aluno getItem(int position) {
        return alunos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return alunos.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Aluno alunoDevolvido = alunos.get(position);

        View viewCriada = criaView(viewGroup);

        vincula(alunoDevolvido, viewCriada);

        return viewCriada;
    }

    private View criaView(ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.item_aluno, viewGroup, false);
    }

    private void vincula(Aluno aluno, View view) {
        TextView textNome = view.findViewById(R.id.item_aluno_nome);
        textNome.setText(aluno.getNome());

        TextView textTelefone = view.findViewById(R.id.item_aluno_telefone);
        textTelefone.setText(aluno.getTelefone());
    }

    public void atualiza(List<Aluno> alunos) {
        this.alunos.clear();
        this.alunos.addAll(alunos);

        notifyDataSetChanged();
    }

    public void remove(Aluno aluno) {
        alunos.remove(aluno);

        notifyDataSetChanged();
    }

}
