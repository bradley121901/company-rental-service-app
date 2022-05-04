package com.example.byblosproject;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

public class Admin extends User {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static final String TAG = "Byblos Project";
    public Admin(){
        super("admin@admin.com",  "admin", "admin", "admin", "admin");
    }

    public void addService(String username, Service service){
        DocumentReference userRef = db.collection("users").document(username);

        userRef.update("services", FieldValue.arrayUnion(service));
    }

    public void editService(){

    }

    public void deleteService(String username, Service service){
        DocumentReference userRef = db.collection("users").document(username);

        userRef.update("services", FieldValue.arrayRemove(service));
    }

    public void deleteBranch(String username){
        db.collection("users").document(username)
                .delete()
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "DocumentSnapshot successfully deleted!");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error deleting document", e);
                    }
                });
    }
}
