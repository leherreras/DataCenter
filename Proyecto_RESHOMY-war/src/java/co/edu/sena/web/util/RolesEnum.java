

package co.edu.sena.web.util;



public enum RolesEnum {

    ADMINISTRADOR("Administrador"),
    COLABORADOR("Colaborador"),
    CLIENTE("Cliente");

    private final String role;

    private RolesEnum(String role) {

        this.role = role;

    }

    public String getRule() {
        return this.role;
    }

}
