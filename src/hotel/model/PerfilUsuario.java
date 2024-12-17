package hotel.model;

import java.util.ArrayList;
import java.util.List;

public class PerfilUsuario {

    private int id;
    private String perfilUsuario;
    //id 1 = Administrador / 2 = Operador / 3 = Hóspede
    private static List<PerfilUsuario> perfis;

    public PerfilUsuario(int id, String perfilUsuario) {
        this.id = id;
        this.perfilUsuario = perfilUsuario;
    }

    static {
        perfis = new ArrayList<>();
        perfis.add(new PerfilUsuario(1, "Administrador"));
        perfis.add(new PerfilUsuario(2, "Operador"));
        perfis.add(new PerfilUsuario(3, "Hóspede"));
    }

    public static PerfilUsuario getPerfilById(int id) {
        for (PerfilUsuario perfil : perfis) {
            if (perfil.getId() == id) {
                return perfil;
            }
        }
        return null;
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
