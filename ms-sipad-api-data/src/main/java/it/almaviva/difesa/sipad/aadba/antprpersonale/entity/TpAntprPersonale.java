package it.almaviva.difesa.sipad.aadba.antprpersonale.entity;

import it.almaviva.difesa.sipad.shared.entity.GenericEntity;
import it.almaviva.difesa.sipad.shared.util.Sortable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Sort;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TP_ANTPR_PERSONALE")
public class TpAntprPersonale implements GenericEntity, Serializable, Sortable {

    private static final long serialVersionUID = 6818053287772223464L;

    @Id
    @Column(name = "ANTPR_ID_PK", nullable = false)
    private Long id;

    @Column(name = "ANTPR_DESCR_TPR", length = 100)
    private String antprDescrTpr;

    @Column(name = "ANTPR_ACR_TPR", length = 20)
    private String antprAcrTpr;

    @Column(name = "ANTPR_DATA_INIZ")
    private LocalDate antprDataIniz;

    @Column(name = "ANTPR_DATA_FINE")
    private LocalDate antprDataFine;

    @Column(name = "ANTPR_FLAG_ESPOSIZ", nullable = false)
    private Character antprFlagEsposiz;

    @Column(name = "ANTPR_COD_UID", length = 12)
    private String antprCodUid;

    @Column(name = "ANTPR_DATA_INS", nullable = false)
    private LocalDateTime antprDataIns;

    @Column(name = "ANTPR_DATA_ULT_AGG", nullable = false)
    private LocalDateTime antprDataUltAgg;

    @Column(name = "ANTPR_COD_ULT_AGG", nullable = false, length = 50)
    private String antprCodUltAgg;

    @Override
    public Sort getSort() {
        return Sort.by("id");
    }

}