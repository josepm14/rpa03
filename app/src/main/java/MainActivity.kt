package com.example.pinaresmejiapa03 // Asegúrate de que este sea tu paquete correcto

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.layout.layout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pinaresmejiapa03.R // Importa tu clase R

// Asumiendo que tienes un adaptador para el RecyclerView llamado MessageAdapter
// y una clase de datos llamada Message. Deberás crearlos si no existen.
// Ejemplo de clase de datos (puedes ponerla en otro archivo)
// data class Message(val name: String, val email: String, val message: String)

// Ejemplo de adaptador básico (puedes ponerlo en otro archivo)
/*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MessageAdapter(private val messages: List<Message>) : RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {

    class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.textViewName) // Asume IDs en item_message.xml
        val emailTextView: TextView = itemView.findViewById(R.id.textViewEmail) // Asume IDs en item_message.xml
        val messageTextView: TextView = itemView.findViewById(R.id.textViewMessage) // Asume IDs en item_message.xml
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_message, parent, false) // Asume un layout item_message.xml
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val message = messages[position]
        holder.nameTextView.text = message.name
        holder.emailTextView.text = message.email
        holder.messageTextView.text = message.message
    }

    override fun getItemCount() = messages.size
}
*/

class MainActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etEmail: EditText
    private lateinit var etMessage: EditText
    private lateinit var btnSave: Button
    private lateinit var btnShow: Button
    private lateinit var rvMessages: RecyclerView

    // Lista para almacenar los mensajes (esto es temporal, considera una BD o ViewModel para persistencia)
    private val messageList = mutableListOf<androidx.datastore.core.Message>() // Necesitas crear la clase Message
    private lateinit var messageAdapter: MessageAdapter // Necesitas crear MessageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Infla el layout XML que definiste.
        // Asegúrate de que el nombre del archivo XML sea correcto, por ejemplo "activity_main.xml"
        // y que esté en la carpeta res/layout.
        setContentView(R.layout.activity_main) // Usa el nombre de tu archivo XML aquí

        // Inicializar vistas
        etName = findViewById(R.id.etName)
        etEmail = findViewById(R.id.etEmail)
        etMessage = findViewById(R.id.etMessage)
        btnSave = findViewById(R.id.btnSave)
        btnShow = findViewById(R.id.btnShow)
        rvMessages = findViewById(R.id.rvMessages)

        // Configurar RecyclerView
        // Debes crear MessageAdapter y la clase de datos Message
        // messageAdapter = MessageAdapter(messageList)
        // rvMessages.adapter = messageAdapter
        // rvMessages.layoutManager = LinearLayoutManager(this)

        // Configurar listeners de los botones
        btnSave.setOnClickListener {
            saveMessage()
        }

        btnShow.setOnClickListener {
            showMessages()
        }
    }

    private fun saveMessage() {
        val name = etName.text.toString()
        val email = etEmail.text.toString()
        val messageContent = etMessage.text.toString()

        if (name.isNotEmpty() && email.isNotEmpty() && messageContent.isNotEmpty()) {
            // val newMessage = Message(name, email, messageContent) // Crear instancia de Message
            // messageList.add(newMessage)
            // messageAdapter.notifyItemInserted(messageList.size - 1) // Notificar al adaptador

            // Limpiar campos
            etName.text.clear()
            etEmail.text.clear()
            etMessage.text.clear()

            Toast.makeText(this, "Mensaje guardado", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showMessages() {
        if (messageList.isEmpty()) {
            Toast.makeText(this, "No hay mensajes para mostrar", Toast.LENGTH_SHORT).show()
            return
        }
        // La lógica para "mostrar" los mensajes ya está manejada por el RecyclerView
        // si los datos se agregan a messageList y se notifica al adaptador.
        // Si quieres hacer algo adicional al presionar "Mostrar", como un Log o un Toast diferente:
        Toast.makeText(this, "Mostrando ${messageList.size} mensajes.", Toast.LENGTH_SHORT).show()
        // O podrías, por ejemplo, hacer scroll a la última posición
        // rvMessages.scrollToPosition(messageList.size - 1)
    }
}
