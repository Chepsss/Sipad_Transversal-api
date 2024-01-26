package it.almaviva.difesa.sipad.aadba.sgruoruolo.entity;

import it.almaviva.difesa.sipad.aadba.sgctpcatpersonale.entity.TpSgctpCatpersonale;
import it.almaviva.difesa.sipad.shared.entity.GenericEntity;
import it.almaviva.difesa.sipad.shared.util.Sortable;
import it.almaviva.difesa.sipad.aadba.stfaaforzarmata.entity.TpStfaaForzaArmata;
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
@Table(name = "TP_SGRUO_RUOLO")
public class TpSgruoRuolo implements GenericEntity, Serializable, Sortable {

    private static final long serialVersionUID = 2134353544545129885L;

    @Id
    @Column(name = "SGRUO_COD_PK", nullable = false, length = 12)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SGRUO_SGCTP_ID")
    private TpSgctpCatpersonale sgruoSgctp;

    @Column(name = "SGRUO_DESCR_RUOLO")
    private String sgruoDescrRuolo;

    @Column(name = "SGRUO_DESCRB_RUOLO", length = 50)
    private String sgruoDescrbRuolo;

    @Column(name = "SGRUO_ACR_RUOLO", length = 30)
    private String sgruoAcrRuolo;

    @Column(name = "SGRUO_FLAG_TIPO")
    private Character sgruoFlagTipo;

    @Column(name = "SGRUO_DATA_INIZ")
    private LocalDate sgruoDataIniz;

    @Column(name = "SGRUO_DATA_FINE")
    private LocalDate sgruoDataFine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SGRUO_STFAA_ID")
    private TpStfaaForzaArmata sgruoStfaa;

    @Column(name = "SGRUO_COD_SIPAD1", length = 12)
    private String sgruoCodSipad1;

    @Column(name = "SGRUO_COD_UID", length = 12)
    private String sgruoCodUid;

    @Column(name = "SGRUO_FLAG_LIV", nullable = false)
    private Character sgruoFlagLiv;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SGRUO_SGRUO_COD")
    private TpSgruoRuolo sgruoSgruoCod;

    @Column(name = "SGRUO_FLAG_ALL", nullable = false)
    private Character sgruoFlagAll;

    @Column(name = "SGRUO_FLAG_REL")
    private Character sgruoFlagRel;

    @Column(name = "SGRUO_FLAG_ESPOSIZ", nullable = false)
    private Character sgruoFlagEsposiz;

    @Column(name = "SGRUO_DATA_INS", nullable = false)
    private LocalDateTime sgruoDataIns;

    @Column(name = "SGRUO_COD_ULT_AGG", nullable = false, length = 50)
    private String sgruoCodUltAgg;

    @Column(name = "SGRUO_DATA_ULT_AGG", nullable = false)
    private LocalDateTime sgruoDataUltAgg;


    @Override
    public Sort getSort() {
        return Sort.by("id");
    }

}