package it.almaviva.difesa.sipad.aadba.stcomcomune.entity;

import it.almaviva.difesa.sipad.shared.entity.GenericEntity;
import it.almaviva.difesa.sipad.shared.util.Sortable;
import it.almaviva.difesa.sipad.aadba.stproprovincia.entity.TpStproProvincia;
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
@Table(name = "TP_STCOM_COMUNE")
public class TpStcomComune implements GenericEntity, Serializable, Sortable {

    private static final long serialVersionUID = 9165494511439572289L;

    @Id
    @Column(name = "STCOM_ID_PK", nullable = false, length = 12)
    private Long id;

    @Column(name = "STCOM_COD_COMUNE", nullable = false, length = 4)
    private String stcomCodComune;

    @Column(name = "STCOM_COD_ISTAT", nullable = false, length = 10)
    private String stcomCodIstat;

    @Column(name = "STCOM_DESCR_COMUNE", nullable = false, length = 100)
    private String stcomDescrComune;

    @Column(name = "STCOM_ACR_COMUNE", length = 20)
    private String stcomAcrComune;

    @Column(name = "STCOM_DATA_INIZ", nullable = false)
    private LocalDateTime stcomDataIniz;

    @Column(name = "STCOM_DATA_FINE", nullable = false)
    private LocalDateTime stcomDataFine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STCOM_STPRO_ID")
    private TpStproProvincia stcomStpro;

    @Column(name = "STCOM_DATA_INS", nullable = false)
    private LocalDateTime stcomDataIns;

    @Column(name = "STCOM_COD_ULT_AGG", length = 50)
    private String stcomCodUltAgg;

    @Column(name = "STCOM_DATA_ULT_AGG", nullable = false)
    private LocalDateTime stcomDataUltAgg;


    @Override
    public Sort getSort() {
        return Sort.by("id");
    }

}