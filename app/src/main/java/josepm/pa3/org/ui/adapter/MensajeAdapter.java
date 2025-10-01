package josepm.pa3.org.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import josepm.pa3.org.R;
import josepm.pa3.org.data.model.Mensaje;

/**
 * Adapter para mostrar mensajes en el RecyclerView.
 */
public class MensajeAdapter extends RecyclerView.Adapter<MensajeAdapter.MensajeViewHolder> {

    private final List<Mensaje> listaMensajes;

    public MensajeAdapter(List<Mensaje> listaMensajes) {
        this.listaMensajes = listaMensajes;
    }

    @NonNull
    @Override
    public MensajeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_mensaje, parent, false);
        return new MensajeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MensajeViewHolder holder, int position) {
        Mensaje mensaje = listaMensajes.get(position);
        holder.tvNombre.setText("Nombre: " + mensaje.getNombre());
        holder.tvCorreo.setText("Correo: " + mensaje.getCorreo());
        holder.tvMensaje.setText("Mensaje: " + mensaje.getMensaje());
    }

    @Override
    public int getItemCount() {
        return listaMensajes.size();
    }

    static class MensajeViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre, tvCorreo, tvMensaje;

        public MensajeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvCorreo = itemView.findViewById(R.id.tvCorreo);
            tvMensaje = itemView.findViewById(R.id.tvMensaje);
        }
    }
}
