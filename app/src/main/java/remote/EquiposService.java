package remote;

import java.util.List;

import bean.Equipo;
import retrofit2.Call;
import retrofit2.http.GET;


public interface EquiposService {

    @GET("/rest/equipos")
    Call<List<Equipo>> obtenerEquipos();
}
