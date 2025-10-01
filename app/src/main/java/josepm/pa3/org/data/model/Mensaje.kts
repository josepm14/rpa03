package josepm.pa3.org.data.model

/**
 * Modelo de datos para los mensajes almacenados en Firebase.
 * Incluye los campos solicitados en el enunciado:
 * - nombre
 * - correo
 * - mensaje
 */
data class Mensaje(
    val id: String = "",      // ID generado en Firebase
    val nombre: String = "",
    val correo: String = "",
    val mensaje: String = ""
)
