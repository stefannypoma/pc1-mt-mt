package pe.edu.ulima.pc_1_mt.agregarAlumno;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pe.edu.ulima.pc_1_mt.R;

public class AgregarAlumnoActivity extends AppCompatActivity implements AgregarAlumnoView{

    AgregarAlumnoPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_alumno);



    }

    @Override
    public void setPresenter(AgregarAlumnoPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void check() {

    }

    @Override
    public void fail(String sms) {

    }
}
