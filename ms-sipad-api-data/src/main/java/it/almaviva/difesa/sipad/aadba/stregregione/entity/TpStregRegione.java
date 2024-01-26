package it.almaviva.difesa.sipad.aadba.stregregione.entity;

import it.almaviva.difesa.sipad.shared.entity.GenericEntity;
import it.almaviva.difesa.sipad.shared.util.Sortable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Sort;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TP_STREG_REGIONE")
public class TpStregRegione implements GenericEntity, Serializable, Sortable {

    private static final long serialVersionUID = -1328413858214881352L;

    @Id
    @Column(name = "STREG_ID_PK", nullable = false, length = 4)
    private Long id;

    @Column(name = "STREG_COD_REGIONE", length = 10)
    private String stregCodRegione;

    @Column(name = "STREG_COD_ISTAT", length = 10)
    private String stregCodIstat;

    @Column(name = "STREG_DESCR_REGIONE", nullable = false)
    private String stregDescrRegione;

    @Column(name = "STREG_ACR_REGIONE", length = 20)
    private String stregAcrRegione;

    @Column(name = "STREG_DATA_INIZ", nullable = false)
    private LocalDateTime stregDataIniz;

    @Column(name = "STREG_DATA_FINE", nullable = false)
    private LocalDateTime stregDataFine;

    @Column(name = "STREG_DATA_INS", nullable = false)
    private LocalDateTime stregDataIns;

    @Column(name = "STREG_COD_ULT_AGG", nullable = false, length = 50)
    private String stregCodUltAgg;

    @Column(name = "STREG_DATA_ULT_AGG", nullable = false)
    private LocalDateTime stregDataUltAgg;


    @Override
    public Sort getSort() {
        return Sort.by("id");
    }

}