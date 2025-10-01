package josepm.pa3.org.data.model;

/**
 * Modelo de datos que representa un mensaje en Firebase.
 * Incluye los campos solicitados en el enunciado:
 * - nombre
 * - correo
 * - mensaje
 */
public class Mensaje {

    private String id;
    private String nombre;
    private String correo;
    private String mensaje;

    // Constructor vacío requerido por Firebase
    public Mensaje() {}

    public Mensaje(String id, String nombre, String correo, String mensaje) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.mensaje = mensaje;
    }

    // Getters y setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }
}
