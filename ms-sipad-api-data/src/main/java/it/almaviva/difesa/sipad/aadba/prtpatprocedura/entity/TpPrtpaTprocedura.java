package it.almaviva.difesa.sipad.aadba.prtpatprocedura.entity;

import it.almaviva.difesa.sipad.aadba.prtpotprocedimento.entity.TpPrtpoTprocedimento;
import it.almaviva.difesa.sipad.shared.entity.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
 * Sono le diverse procedure amministrative svolte delle Direzioni Generali della Difesa.<br>
 * Nel caso di PERSOMIL si individuano:
 * <ul>
 *  <li>Aspettativa</li>
 *  <li>Reclutamento</li>
 *  <li>Disciplina</li>
 *  <li>Cessazione</li>
 *  <li>Avanzamento</li>
 *  <li>......</li>
 * </ul>
 * </p>
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TP_PRTPA_TPROCEDURA")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class TpPrtpaTprocedura implements GenericEntity, Serializable {

    private static final long serialVersionUID = -2023736127122524627L;

    @Id
    @Column(name = "PRTPA_ID_PK", nullable = false)
    private Long id;

    @Column(name = "PRTPA_DESCR_PROC", length = 100)
    private String prtpaDescrProc;

    @Column(name = "PRTPA_ACR_PROC", length = 30)
    private String prtpaAcrProc;

    @Column(name = "PRTPA_DATA_INIZ")
    private LocalDate prtpaDataIniz;

    @Column(name = "PRTPA_DATA_FINE", nullable = false)
    private LocalDate prtpaDataFine;

    @Column(name = "PRTPA_STUOR_ID", nullable = false, precision = 4)
    private Long prtpaStuorId;

    @Column(name = "PRTPA_DATA_INS", nullable = false)
    private LocalDateTime prtpaDataIns;

    @Column(name = "PRTPA_DATA_ULT_AGG", nullable = false)
    private LocalDateTime prtpaDataUltAgg;

    @Column(name = "PRTPA_COD_ULT_AGG", nullable = false, length = 50)
    private String prtpaCodUltAgg;

    @OneToMany(mappedBy = "prtpoPrtpa")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<TpPrtpoTprocedimento> tpPrtpoTprocedimentos = new LinkedHashSet<>();

//    @Override
//    public Sort getSort() {
//        return SortConstant.SORT_BY_ID;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TpPrtpaTprocedura that = (TpPrtpaTprocedura) o;
        return id.equals(that.id)
                && Objects.equals(prtpaDescrProc, that.prtpaDescrProc)
                && Objects.equals(prtpaAcrProc, that.prtpaAcrProc)
                && Objects.equals(prtpaDataIniz, that.prtpaDataIniz)
                && Objects.equals(prtpaDataFine, that.prtpaDataFine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, prtpaDescrProc, prtpaAcrProc, prtpaDataIniz, prtpaDataFine);
    }
}