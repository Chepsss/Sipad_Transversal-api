package it.almaviva.difesa.sipad.aadba.hierarchy.entity;

import it.almaviva.difesa.sipad.shared.entity.GenericEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "VW_SG003_SGGRA_GRADO")
public class VwSg003SggraGradoEntity implements GenericEntity {

    @Basic
    @Column(name = "SG003_CODICE_GRADO", length = 12)
    private String sg003CodiceGrado;
    @Basic
    @Column(name = "SG003_DESCR_GRADO", length = 12)
    private String sg003DescrGrado;
    @Basic
    @Column(name = "SG003_DATA_INIZ", length = 12)
    private LocalDate sg003DataIniz;
    @Basic
    @Column(name = "SG003_DATA_FINE", length = 12)
    private LocalDate sg003DataFine;
    @Id
    @Basic
    @Column(name = "SG003_SGCTP_ID", length = 12)
    private Long sg003SgctpId;
    @Basic
    @Column(name = "SG003_STFAA_ID", length = 12)
    private String sg003StfaaId;
    @Basic
    @Column(name = "SG003_CODICE_SIPAD1", length = 12)
    private String sg003CodiceSipad1;
    @Basic
    @Column(name = "SG003_COD_UID", length = 12)
    private String sg003CodUid;
    @Basic
    @Column(name = "SG003_SGGRA_COD_SUP", length = 12)
    private String sg003SggraCodSup;
    @Basic
    @Column(name = "SG003_SGGRA_VAL_GERARCHIA", length = 12)
    private Short sg003SggraValGerarchia;





}
