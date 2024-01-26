package it.almaviva.difesa.sipad.aadba.stentente.entity;

import it.almaviva.difesa.sipad.shared.entity.GenericEntity;
import it.almaviva.difesa.sipad.shared.util.Sortable;
import it.almaviva.difesa.sipad.aadba.stfaaforzarmata.entity.TpStfaaForzaArmata;
import lombok.*;
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
@ToString
@Table(name = "TB_STENT_ENTE")
public class TbStentEnte implements GenericEntity, Serializable, Sortable {

    private static final long serialVersionUID = -1327977924971474372L;

    @Id
    @Column(name = "STENT_COD_ENTE_PK", nullable = false, length = 6)
    private String id;

    @Column(name = "STENT_DENOM_ENTE", nullable = false)
    private String stentDenomEnte;

    @Column(name = "STENT_DENOM_BREVE", length = 60)
    private String stentDenomBreve;

    @Column(name = "STENT_MAIL", length = 100)
    private String stentMail;

    @Column(name = "STENT_IND_DENOM")
    private String stentIndDenom;

    @Column(name = "STENT_IND_CAP", length = 5)
    private String stentIndCap;

    @Column(name = "STENT_IND_TELEGRAFICO", length = 150)
    private String stentIndTelegrafico;

    @Column(name = "STENT_TEL_ENTE", length = 20)
    private String stentTelEnte;

    @Column(name = "STENT_ACR_ENTE", length = 20)
    private String stentAcrEnte;

    @Column(name = "STENT_DATA_FIRMA")
    private LocalDate stentDataFirma;

    @Column(name = "STENT_DATA_ATTUAZIONE")
    private LocalDate stentDataAttuazione;

    @Column(name = "STENT_DESCR_LOCALITA", length = 100)
    private String stentDescrLocalita;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STENT_STFAA_ID")
    private TpStfaaForzaArmata stentStfaa;

    @Column(name = "STENT_STCOM_ID", precision = 12)
    private Long stentStcomId;

    @Column(name = "STENT_COD_PIVA", length = 11)
    private String stentCodPiva;

    @Column(name = "STENT_STNAZ_ID", precision = 12)
    private Long stentStnazId;

    @Column(name = "STENT_STTSE_ID", precision = 4)
    private Long stentSttseId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STENT_STENT_COD_SUP")
    private TbStentEnte stentStentCodSup;

    @Column(name = "STENT_STORG_ID", precision = 4)
    private Long stentStorgId;

    @Column(name = "STENT_STAOO_COD", length = 20)
    private String stentStaooCod;

    @Column(name = "STENT_STOPR_ID", precision = 4)
    private Long stentStoprId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STENT_STENT_COD_CON")
    private TbStentEnte stentStentCodCon;

    @Column(name = "STENT_STOPR_ID_ORD", precision = 4)
    private Long stentStoprIdOrd;

    @Column(name = "STENT_COD_IPA", length = 100)
    private String stentCodIpa;

    @Column(name = "STENT_MAIL_PEC", length = 100)
    private String stentMailPec;

    @Column(name = "STENT_DATA_INS", nullable = false)
    private LocalDateTime stentDataIns;

    @Column(name = "STENT_DATA_ULT_AGG", nullable = false)
    private LocalDateTime stentDataUltAgg;

    @Column(name = "STENT_COD_ULT_AGG", nullable = false, length = 50)
    private String stentCodUltAgg;

    @Column(name = "STENT_DATA_INIZ")
    private LocalDate stentDataIniz;

    @Column(name = "STENT_DATA_FINE")
    private LocalDate stentDataFine;

    @Override
    public Sort getSort() {
        return Sort.by("id");
    }

}