package it.almaviva.difesa.sipad.aadba.pratpprocatt.entity;

import it.almaviva.difesa.sipad.aadba.prattattivazione.entity.TpPrattAttivazione;
import it.almaviva.difesa.sipad.aadba.prtpotprocedimento.entity.TpPrtpoTprocedimento;
import it.almaviva.difesa.sipad.shared.entity.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Modalità di attivazione dei procedimenti
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TP_PRATP_PROC_ATT")
public class TpPratpProcAtt implements GenericEntity, Serializable {

    private static final long serialVersionUID = 6303448361335096769L;

    @EmbeddedId
    private TpPratpProcAttId id;

    @MapsId("pratpPrattIdPk")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PRATP_PRATT_ID_PK", nullable = false)
    private TpPrattAttivazione pratpPrattIdPk;

    @MapsId("pratpPrtpoIdPk")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PRATP_PRTPO_ID_PK", nullable = false)
    private TpPrtpoTprocedimento pratpPrtpoIdPk;

    @Column(name = "PRATP_DATA_INIZ")
    private LocalDate pratpDataIniz;

    @Column(name = "PRATP_DATA_FINE")
    private LocalDate pratpDataFine;

    @Column(name = "PRATP_DATA_INS", nullable = false)
    private LocalDateTime pratpDataIns;

    @Column(name = "PRATP_DATA_ULT_AGG", nullable = false)
    private LocalDateTime pratpDataUltAgg;

    @Column(name = "PRATP_COD_ULT_AGG", nullable = false, length = 50)
    private String pratpCodUltAgg;

//    @Override
//    public Sort getSort() {
//        return SortConstant.SORT_BY_ID;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TpPratpProcAtt that = (TpPratpProcAtt) o;
        return id.equals(that.id)
                && Objects.equals(pratpPrattIdPk, that.pratpPrattIdPk)
                && Objects.equals(pratpPrtpoIdPk, that.pratpPrtpoIdPk)
                && Objects.equals(pratpDataIniz, that.pratpDataIniz)
                && Objects.equals(pratpDataFine, that.pratpDataFine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pratpPrattIdPk, pratpPrtpoIdPk, pratpDataIniz, pratpDataFine);
    }
}