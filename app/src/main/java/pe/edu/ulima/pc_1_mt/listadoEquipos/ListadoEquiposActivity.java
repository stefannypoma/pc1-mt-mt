package pe.edu.ulima.pc_1_mt.listadoEquipos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

import adapter.ListadoEquiposAdapter;
import bean.Equipo;
import pe.edu.ulima.pc_1_mt.R;

public class ListadoEquiposActivity extends AppCompatActivity implements ListadoEquiposView,View.OnClickListener {

    ListadoEquiposPresenter mPresenter;

    GridView gdiEquipos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_equipos);

        gdiEquipos = (GridView) findViewById(R.id.gdiEquipos);

        setPresenter(new ListadoEquiposPresenterRemote(this));

        mPresenter.obtenerEquipos();
    }

    @Override
    public void setPresenter(ListadoEquiposPresenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void mostrarListadoEquipos(List<Equipo> equipos) {

        ListadoEquiposAdapter adapter = new ListadoEquiposAdapter(this,equipos);

        gdiEquipos.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {

    }
}
