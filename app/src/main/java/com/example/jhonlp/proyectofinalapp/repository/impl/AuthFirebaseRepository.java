package com.example.jhonlp.proyectofinalapp.repository.impl;

import android.support.annotation.NonNull;

import com.example.jhonlp.proyectofinalapp.domain.model.User;
import com.example.jhonlp.proyectofinalapp.helpers.Callback;
import com.example.jhonlp.proyectofinalapp.repository.IAuthRepository;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class AuthFirebaseRepository implements IAuthRepository {

    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    public AuthFirebaseRepository() {
        this.mAuth = FirebaseAuth.getInstance();
        this.mDatabase = FirebaseDatabase.getInstance().getReference("users");
    }

    @Override
    public void login(String email, String password, final Callback<User> callback) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful() && task.getResult() != null) {
                            FirebaseUser firebaseUser = task.getResult().getUser();
                            mDatabase.child(firebaseUser.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    User user = dataSnapshot.getValue(User.class);
                                    callback.success(user);
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {
                                    callback.error(databaseError.toException());
                                }
                            });
                        }
                    }
                });
    }

    @Override
    public void signUp(final User user, final Callback<User> callback) {
        mAuth.createUserWithEmailAndPassword(user.getEmail(), user.getPassword())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful() && task.getResult() != null) {
                            FirebaseUser firebaseUser = task.getResult().getUser();
                            user.setPassword(null);
                            mDatabase.child(firebaseUser.getUid()).setValue(user)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                callback.success(user);
                                            } else {
                                                callback.error(task.getException());
                                            }
                                        }
                                    });
                        } else {
                            callback.error(task.getException());
                        }
                    }
                });
    }

    @Override
    public void recoverPassword(String email, final Callback<Boolean> callback) {
        mAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            callback.success(true);
                        } else {
                            callback.error(task.getException());
                        }
                    }
                });
    }
}
