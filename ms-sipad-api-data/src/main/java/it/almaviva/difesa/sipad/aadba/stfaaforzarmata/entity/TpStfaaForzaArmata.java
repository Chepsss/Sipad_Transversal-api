package it.almaviva.difesa.sipad.aadba.stfaaforzarmata.entity;

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
@Table(name = "TP_STFAA_FORZA_ARMATA")
public class TpStfaaForzaArmata implements GenericEntity, Serializable, Sortable {

    private static final long serialVersionUID = 8553789988964013036L;

    @Id
    @Column(name = "STFAA_ID_PK", nullable = false, length = 12)
    private String id;

    @Column(name = "STFAA_DESCR_FFAA", nullable = false)
    private String stfaaDescrFfaa;

    @Column(name = "STFAA_ACR_FFAA", nullable = false, length = 20)
    private String stfaaAcrFfaa;

    @Column(name = "STFAA_DATA_INIZ", nullable = false)
    private LocalDate stfaaDataIniz;

    @Column(name = "STFAA_DATA_FINE", nullable = false)
    private LocalDate stfaaDataFine;

    @Column(name = "STFAA_FLAG_ESPOSIZ", nullable = false)
    private Character stfaaFlagEsposiz;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STFAA_STFAA_ID")
    private TpStfaaForzaArmata stfaaStfaa;

    @Column(name = "STFAA_COD_UID", length = 12)
    private String stfaaCodUid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STFAA_ANTPR_ID")
    private TpAntprPersonale stfaaAntpr;

    @Column(name = "STFAA_DATA_INS", nullable = false)
    private LocalDateTime stfaaDataIns;

    @Column(name = "STFAA_COD_ULT_AGG", nullable = false, length = 50)
    private String stfaaCodUltAgg;

    @Column(name = "STFFA_DATA_ULT_AGG", nullable = false)
    private LocalDateTime stffaDataUltAgg;


    @Override
    public Sort getSort() {
        return Sort.by("id");
    }

}