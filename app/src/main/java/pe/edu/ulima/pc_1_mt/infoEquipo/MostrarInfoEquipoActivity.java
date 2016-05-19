package pe.edu.ulima.pc_1_mt.infoEquipo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pe.edu.ulima.pc_1_mt.R;

public class MostrarInfoEquipoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_info_equipo);
        
                lviAlumnos = (ListView) findViewById(R.id.lviAlumnos);

        setPresenter(new ListadoAlumnosPresenterImpl(this));

        mPresenter.obtenerAlumnos();
    }

    @Override
    public void setPresenter(ListadoEquiposPresenter presenter) {
        this.mPresenter= presenter;
    }

    @Override
    public void mostrarListadoAlumnos(List<Alumno> alumnos) {
        ListadoEquiposAdapter adapter = new ListadoEquiposAdapter(this, alumnos);

        lviAlumnos.setAdapter(adapter);
    }



    }
}
