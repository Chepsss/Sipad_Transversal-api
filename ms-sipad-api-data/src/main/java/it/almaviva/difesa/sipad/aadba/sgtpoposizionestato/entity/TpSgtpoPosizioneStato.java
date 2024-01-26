package it.almaviva.difesa.sipad.aadba.sgtpoposizionestato.entity;

import it.almaviva.difesa.sipad.aadba.sgctpcatpersonale.entity.TpSgctpCatpersonale;
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
@Table(name = "TP_SGTPO_POSIZIONE_STATO")
public class TpSgtpoPosizioneStato implements GenericEntity, Serializable, Sortable {

    private static final long serialVersionUID = 1986583022291559757L;

    @Id
    @Column(name = "SGTPO_COD_PK", nullable = false, length = 12)
    private String id;

    @Column(name = "SGTPO_DESCR_POSIZIONE", length = 100)
    private String sgtpoDescrPosizione;

    @Column(name = "SGTPO_ACR_POSIZIONE", length = 30)
    private String sgtpoAcrPosizione;

    @Column(name = "SGTPO_DATA_INIZ")
    private LocalDate sgtpoDataIniz;

    @Column(name = "SGTPO_DATA_FINE")
    private LocalDate sgtpoDataFine;

    @Column(name = "SGTPO_SGCTS_ID", nullable = false)
    private Long sgtpoSgctsId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SGTPO_SGCTP_ID")
    private TpSgctpCatpersonale sgtpoSgctp;

    @Column(name = "SGTPO_COD_SIPAD1", length = 12)
    private String sgtpoCodSipad1;

    @Column(name = "SGTPO_COD_UID", length = 12)
    private String sgtpoCodUid;

    @Column(name = "SGTPO_COD_CONF", length = 12)
    private String sgtpoCodConf;

    @Column(name = "SGTPO_DATA_INS", nullable = false)
    private LocalDateTime sgtpoDataIns;

    @Column(name = "SGTPO_COD_ULT_AGG", nullable = false, length = 50)
    private String sgtpoCodUltAgg;

    @Column(name = "SGTPO_DATA_ULT_AGG", nullable = false)
    private LocalDateTime sgtpoDataUltAgg;

    @Column(name = "SGTPO_VAL_FERMIN")
    private Long sgtpoValFermin;

    @Column(name = "SGTPO_VAL_FERMAX")
    private Long sgtpoValFermax;

    @Column(name = "SGTPO_FLAG_PROL", nullable = false, length = 1)
    private String sgtpoFlagProl;

    @Column(name = "SGTPO_VAL_FERAGG")
    private Long sgtpoValFeragg;


    @Override
    public Sort getSort() {
        return Sort.by("id");
    }

}