

package co.edu.sena.web.util;



public enum NavigatorRulesEnum {

    ADMINISTRADOR("administrador"),
    COLABORADOR("colaborador"),
    CLIENTE("cliente");

    private final String rule;

    private NavigatorRulesEnum(String rule) {

        this.rule = rule;

    }

    public String getRule() {
        return this.rule;
    }

}
