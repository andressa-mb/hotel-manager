package senacuc15.etapa;

public class PerfilUsuario {

    private int id;
    private String perfilUsuario;
    //id 1 = Administrador / 2 = Operador / 3 = Hóspede

    public PerfilUsuario(int id, String perfilUsuario) {
        this.id = id;
        this.perfilUsuario = perfilUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPerfilUsuario() {
        return perfilUsuario;
    }

    public void setPerfilUsuario(String perfilUsuario) {
        this.perfilUsuario = perfilUsuario;
    }

}
