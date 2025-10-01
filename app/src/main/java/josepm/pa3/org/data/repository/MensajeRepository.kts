package josepm.pa3.org.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import josepm.pa3.org.data.model.Mensaje
import kotlinx.coroutines.tasks.await

/**
 * Repositorio encargado de interactuar con Firebase Firestore.
 * Implementa funciones suspend (coroutines) para guardar y leer datos.
 */
class MensajeRepository {

    private val db = FirebaseFirestore.getInstance()
    private val collection = db.collection("mensajes") // Nombre de la colección en Firestore

    /**
     * Guarda un mensaje en Firebase Firestore.
     * @param mensaje Objeto Mensaje a guardar.
     */
    suspend fun guardarMensaje(mensaje: Mensaje) {
        val docRef = collection.document()
        val mensajeConId = mensaje.copy(id = docRef.id)
        docRef.set(mensajeConId).await()
    }

    /**
     * Obtiene todos los mensajes almacenados en Firestore.
     * @return Lista de mensajes.
     */
    suspend fun obtenerMensajes(): List<Mensaje> {
        val snapshot = collection.get().await()
        return snapshot.documents.mapNotNull { it.toObject(Mensaje::class.java) }
    }
}
