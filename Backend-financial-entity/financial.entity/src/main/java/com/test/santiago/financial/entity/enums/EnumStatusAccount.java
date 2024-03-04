
package com.test.santiago.financial.entity.enums;

/**
 * Descripción enumeracion para tipo de movimiento
 *
 * @author santiago.montoya@f2x.com.co
 * @version 1.0
 * @since 10/03/2023
 */
public enum EnumStatusAccount {
    ACTIVE(0L, "Activa"),
    INACTIVE(1L, "Inactiva"),
    CANCELED(2L, "Cancelada");

    private final Long id;
    private final String name;

    EnumStatusAccount(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {

        return id;
    }

    public String getName() {

        return name;
    }
    public static EnumStatusAccount findById(Long idDocumentType) {

        EnumStatusAccount aRet = null;

        for (EnumStatusAccount state : EnumStatusAccount.values()) {
            if (state.getId() == idDocumentType) {
                aRet = state;
                break;
            }
        }

        return aRet;
    }
}
