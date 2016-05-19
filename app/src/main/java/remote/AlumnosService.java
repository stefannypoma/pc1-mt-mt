package remote;

import java.util.List;

import bean.Alumno;
import pe.edu.ulima.pc_1_mt.login.Message;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface AlumnosService {

    @GET("rest/alumnos")
    Call<List<Alumno>> obtenerAlumnos();

    @POST("rest/alumnos/login")
    Call<Message> login(@Body Alumno alumno);

    @POST("equipos/{id}/{codigo_alumno}")
    Call<Message> agregarIntegrante(@Body Equipo equipo, @Body Alumno alumno);
}
