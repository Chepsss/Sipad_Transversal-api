package it.almaviva.difesa.sipad.aadba.storaorganigrammaaoo.entity;

import it.almaviva.difesa.sipad.shared.entity.GenericEntity;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Setter(AccessLevel.NONE)
@Entity
@ToString
@IdClass(OrganigrammaPk.class)
@Table(name = "TB_STORA_ORGANIGRAMMA_AOO")

/**
 * Sono le unità organizzative e l''organico di riferimento all''interno delle Direzioni Generali della Difesa.
 * -- La struttura organizzativa  viene allineata a partire dall''analoga tabella presente nel sistema AD-HOC - ORGANIGRAMMA, scaricata periodicamente tramite il servizio GetHierarchy richiamato  per le diverse AOO corrispondenti alle D.G..
 * -- Le D.G. risultano strutturate in più  livelli organizzativi, ovvero, nel caso di PERSOMIL:
 * --
 * --  1^ 	livello: Comprende il personale di vertice della D.G.
 * --
 * --  2^ 	livello: Comprende le strutture di staff alla D.G ed i singoli Reparti. Ogni D.G. è suddivisa in n 		Reparti; ciascun reparto è diretto da un caporeparto, si avvale di un segretario e di n addetti e si 		occupa di aree tematiche di interesse  per la gestione del personale della Difesa.
 * -- 		Es. I Reparto di PERSOMIL si occupa di:
 * -- 		- Reclutamento
 * -- 		- Disciplina
 * --
 * -- 3^	livello:  Comprende le articolazioni degli ufficio del direttore generale e del vice-direttore e le 		diverse divisioni all''interno dei reparti. Ogni divisione si occupa di procedimenti specifici al''interno 		delle aree tematiche di competenza del reparto di appartenenza.
 * --
 * --
 * -- 5^	livello: Comprende ulteriori articolazioni del 4^ livello organizzativo.
 * --
 * -- Per ciascun livello organizzativo vengono riportate tutte le unità organiche previte. Al momento sono previsti un mssimo di 5 livelli
 * --   ';
 */


public class TbStoraOrganigrammaAoo implements GenericEntity {


    /**
     * odice dell''AOO di riferimento
     */
    @Id
    @Column(name = "STORA_STAOO_COD_PK")
    private String staooCodPk;

    /**
     * Codice login relativo all''unità organica del  livello organizzativo
     */
    @Id
    @Column(name = "STORA_COD_LOGIN_PK")
    private String codLoginPk;

    /**
     * Denominazione per esteso del 1^  livello organizzativo di riferimento. Valorizzato solo se la struttura organizzativa prevede  1 o più livelli
     */
    @Column(name = "STORA_DENOM_LIV1")
    private String denomLiv1;

    /**
     * Denominazione per esteso del 2^  livello organizzativo di riferimento. Valorizzato solo se la struttura organizzativa prevede  1 o più livelli
     */
    @Column(name = "STORA_DENOM_LIV2")
    private String denomLiv2;

    /**
     * Denominazione per esteso del 3^  livello organizzativo di riferimento. Valorizzato solo se la struttura organizzativa prevede  1 o più livelli
     */
    @Column(name = "STORA_DENOM_LIV3")
    private String denomLiv3;

    /**
     * Denominazione per esteso del 4^  livello organizzativo di riferimento. Valorizzato solo se la struttura organizzativa prevede  1 o più livelli
     */
    @Column(name = "STORA_DENOM_LIV4")
    private String denomLiv4;

    /**
     * Denominazione per esteso del 5^  livello organizzativo di riferimento. Valorizzato solo se la struttura organizzativa prevede  1 o più livelli
     */
    @Column(name = "STORA_DENOM_LIV5")
    private String denomLiv5;

    /**
     * Individua l'' articolazione e l''organico da considerare di  riferimento nell''ambito del livello organizzativo. Valori ammessi: S = Di rifermento, N = Non di riferimento
     */
    @Column(name = "STORA_FLAG_RIF")
    private String flagRif;

    /**
     * Indica se il livello organizzativo ed organico va visualizzato o meno.
     * -- Valori ammessi S = si, N = no';
     */
    @Column(name = "STORA_FLAG_ESP")
    private String flagEsp;

    /**
     * Posizione gerarchica del livello organizzativo
     */
    @Column(name = "STORA_NUM_LIVELLO")
    private Integer numLivello;

    @Column(name="STORA_ID_UO")
    private Long idUo;

    @Column(name = "stora_id_ruolo")
    private Long storaIdRuolo;

    /**
     * Data inizio validità
     */
    @Column(name = "STORA_DATA_INIZ")
    private Date dataIniz;

    /**
     * Data fine validità
     */
    @Column(name = "STORA_DATA_FINE")
    private Date dataFine;

    /**
     * Data inserimento del record
     */
    @Column(name = "STORA_DATA_INS")
    private Timestamp storiaDataIns;

    /**
     * Codice ultimo utente in aggiornamento
     */
    @Column(name = "STORA_COD_ULT_AGG")
    private String codUltAgg;
    /**
     * Data ultimo aggiornamento
     */
    @Column(name = "STORA_DATA_ULT_AGG")
    private Timestamp dataUltAgg;


}
