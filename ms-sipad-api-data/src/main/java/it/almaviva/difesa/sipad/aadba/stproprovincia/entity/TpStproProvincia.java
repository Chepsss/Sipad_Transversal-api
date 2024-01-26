package it.almaviva.difesa.sipad.aadba.stproprovincia.entity;

import it.almaviva.difesa.sipad.aadba.stregregione.entity.TpStregRegione;
import it.almaviva.difesa.sipad.shared.entity.GenericEntity;
import it.almaviva.difesa.sipad.shared.util.Sortable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Sort;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TP_STPRO_PROVINCIA")
public class TpStproProvincia implements GenericEntity, Serializable, Sortable {

    private static final long serialVersionUID = 7919478706638099798L;

    @Id
    @Column(name = "STPRO_ID_PK", nullable = false, length = 12)
    private Long id;

    @Column(name = "STPRO_COD_ISTAT", length = 10)
    private String stproCodIstat;

    @Column(name = "STPRO_COD_SIGLA", nullable = false, length = 2)
    private String stproCodSigla;

    @Column(name = "STPRO_DESCR_PROVINCIA", nullable = false, length = 100)
    private String stproCDescrProvincia;

    @Column(name = "STPRO_ACR_PROVINCIA", length = 20)
    private String stproAcrProvincia;

    @Column(name = "STPRO_DATA_INIZ", nullable = false)
    private LocalDateTime stproDataIniz;

    @Column(name = "STPRO_DATA_FINE", nullable = false)
    private LocalDateTime stproDataFine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STPRO_STREG_ID")
    private TpStregRegione stproStreg;

    @Column(name = "STPRO_DATA_INS", nullable = false)
    private LocalDateTime stproDataIns;

    @Column(name = "STPRO_COD_ULT_AGG", nullable = false, length = 50)
    private String stproCodUltAgg;

    @Column(name = "STPRO_DATA_ULT_AGG", nullable = false)
    private LocalDateTime stproDataUltAgg;

    @Override
    public Sort getSort() {
        return Sort.by("id");
    }

}