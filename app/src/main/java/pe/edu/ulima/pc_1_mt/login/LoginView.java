package pe.edu.ulima.pc_1_mt.login;

/**
 * Created by w3228 on 18/05/2016.
 */
public interface LoginView {
    public void setPresenter(LoginPresenter presenter);


    public void check();
    public void fail(String sms);

}
