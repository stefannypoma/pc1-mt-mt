package pe.edu.ulima.pc_1_mt.login;

import android.util.Log;
import android.widget.AdapterView;

import java.util.List;

import bean.Alumno;
import remote.AlumnosService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class LoginPresenterRemote implements LoginPresenter {

    LoginView lview;

    public LoginPresenterRemote (LoginView view) {this.lview = view;}

    @Override
    public void obtenerLogin(Alumno alumno) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://1-dot-pichangers-1307.appspot.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AlumnosService service = retrofit.create(AlumnosService.class);
        service.login(alumno).enqueue(new Callback<Message>() {
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
