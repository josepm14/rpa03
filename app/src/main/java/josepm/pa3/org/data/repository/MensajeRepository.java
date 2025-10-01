package josepm.pa3.org.data.repository;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import java.util.ArrayList;
import java.util.List;

import josepm.pa3.org.data.model.Mensaje;

/**
 * Repositorio encargado de la interacción con Firebase Firestore.
 * Aquí centralizamos la lógica de acceso a datos.
 */
public class MensajeRepository {

    private final DatabaseReference database;

    public MensajeRepository() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        database = db.getReference("mensajes");
    }

    /**
     * Guarda un mensaje en Firebase Firestore.
     */
    public void guardarMensaje(Mensaje mensaje, OnSaveListener listener) {
        String id = database.push().getKey();
        mensaje.setId(id);
        database.child(id).setValue(mensaje)
                .addOnSuccessListener(aVoid -> listener.onSuccess())
                .addOnFailureListener(listener::onError);
    }

    /**
     * Obtiene todos los mensajes desde Firebase.
     */
    public void obtenerMensajes(OnFetchListener listener) {
        database.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<Mensaje> lista = new ArrayList<>();
                for (DataSnapshot childSnapshot : snapshot.getChildren()) {
                    Mensaje mensaje = childSnapshot.getValue(Mensaje.class);
                    lista.add(mensaje);
                }
                listener.onSuccess(lista);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                listener.onError(error.toException());
            }
        });
    }

    // Interfaces para callbacks
    public interface OnSaveListener {
        void onSuccess();
        void onError(Exception e);
    }

    public interface OnFetchListener {
        void onSuccess(List<Mensaje> mensajes);
        void onError(Exception e);
    }
}
