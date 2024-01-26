package it.almaviva.difesa.sipad.aadba.prtpotprocedimento.entity;

import it.almaviva.difesa.sipad.aadba.pratpprocatt.entity.TpPratpProcAtt;
import it.almaviva.difesa.sipad.aadba.prtpatprocedura.entity.TpPrtpaTprocedura;
import it.almaviva.difesa.sipad.shared.entity.GenericEntity;
import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * <p>
 * Rappresentano le diverse tipologie di procedimenti in cui si articola una stessa procedura amministrativa.
 * Qualora non siano significative diverse tipologie di procedimento, la tipologia si assimila alla procedura stessa.
 * </p>
 * <p>
 * Nel caso della procedura di aspettiva, per il personale militare, le tipologie di procedimenti previsti sono:
 * <ul>
 *  <li>Aspettativa per infermit&agrave;</li>
 *  <li>Aspettativa per Riduzione Quadri</li>
 *  <li>Aspettativa ai sensi del DPR 461/2001</li>
 *  <li>Aspettativa per motivi privati</li>
 *  <li>Aspettativa per motivi di studio</li>
 *  <li>Altre motivazioni</li>
 * </ul>
 * </p>
 * <p>
 * Le diverse specializzazioni nell'ambito della stessa tipologia di procedimento sono descritte
 * nel diagramma di classi della procedura di riferimento.
 * </p>
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TP_PRTPO_TPROCEDIMENTO")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class TpPrtpoTprocedimento implements GenericEntity, Serializable {

    private static final long serialVersionUID = -8612393241404297227L;

    @Id
    @Column(name = "PRTPO_ID_PK", nullable = false)
    private Long id;

    @Column(name = "PRTPO_DESCR_PROC", length = 100)
    private String prtpoDescrProc;

    @Column(name = "PRTPO_ACR_PROC", length = 30)
    private String prtpoAcrProc;

    @Column(name = "PRTPO_DATA_INIZ")
    private LocalDate prtpoDataIniz;

    @Column(name = "PRTPO_DATA_FINE")
    private LocalDate prtpoDataFine;

    @Column(name = "PRTPO_NUM_GG_DURLAV")
    private Long prtpoNumGgDurlav;

    @Column(name = "PRTPO_PRDAV_ID", nullable = false, precision = 4)
    private Long prtpoPrdavId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PRTPO_PRTPA_ID", nullable = false)
    private TpPrtpaTprocedura prtpoPrtpa;

    @Column(name = "PRTPO_STATO_PROC", length = 3)
    private String prtpoStatoProc;

    @Column(name = "PRTPO_FLAG_GRADO")
    private Character prtpoFlagGrado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRTPO_PRTPO_ID_ARS")
    private TpPrtpoTprocedimento prtpoPrtpoIdArs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRTPO_PRTPO_ID_SUP")
    private TpPrtpoTprocedimento prtpoPrtpoIdSup;

    @Column(name = "PRTPO_FLAG_COLL", nullable = false)
    private Character prtpoFlagColl;

    @Column(name = "PRTPO_DATA_INS", nullable = false)
    private LocalDateTime prtpoDataIns;

    @Column(name = "PRTPO_DATA_ULT_AGG", nullable = false)
    private LocalDateTime prtpoDataUltAgg;

    @Column(name = "PRTPO_COD_ULT_AGG", nullable = false, length = 50)
    private String prtpoCodUltAgg;

//    @OneToMany(mappedBy = "cetipPrtpoSeqPk")
//    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
//    private Set<TpCetipCessazione> tpCetipCessaziones = new LinkedHashSet<>();

    @OneToMany(mappedBy = "pratpPrtpoIdPk")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<TpPratpProcAtt> tpPratpProcAtts = new LinkedHashSet<>();

    @OneToMany(mappedBy = "prtpoPrtpoIdSup")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<TpPrtpoTprocedimento> tpPrtpoTprocedimentos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "prtpoPrtpoIdArs")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<TpPrtpoTprocedimento> secTpPrtpoTprocedimentos = new LinkedHashSet<>();

//    @Override
//    public Sort getSort() {
//        return SortConstant.SORT_BY_ID;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TpPrtpoTprocedimento that = (TpPrtpoTprocedimento) o;
        return id.equals(that.id)
                && Objects.equals(prtpoDescrProc, that.prtpoDescrProc)
                && Objects.equals(prtpoAcrProc, that.prtpoAcrProc)
                && Objects.equals(prtpoDataIniz, that.prtpoDataIniz)
                && Objects.equals(prtpoDataFine, that.prtpoDataFine)
                && Objects.equals(prtpoNumGgDurlav, that.prtpoNumGgDurlav)
                && Objects.equals(prtpoStatoProc, that.prtpoStatoProc)
                && Objects.equals(prtpoFlagGrado, that.prtpoFlagGrado)
                && Objects.equals(prtpoFlagColl, that.prtpoFlagColl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, prtpoDescrProc, prtpoAcrProc, prtpoDataIniz,
                prtpoDataFine, prtpoNumGgDurlav, prtpoStatoProc, prtpoFlagGrado, prtpoFlagColl);
    }
}