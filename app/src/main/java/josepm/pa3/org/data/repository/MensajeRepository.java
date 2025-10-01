package josepm.pa3.org.data.repository;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

import josepm.pa3.org.data.model.Mensaje;

/**
 * Repositorio encargado de la interacción con Firebase Firestore.
 * Aquí centralizamos la lógica de acceso a datos.
 */
public class MensajeRepository {

    private final CollectionReference collection;

    public MensajeRepository() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        collection = db.collection("mensajes");
    }

    /**
     * Guarda un mensaje en Firebase Firestore.
     */
    public void guardarMensaje(Mensaje mensaje, OnSaveListener listener) {
        String id = collection.document().getId();
        mensaje.setId(id);
        collection.document(id).set(mensaje)
                .addOnSuccessListener(aVoid -> listener.onSuccess())
                .addOnFailureListener(listener::onError);
    }

    /**
     * Obtiene todos los mensajes desde Firebase.
     */
    public void obtenerMensajes(OnFetchListener listener) {
        collection.get()
                .addOnSuccessListener(queryDocumentSnapshots -> {
                    List<Mensaje> lista = new ArrayList<>();
                    for (QueryDocumentSnapshot doc : queryDocumentSnapshots) {
                        Mensaje mensaje = doc.toObject(Mensaje.class);
                        lista.add(mensaje);
                    }
                    listener.onSuccess(lista);
                })
                .addOnFailureListener(listener::onError);
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
