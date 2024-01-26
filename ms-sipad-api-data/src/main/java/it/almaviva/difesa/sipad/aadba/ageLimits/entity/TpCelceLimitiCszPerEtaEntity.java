package it.almaviva.difesa.sipad.aadba.ageLimits.entity;

import it.almaviva.difesa.sipad.shared.entity.GenericEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@Table(name = "TP_CELCE_LIMITI_CSZ_PER_ETA")
@Entity
public class TpCelceLimitiCszPerEtaEntity implements GenericEntity {

    @Id
    @Basic
    @Column(name = "CELCE_SGGRA_SEQ_PK", length = 12)
    private String celceSggraSeqPk;

    @Basic
    @Column(name = "CELCE_SGRUO_SEQ_PK", length = 12)
    private String celceSgruoSeqPk;

    @Basic
    @Column(name = "CELCE_SGFFA_SEQ_PK", length = 12)
    private String celceSgffaSeqPk;

    @Basic
    @Column(name = "CELCE_LIMITA_ETA")
    private Integer celceLimitaEta;

    @Basic
    @Column(name = "CELCE_DATA_INIZ")
    private LocalDate celceDataIniz;

    @Basic
    @Column(name = "CELCE_DATA_FINE")
    private LocalDate celceDataFine;

    @Basic
    @Column(name = "CELCE_DATA_INS")
    private Instant celceDataIns;

    @Basic
    @Column(name = "CELCE_DATA_ULT_AGG")
    private Instant celceDataUltAgg;

    @Basic
    @Column(name = "CELCE_COD_ULT_AGG", length = 50)
    private String celceCodUltAgg;

}