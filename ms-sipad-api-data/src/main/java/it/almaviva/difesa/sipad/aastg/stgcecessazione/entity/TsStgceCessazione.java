package it.almaviva.difesa.sipad.aastg.stgcecessazione.entity;

import it.almaviva.difesa.sipad.shared.entity.GenericEntity;
import it.almaviva.difesa.sipad.aastg.stgcecessazione.entity.composite.CFNumDecretoCompositeKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TS_STGCE_CESSAZIONE")
@EntityListeners(AuditingEntityListener.class)
public class TsStgceCessazione implements GenericEntity, Serializable {

    private static final long serialVersionUID = 2242274557215297492L;

    @EmbeddedId
    private CFNumDecretoCompositeKey id;

    @Column(name = "STGCE_DATA_DECORRENZA", nullable = false)
    private LocalDate stgceDataDecorrenza;

    @Column(name = "STGCE_COD_UID_TT01", nullable = false, length = 30)
    private String stgceCodUidTt01;

    @Column(name = "STGCE_COD_UID_TT03", nullable = false, length = 30)
    private String stgceCodUidTt03;

    @Column(name = "STGCE_COD_UID_TT05", nullable = false, length = 30)
    private String stgceCodUidTt05;

    @Column(name = "STGCE_COD_UID_TT06", nullable = false, length = 30)
    private String stgceCodUidTt06;

    @Column(name = "STGCE_COD_UID_TT07", nullable = false, length = 20)
    private String stgceCodUidTt07;

    @Column(name = "STGCE_COD_UID_TT51", nullable = false, length = 20)
    private String stgceCodUidTt51;

    @Column(name = "STGCE_DATA_DECRETO", nullable = false)
    private LocalDate stgceDataDecreto;

    @Column(name = "STGCE_OGGETTO_DECRETO", length = 200)
    private String stgceOggettoDecreto;

    @Column(name = "STGCE_DODOC_SEQ")
    private Long stgceDodocSeq;

    @Column(name = "STGCE_FLAG_ELABORATO", length = 1)
    private String stgceFlagElaborato = "N";

    @Column(name = "STGCE_ELAB_MSG", length = 4000)
    private String stgceElabMsg;

    @Column(name = "STGCE_DATA_ELAB")
    private LocalDate stgceDataElab;

    @CreatedDate
    @Column(name = "STGCE_DATA_INS")
    private LocalDate stgceDataIns;

    @Column(name = "STGCE_COD_ULT_AGG", length = 20)
    private String stgceCodUltAgg;

    @Column(name = "STGCE_PROM_TIT_ONOR", length = 1)
    private String stgcePromTitOnor = "N";

}
