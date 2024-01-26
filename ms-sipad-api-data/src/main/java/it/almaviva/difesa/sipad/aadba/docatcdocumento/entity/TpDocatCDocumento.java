package it.almaviva.difesa.sipad.aadba.docatcdocumento.entity;


import it.almaviva.difesa.sipad.shared.entity.GenericEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;


/**
 * <p>Categoria di documento. Ogni categoria racchiude uno o più tipologie di documenti.</p>
 * <p>Es. di categorie:</p>
 * <p>Lettera</p>
 * <p>Decreto</p>
 * <p>Appunto</p>
 * <p>Nota</p>
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
@EqualsAndHashCode
@Table(name = "tp_docat_cdocumento")
public class TpDocatCDocumento implements Serializable, GenericEntity {

    private static final long serialVersionUID = 6027927514707448778L;

    /**
     * Identificativo categoria di documento
     */
    @Id
    @Column(name = "DOCAT_ID_PK")
    private long id;

    /**
     * Descrizione categoria di documento
     */
    @Column(name = "DOCAT_DESCR_CAT")
    private String descrCat;

    /**
     * Acronimo categoria di documento
     */
    @Column(name = "DOCAT_ACR_CAT")
    private String acrCat;

    /**
     * Data inizio validità
     */
    @Column(name = "DOCAT_DATA_INIZ")
    private Date dataIniz;

    /**
     * Data fine validità
     */
    @Column(name = "DOCAT_DATA_FINE")
    private Date dataFine;

    /**
     * Data inserimento del record
     */
    @Column(name = "DOCAT_DATA_INS")
    private Timestamp dataIns;

    /**
     * data ultimo aggiornamento
     */
    @Column(name = "DOCAT_DATA_ULT_AGG")
    private Timestamp dataUltAgg;

    /**
     * Codice ultimo utente in aggiornamento
     */
    @Column(name = "DOCAT_COD_ULT_AGG")
    private String codUltAgg;
}
