package pe.edu.ulima.pc_1_mt.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import bean.Alumno;
import butterknife.BindView;
import butterknife.ButterKnife;

import pe.edu.ulima.pc_1_mt.listadoEquipos.ListadoEquiposActivity;
import pe.edu.ulima.pc_1_mt.R;
import retrofit2.Call;
import retrofit2.http.Body;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginView {


    @BindView(R.id.butInscribir)
    Button butInscribir;
    @BindView(R.id.eteUsuario)
    EditText eteUsuario;
    @BindView(R.id.etePassword)
    EditText etePassword;
    LoginPresenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        eteUsuario = (EditText) findViewById(R.id.eteUsuario);
        etePassword = (EditText) findViewById(R.id.etePassword);
        butInscribir = (Button) findViewById(R.id.butInscribir);

        setPresenter(new LoginPresenterRemote(this));

        butInscribir.setOnClickListener(this);
    }

    public void onClick(View v) {

        Alumno alumno = new Alumno();
        alumno.setCodigo(eteUsuario.getText().toString());
        //alumno.setContraseña(etePassword.getText().toString());
        alumno.setContraseña("123");

        mPresenter.obtenerLogin(alumno);


    }


    //@Override
    /*public void obtenerLogin(Alumno alumno) {

        eteUsuario = (EditText) findViewById(R.id.eteUsuario);
        etePassword = (EditText) findViewById(R.id.etePassword);
        butInscribir = (Button) findViewById(R.id.butInscribir);

        String usuario = eteUsuario.getText().toString();
        String password = etePassword.getText().toString();

        if (usuario.equals(alumno.getCodigo())&& password.equals("123")){
            onClick(butInscribir);
        }else {
            Toast.makeText(this, "Login incorrecto", Toast.LENGTH_SHORT).show();
        }

    }*/

    @Override
    public void setPresenter(LoginPresenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void check() {

        Intent intent = new Intent(this,ListadoEquiposActivity.class);
        startActivity(intent);

    }

    @Override
    public void fail(String sms) {
        Toast.makeText(this, "Login incorrecto", Toast.LENGTH_SHORT).show();

    }
}
