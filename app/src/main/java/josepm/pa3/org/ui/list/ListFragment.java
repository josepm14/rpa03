package josepm.pa3.org.ui.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import josepm.pa3.org.R;
import josepm.pa3.org.data.model.Mensaje;
import josepm.pa3.org.data.repository.MensajeRepository;
import josepm.pa3.org.ui.adapter.MensajeAdapter;

/**
 * Fragmento que obtiene los datos de Firebase y los muestra en un RecyclerView.
 */
public class ListFragment extends Fragment {

    private RecyclerView recyclerView;
    private MensajeAdapter adapter;
    private MensajeRepository repository;

    public ListFragment() {}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewMensajes);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        repository = new MensajeRepository();
        cargarMensajes();

        return view;
    }

    private void cargarMensajes() {
        repository.obtenerMensajes(new MensajeRepository.OnFetchListener() {
            @Override
            public void onSuccess(List<Mensaje> mensajes) {
                adapter = new MensajeAdapter(mensajes);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onError(Exception e) {
                Toast.makeText(getContext(), "Error al obtener datos: " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
