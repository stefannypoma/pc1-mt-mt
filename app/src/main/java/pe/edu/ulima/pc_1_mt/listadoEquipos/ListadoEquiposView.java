package pe.edu.ulima.pc_1_mt.listadoEquipos;

import java.util.List;

import bean.Equipo;

/**
 * Created by Stefanny on 16/05/2016.
 */
public interface ListadoEquiposView {

    public void setPresenter(ListadoEquiposPresenter presenter);
    public void mostrarListadoEquipos(List<Equipo> equipos);
}
