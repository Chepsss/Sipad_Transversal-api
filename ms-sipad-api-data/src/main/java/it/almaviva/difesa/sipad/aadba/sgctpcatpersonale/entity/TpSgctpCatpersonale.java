package it.almaviva.difesa.sipad.aadba.sgctpcatpersonale.entity;

import it.almaviva.difesa.sipad.aadba.antprpersonale.entity.TpAntprPersonale;
import it.almaviva.difesa.sipad.shared.entity.GenericEntity;
import it.almaviva.difesa.sipad.shared.util.Sortable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Sort;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TP_SGCTP_CATPERSONALE")
public class TpSgctpCatpersonale implements GenericEntity, Serializable, Sortable {

    private static final long serialVersionUID = -5577157068870299777L;

    @Id
    @Column(name = "SGCTP_ID_PK", nullable = false)
    private Long id;

    @Column(name = "SGCTP_COD_CATPERS", length = 25)
    private String sgctpCodCatpers;

    @Column(name = "SGCTP_DESCR_CATPERS")
    private String sgctpDescrCatpers;

    @Column(name = "SGCTP_ACR_CATPERS", length = 10)
    private String sgctpAcrCatpers;

    @Column(name = "SGCTP_DATA_INIZ")
    private LocalDate sgctpDataIniz;

    @Column(name = "SGCTP_DATA_FINE")
    private LocalDate sgctpDataFine;

    @Column(name = "SGCTP_FLAG_ESPOSIZ", nullable = false)
    private Character sgctpFlagEsposiz;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SGCTP_ANTPR_ID", nullable = false)
    private TpAntprPersonale sgctpAntpr;

    @Column(name = "SGCTP_COD_UID", length = 12)
    private String sgctpCodUid;

    @Column(name = "SGCTP_NUM_ORD")
    private Long sgctpNumOrd;

    @Column(name = "SGCTP_DATA_INS", nullable = false)
    private LocalDateTime sgctpDataIns;

    @Column(name = "SGCTP_COD_ULT_AGG", nullable = false, length = 50)
    private String sgctpCodUltAgg;

    @Column(name = "SGCTP_DATA_ULT_AGG", nullable = false)
    private LocalDateTime sgctpDataUltAgg;


    @Override
    public Sort getSort() {
        return Sort.by("id");
    }

}