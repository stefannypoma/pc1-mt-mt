package pe.edu.ulima.pc_1_mt.infoEquipo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

import adapter.ListadoEquiposAdapter;
import bean.Alumno;
import bean.Equipo;
import pe.edu.ulima.pc_1_mt.R;
import pe.edu.ulima.pc_1_mt.listadoEquipos.ImageAdapter;
import pe.edu.ulima.pc_1_mt.listadoEquipos.ListadoEquiposPresenter;
import pe.edu.ulima.pc_1_mt.listadoEquipos.ListadoEquiposPresenterRemote;
import pe.edu.ulima.pc_1_mt.listadoEquipos.ListadoEquiposView;


public class MostrarInfoEquipoActivity extends AppCompatActivity  implements ListadoEquiposView{

    ListView lviEquipos;
    ListadoEquiposPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_info_equipo);
        
               // lviAlumnos = (ListView) findViewById(R.id.lviAlumnos);

        setPresenter(new ListadoEquiposPresenterRemote(this));

        mPresenter.obtenerEquipos();
    }

    @Override
    public void setPresenter(ListadoEquiposPresenter presenter) {
        this.mPresenter= presenter;
    }

    @Override
    public void mostrarListadoEquipos(List<Equipo> equipos) {
        //ImageAdapter adapter = new ImageAdapter(this, equipos);

    }

    //@Override
    public void mostrarListadoAlumnos(List<Alumno> alumnos) {
        //ListadoEquiposAdapter adapter = new ListadoEquiposAdapter(this, alumnos);

        //lviAlumnos.setAdapter(adapter);
    }



    }

