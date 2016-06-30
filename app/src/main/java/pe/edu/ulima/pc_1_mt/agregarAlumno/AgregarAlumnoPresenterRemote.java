package pe.edu.ulima.pc_1_mt.agregarAlumno;

import bean.Alumno;
import bean.Equipo;
import pe.edu.ulima.pc_1_mt.login.LoginView;
import pe.edu.ulima.pc_1_mt.login.Message;
import remote.AlumnosService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import pe.edu.ulima.pc_1_mt.login.LoginPresenterRemote;

/**
 * Created by Stefanny on 26/06/2016.
 */

public class AgregarAlumnoPresenterRemote implements AgregarAlumnoPresenter{

    LoginView lview;

    public AgregarAlumnoPresenterRemote(AgregarAlumnoView view){lview=(LoginView) view;}

    @Override
    public void agregarIntegrante(Equipo equipo, Alumno alumno) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://pichangers-api.mybluemix.net")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AlumnosService service = retrofit.create(AlumnosService.class);

        service.agregarIntegrante(equipo, alumno).enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                if((response.body().getMsg()).equals("OK")){
                    lview.check();

                } else {
                    lview.fail(response.body().getMsg());
                }
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {

            }
        });
    }
}
