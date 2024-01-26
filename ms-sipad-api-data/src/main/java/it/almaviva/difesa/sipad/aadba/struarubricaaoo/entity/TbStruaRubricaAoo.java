package it.almaviva.difesa.sipad.aadba.struarubricaaoo.entity;


import it.almaviva.difesa.sipad.shared.entity.GenericEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Setter(AccessLevel.NONE)
@Entity
@ToString
@Table(name = "TB_STRUA_RUBRICA_AOO")
/**
 * ono i dati relativi alla rubrica di una  AOO della Difesa, così come ciascuna AOO l''ha configurata.
 * -- La tabella viene allineata a partire dall''analoga tabella presente nel sistema AD-HOC - RUBRICA scaricata periodicamente tramite il servizio GetReceiverList attivato per le AOO di interesse.
 */
public class TbStruaRubricaAoo implements Serializable, GenericEntity {

    /**
     * Codice dell''AOO di riferimento
     */
    @Column(name = "STRUA_STAOO_COD_PK")
    private String staooCodPk;

    /**
     * Identificativo del nominativo in rubrica
     */
    @Id
    @Column(name = "STRUA_ID_PK")
    private Long idPk;

    /**
     * Denominazione  Nominativo.
     */
    @Column(name = "STRUA_DENOM_NOM")
    private String denomNom;

    /**
     * Descrizione indirizzo
     */
    @Column(name = "STRUA_IND_VIA")
    private String indVia;

    /**
     * Indirizzo Nominativo - Città
     */
    @Column(name = "STRUA_IND_CITTA")
    private String indCitta;

    /**
     * Indirizzo Nominativo - CAP
     */
    @Column(name = "STRUA_IND_CAP")
    private String indCap;

    /**
     * Indirizzo Nominativo - Sigla Provincia
     */
    @Column(name = "STRUA_IND_PRO")
    private String indPro;

    /**
     * ndirizzo Nominativo - Descrizione estesa Stato
     */
    @Column(name = "STRUA_IND_STATO")
    private String indStato;

    /**
     * Telefono Nominativo
     */
    @Column(name = "STRUA_TEL_NOM")
    private String telNom;
    /**
     * Fax Nominativo
     */
    @Column(name = "STRUA_FAX_NOM")
    private String faxNom;

    /**
     * Mail Nominativo
     */
    @Column(name = "STRUA_MAIL_NOM")
    private String mailNom;

    /**
     * PEC Nominativo
     */
    @Column(name = "STRUA_PEC_NOM")
    private String pecNom;

    /**
     * Data inizio validità
     */
    @Column(name = "STRUA_DATA_INIZ")
    private Date dataIniz;

    /**
     * Data fine validità'
     */
    @Column(name = "STRUA_DATA_FINE")
    private Date dataFine;

    /**
     * Data di inserimento del record.
     */
    @Column(name = "STRUA_DATA_INS")
    private Timestamp dataIns;

    /**
     * Data di ultimo aggiornamento del  record
     */
    @Column(name = "STRUA_DATA_ULT_AGG")
    private Timestamp dataUltAgg;

    /**
     * Codice dell''utente/funzione che ha aggiornato il record. Per le funzioni on-line è l''identificativo utente che apre la sessione di lavoro, per le funzioni fuori-linea coincide con la  codifica assegnata alla funzione
     */
    @Column(name = "STRUA_COD_ULT_AGG")
    private String codUltAgg;

}
