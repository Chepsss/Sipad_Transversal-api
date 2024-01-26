package it.almaviva.difesa.sipad.aadba.immissione.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.almaviva.difesa.sipad.shared.entity.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;



//    comment on table tb_sgimm_immissione is '';

/**
 * Dati riferiti alla  immissione/cessazione dal servizio del dipendente presso l'amministrazione Difesa
 * determinati all'atto del reclutamento e i dati propri di tale fase quali la data e il luogo del giuramento, ecc. (TMXIMMI)
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_sgimm_immissione")
@EntityListeners(AuditingEntityListener.class)
public class Immissione implements GenericEntity, Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Identificativo univoco del dipendente
     */
    @Id
    @Column(name = "sgimm_andip_id_pk", nullable = false)
    private Long id;

    /**
     * Progressivo immissione in servizio
     */

    @Column(name = "sgimm_prg_pk", nullable = false)
    private Long prgPk;

    /**
     * Data di prima immissione in servizio da usare per il calcolo dell''anzianità di servizio. (Coincide con al data di arruolamento?)
     */
    @Column(name = "sgimm_data_imm")
    private LocalDate dataImm;

    /**
     * Data decorrenza Giuridica
     */
    @Column(name = "sgimm_data_dec_giu",  nullable = false)
    private LocalDate dataDecGiu;

    /**
     * Data decorrenza Economica
     */
    @Column(name = "sgimm_data_dec_eco")
    private LocalDate dataDecEco;

    /**
     * Data del giuramento. Forse va eliminata
     */

    @Column(name = "sgimm_data_giuramento")
    private LocalDate dataGiuramento;

    /**
     * Sede dove è stato prestato il giuramento. Forse va eliminata
     */
    @Column(name = "sgimm_descr_sede_giu")
    private String descrSedeGiu;

    /**
     * Data decorrenza giuridica precedente alla legge 186????. Va chiarito il significato
     */
    @Column(name = "sgimm_data_ante_giu_186")
    private LocalDate dataAnteGiu186;

    /**
     *  Flag legge 186 (0 = nessuna legge applicata / 1 = tipologia legge applicata)
     */
    @Column(name = "sgimm_flag_legge")
    private String flagLegge;

    /**
     * Data fine decorrenza
     */
    @Column(name = "sgimm_data_ces")
    private LocalDate dataCes;

    /**
     * Codice identificativo della causale immissione
     */
    @Column(name = "sgimm_sgcai_cod")
    private String sgcaiCod;

    /**
     * Codice identificativo della causale cessazione
     */
    @Column(name = "sgimm_sgcac_cod")
    private String sgcacCod;

    /**
     * Identificativo univoco della categoria di posizione di stato
     */
    @Column(name = "sgimm_sgcts_id", nullable = false)
    private Long sgctsId;

    /**
     * Codice della FF.AA. di appartenenza
     */
    @Column(name = "sgimm_stfaa_id", nullable = false)
    private String stfaaId;

    /**
     * Codice Identificativo della qualifica attribuita all''atto dell''immissione nella categoria di P.S.
     */
    @Column(name = "sgimm_sgqua_cod")
    private String sgquaCod;

    /**
     * Identificativo univoco della categoria del personale militare all''atto dell''imissione in servizio
     */
    @Column(name = "sgimm_sgctp_id", nullable = false)
    private Long sgctpId;

    /**
     * Codice della tipologia di Arma e Corpo
     */
    @Column(name = "sgimm_starc_cod")
    private String starcCod;

    /**
     * Data inserimento del record
     */
    @CreatedDate
    @Column(name = "sgimm_data_ins", updatable = false)
    @JsonIgnore
    private LocalDateTime dataIns = LocalDateTime.now();

    /**
     * Data ultimo aggiornamento
     */
    @LastModifiedDate
    @Column(name = "sgimm_data_ult_agg")
    @JsonIgnore
    private LocalDateTime dataUltAgg = LocalDateTime.now();

    /**
     * Codice ultimo utente in aggiornamento
     */
    @Column(name = "sgimm_cod_ult_agg", nullable = false)
    private String codUltAgg;

    /**
     * Codice stato del record
     */
    @Column(name = "sgimm_sgsta_cod")
    private String sgstaCod;

    /**
     * Identificativo univoco del documento che sancisce la situazione giuridica del record di riferimento.
     * Al momento la tabella riferisce la tabella TB_SGDOC,  ma a regime dovrà riferire la tabella TB_DODOC
     * nella quale dovranno confluire sia i documenti pregressi che quelli generati dai procedimenti amministrativi.
     */
    @Column(name = "sgimm_dodoc_seq")
    private Long dodocSeq;

    /**
     * Codice fonte de dato
     */
    @Column(name = "sgimm_opfon_cod")
    private String opfonCod;

    /**
     * Identificativo codice  della variazione
     */
    @Column(name = "sgimm_prtiv_cod_uid")
    private String prtivCodUid;



}
