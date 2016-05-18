package pe.edu.ulima.pc_1_mt.listadoEquipos;

import android.util.Log;

import java.util.List;

import bean.Equipo;
import remote.EquiposService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Stefanny on 16/05/2016.
 */
public class ListadoEquiposPresenterRemote implements ListadoEquiposPresenter{


    ListadoEquiposView mView;

    public ListadoEquiposPresenterRemote (ListadoEquiposView view){
        mView = view;
    }


    @Override
    public void obtenerEquipos() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://1-dot-pichangers-1307.appspot.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EquiposService service = retrofit.create(EquiposService.class);
        service.obtenerEquipos().enqueue(new Callback<List<Equipo>>() {
            @Override
            public void onResponse(Call<List<Equipo>> call, Response<List<Equipo>> response) {
                List<Equipo> equipos =response.body();
                mView.mostrarListadoEquipos(equipos);
            }

            @Override
            public void onFailure(Call<List<Equipo>> call, Throwable t) {
                Log.e("PC", t.getMessage());
            }
        });

    }
}
