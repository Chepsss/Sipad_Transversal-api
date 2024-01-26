package it.almaviva.difesa.sipad.aadba.titolario.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Embeddable
public class TitolarioPk implements Serializable {

    private static final long serialVersionUID = -4715866285142783676L;
    /**
     * Codifica del titolo
     */
    @Column(name = "DOTIT_COD_TIT")
    private String codTit;
    /**
     * Codifica della Classe .
     * -- Valorizzato 3 bytes.
     */
    @Column(name = "DOTIT_COD_CLA")
    private String codCla;
    /**
     * Codifica della Sottoclasse.
     * -- Valorizzato 3 bytes.
     */
    @Column(name = "DOTIT_COD_SOTCLA")
    private String codSotcla;
    /**
     * Codifica del Fascicolo.
     */
    @Column(name = "DOTIT_COD_FAS")
    private String codFas;
    /**
     * Codifica del SottoFascicolo.
     */
    @Column(name = "DOTIT_COD_SOTFAS")
    private String codSotfas;
    /**
     * dentifica la versione del titolario adhoc
     */
    @Column(name = "DOTIT_FLAG_VERS")
    private String flagVers;
}
