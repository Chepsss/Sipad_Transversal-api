package it.almaviva.difesa.sipad.aadba.titolario.entity;

import it.almaviva.difesa.sipad.shared.entity.GenericEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.springframework.data.annotation.Immutable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

/**<pre>
 * Titolario dei documenti. È la classificazione prevista per i documenti prodotti. Si articola in :
 * -- - Titolo
 * -- - Classe
 * -- - Sottoclasse
 * -- - Fascicolo
 * -- - Sottofascicolo
 * --
 * -- Il Titolo e la classe sono predefinite, la sottoclasse ed il fascicolo sono definiti dagli utenti.
 * -- La tabella ripropone la struttura utilizzata dal sistema AD-HOC. Va stabilita l'univocità dei dati, la trasversalità o meno rispetto alle AOO della Difesa e la volatilità nel tempo (va gestito uno storico?)
 * --  ';
 * </pre>
 */
@NoArgsConstructor
@Getter
@Entity
@ToString
@Immutable
@Table(name = "TP_DOTIT_TITOLARIO")
public class TpDotitTitolario implements Serializable, GenericEntity {

    private static final long serialVersionUID = -7968945282412923457L;

    @EmbeddedId
    private TitolarioPk id;

    @Column(name = "DOTIT_STAOO_COD")
    private String staooCod;



    /**
     * Descrizione Titolo
     */
    @Column(name = "DOTIT_DESCR_TIT")
    private String descrTit;



    /**
     * Descrizione Classe
     */
    @Column(name = "DOTIT_DESCR_CLA")
    private String descrCla;



    /**
     * Descrizione Sottoclasse
     */
    @Column(name = "DOTIT_DESCR_SOTCLA")
    private String descrSotcla;



    /**
     * Descrizione Fascicolo
     */
    @Column(name = "DOTIT_DESCR_FAS")
    private String descrFas;



    /**
     * Descrizione SottoFascicolo
     */
    @Column(name = "DOTIT_DESCR_SOTFAS")
    private String descrSotfas;

    /**
     * Data inserimento del record
     */
    @Column(name = "DOTIT_DATA_INS")
    private Timestamp dataIns;

    /**
     * Data ultimo aggiornamento
     * -- ';
     */
    @Column(name = "DOTIT_DATA_ULT_AGG")
    private Timestamp dataUltAgg;

    /**
     * Codice ultimo utente in aggiornamento
     */
    @Column(name = "DOTIT_COD_ULT_AGG")
    private String codUltAgg;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TpDotitTitolario that = (TpDotitTitolario) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
