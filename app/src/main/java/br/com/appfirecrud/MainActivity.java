package br.com.appfirecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    //Declarando os componentes da view
    EditText editNome;
    EditText editProfissao;
    Button btnCadastrar;
    Button btnAtualizar;
    Button btnDeletar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNome = findViewById(R.id.editNome);
        editProfissao = findViewById(R.id.editProfissao);

        btnCadastrar = findViewById(R.id.btnCadastrar);
        btnAtualizar = findViewById(R.id.btnAtualizar);
        btnDeletar = findViewById(R.id.btnDeletar);

        DAOConexao dao = new DAOConexao();

        btnCadastrar.setOnClickListener(v ->{
            Pessoa pes = new Pessoa(editNome.getText().toString(), editProfissao.getText().toString());
            dao.add(pes).addOnSuccessListener(suc-> {

                //Exibindo mensagem de sucesso e de erro na tela do aplicativo
                Toast.makeText(this, "Registro Inserido", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->{
                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });

        });

        btnAtualizar.setOnClickListener(v -> {
            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("nome", editNome.getText().toString());
            hashMap.put("profissao", editProfissao.getText().toString());

            dao.update("-MfVX8DZCq_V515v6Dor", hashMap).addOnSuccessListener(suc ->{

            //Exibindo mensagem de sucesso e de erro na tela do aplicativo
                Toast.makeText(this, "Registro Atualizado", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->{
                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });

        });

        btnDeletar.setOnClickListener(v -> {

            dao.remove("-MfVX8DZCq_V515v6Dor").addOnSuccessListener(suc ->{

                //Exibindo mensagem de sucesso e de erro na tela do aplicativo
                Toast.makeText(this, "Registro Removido", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->{
                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });

        });
    }
}