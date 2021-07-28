package br.com.appfirecrud;


import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class DAOConexao {

    private DatabaseReference databaseReference;

    public DAOConexao(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Pessoa.class.getSimpleName());
    }
    public Task<Void> add(Pessoa p){
        return databaseReference.push().setValue(p);
    }
    public Task<Void> update(String chave, HashMap<String, Object> hashMap){
        return databaseReference.child(chave).updateChildren(hashMap);
    }
    public Task<Void> remove(String key){
        return databaseReference.child(key).removeValue();
    }
}
