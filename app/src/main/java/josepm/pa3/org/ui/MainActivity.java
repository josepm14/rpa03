package josepm.pa3.org.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import josepm.pa3.org.R;
import josepm.pa3.org.ui.form.FormFragment;

/**
 * Actividad principal que carga los Fragments.
 * Usa un contenedor (FrameLayout) definido en activity_main.xml
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Al iniciar, mostramos el FormFragment
        if (savedInstanceState == null) {
            cargarFragmento(new FormFragment());
        }
    }

    private void cargarFragmento(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}
