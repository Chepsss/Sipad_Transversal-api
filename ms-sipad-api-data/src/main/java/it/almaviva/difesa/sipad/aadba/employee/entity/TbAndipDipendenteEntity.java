package it.almaviva.difesa.sipad.aadba.employee.entity;

import it.almaviva.difesa.sipad.shared.entity.GenericEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "TB_ANDIP_DIPENDENTE")
public class TbAndipDipendenteEntity implements GenericEntity {

    @Id
    @Column(name = "ANDIP_ID_PK")
    private Long andipIdPk;

    @Column(name = "ANDIP_COGN")
    private String andipCogn;

    @Column(name = "ANDIP_NOME")
    private String andipNome;

    @Column(name = "ANDIP_DATA_NASCITA")
    private LocalDate andipDataNascita;

    @Column(name = "ANDIP_COD_MATRICOLA")
    private String andipCodMatricola;

    @Column(name = "ANDIP_COD_FSC")
    private String andipCodFsc;

    @Column(name = "ANDIP_DATA_DECESSO")
    private LocalDate andipDataDecesso;

    @Column(name = "ANDIP_FLAG_SESSO")
    private Character andipFlagSesso;

    @Column(name = "ANDIP_MAIL_UFFICIO")
    private String andipMailUfficio;

    @Column(name = "ANDIP_IND_DOM")
    private String andipIndDom;

    @Column(name = "ANDIP_CAP_DOM")
    private String andipCapDom;

    @Column(name = "ANDIP_IND_RES")
    private String andipIndRes;

    @Column(name = "ANDIP_CAP_RES")
    private String andipCapRes;

    @Column(name = "ANDIP_TEL_RES")
    private String andipTelRes;

    @Column(name = "ANDIP_NOTE_ANAGR")
    private String andipNoteAnagr;

    @Column(name = "ANDIP_DATA_STATO_CIVILE")
    private LocalDate maritalStatusDate;

    @Column(name = "ANDIP_STCOM_ID_NAS")
    private Long andipStcomIdNas;

    @Column(name = "ANDIP_STCOM_ID_RES")
    private Long andipStcomIdRes;

    @Column(name = "ANDIP_STCOM_ID_DOM")
    private Long andipStcomIdDom;

    @Column(name = "ANDIP_STNAZ_ID_NAS")
    private Long andipStnazIdNas;

    @Column(name = "ANDIP_ANTPR_ID")
    private Long andipAntprId;

    @Column(name = "ANDIP_ANSTC_ID")
    private Long andipAnstcId;

    @Column(name = "ANDIP_COD_CARTA")
    private String andipCodCarta;

    @Column(name = "ANDIP_STNAZ_ID_CIT")
    private Long andipStnazIdCit;

    @Column(name = "ANDIP_STFAA_ID")
    private String andipStfaaId;

    @Column(name = "ANDIP_LOC_RES")
    private String andipLocRes;

    @Column(name = "ANDIP_LOC_DOM")
    private String andipLocDom;

    @Column(name = "ANDIP_STNAZ_ID_RES")
    private Long andipStnazIdRes;

    @Column(name = "ANDIP_STNAZ_ID_DOM")
    private Long andipStnazIdDom;

    @Column(name = "ANDIP_DATA_INS")
    private LocalDateTime andipDataIns;

    @Column(name = "ANDIP_DATA_ULT_AGG")
    private LocalDateTime andipDataUltAgg;

    @Column(name = "ANDIP_COD_ULT_AGG")
    private String andipCodUltAgg;

    @Column(name = "ANDIP_FLAG_AID")
    private Integer andipFlagAid;

    @Column(name = "ANDIP_ANSTR_COD")
    private String andipAnstrCod;

    @Column(name = "ANDIP_ANSTS_COD")
    private String andipAnstsCod;

    @Column(name = "ANDIP_FLAG_BDUS")
    private Integer andipFlagBdus;
}
