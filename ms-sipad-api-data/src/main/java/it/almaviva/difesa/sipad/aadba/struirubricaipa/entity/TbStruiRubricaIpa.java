package it.almaviva.difesa.sipad.aadba.struirubricaipa.entity;


import it.almaviva.difesa.sipad.shared.entity.GenericEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Setter(AccessLevel.NONE)
@Entity
@ToString
@Table(name = "TB_STRUI_RUBRICA_IPA")
/**
 * ono i dati relativi alla rubrica della Pubblica Amministrazione, estratti dal sito dell''IPA. Vengono allineati a partire dal file predisposto dl sistema AD-HOC all''indirizzo XXXXXXXXXXX che popola anche la tabella RUBRICA_IPA.
 * -- I dati relativi alle AOO dell''Amministrazione Difesa andranno a popolare la tabella TB_STAOO_AOO.
 */

public class TbStruiRubricaIpa implements GenericEntity {

    @Id
    @Column(name = "id")
    private Long id;

    /**
     * odice Amministrazione Pubblica (la Difesa ha codifica m_d)
     */
    @Column(name = "STRUI_COD_AMM_PK")
    private String codAmmPk;

    /**
     * Codice AOO all''interno dell''Amministrazione Pubblica (la Difesa ha codifica m_d). E'' univoca all''interno del codice dell''amministrazione pubblica
     */
    @Column(name = "STRUI_COD_AOO_PK")
    private String codAooPk;

    /**
     * Denominazione  AOO all''interno dell''Amministrazione Pubblica (la Difesa ha codifica m_d).
     */
    @Column(name = "STRUI_DENOM_AOO")
    private String denomAoo;

    /**
     * Descrizione indirizzo
     */
    @Column(name = "STRUI_IND_VIA")
    private String indVia;

    /**
     * Indirizzo AOO - Città
     */
    @Column(name = "STRUI_IND_CITTA")
    private String indCitta;

    @Column(name = "STRUI_DATA_AOO")
    private Date dataAoo;

    /**
     * Indirizzo AOO - CAP
     */
    @Column(name = "STRUI_IND_CAP")
    private String indCap;

    /**
     * Indirizzo AOO - Sigla Provincia
     */
    @Column(name = "STRUI_IND_PRO")
    private String indPro;

    /**
     * Indirizzo AOO - Descrizione Regione'
     */
    @Column(name = "STRUI_IND_REG")
    private String indReg;

    /**
     * Telefono AOO
     */
    @Column(name = "STRUI_TEL_AOO")
    private String telAoo;


    /**
     * Nome responsabile AOO
     */
    @Column(name = "STRUI_NOME_RESP")
    private String nomeResp;

    /**
     * Cognome responsabile AOO
     */
    @Column(name = "STRUI_COGN_RESP")
    private String cognResp;

    /**
     * Mail responsabile AOO
     */
    @Column(name = "STRUI_MAIL_RESP")
    private String mailResp;

    /**
     * Telefono responsabile AOO
     */
    @Column(name = "STRUI_TEL_RESP")
    private String telResp;

    /**
     * Fax responsabile AOO
     */
    @Column(name = "STRUI_FAX_RESP")
    private String faxResp;

    /**
     * Mail1  AOO
     */
    @Column(name = "STRUI_MAIL1_AOO")
    private String mail1Aoo;

    /**
     * ipologia mail1   AOO. Valori:
     *
     * -- pec 			- Posta Elettronica Certificata
     * -- cecpac 	- Comunicazione  Elettronica Certificata tra la P.A. ed i cittadini italiani maggiorenni (anche 					residenti all''estero)
     * -- altro 		- Posta Elettronica generica
     */
    @Column(name = "STRUI_TIPO1_AOO")
    private String tipo1Aoo;

    /**
     * Mail2  AOO
     */
    @Column(name = "STRUI_MAIL2_AOO")
    private String mail2Aoo;

    /**
     * Tipologia mail2  AOO. Valori:
     * --
     * -- pec 			- Posta Elettronica Certificata
     * -- cecpac 	- Comunicazione  Elettronica Certificata tra la P.A. ed i cittadini italiani maggiorenni (anche 					residenti all''estero)
     * -- altro 		- Posta Elettronica generica
     * --  ';
     */
    @Column(name = "STRUI_TIPO2_AOO")
    private String tipo2Aoo;

    /**
     * Mail3  AOO
     */
    @Column(name = "STRUI_MAIL3_AOO")
    private String mail3Aoo;

    /**
     * tipologia mail3  AOO. Valori:
     * --
     * -- pec 			- Posta Elettronica Certificata
     * -- cecpac 	- Comunicazione  Elettronica Certificata tra la P.A. ed i cittadini italiani maggiorenni (anche 					residenti all''estero)
     * -- altro 		- Posta Elettronica generica
     */
    @Column(name = "STRUI_TIPO3_AOO")
    private String tipo3Aoo;

    /**
     * Indirizzo AOO - Descrizione estesa Stato
     */
    @Column(name = "STRUI_IND_STATO")
    private String indStato;

    /**
     * Codice IPA dell''AOO. E'' composto dal Codice Amministrazione e dal codiece  AOO
     */
    @Column(name = "STRUI_COD_IPA")
    private String codIpa;

    /**
     * Data inizio validità
     */
    @Column(name = "STRUI_DATA_INIZ")
    private Date dataIniz;

    /**
     * Data fine validità
     */
    @Column(name = "STRUI_DATA_FINE")
    private Date dataFine;

    /**
     * Data di inserimento del record.
     */
    @Column(name = "STRUI_DATA_INS")
    private Timestamp dataIns;
    /**
     * Data di ultimo aggiornamento del  record.
     */
    @Column(name = "STRUI_DATA_ULT_AGG")
    private Timestamp dataUltAgg;

    /**
     * DCodice dell''utente/funzione che ha aggiornato il record. Per le funzioni on-line è l''identificativo utente che apre la sessione di lavoro, per le funzioni fuori-linea coincide con la  codifica assegnata alla funzione.
     */
    @Column(name = "STRUI_COD_ULT_AGG")
    private String codUltAgg;

}
