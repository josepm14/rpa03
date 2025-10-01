package josepm.pa3.org.ui.form;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import josepm.pa3.org.R;
import josepm.pa3.org.data.model.Mensaje;
import josepm.pa3.org.data.repository.MensajeRepository;
import josepm.pa3.org.ui.list.ListFragment;

/**
 * Fragmento que muestra un formulario con los campos:
 * nombre, correo, mensaje.
 * Al presionar Guardar → almacena en Firebase.
 * Al presionar Mostrar → abre ListFragment con el listado de mensajes.
 */
public class FormFragment extends Fragment {

    private EditText etNombre, etCorreo, etMensaje;
    private Button btnGuardar, btnMostrar;

    private MensajeRepository repository;

    public FormFragment() {
        // Constructor vacío requerido
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form, container, false);

        etNombre = view.findViewById(R.id.etNombre);
        etCorreo = view.findViewById(R.id.etCorreo);
        etMensaje = view.findViewById(R.id.etMensaje);
        btnGuardar = view.findViewById(R.id.btnGuardar);
        btnMostrar = view.findViewById(R.id.btnMostrar);

        repository = new MensajeRepository();

        // Acción botón Guardar
        btnGuardar.setOnClickListener(v -> guardarEnFirebase());

        // Acción botón Mostrar
        btnMostrar.setOnClickListener(v -> abrirListFragment());

        return view;
    }

    /**
     * Valida los campos y guarda en Firebase.
     */
    private void guardarEnFirebase() {
        String nombre = etNombre.getText().toString().trim();
        String correo = etCorreo.getText().toString().trim();
        String mensaje = etMensaje.getText().toString().trim();

        if (TextUtils.isEmpty(nombre) || TextUtils.isEmpty(correo) || TextUtils.isEmpty(mensaje)) {
            Toast.makeText(getContext(), "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
            return;
        }

        Mensaje nuevoMensaje = new Mensaje("", nombre, correo, mensaje);
        repository.guardarMensaje(nuevoMensaje, new MensajeRepository.OnSaveListener() {
            @Override
            public void onSuccess() {
                Toast.makeText(getContext(), "Mensaje guardado correctamente", Toast.LENGTH_SHORT).show();
                limpiarCampos();
            }

            @Override
            public void onError(Exception e) {
                Toast.makeText(getContext(), "Error al guardar: " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    /**
     * Abre el ListFragment para mostrar los mensajes guardados.
     */
    private void abrirListFragment() {
        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new ListFragment())
                .addToBackStack(null)
                .commit();
    }

    /**
     * Limpia los campos del formulario después de guardar.
     */
    private void limpiarCampos() {
        etNombre.setText("");
        etCorreo.setText("");
        etMensaje.setText("");
    }
}
