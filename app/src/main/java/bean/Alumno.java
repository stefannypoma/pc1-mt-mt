package bean;


public class Alumno {

    private String codigo;
    private String contraseña;

    public Alumno(String codigo, String contraseña) {
        this.codigo = codigo;
        this.contraseña = contraseña;
    }

    public Alumno() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
